/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Logger;

import Controller.database;
import DAO.bookDAO;
import DAO.staffDAO;
import Entity.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.control.cell.*;
import javafx.event.*;
import javafx.collections.transformation.FilteredList;
import javafx.scene.image.*;


/**
 * FXML Controller class
 *
 * @author Anh Quan
 */
public class StaffController implements Initializable {

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
    private TableColumn<Staff, String> roleC;
    @FXML
    private TextField txtID;
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
    private Button clearBtn;
    @FXML
    private TextField searchStaff;
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton female;
    @FXML 
    private ChoiceBox role_choice;
    @FXML
    private RadioButton namesearch;
    @FXML
    private RadioButton idsearch;
    @FXML
    private ToggleGroup searchbar;
    @FXML
    private ImageView staffimg;
    
    ObservableList<Staff> staffList = FXCollections.observableArrayList();
    FilteredList<Staff> flstaff = new FilteredList(staffList, p -> true);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        role_choice.getItems().addAll("Staff","Admin");
        role_choice.setValue("Staff");
        //role_choice.setValue("role");
        loadStaff();
        onSelect();
    }
    public void loadStaff() {
        database db=new database();
        try {
            
            db.getConnect();
            ResultSet rs=db.execution("SELECT * FROM staff");
            while(rs.next()){
                staffList.add(new Staff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getInt(7)));
                //staffList=staffDAO.load();
            }
        } catch (Exception e) {
            Logger.getLogger(StaffController.class.getName());
        }
        db.disconnect();
        ID.setCellValueFactory(new PropertyValueFactory<>("staffID"));
        nameC.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        dobC.setCellValueFactory(new PropertyValueFactory<>("staffDOB"));
        genderC.setCellValueFactory(new PropertyValueFactory<>("staffGender"));
        phoneC.setCellValueFactory(new PropertyValueFactory<>("staffPhone"));
        addressC.setCellValueFactory(new PropertyValueFactory<>("staffAddr"));
        roleC.setCellValueFactory(new PropertyValueFactory<>("role_name"));
        staffTable.setItems(staffList);     
    }
    //        ADD staff Start
    
    public void addStaffbtn(ActionEvent event) throws Exception{
        Staff staff= new Staff();
        String Name=name.getText();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(dob.getText());
        String dob=df.format(date1);
        String  Addr=address.getText();
        String gender1=null;
        int role1= Integer.parseInt(role.getText());
        if(male.isSelected()==true){
            gender1=male.getText();
        }
        if(female.isSelected()==true){
            gender1=female.getText();
        }
        String phone1=phone.getText();
        staff.setStaffName(Name);
        staff.setStaffDOB(dob);
        staff.setStaffAddr(Addr);
        staff.setStaffGender(gender1);
        staff.setStaffPhone(phone1);
        staff.setStaff_role(role1);
        staffDAO.addStaff(staff);
        loadStaff();
    }
    public void updateStaffBtn(ActionEvent event) throws Exception{
        //error
        Staff staff = new Staff();
        int idd=Integer.parseInt(txtID.getText());
        String Name=name.getText();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(dob.getText());
        String dob1=df.format(date1);
        String  Addr=address.getText();
        String gender1=null;
        if(male.isSelected()==true){
            gender1=male.getText();
        }
        if(female.isSelected()==true){
            gender1=female.getText();
        }
        int role1= Integer.parseInt(role.getText());
        String phone1=phone.getText();
        staff.setStaffID(idd);
        staff.setStaffName(Name);
        staff.setStaffDOB(dob1);
        staff.setStaffAddr(Addr);
        staff.setStaffGender(gender1);
        staff.setStaffPhone(phone1);
        staff.setStaff_role(role1);
        staffDAO.editStaff(staff);
        loadStaff();
    }

//delete start
    public void rmvStaff(ActionEvent event){
        Alert.AlertType type=Alert.AlertType.CONFIRMATION;
        Alert al=new Alert(type,"");
        al.setTitle("Confirm");
        al.setContentText("Are you sure you want to delete this?");
        Optional<ButtonType> res= al.showAndWait();
        if(res.get() == ButtonType.OK){
            int idd=Integer.parseInt(txtID.getText());
            staffDAO.deleteStaff(idd);
            loadStaff();
        }
      
    }
//delete end

public void refreshstaff(){
    staffList.clear();
    database db=new database();
    try {
        
        db.getConnect();
        ResultSet rs=db.execution("SELECT * FROM Staff");
        while(rs.next()){
            staffList.add(new Staff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
        }
    } catch (SQLException e) {
        Logger.getLogger(StaffController.class.getName());
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
//refresh end
    
    
    //          Add staff end
    public void onSelect() {
        this.staffTable.setRowFactory(param -> {
            TableRow row = new TableRow();

            row.setOnMouseClicked(et -> {
                Staff s = this.staffTable.getSelectionModel().getSelectedItem();
                this.txtID.setText(Integer.toString(s.getStaffID()));
                this.name.setText((s.getStaffName()));
                this.dob.setText(s.getStaffDOB());
                if (s.getStaffGender().equals("Male")) male.setSelected(true);
                else female.setSelected(true);
                int r1=0;
                if(s.getRole_name().equals("Staff")){
                    r1=1;
                }else{
                    if(s.getRole_name().equals("Admin")){
                        r1=2;
                    }
                }
                this.role.setText(Integer.toString(r1));
                this.phone.setText(s.getStaffPhone());
                this.address.setText(s.getStaffAddr());
            });
            return row;
        });
    }

    public void clearAll(){
        txtID.clear();
        name.clear();
        dob.clear();
        phone.clear();
        address.clear();
        role.clear();
    }
    public void searchBar(){
        flstaff.removeAll();
        staffTable.setItems(flstaff);
        if (searchStaff.getText().isEmpty()) staffTable.setItems(staffList);            
        else {
            if (namesearch.isSelected()==true) flstaff.setPredicate(p -> p.getStaffName().toLowerCase().contains(searchStaff.getText().toLowerCase().trim()));
            else {
                if(searchStaff.getText().matches("[1-9]*")) flstaff.setPredicate(p -> p.getStaffID() == Integer.parseInt(searchStaff.getText()));
                else staffTable.setItems(staffList);
            }
        }
    }
}
