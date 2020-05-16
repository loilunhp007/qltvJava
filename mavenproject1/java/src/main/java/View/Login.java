/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.*;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

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
        Connect.getConnect();
    }    
    
    @FXML
    public void loginPressed(ActionEvent event) {
        /*if (Connect.checkAccount(username.getText(),password.getText()) == 0) {
            warning.setVisible(true);
            diaglog.setHeading(new Text("Wrong username, password combination!"));
            diaglog.setBody(new Text("Please try again!"));
            JFXDialog dialog = new JFXDialog(View.Login, diaglog, JFXDialog.DialogTransition.CENTER);
            dialog.show();
        }
        else {
            warning.setVisible(false);
        }*/
        String txtUsername = username.getText();
        String txtpass = password.getText();
        Connect con=new Connect();
        con.getConnect();
        String sql="SELECT* FROM account WHERE userName=? and userPassword=?";
        PreparedStatement pst;
        ResultSet rs;
        pst.executeQuery(sql);

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
