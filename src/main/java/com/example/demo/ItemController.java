package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class ItemController {


    @FXML
    private ImageView img; // Приватний клас для картинки який звязаний з FXML макетом

    @FXML
    private Label nameLabel; // Приватний клас для назви який звязаний з FXML макетом

    @FXML
    private Label priceLabel; // Приватний клас для ціни який звязаний з FXML макетом

    @FXML
    private void click(){
        myListener.onClickListener(book);
    } // Приватний клікера для картинки який звязаний з FXML макетом

    private Book book; // Оголосив приватну змінну
    private MyListener myListener; // Оголосив приватну змінну

    public void setData(Book book, MyListener myListener){ // Оголосив публічні класи для властивостей масиву
        this.book= book;
        this.myListener = myListener;
        nameLabel.setText(book.getName());
        priceLabel.setText(Main.CURRENCY + this.book.getPrice());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(book.getImgSrc())));
        img.setImage(image);
    }
}
