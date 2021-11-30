/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.io.IOException;
import java.util.Set;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.animation.Timeline;
import javafx.beans.NamedArg;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 *
 * @author chris
 */
public class Temporizador extends HBox{
    
    @FXML
    private Label etiqueta;
    
    @FXML
    private Label contador;
    
    @FXML
    private Label medida;
    
    private IntegerProperty tiempo = new SimpleIntegerProperty();
    private EventHandler<ActionEvent> onFinished;

    private Timeline timeline;
    
    public Temporizador() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TemporizadorView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
    }
    
    public Temporizador(@NamedArg("time") int time) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TemporizadorView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        setTiempo(time);
    }
    
    public void iniciaTemporizador()
    {
        timeline = new Timeline(new KeyFrame(Duration.seconds(tiempo.get()), onFinished, new KeyValue(tiempo, 0)));
        timeline.play();
        contador.textProperty().bind(tiempo.asString());
    }
    
    public int getTiempo() {
        return tiempoProperty().get();
    }

    public void setTiempo(int value) {
        tiempoProperty().set(value);
    }

    public IntegerProperty tiempoProperty() {
        return tiempo;
    }
    
    public String getTextEtiqueta() {
        return textEtiquetaProperty().get();
    }

    public void setTextEtiqueta(String value) {
        textEtiquetaProperty().set(value);
    }
    
    public StringProperty textEtiquetaProperty() {
        return etiqueta.textProperty();
    }
    
    public String getMedidaTiempo() {
        return medidaTiempoProperty().get();
    }

    public void setMedidaTiempo(String value) {
        medidaTiempoProperty().set(value);
    }

    public StringProperty medidaTiempoProperty() {
        return medida.textProperty();
    }
    
    public StringProperty contadorProperty() {
        return contador.textProperty();
    }
    
    public void setOnFinished(EventHandler<ActionEvent> onFinished) {
        this.onFinished = onFinished;
    }
    public final ObjectProperty<EventHandler<ActionEvent>> onFinishedProperty() {
     return (ObjectProperty<EventHandler<ActionEvent>>) onFinished;
    }
    public final EventHandler<ActionEvent> getOnFinished() {
        return onFinishedProperty().get();
    }
     
}
