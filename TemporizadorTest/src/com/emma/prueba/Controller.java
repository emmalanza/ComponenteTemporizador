package com.emma.prueba;

import com.emma.ComponenteTemporizador;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComponenteTemporizador temp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        temp.setTiempo(5);
        temp.comenzar();

    }
}
