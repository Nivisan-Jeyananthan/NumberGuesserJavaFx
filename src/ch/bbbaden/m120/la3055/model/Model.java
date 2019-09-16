/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.m120.la3055.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;


public class Model {

    private final static int MAX = 100;
    private final static int MAX_ATTEMPTS = 5;
    private final static String MESSAGE_TO_LOW = "The guessed number is to low";
    private final static String MESSAGE_TO_HIGH = "The guessed number is to big";
    private final static String MESSAGE_CORRECT = "You guessed the number. Congrats.";

    private int randomNumber;
    private int attempt = 0;
    private double attemptPercent = 0.0;
    private String message = "";

    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public Model() {
        createRandom();
    }

    private void createRandom() {
        Random random = new Random();
        randomNumber = random.nextInt(MAX) + 1;
    }

    public void check(int guess) {
        double oldAttemptPercent = attemptPercent;
        attempt++;
        attemptPercent = (double)attempt/MAX_ATTEMPTS;
        String oldMessage = message;
        
        if (guess > randomNumber) {
            message = MESSAGE_TO_HIGH;
        } else if (guess < randomNumber) {
            message = MESSAGE_TO_LOW;
        } else {
           message = MESSAGE_CORRECT;     
        }
        changes.firePropertyChange("attempt", oldAttemptPercent, attemptPercent);
        changes.firePropertyChange("message", oldMessage, message);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener){
        changes.addPropertyChangeListener(listener);
    }

}
