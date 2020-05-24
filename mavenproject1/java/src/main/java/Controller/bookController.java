package Controller;
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

public class bookController implements Initializable {
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
    private Button bookRefresh;
    @FXML
    private TextField id;
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
    ObservableList<Book> bookList = FXCollections.observableArrayList();
    
     
    @Override
    public void initialize( URL url, ResourceBundle rb){
        loadBook();
        onSelect();
    }
//Show data book from database
    public void loadBook() {
        database db=new database();
        try {
            
            db.getConnect();
            ResultSet rs=db.execution("SELECT * FROM book");
            while(rs.next()){
                bookList.add(new Book(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            Logger.getLogger(bookController.class.getName());
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
        refreshBook();
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
        int idd=Integer.parseInt(id.getText());
        book1.setBookID(idd);
        book1.setBookName(Name);
        book1.setBookAuthorID(Author);
        book1.setBookCategoryID(cate);
        book1.setBookPublisher(publish);
        book1.setBookPrice(cpri);
        book1.setBookPages(avai);
        bookDAO.editBook(book1);
        refreshBook();
    }
//refesh start
    public void refreshBook(){
        bookList.clear();
        database db=new database();
        try {
            
            db.getConnect();
            ResultSet rs=db.execution("SELECT * FROM book");
            while(rs.next()){
                bookList.add(new Book(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            Logger.getLogger(bookController.class.getName());
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
//refresh end

//delete start
    public void rmv(ActionEvent event){
        Alert.AlertType type=Alert.AlertType.CONFIRMATION;
        Alert al=new Alert(type,"");
        al.setTitle("Confirm");
        al.setContentText("Are you sure to Delete this?");
        Optional<ButtonType> res= al.showAndWait();
        if(res.get() == ButtonType.OK){
            int idd=Integer.parseInt(id.getText());
            bookDAO.deleteBook(idd);
            refreshBook();
        }
      
    }
//delete end

//select row from tableView
    public void onSelect() {
        this.bookTable.setRowFactory(param -> {
            TableRow row = new TableRow();
            row.setOnMouseClicked(et -> {
                Book b = this.bookTable.getSelectionModel().getSelectedItem();
                this.id.setText(Integer.toString(b.getBookID()));
                this.book.setText((b.getBookName()));
                this.author.setText(Integer.toString(b.getBookAuthorID()));
                this.category.setText(Integer.toString(b.getBookCategoryID()));
                this.publisher.setText(b.getBookPublisher());
                this.available.setText(Integer.toString(b.getBookPages()));
                this.price.setText(Integer.toString(b.getBookPrice()));
            });
            return row;
        });
    }
    public void clearAll(){
        id.clear();
        book.clear();
        author.clear();
        category.clear();
        publisher.clear();
        available.clear();
        price.clear();
    }

}