/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Book;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
/**
 * FXML Controller class
 *
 * @author Anh Quan
 */
public class FunctionController implements Initializable {
    ObservableList<Book> bookList = FXCollections.observableArrayList();
    @FXML
    private Button staff;
    @FXML
    private Button book;
    @FXML
    private Button settings;
    @FXML
    private Button logout;
    @FXML
    private ImageView staffimg;
    @FXML
    private ImageView bookimg;
    @FXML
    private ImageView settingsimg;
    @FXML
    private ImageView logoutimg;
    @FXML 
    private TextField log;
    @FXML
     
    @Override
    public void initialize( URL url, ResourceBundle rb){
        //bookimg.setImage(new Image("../../resources/res/personnel.png"));

    }
    public void get_accountID(int ID){
        log.setText(Integer.toString(ID));
    }
    
}

