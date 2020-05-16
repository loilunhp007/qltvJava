/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Anh Quan
 */
public class FunctionController implements Initializable {

    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> nameTable;
    @FXML
    private TableColumn<?, ?> usernameTable;
    @FXML
    private TableColumn<?, ?> passwordTable;
    @FXML
    private TableColumn<?, ?> dobTable;
    @FXML
    private TableColumn<?, ?> genderTable;
    @FXML
    private TableColumn<?, ?> phoneTable;
    @FXML
    private TableColumn<?, ?> addressTable;
    @FXML
    private TextField name;
    @FXML
    private TextField dob;
    @FXML
    private TextField gender;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
