/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import DAO.AccountDAO;
import Entity.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.util.StringConverter;
import javafx.collections.*;
import javafx.scene.image.*;
import javafx.collections.transformation.FilteredList;


/**
 * FXML Controller class
 *
 * @achor lapgo
 */
public class AccountController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField userName;
    @FXML
    private TextField userPass;
    @FXML
    private DatePicker createday;
    @FXML
    private DatePicker outday;
    @FXML
    private TextField staffID;
    @FXML
    private Button addBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private Button update;
    @FXML
    private Button clear;
    @FXML
    private TableView<Account> tableAccount;
    @FXML
    private TableColumn<Account, Integer> t_id;
    @FXML
    private TableColumn<Account, String> t_name;
    @FXML
    private TableColumn<Account, String> t_pass;
    @FXML
    private TableColumn<Account, String> t_startdate;
    @FXML
    private TableColumn<Account, String> t_outdate;
    @FXML
    private TableColumn<Account, String> t_staffName;
    @FXML
    private ImageView userimg;
    @FXML
    private RadioButton namesearch;
    @FXML
    private RadioButton idsearch;
    @FXML
    private ToggleGroup searchbar;
    @FXML
    private TextField searchAccount;
    /**
     * Initializes the controller class.
     */
    ObservableList<Account> l_account= FXCollections.observableArrayList();
    


    @Override
    public void initialize( URL url, ResourceBundle rb){
        convertDate();
        convertDate1();
        loadAccount();
        onSelect();
    }
    public void convertDate(){
       String pattern="yyyy-MM-dd";
       createday.setPromptText(pattern.toLowerCase());
       createday.setConverter(new StringConverter<LocalDate>(){
        DateTimeFormatter DTF=DateTimeFormatter.ofPattern(pattern);
           @Override
           public String toString(LocalDate t) {
               if(t !=null){
                   return DTF.format(t);
               }
               return null;
           }
    
             @Override
           public LocalDate fromString(String string) {
               if(string !=null && !string.isEmpty()){
                   return LocalDate.parse(string,DTF);
               }
               return null;
           }
       }); 
    }
    public void convertDate1(){
        String pattern="yyyy-MM-dd";
        outday.setPromptText(pattern.toLowerCase());
        outday.setConverter(new StringConverter<LocalDate>(){
         DateTimeFormatter DTF=DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate t) {
                if(t !=null){
                    return DTF.format(t);
                }
                return null;
            }
     
              @Override
            public LocalDate fromString(String string) {
                if(string !=null && !string.isEmpty()){
                    return LocalDate.parse(string,DTF);
                }
                return null;
            }
        }); 
     }
    public void loadAccount() {
        database db=new database();
        try {
            
            db.getConnect();
            //ResultSet rs=db.execution("SELECT * FROM student");
            //while(rs.next()){
                //studentList.add(new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getInt(7)));
                l_account=AccountDAO.loadAccount();
            //}
        } catch (Exception e) {
            Logger.getLogger(cardController.class.getName());
        }
        db.disconnect();
        t_id.setCellValueFactory(new PropertyValueFactory<>("userID"));
        t_name.setCellValueFactory(new PropertyValueFactory<>("userName"));
        t_pass.setCellValueFactory(new PropertyValueFactory<>("userPassword"));
        t_startdate.setCellValueFactory(new PropertyValueFactory<>("createday"));
        t_outdate.setCellValueFactory(new PropertyValueFactory<>("outofday"));
        t_staffName.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        tableAccount.setItems(l_account);     
    }
    //        ADD student Start
    
    public void addAccountBtn(ActionEvent event) throws Exception{
        try{
            Account ac= new Account();
            String Name=userName.getText();
            String Pass=userPass.getText();
            LocalDate date1= LocalDate.now();
            LocalDate date2= outday.getValue();
            String dob1=date1.toString();
            String dob2=date2.toString();
            int staffidd=Integer.parseInt(staffID.getText());
            ac.setUserName(Name);
            ac.setUserPassword(Pass);
            ac.setCreateday(dob1);
            ac.setOutofday(dob2);
            ac.setStaffID(staffidd);
            AccountDAO.addAccount(ac);}
            catch(Exception e){e.printStackTrace();}
            clearALL();
            loadAccount();
        }
        public void updateAccountBtn(ActionEvent event) throws Exception{
            try{
            Account ac = new Account();
            int idd=Integer.parseInt(id.getText());
            String username=userName.getText();
            String userpass=userPass.getText();
            int staffidd=Integer.parseInt(staffID.getText());
            LocalDate date1=outday.getValue();
            String dob1=date1.toString();
            LocalDate date2=createday.getValue();
            String dob2=date2.toString();
            ac.setUserID(idd);
            ac.setUserName(username);
            ac.setUserPassword(userpass);
            ac.setCreateday(dob2);
            ac.setOutofday(dob1);
            ac.setStaffID(staffidd);
            AccountDAO.editAccount(ac);}
            catch(Exception e){e.printStackTrace();}
            loadAccount();
    }

//delete start
    public void removeAccountBtn(ActionEvent event){
        try{
            Alert.AlertType type=Alert.AlertType.CONFIRMATION;
            Alert al=new Alert(type,"");
            al.setTitle("Confirm");
            al.setContentText("Are you sure you want to delete this?");
            Optional<ButtonType> res= al.showAndWait();
            if(res.get() == ButtonType.OK){
                int idd=Integer.parseInt(id.getText());
                AccountDAO.deleteAccount(idd);
                loadAccount();
            }}
        catch(Exception e){e.printStackTrace();}
    }
//delete end    
    
    //          Add student end
    public void onSelect() {
        this.tableAccount.setRowFactory(param -> {
            TableRow row = new TableRow();
            row.setOnMouseClicked(et -> {
                Account ac = this.tableAccount.getSelectionModel().getSelectedItem();
                this.id.setText(Integer.toString(ac.getUserID()));
                this.userName.setText((ac.getUserName()));
                this.userPass.setText(ac.getUserPassword());
                LocalDate dob1=LocalDate.parse(ac.getOutofday());
                LocalDate dob2=LocalDate.parse(ac.getCreateday());
                this.outday.setValue(dob1);
                this.createday.setValue(dob2);
                this.staffID.setText(Integer.toString(ac.getStaffID()));
            });
            return row;
        });
    }

    public void clearALL(){
        id.clear();
        userName.clear();
        outday.setValue(null);
        userPass.clear();
        staffID.clear();
    }

    public void searchBar(){
        FilteredList<Account> flaccount = new FilteredList(l_account, p -> true);
        flaccount.removeAll();
        tableAccount.setItems(flaccount);
        if (searchAccount.getText().isEmpty()) tableAccount.setItems(l_account);        
        else {
            if (namesearch.isSelected()==true) flaccount.setPredicate(p -> p.getUserName().toLowerCase().contains(searchAccount.getText().toLowerCase().trim()));
            else {
                if(searchAccount.getText().matches("[1-9]*")) flaccount.setPredicate(p -> p.getUserID() == Integer.parseInt(searchAccount.getText()));
                else tableAccount.setItems(l_account);
            }
        }
    }
}
