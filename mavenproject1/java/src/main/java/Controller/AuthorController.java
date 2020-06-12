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

import DAO.authorDAO;
import Entity.Author;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.util.StringConverter;
import javafx.collections.transformation.FilteredList;
import javafx.scene.image.*;

/**
 * FXML Controller class
 *
 * @author lapgo
 */
public class AuthorController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField authorName;
    @FXML
    private TextField authorEmail;
    @FXML
    private DatePicker dob;
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton female;
    @FXML 
    private RadioButton idsearch;
    @FXML
    private ToggleGroup searchbar;
    @FXML
    private RadioButton namesearch;
    @FXML
    private TextField price;
    @FXML
    private TextField category;
    @FXML
    private Button addBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private Button update;
    @FXML
    private Button clear;
    @FXML
    private TableView<Author> tableAuthor;
    @FXML
    private TableColumn<Author, Integer> t_id;
    @FXML
    private TableColumn<Author, String> t_name;
    @FXML
    private TableColumn<Author, String> t_dob;
    @FXML
    private TableColumn<Author, String> t_email;
    @FXML
    private TableColumn<Author, String> t_gender;
    @FXML
    private ImageView userimg;
    @FXML
    private TextField searchAuthor;

    /**
     * Initializes the controller class.
     */
    ObservableList<Author> authorList= FXCollections.observableArrayList();
    @Override
    public void initialize( URL url, ResourceBundle rb){
        convertDate();
        loadAuthor();
        onSelect();
    }
    public void convertDate(){
       String pattern="yyyy-MM-dd";
       dob.setPromptText(pattern.toLowerCase());
       dob.setConverter(new StringConverter<LocalDate>(){
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
    public void loadAuthor() {
        database db=new database();
        try {
            
            db.getConnect();
            //ResultSet rs=db.execution("SELECT * FROM student");
            //while(rs.next()){
                //studentList.add(new Author(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getInt(7)));
                authorList=authorDAO.load();
            //}
        } catch (Exception e) {
            Logger.getLogger(cardController.class.getName());
        }
        db.disconnect();
        t_id.setCellValueFactory(new PropertyValueFactory<>("authorID"));
        t_name.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        t_gender.setCellValueFactory(new PropertyValueFactory<>("authorGender"));
        t_dob.setCellValueFactory(new PropertyValueFactory<>("authorDOB"));
        t_email.setCellValueFactory(new PropertyValueFactory<>("authorEmail"));
        tableAuthor.setItems(authorList);     
    }
    //        ADD student Start
    
    public void addAuthorBtn(ActionEvent event) throws Exception{
        try{Author aut= new Author();
        String Name=authorName.getText();
        LocalDate date1= dob.getValue();
        String dob1=date1.toString();
        String  email1=authorEmail.getText();
        String gender1=null;
        if(male.isSelected()==true){
            gender1=male.getText();
        }
        if(female.isSelected()==true){
            gender1=female.getText();
        }
        aut.setAuthorName(Name);
        aut.setAuthorGender(gender1);
        aut.setAuthorDOB(dob1);
        aut.setAuthorEmail(email1);
        authorDAO.addAuthor(aut);}
        catch(Exception e){e.printStackTrace();}
        clearALL();
        loadAuthor();
    }
    public void updateAuthorBtn(ActionEvent event) throws Exception{
        try{
        Author aut = new Author();
        int idd=Integer.parseInt(id.getText());
        String Name=authorName.getText();
        LocalDate date1=dob.getValue();
        String dob1=date1.toString();
        String  email1=authorEmail.getText();
        String gender1=null;
        if(male.isSelected()==true){
            gender1=male.getText();
        }
        if(female.isSelected()==true){
            gender1=female.getText();
        }
        aut.setAuthorID(idd);
        aut.setAuthorName(Name);
        aut.setAuthorDOB(dob1);
        aut.setAuthorEmail(email1);
        aut.setAuthorGender(gender1);
        authorDAO.editAuthor(aut);}
        catch(Exception e){e.printStackTrace();}
        loadAuthor();
    }

//delete start
    public void removeAuthorBtn(ActionEvent event){
        try{
            Alert.AlertType type=Alert.AlertType.CONFIRMATION;
            Alert al=new Alert(type,"");
            al.setTitle("Confirm");
            al.setContentText("Are you sure you want to delete this?");
            Optional<ButtonType> res= al.showAndWait();
            if(res.get() == ButtonType.OK){
                int idd=Integer.parseInt(id.getText());
                authorDAO.deleteAuthor(idd);
                loadAuthor();
            }}
        catch(Exception e){e.printStackTrace();}
    }
//delete end    
    
    //          Add student end
    public void onSelect() {
        this.tableAuthor.setRowFactory(param -> {
            TableRow row = new TableRow();
            row.setOnMouseClicked(et -> {
                Author aut = this.tableAuthor.getSelectionModel().getSelectedItem();
                this.id.setText(Integer.toString(aut.getAuthorID()));
                this.authorName.setText((aut.getAuthorName()));
                LocalDate dob1=LocalDate.parse(aut.getAuthorDOB());
                this.dob.setValue(dob1);
                if (aut.getAuthorGender().equals("Male")) male.setSelected(true);
                else female.setSelected(true);
            });
            return row;
        });
    }

    public void clearALL(){
        id.clear();
        authorName.clear();
        dob.setValue(null);
        authorEmail.clear();
        male.setSelected(true);;
    }
    
    public void searchBar(){
        FilteredList<Author> flaccount = new FilteredList(authorList, p -> true);
        flaccount.removeAll();
        tableAuthor.setItems(flaccount);
        if (searchAuthor.getText().isEmpty()) tableAuthor.setItems(authorList);        
        else {
            if (namesearch.isSelected()==true) flaccount.setPredicate(p -> p.getAuthorName().toLowerCase().contains(searchAuthor.getText().toLowerCase().trim()));
            else {
                if(searchAuthor.getText().matches("[1-9]*")) flaccount.setPredicate(p -> p.getAuthorID() == Integer.parseInt(searchAuthor.getText()));
                else tableAuthor.setItems(authorList);
            }
        }
    }
}
