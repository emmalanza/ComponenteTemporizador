package com.emma;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ComponenteTemporizador extends Label {

    private int tiempo;
    private ArrayList<FinCuentaAtras> lista_acciones = new ArrayList<>();

    public ComponenteTemporizador() {
        super();
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        setText(Integer.toString(tiempo));
        this.tiempo = tiempo;

    }

    public void addFinCuentaAtras(FinCuentaAtras fin){
        lista_acciones.add(fin);
    }

    public void comenzar(){
        setStyle("-fx-text-fill: green");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(tiempo>0){
                    tiempo--;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            setText(Integer.toString(tiempo));
                            if(tiempo==0) {
                                setStyle("-fx-text-fill: red");
                                if(lista_acciones.size()!=0)
                                  for(int i = 0; i<lista_acciones.size(); i++){
                                      lista_acciones.get(i).ejecuta();
                                  }
                            }
                        }
                    });
                }
                else{

                    cancel();
                }
            }
        },1000,1000);

        }

    }

