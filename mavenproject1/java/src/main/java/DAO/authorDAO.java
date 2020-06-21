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
                author.setAuthorEmail(rs.getString(5));
                l_Author.add(author);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error while loading author");
        }
        db.disconnect();
        return l_Author;
    }
    public static void addAuthor(Author Author){
        database db = new database();
        db.getConnect();
        try{
            String sql = "INSERT INTO author (authorName,authorGender,authorDOB,authorEmail ) VALUES ('";
            sql +=Author.getAuthorName()+"','";
            sql += Author.getAuthorGender() +"','";
            sql += Author.getAuthorDOB() +"','";
            sql +=Author.getAuthorEmail()+"');";
            db.update(sql);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        db.disconnect();
    }
    public static void deleteAuthor(int authorID){
        database db = new database();
        db.getConnect();
        try{
        db.update("DELETE FROM Author WHERE authorID="+authorID);
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
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
        sql+="authorEmail='"+ author.getAuthorEmail() + "' WHERE authorID='"+author.getAuthorID()+"';";
        db.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
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
            JOptionPane.showMessageDialog(null,"Can't find anything about this");
        }
        db.disconnect();
        return null;
    }

    public static int findRoleByName(String authorName){
        int authorid=0;
        database db = new database();
        db.getConnect();
        ResultSet rs = db.execution("SELECT authorID From author WHERE authorName='"+authorName+"'");
        try {
            while(rs.next()){
                authorid=rs.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Can't find anything about this");
            
        }
        db.disconnect();
        return authorid;
    }
}