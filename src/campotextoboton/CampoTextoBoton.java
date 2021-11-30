/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campotextoboton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import static oracle.jrockit.jfr.JFR.get;

/**
 *
 * @author chris
 */
public class CampoTextoBoton extends HBox implements Initializable{
    
    @FXML 
    private TextField textField;
    
    @FXML
    private Button button;
    
    private ObjectProperty<EventHandler<ActionEvent>> propertyOnAction = new SimpleObjectProperty<EventHandler<ActionEvent>>();

    public CampoTextoBoton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("custom_control.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        this.button.setOnAction(new EventHandler<ActionEvent>() {
            @Override    
            public void handle(ActionEvent event) {
                onActionProperty().get().handle(event);
            }
        });
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
    }

    public String getText() {
        return textProperty().get();
    }

    public void setText(String value) {
        textProperty().set(value);
    }

    public StringProperty textProperty() {
        return textField.textProperty();
    }
    
    public String getButtonText()
    {
        return buttonTextProperty().get();
    }
    
    public void setButtonText(String value) {
        buttonTextProperty().set(value);
    }

    public StringProperty buttonTextProperty() {
        return button.textProperty();
    }
    
    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return propertyOnAction;
    }
    
    public final void setOnAction(EventHandler<ActionEvent> handler) {
        propertyOnAction.set(handler);
    }
    
    public final EventHandler<ActionEvent> getOnAction() {
        return propertyOnAction.get();
    }
    
}
