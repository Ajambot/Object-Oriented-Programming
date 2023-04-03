module com.example.bookcheckout {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bookcheckout to javafx.fxml;
    exports com.example.bookcheckout;
}