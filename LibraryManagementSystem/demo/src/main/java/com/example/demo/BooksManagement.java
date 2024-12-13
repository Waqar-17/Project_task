package com.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;



public class BooksManagement {






    public static void addBook() {
        Stage addBookStage = new Stage();
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        File file2 = new File("Book.txt");
        Alert alert = new Alert(Alert.AlertType.WARNING);

        Label bookLabel = new Label("Enter Book Title:");
        TextField bookField = new TextField();
        Label bookId = new Label("Enter Book ID:");
        TextField bookIdField = new TextField();
        Button addButton = new Button("Add Book");






        addButton.setOnAction(e -> {
            String bookTitle = bookField.getText().trim();
            String bookID = bookIdField.getText().trim();


            if (!bookTitle.isEmpty() && !bookID.isEmpty()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter( file2, true))) {

                    writer.write(bookID + "," + bookTitle);
                    writer.newLine();

                    alert.setHeaderText("Book Added");
                    alert.show();
                    addBookStage.close();
                } catch (IOException ex) {

                }
            } else {
                alert.setHeaderText("Book Title and Book ID cannot be empty");
                alert.show();
            }
        });
        BackgroundImage backgroundImage1 = new BackgroundImage(
                new Image("Icon 1/123456.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        layout.setBackground(new Background(backgroundImage1));
        layout.getChildren().addAll(bookLabel, bookField,bookId,bookIdField, addButton);

        Scene scene = new Scene(layout, 500, 300);
        addBookStage.setTitle("Add Book");
        addBookStage.setScene(scene);
        addBookStage.show();
    }


    public static void showBooks() {

    }


    public static void borrowBook(String username) {
        Alert  alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText("Borrow Book");

        alert.show();
    }

    public static void returnBook(String username) {

    }
}