package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.database;
 import Entity.Book;

public class bookDAO{

    public static List<Book> load(){
        List<Book> l_book = new ArrayList<>();
        database db = new database();
        db.getConnect();
        ResultSet rs = db.execution("SELECT * From book;");
        try {
            while(rs.next()){
                Book book = new Book(rs.getInt(1));
                book.setBookName(rs.getString(2));
                book.setBookAuthorID(rs.getInt(3));
                book.setBookCategoryID(rs.getInt(4));
                book.setBookPublisher(rs.getString(5));
                book.setBookPrice(rs.getInt(6));
                book.setBookPages(rs.getInt(7));
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
        String sql = "INSERT INTO book (bookName,bookAuthorID,bookCategoryID,bookPublisher,bookPrice,bookPages ) VALUES ('";
        sql +=book.getBookName()+"','";
        sql += book.getBookAuthorID() +"','";
        sql += book.getBookCategoryID() +"','";
        sql +=book.getBookPublisher()+"','";
        sql +=book.getBookPrice()+"','";
        sql +=book.getBookPages()+"');";
        db.update(sql);
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
            String sql="UPDATE book SET ";
        sql+="bookName='"+ book.getBookName()+"',";
        sql+="bookAuthorID='"+ book.getBookAuthorID()+"',";
        sql+="bookCategoryID='"+ book.getBookCategoryID()+"',";
        sql+="bookPublisher='"+ book.getBookPublisher()+"',";
        sql+="bookPrice='"+book.getBookPrice()+"',";
        sql+="bookPages='"+book.getBookPages()+"' WHERE bookID="+book.getBookID()+";";
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
                return book;
            }
        } catch (Exception e) {
            
        }
        db.disconnect();
        return null;
    }
}