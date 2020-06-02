package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;

import Controller.database;
import Entity.Author;
import javafx.collections.*;
public class authorDAO {
    public static ObservableList<Author> load(){
        ObservableList<Author> l_Author=  FXCollections.observableArrayList();
        database db=new database();
        db.getConnect();
        ResultSet rs = db.execution("SELECT * From author;");
        try {
            while(rs.next()){
                Author author = new Author(rs.getInt(1));
                author.setAuthorName(rs.getString(2));
                author.setAuthorGender(rs.getString(3));
                author.setAuthorDOB(rs.getString(4));
                author.setAuthorGender(rs.getString(5));
                author.setAuthorEmail(rs.getString(6));
                l_Author.add(author);
            }
        } catch (Exception e) {
        }
        db.disconnect();
        return l_Author;
    }
    public static void addAuthor(Author Author){
        database db = new database();
        db.getConnect();
        String sql = "INSERT INTO author (authorName,authorGender,authorDOB,authorEmail ) VALUES ('";
        sql +=Author.getAuthorName()+"','";
        sql += Author.getAuthorGender() +"','";
        sql += Author.getAuthorDOB() +"','";
        sql +=Author.getAuthorEmail()+"');";
        db.update(sql);
        db.disconnect();
    }
    public static void deleteAuthor(int authorID){
        database db = new database();
        db.getConnect();
        db.update("DELETE FROM Author WHERE authorID="+authorID);
        db.disconnect();
    }
    public static void editAuthor(Author author){
        database db=new database();
        db.getConnect();
        try {
            String sql="UPDATE Author SET ";
        sql+="authorName='"+ author.getAuthorName()+"',";
        sql+="authorGender='"+ author.getAuthorGender()+"',";
        sql+="authorDOB='"+ author.getAuthorDOB()+"',";
        sql+="AuthorPublisher='"+ author.getAuthorEmail() + " WHERE suthorID="+author.getAuthorID()+";";
        db.update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }        
        db.disconnect();
    }
    public static Author findAuthorByID(int authorID){
        database db = new database();
        db.getConnect();
        ResultSet rs = db.execution("SELECT * From author WHERE authorID="+authorID);
        try {
            while(rs.next()){
                Author author = new Author(rs.getInt(1));
                author.setAuthorName(rs.getString(2));
                author.setAuthorGender(rs.getString(3));
                author.setAuthorDOB(rs.getString(4));
                author.setAuthorEmail(rs.getString(5));
                return author;
            }
        } catch (Exception e) {
            
        }
        db.disconnect();
        return null;
    }

    
}