package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarketController implements Initializable {
    @FXML
    private ImageView bookImg;

    @FXML
    private Label bookNameLabel;

    @FXML
    private Label bookPriceLabel;

    @FXML
    private VBox chosenbookCard;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;


    private List<Book> books = new ArrayList<>();

    public MarketController() {
    }

    private List<Book> getData() {
        List<Book> books = new ArrayList<>();
        Book book;

        for (int i = 0; i < 20; i++) {
            book = new Book();
            book.setName("Чорний ворон");
            book.setPrice(3);
            book.setImgSrc("/img/Chornyuvoron.jpg");
            book.setColor("6a7324");
            books.add(book);
        }

        return books;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        books.addAll(getData());
        int column = 0;
        int row = 0;
        try {
            for (int i = 0; i < books.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();


                ItemController itemController = fxmlLoader.getController();
                itemController.setData(books.get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}