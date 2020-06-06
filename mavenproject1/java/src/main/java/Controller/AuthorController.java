/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author lapgo
 */
public class AuthorController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField book;
    @FXML
    private RadioButton idsearch;
    @FXML
    private ToggleGroup searchbar;
    @FXML
    private RadioButton namesearch;
    @FXML
    private TextField price;
    @FXML
    private TextField category;
    @FXML
    private Button addBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private Button update;
    @FXML
    private Button clear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addCardBtn(ActionEvent event) {
    }

    @FXML
    private void removeCardBtn(ActionEvent event) {
    }

    @FXML
    private void updateCardBtn(ActionEvent event) {
    }

    @FXML
    private void clearALL(ActionEvent event) {
    }
    
}
