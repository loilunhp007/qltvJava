/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Utils.Connect;
import javafx.event.*;

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
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize( URL url, ResourceBundle rb) {
        
    }
    void login(ActionEvent event) {
        String txtUsername = username.getText();
        String txtpass = pass.getText();
        String sql = "SELECT * FROM account WHERE userName= ? AND userPassword=?";
           
           try {
               pst = conn.prepareStatement(sql);
               pst.setString(1, txtUsername);
               pst.setString(2, txtpass);
               rs= pst.executeQuery();
               if(!rs.next()){
                   JOptionPane.showMessageDialog(null, "Username or Password can't null");
               }
               else{
                   JOptionPane.showMessageDialog(null, "Login Success");
               }
           } catch (Exception e) {
               e.printStackTrace();
           }

       }
}
