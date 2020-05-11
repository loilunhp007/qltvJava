/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Model.*;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import java.net.URL;
import java.util.List;
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
public class Login implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private TextField pass;
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
        List<Account> account = Ultis.getAccount();
        for (Account acc: account) {
            if (username.getText().equals(acc.getUserName()) && pass.getText().equals(acc.getUserPassword())) {
                username.clear();
            }
            
        }
    }
    
    public void onMouseEnter() {
        loginBtn.setStyle("-fx-background-radius:10px; -fx-background-color: white; -fx-border-color: #c8864e; -fx-border-radius:10px; -fx-text-fill: black;");
    }
    
    public void onMouseExit() {
        loginBtn.setStyle("-fx-background-radius:10px; -fx-background-color: #c8864e; -fx-border-color: #c8864e;-fx-border-radius:10px; -fx-text-fill: white;");
    }
    
}
