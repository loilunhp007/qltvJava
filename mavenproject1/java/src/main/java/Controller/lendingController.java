package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.Date;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Controller.database;
import DAO.Lending_detailDAO;
import DAO.authorDAO;
import DAO.bookDAO;
import DAO.bookLendingDAO;
import DAO.staffDAO;
import DAO.studentDAO;
import Entity.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.control.cell.*;
import javafx.util.StringConverter;
import javafx.event.*;
import javafx.collections.transformation.FilteredList;
public class lendingController implements Initializable {
    
    @FXML
    private TableView<BookLending> tableLend;
    @FXML
    private TableColumn<Student, Integer> t_ID;
    @FXML
    private TableColumn<Student, String> t_name;
    @FXML
    private TableColumn<Student, String> t_create;
    @FXML
    private TableColumn<Student, String> t_staff;
    @FXML
    private TableColumn<Student, Integer> t_total;
    @FXML
    private Button addBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private Button clear;
    @FXML
    private Button checkbookBtn;
    @FXML
    private Button checkcardBtn;
    @FXML
    private Button checkstaffBtn;
    @FXML
    private TextField lendID;
    @FXML
    private TextField cardID;
    @FXML
    private TextField bookID;
    @FXML
    private TextField bookAuthor;
    @FXML
    private DatePicker createday;
    @FXML
    private TextField book;
    @FXML
    private TextField staffID;
    @FXML
    private TextField studentName;
    @FXML
    private TextField studentClass;
    @FXML
    private TextField price;
    @FXML
    private TextField staffName;
    @FXML
    private TextField search;
    ObservableList<BookLending> lendList = FXCollections.observableArrayList();
    @Override
    public void initialize( URL url, ResourceBundle rb){
        convertDate();
        loadLend();
        //onSelect();
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
    public void loadLend() {
        database db=new database();
        try {
            
            db.getConnect();
            //ResultSet rs=db.execution("SELECT * FROM student");
            //while(rs.next()){
                //studentList.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getInt(7)));
                lendList=bookLendingDAO.load();
            //}
        } catch (Exception e) {
            Logger.getLogger(lendingController.class.getName());
        }
        db.disconnect();
        t_ID.setCellValueFactory(new PropertyValueFactory<>("lendID"));
        t_name.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        t_create.setCellValueFactory(new PropertyValueFactory<>("createDay"));
        t_staff.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        t_total.setCellValueFactory(new PropertyValueFactory<>("total"));
        tableLend.setItems(lendList);     
    }
    //Check book
    public void checkBook(ActionEvent event) throws Exception{
        int bookid1=Integer.parseInt(bookID.getText());
        Book b1=new Book();
        Author aut=new Author();
        b1=bookDAO.findBookByID(bookid1);
        aut=authorDAO.findAuthorByID(b1.getBookAuthorID());
        book.setText(b1.getBookName());
        bookAuthor.setText(aut.getAuthorName());
        String price1=Integer.toString(b1.getBookPrice());
        price.setText(price1);
    }
//Check book end

//Check card student

public void checkCard(ActionEvent event) throws Exception{
    try {
        int cardid1=Integer.parseInt(cardID.getText());
    Student st1=new Student();
    st1=studentDAO.findStudentByID(cardid1);
    studentName.setText(st1.getStudentName());
    studentClass.setText(st1.getStudentClass());    
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"No Student Found");
    }
    
}

//Check card student end

//staff check
public void checkStaff(ActionEvent event) throws Exception{
    try {
        int staffid1=Integer.parseInt(staffID.getText());
        Staff staff1=new Staff();
        staff1=staffDAO.findstaffByID(staffid1);
        staffName.setText(staff1.getStaffName());    
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"No Student Found");
    }
    
}

//staff check end
    //        ADD borrow Start
    
    public void addLendBtn(ActionEvent event) throws Exception{
        try {
        BookLending bl = new BookLending();
        Lending_Detail ld= new Lending_Detail();
        int cardid1=Integer.parseInt(cardID.getText());
        LocalDate date1= LocalDate.now();
        createday.setValue(date1);
        LocalDate date2=createday.getValue();
        String create1=date2.toString();
        int staff1=Integer.parseInt(staffID.getText());
        bl.setLendStudentID(cardid1);
        bl.setCreateDay(create1);
        bl.setIssued_by(staff1);
        bookLendingDAO.addLend(bl);
        //add to booklending
        int lendid1=Lending_detailDAO.newLendID();
        String book1=book.getText();   
        String out= null;
        String txtID=bookID.getText();
        int bookID=Integer.parseInt(txtID);
        ld.setLendID(lendid1);
        ld.setBookID(bookID);
        ld.setDueDay(out);
        ld.setLendStatus("Lending");//add to detail
        Lending_detailDAO.addLend(ld);
        //clearALL();
        loadLend();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error to Lend");
        }
    }


    //Borrowed book End
    public void updateLendBtn(ActionEvent event) throws Exception{
        //error
        BookLending bl = new BookLending();
        int idd=Integer.parseInt(lendID.getText());
        String Name=cardID.getText();
        int cardid=Integer.parseInt(Name);
        LocalDate date1=createday.getValue();
        String create1=date1.toString();
        String  staff1=staffID.getText();
        int issued_by=Integer.parseInt(staff1);
        bl.setLendID(idd);
        bl.setLendStudentID(cardid);
        bl.setCreateDay(create1);
        bl.setIssued_by(issued_by);
        bookLendingDAO.editLend(bl);
        loadLend();
    }

//delete start
    public void removeCardBtn(ActionEvent event){
        Alert.AlertType type=Alert.AlertType.CONFIRMATION;
        Alert al=new Alert(type,"");
        al.setTitle("Confirm");
        al.setContentText("Are you sure you want to delete this?");
        Optional<ButtonType> res= al.showAndWait();
        if(res.get() == ButtonType.OK){
            int idd=Integer.parseInt(lendID.getText());
            int idd2=Integer.parseInt(book.getText());
            bookLendingDAO.deleteLend(idd);
            Lending_detailDAO.deleteLend(idd, idd2);
            loadLend();
        }
      
    }
//delete end    
    
    //          Add student end
    /*public void onSelect() {
        this.tableLend.setRowFactory(param -> {
            TableRow row = new TableRow();

            row.setOnMouseClicked(et -> {
                BookLending bl = this.tableLend.getSelectionModel().getSelectedItem();
                this.lendID.setText(Integer.toString(bl.getLendID()));
                this.st.setText((student.getStudentName()));
                LocalDate create1=LocalDate.parse(student.getStudentDOB());
                this.create.setValue(create1);
                this.studentclass.setText(student.getStudentClass());
            });
            return row;
        });
    }
    public void clearALL(){
        id.clear();
        name.clear();
        create.setValue(null);
        email.clear();
        studentclass.clear();
    }*/
}