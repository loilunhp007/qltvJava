/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Controller.*;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;
import com.jfoenix.controls.*;
import com.mysql.cj.*;
import java.net.URL;
import java.util.*;
import javafx.fxml.*;
import javafx.scene.control.*;


/**
 * FXML Controller class
 *
 * @author Anh Quan
 */

public class LoginController implements Initializable {
    @FXML
    private Button loginBtn;
    @FXML
    private CheckBox checkbox;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private javafx.scene.control.Label warning;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void loginPressed() {
        if (Connect.checkAccount(username.getText(),password.getText()) == 0) {
            warning.setVisible(true);
        }
        else {
            warning.setVisible(false);
        }
    }
    
    @FXML
    public void onMouseEnter() {
        loginBtn.setStyle("-fx-background-color: #39b54a; -fx-border-color: #39b54a; -fx-text-fill: black;");
    }
    
    @FXML
    public void onMouseExit() {
        loginBtn.setStyle("-fx-background-color: #88b38f; -fx-border-color: #88b38f; -fx-text-fill: white;");
    }
    
}
