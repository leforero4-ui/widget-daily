module com.forest.widget_daily {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.forest.widget_daily to javafx.fxml;
    exports com.forest.widget_daily;
}