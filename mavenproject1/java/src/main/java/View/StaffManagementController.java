/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;
import Controller.database;
import DAO.bookDAO;
import Entity.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.control.cell.*;
import javafx.event.*;

/**
 * FXML Controller class
 *
 * @author Anh Quan
 */
public class StaffManagementController implements Initializable {

    @FXML
    private TableView<Staff> staffTable;
    @FXML
    private TableColumn<Staff, Integer> ID;
    @FXML
    private TableColumn<Staff, String> nameC;
    @FXML
    private TableColumn<Staff,String> dobC;
    @FXML
    private TableColumn<Staff, String> genderC;
    @FXML
    private TableColumn<Staff, String> phoneC;
    @FXML
    private TableColumn<Staff, String> addressC;
    @FXML
    private TableColumn<Staff, Integer> roleC;
    @FXML
    private TextField name;
    @FXML
    private TextField dob;
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
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton female;

    ObservableList<Staff> staffList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void loadStaff() {
        database db=new database();
        try {
            
            db.getConnect();
            ResultSet rs=db.execution("SELECT * FROM staff");
            while(rs.next()){
                staffList.add(new Staff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            Logger.getLogger(FunctionController.class.getName());
        }
        db.disconnect();
        ID.setCellValueFactory(new PropertyValueFactory<>("staffID"));
        nameC.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        dobC.setCellValueFactory(new PropertyValueFactory<>("staffDOB"));
        genderC.setCellValueFactory(new PropertyValueFactory<>("staffGender"));
        phoneC.setCellValueFactory(new PropertyValueFactory<>("staffPhone"));
        addressC.setCellValueFactory(new PropertyValueFactory<>("staffAddr"));
        roleC.setCellValueFactory(new PropertyValueFactory<>("staff_role"));
        staffTable.setItems(staffList);     
    }

    public void onSelect() {
        this.staffTable.setRowFactory(param -> {
            TableRow row = new TableRow();

            row.setOnMouseClicked(et -> {
                Staff s = this.staffTable.getSelectionModel().getSelectedItem();
                this.name.setText((s.getStaffName()));
                this.dob.setText(s.getStaffDOB());
                if (s.getStaffGender().equals("Male")) male.setSelected(true);
                else female.setSelected(true);
                this.role.setText(Integer.toString(s.getStaff_role()));
                this.phone.setText(s.getStaffPhone());
                this.address.setText(s.getStaffAddr());
            });
            return row;
        });
    }

    public void clearAll(){
        name.clear();
        dob.clear();
        phone.clear();
        address.clear();
        role.clear();
    }
}
