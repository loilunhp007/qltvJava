/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.*;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.*;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JOptionPane;
import Controller.*;
import javafx.stage.*;

/**
 * FXML Controller class
 *
 * @author Anh Quan
 */

public class Login implements Initializable {
    @FXML
    private Button loginBtn;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private javafx.scene.control.Label warning;
    @FXML
    private JFXDialogLayout diaglog;
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database db=new database();
        db.getConnect();
    }    
    
    @FXML
    public void loginPressed(ActionEvent event) throws Exception {
        database db=new database();
        db.getConnect();
        String txtName=username.getText();
        String txtPass=password.getText();
        ResultSet rs=db.execution("SELECT userName,userPassword FROM account");
        while(rs.next()){
            if(txtName.equals(rs.getString(1)) && txtPass.equals(rs.getString(2))){
                loginBtn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/Function.fxml"));
                Stage mainStage=new Stage();
                Scene scene=new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
            }
        }
        /*if (Connect.checkAccount(username.getText(),password.getText()) == 0) {
            warning.setVisible(true);
        }
        else {
            warning.setVisible(false);
        }*/
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
