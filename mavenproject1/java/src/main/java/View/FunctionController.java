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
import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;
import Controller.database;
import DAO.AccountDAO;
import Entity.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.control.cell.*;

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
    private TableColumn<Book, String> bookAuthor;
    @FXML
    private TableColumn<Book, String> bookCategory;
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

    public void loadBook() {
        database db=new database();
        try {
            
            db.getConnect();
            ResultSet rs=db.execution("SELECT * FROM book_detail");
            while(rs.next()){
                bookList.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            Logger.getLogger(FunctionController.class.getName());
        }
        db.disconnect();
        bookID.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        bookAuthor.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        bookCategory.setCellValueFactory(new PropertyValueFactory<>("bookCategory"));
        bookPub.setCellValueFactory(new PropertyValueFactory<>("bookPublisher"));
        bookPrice.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));
        bookQuantity.setCellValueFactory(new PropertyValueFactory<>("bookPages"));
        bookTable.setItems(bookList);     
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

        this.bookTable.setRowFactory(param -> {
            TableRow row2 = new TableRow();

            row2.setOnMouseClicked(et -> {
                Book b = this.bookTable.getSelectionModel().getSelectedItem();
                this.book.setText((b.getBookName()));
                this.author.setText(b.getBookAuthor());
                this.category.setText(b.getBookCategory());
                this.publisher.setText(b.getBookPublisher());
                /*this.available.setText(Integer.toString(b.getStaff_role()));*/
                this.price.setText(Integer.toString(b.getBookPrice()));
            });
            return row2;
        });
    }
}
