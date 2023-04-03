package com.example.bookcheckout;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;



//Class Book:
//This class is used during the program and contains the title, price and quantity
// of each book received from the text file.

class Book{
    private String title;
    private double price;
    private int quantity;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
        this.quantity= 0;
    }

    public String getTitle(){ return title; }
    public double getPrice(){ return price; }
    public int getQuantity(){ return quantity; }

    public void setTitle(String title){ this.title = title;}
    public void setPrice(double price){ this.price = price;}
    public void setQuantity(int quantity){ this.quantity = quantity;}

    public void add(){ quantity++; }
    public void sub(){if(quantity>0)quantity--;}
    public String toString(){ return String.format("%-30s$%7.2f\n", title, price); }
}

public class BookCheckout extends Application {
    private static ArrayList<Book> books = new ArrayList<Book>();

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        //Reading book file (function defined later in the code)
        readBookFile();

        // Project column layout
        HBox columns = new HBox();
        columns.setBackground(new Background(new BackgroundFill(Color.rgb(250, 255, 210), new CornerRadii(0), new Insets(0))));
        columns.setPadding(new Insets(30));
        columns.setAlignment(Pos.CENTER);

        // Declare two columns
        VBox col1 = new VBox();
        VBox col2 = new VBox();
        col1.setSpacing(20);
        col2.setSpacing(20);
        columns.setSpacing(20);
        col1.setAlignment(Pos.CENTER);
        col2.setAlignment(Pos.CENTER);

        // Declare column headers and add to respective column
        Text text1 = new Text(10, 40, "Book List");
        text1.setFont(Font.font("Courier", FontWeight.BOLD,
                FontPosture.ITALIC, 15));

        Text text2 = new Text(10, 40, "Shopping Cart");
        text2.setFont(Font.font("Courier", FontWeight.BOLD,
                FontPosture.ITALIC, 15));
        text1.setTextAlignment(TextAlignment.CENTER);
        text2.setTextAlignment(TextAlignment.CENTER);
        col1.getChildren().add(text1);
        col2.getChildren().add(text2);

        //Creating listviews:
        //In here two listviews are created: one which holds all the books and one which represent the shopping cart

        //Adding Book List ListView
        ObservableList<String> books_info = FXCollections.observableArrayList();
        for (Book book : books) {
            books_info.add(book.toString());
        }
        ListView<String> listView = new ListView<String>(books_info);

        // Adding shoppingCart ListView
        ObservableList<String> shopping_cart = FXCollections.observableArrayList();
        ListView<String> listView_2 = new ListView<String>(shopping_cart);
        listView.setPrefWidth(300);
        listView_2.setPrefWidth(300);
        col1.getChildren().add(listView);
        col2.getChildren().add(listView_2);

        //ACTIONS
        //Buttons for adding and removing elements from shopping cart
        HBox addRemoveButtons = new HBox();
        Button lessBtn = new Button("Remove Item");
        Button addBtn = new Button("Add Item");
        addBtn.setOnAction(e -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            books.get(index).add();
            listView_2.getItems().add(books.get(index).toString());
            System.out.println("Book added");
        });
        lessBtn.setOnAction(e -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            books.get(index).sub();
            listView_2.getItems().remove(books.get(index).toString());
            System.out.println("Book removed");
        });
        addRemoveButtons.getChildren().addAll(lessBtn, addBtn);
        lessBtn.setPrefSize(100, 30);
        addBtn.setPrefSize(100, 30);
        addRemoveButtons.setAlignment(Pos.CENTER);

        // Buttons for clearing shopping list and checkout
        Button clear = new Button("Clear");
        clear.setPrefSize(100, 30);
        clear.setOnAction(e->{
            listView_2.getItems().clear();
            for(Book book : books) book.setQuantity(0);
        });

        HBox clearCheckoutButtons = new HBox();
        Button checkout = new Button("Checkout");
        checkout.setPrefSize(100, 30);
        checkout.setOnAction(e->{
            //Calculating subtotal and taxes
            double subtotal = 0;
            for (Book curBook : books) {
                if (curBook.getQuantity() > 0) {
                    subtotal += curBook.getPrice() * curBook.getQuantity();
                }
            }
            if(subtotal==0){
                Alert a = new Alert(Alert.AlertType.WARNING, "Shopping Cart is Empty", ButtonType.OK);
                a.show();
                return;
            }
            listView_2.getItems().add(String.format("%30s————————\n", ""));
            listView_2.getItems().add(String.format("%-30s$%7.2f\n", "Subtotal", subtotal));
            listView_2.getItems().add(String.format("%-30s$%7.2f\n", "Tax     ", subtotal * 0.07));
            listView_2.getItems().add(String.format("%-30s$%7.2f\n", "TOTAL   ", subtotal * 1.07));

            printReceipt();
            listView_2.getItems().clear();
            for(Book book : books) book.setQuantity(0);
            ButtonType openReceipt = new ButtonType("See receipt");
            ButtonType closeDialog = new ButtonType("Close dialog");
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Your Receipt is Ready!", openReceipt, closeDialog);
            Optional<ButtonType> result = a.showAndWait();
            if(result.get() == openReceipt) {
                ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "receipt.txt");
                try{
                    pb.start();
                }
                catch(IOException error){
                    System.out.println("Could not start process");
                }
            }

        });

        clearCheckoutButtons.getChildren().addAll(clear, checkout);
        clearCheckoutButtons.setAlignment(Pos.CENTER);

        // Add Buttons to each column
        col1.getChildren().add(addRemoveButtons);
        col2.getChildren().add(clearCheckoutButtons);
        // Add columns to layout
        columns.getChildren().addAll(col1, col2);

        //Displaying elements
        Scene scene = new Scene(columns);
        scene.getStylesheets().add("styles.css");
        stage.setTitle("Bookstore");
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.show();
    }

    //This function is used to read the names of the files from an external .txt file
    public static void readBookFile() throws FileNotFoundException {
        //Reading book names and prices from txt
        File file = new File("BookPrice");
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String str = input.nextLine();
            String[] tokens = str.split(","); // Split lines into 2 comma separated tokens: title and price
            books.add(new Book(tokens[0], Double.parseDouble(tokens[1]))); // Add new book object to list with info from current line in file
        }
    }

    //This function is ued to create a new .txt file which will hold the receipt, that includes the date of when the
    //items were purchased as well as a subtotal,tax and grandtotal
    public static void printReceipt(){
        // Generate receipt
        try {
            File receipt = new File("receipt.txt");
            if (receipt.createNewFile()) {
                System.out.println("File created: " + receipt.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter writer = new FileWriter("receipt.txt");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            writer.write("Receipt: " + dtf.format(LocalDateTime.now()) + "\n");
            writer.write(String.format("%-40s%7s\n————————————————————————————————————————————————\n", "Title", "Price"));
            double subtotal = 0;
            // Write each item into receipt and add price into subtotal
            for (Book curBook : books) {
                if (curBook.getQuantity() > 0) {
                    subtotal += curBook.getPrice()* curBook.getQuantity();
                    writer.write(String.format("%-40s$%7.2f\n", curBook.getTitle() + " x " + curBook.getQuantity(), curBook.getPrice()*curBook.getQuantity()));
                }
            }

            // Subtotal, tax, and grandtotal
            writer.write(String.format("%-40s$%7.2f\n", "Subtotal", subtotal));
            writer.write(String.format("%-40s$%7.2f\n", "Tax", subtotal * 0.07));
            writer.write(String.format("%40s————————\n", ""));
            writer.write(String.format("%-40s$%7.2f\n", "Grandtotal", subtotal * 1.07));
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}