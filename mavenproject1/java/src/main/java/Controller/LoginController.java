/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Controller.database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anh Quan
 */

public class LoginController implements Initializable {
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
    private Pattern pattern;
    public static final String  user_Pattern="^[a-z0-9._-]{6-15}$";
    public static final String  pass_Pattern="((?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!.#$@_+,?-]).{8,20})";
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
            /*if(validateUser(txtName) &&validatePass(txtPass)){
                if(txtName.equals(rs.getString(1)) && txtPass.equals(rs.getString(2))){
                    loginBtn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/Function.fxml"));
                    Stage mainStage=new Stage();
                    Scene scene=new Scene(root);
                    mainStage.setScene(scene);
                    mainStage.show();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Your UserName or Password Incorrect");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"wrong  regex");
            }*/
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
            ResultSet rs=db.excution("select ");
            warning.setVisible(true);
        }
        else {
            warning.setVisible(false);
        }*/
    }
    public boolean validateUser(final String userName){
        pattern=Pattern.compile(user_Pattern);
        return pattern.matcher(userName).matches();
    }
    public boolean validatePass(final String password){
        pattern=Pattern.compile(pass_Pattern);
        return pattern.matcher(password).matches();
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
