package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MarketController implements Initializable {
    @FXML
    private ImageView bookImg; // Приватний клас який звязаний з FXML макетом

    @FXML
    private Label bookNameLabel; // Приватний клас який звязаний з FXML макетом

    @FXML
    private Label bookPriceLabel; // Приватний клас який звязаний з FXML макетом

    @FXML
    private VBox chosenbookCard; // Приватний клас який звязаний з FXML макетом

    @FXML
    private GridPane grid; // Приватний клас який звязаний з FXML макетом


    private final List<Book> books = new ArrayList<>(); // Приватний клас для масиву данних
    private MyListener myListener; // Приватний клас для клікера

    public MarketController() {
    }

    private List<Book> getData() { // Массив данних
        List<Book> books = new ArrayList<>();
        Book book;

        book = new Book();
        book.setName("Бійцівський клуб");
        book.setPrice(20);
        book.setImgSrc("/img/fight__club.jpg");
        book.setColor("613B28");
        books.add(book);

        book = new Book();
        book.setName("Останній сеанс");
        book.setPrice(20);
        book.setImgSrc("/img/one__book.jpg");
        book.setColor("433C65");
        books.add(book);

        book = new Book();
        book.setName("Чорний ворон");
        book.setPrice(50);
        book.setImgSrc("/img/Chornyuvoron.jpg");
        book.setColor("880808");
        books.add(book);

        book = new Book();
        book.setName("Кобзар");
        book.setPrice(70);
        book.setImgSrc("/img/kobzar.jpg");
        book.setColor("6a7324");
        books.add(book);

        book = new Book();
        book.setName("Мене забули на мiсяцi");
        book.setPrice(20);
        book.setImgSrc("/img/two__book.jpg");
        book.setColor("2A4165");
        books.add(book);

        book = new Book();
        book.setName("Фактор Черчилля");
        book.setPrice(20);
        book.setImgSrc("/img/three__book.jpg");
        book.setColor("2A4165");
        books.add(book);

        book = new Book();
        book.setName("Таємниці Віолети Вейл");
        book.setPrice(20);
        book.setImgSrc("/img/four__book.jpg");
        book.setColor("2A4165");
        books.add(book);



        return books;
    }

    private void setChosenbook (Book book){ // Приватний клас для зміни головного вікна при нажиманні на обєкти
        bookNameLabel.setText(book.getName());
        bookPriceLabel.setText(Main.CURRENCY + book.getPrice());
        // Приватний клас для картинок
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(book.getImgSrc())));
        bookImg.setImage(image);
        chosenbookCard.setStyle("    -fx-background-color: #"+ book.getColor()+";\n" +
                "    -fx-background-radius: 30;");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { // Ініціалізація ресурсів і виведення їх на FXML макет
        books.addAll(getData());
        if (books.size() > 0){
            setChosenbook(books.get(0));
            myListener = this::setChosenbook;
        }
        int column = 0;
        int row = 1;
        try {
            for (Book book : books) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();


                ItemController itemController = fxmlLoader.getController();
                itemController.setData(book, myListener);

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