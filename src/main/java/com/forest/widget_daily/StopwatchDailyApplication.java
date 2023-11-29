package com.forest.widget_daily;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StopwatchDailyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //panel
        FXMLLoader fxmlLoader = new FXMLLoader(StopwatchDailyApplication.class.getResource("stopwatch-daily-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 600);
        stage.setTitle("Daily");
        stage.setScene(scene);
        
        // Mantener la ventana siempre encima de otras aplicaciones
        stage.setAlwaysOnTop(true);
        
        //limpiar recursos
        stage.setOnCloseRequest(event -> {
            StopwatchDailyController controller = fxmlLoader.getController();
            controller.close();
        });
        
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}