package com.emma.prueba;

import com.emma.ComponenteTemporizador;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Prueba2 extends Application {


    public static void main (String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("fxml/prueba2.fxml"));
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
        stage.show();

    }
}
