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
import DAO.AccountDAO;
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
public class FunctionController implements Initializable {
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
    private ToggleGroup gender;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
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
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, Integer> bookID;
    @FXML
    private TableColumn<Book, String> bookName;
    @FXML
    private TableColumn<Book, Integer> bookAuthorID;
    @FXML
    private TableColumn<Book, Integer> bookCategoryID;
    @FXML
    private TableColumn<Book, String> bookPub;
    @FXML
    private TableColumn<Book, Integer> bookQuantity;
    @FXML
    private TableColumn<Book, Integer> bookPrice;
    @FXML
    private Button bookAdd;
    @FXML
    private Button bookUpdate;
    @FXML
    private Button bookRemove;
    @FXML
    private TextField book;
    @FXML
    private TextField author;
    @FXML
    private TextField category;
    @FXML
    private TextField publisher;
    @FXML
    private TextField price;
    @FXML
    private TextField available;
    @FXML
    private TextField bookSearch;
    /**
     * Initializes the controller class.
     */
    ObservableList<Staff> staffList = FXCollections.observableArrayList();
    ObservableList<Book> bookList = FXCollections.observableArrayList();
     
    @Override
    public void initialize( URL url, ResourceBundle rb){
        loadStaff();
        loadBook();
        onSelect();
    }
//show staff data
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
//Show data book from database
    public void loadBook() {
        database db=new database();
        try {
            
            db.getConnect();
            ResultSet rs=db.execution("SELECT * FROM book_detail");
            while(rs.next()){
                bookList.add(new Book(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            Logger.getLogger(FunctionController.class.getName());
        }
        db.disconnect();
        bookID.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        bookAuthorID.setCellValueFactory(new PropertyValueFactory<>("bookAuthorID"));
        bookCategoryID.setCellValueFactory(new PropertyValueFactory<>("bookCategoryID"));
        bookPub.setCellValueFactory(new PropertyValueFactory<>("bookPublisher"));
        bookPrice.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));
        bookQuantity.setCellValueFactory(new PropertyValueFactory<>("bookPages"));
        bookTable.setItems(bookList);     
    }
    @FXML
    public void addBookbtn(ActionEvent event) throws Exception{
        Book book1= new Book();
        String Name=book.getText();
        int  Author=Integer.parseInt(author.getText());
        int cate= Integer.parseInt(category.getText());
        String publish=publisher.getText();
        int cpri=Integer.parseInt(price.getText());
        int avai=Integer.parseInt(available.getText());
        book1.setBookName(Name);
        book1.setBookAuthorID(Author);
        book1.setBookCategoryID(cate);
        book1.setBookPublisher(publish);
        book1.setBookPrice(cpri);
        book1.setBookPages(avai);
        bookDAO.addBook(book1);
    }
    public void updateBookBtn(ActionEvent event) throws Exception{
        //error
        Book book1 = new Book();
        String Name=book.getText();
        int  Author=Integer.parseInt(author.getText());
        int cate= Integer.parseInt(category.getText());
        String publish=publisher.getText();
        int cpri=Integer.parseInt(price.getText());
        int avai=Integer.parseInt(available.getText());
        book1.setBookName(Name);
        book1.setBookAuthorID(Author);
        book1.setBookCategoryID(cate);
        book1.setBookPublisher(publish);
        book1.setBookPrice(cpri);
        book1.setBookPages(avai);
        bookDAO.editBook(book1);
    }



//select row from tableView
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

        this.bookTable.setRowFactory(param -> {
            TableRow row2 = new TableRow();

            row2.setOnMouseClicked(et -> {
                Book b = this.bookTable.getSelectionModel().getSelectedItem();
                this.book.setText((b.getBookName()));
                this.author.setText(Integer.toString(b.getBookAuthorID()));
                this.category.setText(Integer.toString(b.getBookCategoryID()));
                this.publisher.setText(b.getBookPublisher());
                /*this.available.setText(Integer.toString(b.getStaff_role()));*/
                this.price.setText(Integer.toString(b.getBookPrice()));
            });
            return row2;
        });
    }
}
