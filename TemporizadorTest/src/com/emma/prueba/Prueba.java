package com.emma.prueba;
import com.emma.ComponenteTemporizador;
import com.emma.FinCuentaAtras;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Prueba extends Application {

    public static void main(String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        VBox vbox = new VBox();
        ComponenteTemporizador temp = new ComponenteTemporizador();
        temp.setTiempo(5);
        temp.setFont(new Font(40));
        temp.addFinCuentaAtras(new FinCuentaAtras() {
            @Override
            public void ejecuta() {
                temp.setText("Fin de la cuenta atrás.");
            }
        });

        temp.addFinCuentaAtras(new FinCuentaAtras() {
            @Override
            public void ejecuta() {
              System.out.println("JeJe");
            }
        });

        vbox.getChildren().add(temp);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
        temp.comenzar();

    }
}
