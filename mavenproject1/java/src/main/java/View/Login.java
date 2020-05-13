/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Anh Quan
 */
public class Login implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField pass;
    @FXML
    private Button loginBtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void loginPressed() {
        
    }
    
    public void onMouseEnter() {
        loginBtn.setStyle("-fx-background-radius:10px; -fx-background-color: transparent; -fx-border-color: #88b38f; -fx-border-radius:10px; -fx-text-fill: black;");
    }
    
    public void onMouseExit() {
        loginBtn.setStyle("-fx-background-radius:10px; -fx-background-color: #88b38f; -fx-border-color: #88b38f;-fx-border-radius:10px; -fx-text-fill: white;");
    }
    
}
