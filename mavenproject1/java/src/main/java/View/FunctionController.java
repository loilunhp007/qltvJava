/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import Controller.database;
import DAO.AccountDAO;
import Entity.Account;
import Entity.Staff;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.*;

/**
 * FXML Controller class
 *
 * @author Anh Quan
 */
public class FunctionController implements Initializable {

    @FXML
    private TableView<Staff> staffTable;
    @FXML
    private TableColumn<Staff, String> ID;
    @FXML
    private TableColumn<Staff, String> nameTable;
    @FXML
    private TableColumn<Staff,String> dobTable;
    @FXML
    private TableColumn<Staff, String> genderTable;
    @FXML
    private TableColumn<Staff, String> phoneTable;
    @FXML
    private TableColumn<Staff, String> addressTable;
    @FXML
    private TableColumn<Staff, String> RoleIdTable;
    @FXML
    private TextField name;
    @FXML
    private TextField dob;
    @FXML
    private TextField gender;
    @FXML
    private TextField role;
    @FXML
    private TextField phone;
    @FXML
    private TextField address;
    @FXML
    private Button addBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private TextField search;

    /**
     * Initializes the controller class.
     */
    ObservableList<Staff> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb){
       showdata();
    }
    public void showdata(){
        try {
            database db=new database();
            db.getConnect();
            ResultSet rs=db.execution("SELECT * FROM staff;");
            while(rs.next()){
                oblist.add(new Staff(rs.getInt(1)));
            }
        } catch (SQLException e) {
            Logger.getLogger(FunctionController.class.getName());
        }
        staffTable.setItems(oblist);
    }
    
}
