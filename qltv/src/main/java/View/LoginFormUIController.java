/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Anh Quan
 */
public class LoginFormUIController implements Initializable {

    @FXML
    private TextField usr;
    @FXML
    private TextField passwd;
    @FXML
    private TextField job;
    @FXML
    private Button loginBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button regBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    public void clearAll(){
        usr.clear();
        passwd.clear();
    }
}
