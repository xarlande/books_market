package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends javafx.application.Application {

    public static final String CURRENCY = "$";
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("market.fxml"));// Головний файл .fxml
        Scene scene = new Scene(fxmlLoader.load(), 1315, 810);// Розширення головної сторінки
        stage.setTitle("Books Market!");// Назва вікна
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}