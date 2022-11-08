package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ItemController {


    @FXML
    private ImageView img;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private void click(MouseEvent mouseEvent){
        myListener.onClickListener(book);
    }

    private Book book;
    private MyListener myListener;

    public void setData(Book book, MyListener myListener){
        this.book= book;
        this.myListener = myListener;
        nameLabel.setText(book.getName());
        priceLabel.setText(Main.CURRENCY + this.book.getPrice());
        Image image = new Image(getClass().getResourceAsStream(book.getImgSrc()));
        img.setImage(image);
    }
}
