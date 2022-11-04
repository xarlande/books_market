package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemController {


    @FXML
    private ImageView img;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    private Book book;

    public void setData(Book book){
        this.book= book;
        nameLabel.setText(book.getName());
        priceLabel.setText(Main.CURRENCY + this.book.getPrice());
        Image image = new Image(getClass().getResourceAsStream(book.getImgSrc()));
        img.setImage(image);
    }
}
