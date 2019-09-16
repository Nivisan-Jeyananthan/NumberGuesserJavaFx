/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.m120.la3055.viewmodel;

import ch.bbbaden.m120.la3055.model.Model;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class ViewModel implements PropertyChangeListener {

    private Model model;
    private DoubleProperty attempt = new SimpleDoubleProperty();
    private StringProperty guess = new SimpleStringProperty();
    private DoubleProperty progress = new SimpleDoubleProperty();
    private StringProperty message = new SimpleStringProperty();
    private BooleanProperty buttonEnabled = new SimpleBooleanProperty(true);

    public ViewModel(Model model) {
        this.model = model;
    }

    public void guess() {
        model.check(Integer.parseInt(guess.getValue()));
        guess.setValue("");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        switch (evt.getPropertyName()) {
            case "attempt":
                double attemptPercent = Double.parseDouble(evt.getNewValue().toString());
                buttonEnabled.setValue(attemptPercent < 1.0);
                progress.setValue(attemptPercent);
                break;
            case "message":
                message.setValue(evt.getNewValue().toString());
                break;
        }
    }

    public DoubleProperty getAttempt() {
        return attempt;
    }

    public DoubleProperty getProgress() {
        return progress;
    }

    public StringProperty getMessage() {
        return message;
    }

    public StringProperty getGuess() {
        return guess;
    }



    public BooleanProperty getButtonEnabled() {
        return buttonEnabled;
    }
    
    

}
