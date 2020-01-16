package com.emma;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ComponenteTemporizador extends Label {

    private IntegerProperty tiempo = new SimpleIntegerProperty(0);
    private ObjectProperty<Paint> colorStart = new SimpleObjectProperty<Paint>(Color.GREEN);
    private ObjectProperty<Paint> colorEnd = new SimpleObjectProperty<Paint>(Color.RED);
    private StringProperty texto_fin = new SimpleStringProperty();

    private ArrayList<FinCuentaAtras> lista_acciones = new ArrayList<>();

    public ComponenteTemporizador() {
        super();
    }

    public String getTexto_fin() {
        return texto_fin.get();
    }

    public StringProperty texto_finProperty() {
        return texto_fin;
    }

    public void setTexto_fin(String texto_fin) {
        this.texto_fin.set(texto_fin);
    }

    public Paint getColorStart() {
        return colorStart.get();
    }

    public ObjectProperty<Paint> colorStartProperty() {
        return colorStart;
    }

    public void setColorStart(Paint colorStart) {
        this.colorStart.set(colorStart);
    }

    public Paint getColorEnd() {
        return colorEnd.get();
    }

    public ObjectProperty<Paint> colorEndProperty() {
        return colorEnd;
    }

    public void setColorEnd(Paint colorEnd) {
        this.colorEnd.set(colorEnd);
    }

    public int getTiempo() {
        return tiempo.get();
    }

    public IntegerProperty tiempoProperty() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo.set(tiempo);
        setText(Integer.toString(tiempo));
    }

    public void addFinCuentaAtras(FinCuentaAtras fin){
        lista_acciones.add(fin);
    }

    public void comenzar(){

       /* setStyle("-fx-text-fill:#" + String.format("%02x%02x%02x",
                (int)colorStart.get().getRed()*255,
                (int)colorStart.get().getGreen()*255,
                (int)colorStart.get().getBlue()*255));*/

        setStyle("-fx-text-fill:#"+colorStart.get().toString().substring(2));

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(tiempo.get()>0){
                    tiempo.set(tiempo.get()-1);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            setText(Integer.toString(tiempo.get()));
                            if(tiempo.get()==0) {
                                setStyle("-fx-text-fill:#"+colorEnd.get().toString().substring(2));
                                if(texto_fin.get()==null)
                                    texto_fin.set("0");
                                setText(texto_fin.get());
                                if(lista_acciones.size()!=0)
                                  for(int i = 0; i<lista_acciones.size(); i++){
                                      lista_acciones.get(i).ejecuta();
                                  }
                            }
                        }
                    });
                }
                else{
                    timer.cancel();
                    timer.purge();
                }
            }
        },1000,1000);

        }

    }

