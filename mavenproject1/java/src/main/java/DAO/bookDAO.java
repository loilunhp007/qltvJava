package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.sql.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

import Controller.database;
import Entity.Book;
import javafx.collections.*;
public class bookDAO{

    public static ObservableList<Book> load() {
        ObservableList<Book> l_book =FXCollections.observableArrayList();
        database db = new database();
        db.getConnect();
        ResultSet rs = db.execution("SELECT b.bookID,b.bookName,b.bookAuthorID,b.bookCategoryID,b.bookPublisher,b.bookPrice,b.bookPages,a.authorName,cate.categoryName From book b left join author a on b.bookAuthorID=a.authorID left join categories cate on b.bookCategoryID=cate.categoryID ;");
        try {
            while(rs.next()){
                Book book = new Book(rs.getInt(1));
                book.setBookName(rs.getString(2));
                book.setBookAuthorID(rs.getInt(3));
                book.setBookCategoryID(rs.getInt(4));
                book.setBookPublisher(rs.getString(5));
                book.setBookPrice(rs.getInt(6));
                book.setBookPages(rs.getInt(7));
                book.setBookAuthor(rs.getString(8));
                book.setBookCategory(rs.getString(9));
                l_book.add(book);
            }
        } catch (Exception e) {
        }
        db.disconnect();
        return l_book;
        

    }
    public static  void addBook(Book book) {
        database db = new database();
        db.getConnect();
        try {
            File file= new File(staff.getBookImg());
            FileInputStream input= new FileInputStream(file);            
            String sql = "INSERT INTO book (bookName,bookAuthorID,bookCategoryID,bookPublisher,bookPrice,bookPages,bookImg) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st= db.getCon().prepareStatement(sql);
            st.setString(1, book.getBookName());
            //sql +=book.getBookName()+"','";
            st.setInt(2, book.getBookAuthorID());
            //sql += book.getBookAuthorID() +"','";
            st.setInt(3, book.getBookCategoryID());
            //sql += book.getBookCategoryID() +"','";
            st.setString(4, book.getBookPublisher());
            //sql +=book.getBookPublisher()+"','";
            st.setInt(5, book.getBookPrice());
            //sql +=book.getBookPrice()+"','";
            st.setInt(6, book.getBookPages());
            //sql +=book.getBookPages()+"');";
            st.setBinaryStream(7, input);
            db.update(sql);
        } catch (Exception e) {
            e.getMessage();
        }
        db.disconnect();
    }
    public static void deleteBook(int bookID){
        database db = new database();
        db.getConnect();
        db.update("DELETE FROM book WHERE bookID="+bookID);
        db.disconnect();
    }
    public static void editBook(Book book){
        database db=new database();
        db.getConnect();
        try {
            File file=new File(staff.getBookImg());
            FileInputStream input= new FileInputStream(file);
            String sql="UPDATE book SET bookName=?, bookAuthorID=?, bookCategoryID=?, bookPublisher=?, bookPrice=?, bookPages=?, bookImg=? WHERE bookID="+book.getBookID()+";";
            PreparedStatement st = db.getCon().prepareStatement(sql);
            st.setString(1, book.getBookName());
            //sql +=book.getBookName()+"','";
            st.setInt(2, book.getBookAuthorID());
            //sql += book.getBookAuthorID() +"','";
            st.setInt(3, book.getBookCategoryID());
            //sql += book.getBookCategoryID() +"','";
            st.setString(4, book.getBookPublisher());
            //sql +=book.getBookPublisher()+"','";
            st.setInt(5, book.getBookPrice());
            //sql +=book.getBookPrice()+"','";
            st.setInt(6, book.getBookPages());
            //sql +=book.getBookPages()+"');";
            st.setBinaryStream(7, input);
        db.update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }        
        db.disconnect();
    }
    public static Book findBookByID(int bookID){
        database db = new database();
        db.getConnect();
        ResultSet rs = db.execution("SELECT * From book WHERE bookID="+bookID);
        try {
            while(rs.next()){
                Book book = new Book(rs.getInt(1));
                book.setBookName(rs.getString(2));
                book.setBookAuthorID(rs.getInt(3));
                book.setBookCategoryID(rs.getInt(4));
                book.setBookPublisher(rs.getString(5));
                book.setBookPrice(rs.getInt(6));
                book.setBookPages(rs.getInt(7));
                book.setBlob(rs.getBlob(8));
                return book;
            }
        } catch (Exception e) {
            
        }
        db.disconnect();
        return null;
    }
    public static void forlend(int bookID){
        database db=new database();
        db.getConnect();
        try {
            Book book=new Book();
            book=findBookByID(bookID);
            int available=(book.getBookPages()-1);
            if(available > 0){
                String sql="UPDATE book SET ";
                sql+="bookPages='"+available+"' WHERE bookID="+book.getBookID()+";";
                db.update(sql);
            }
            else{
                JOptionPane.showMessageDialog(null,"this book is over");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error While Lending book");
        }        
        db.disconnect();
    }
    public static void returnlend(int bookID){
        database db=new database();
        db.getConnect();
        try {
            Book book=new Book();
            book=findBookByID(bookID);
            int available=book.getBookPages()+1;
                String sql="UPDATE book SET ";
                sql+="bookPages='"+available+"' WHERE bookID="+book.getBookID()+";";
                db.update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error While Returning book");
        }        
        db.disconnect();
    }
}