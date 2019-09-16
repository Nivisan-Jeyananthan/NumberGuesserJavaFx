/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.m120.la3055.view;

import ch.bbbaden.m120.la3055.viewmodel.ViewModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;


public class View implements Initializable {

    @FXML
    private Button guessBtn;
    @FXML
    private TextField guessTxt;
    @FXML
    private Label answerLbl;
    @FXML
    private ProgressBar attemptPgr;

    private ViewModel viewModel;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
    
    public void bind(){
        answerLbl.textProperty().bind(viewModel.getMessage());
        attemptPgr.progressProperty().bind(viewModel.getProgress());
        guessTxt.textProperty().bindBidirectional(viewModel.getGuess());
        guessBtn.disableProperty().bind(viewModel.getButtonEnabled().not());
    }

    @FXML
    private void guessAction(ActionEvent event) {
        viewModel.guess();
    }
    
    
    
    
}
