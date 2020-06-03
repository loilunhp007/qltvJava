package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;

import Controller.database;
import Entity.Book;
import Entity.BookLending;
import Entity.Lending_Detail;
import javafx.collections.*;
public class Lending_detailDAO {
    public static ObservableList<Lending_Detail> load(){
        ObservableList<Lending_Detail> l_lenddetail = FXCollections.observableArrayList();
        database db = new database();
        ResultSet rs= db.execution("SELECT ld.lendID,b,bookName,ld.dueDay,ld.lenStatus FROM lending_detail ld join booklending bl on ld.lendID=bl.lendID join book b on ld.bookID=b.bookID;");
        try {
            while(rs.next()){
                Lending_Detail ld=new Lending_Detail(rs.getInt(1),rs.getInt(2));
                ld.setDueDay(rs.getString(3));
                ld.setLendStatus(rs.getString(4));
                l_lenddetail.add(ld);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Lending book detail  error");
        }
        db.disconnect();
        return l_lenddetail;
    }
    public static void addLend(Lending_Detail ld){
        database db = new database();
        db.getConnect();
        String sql = "INSERT INTO lending_detail (lendID,bookID,dueDay,lendStatus) VALUES ('";
        sql +=ld.getLendID()+"','";
        sql += ld.getBookID() +"','";
        sql += ld.getDueDay() +"','";
        sql +=ld.getLendStatus()+"');";
        db.update(sql);
        db.disconnect();
    }
    public static void editLend(Lending_Detail ld){
        database db=new database();
        db.getConnect();
        try {
            String sql="UPDATE lending_detail SET ";
        sql+="dueDay='"+ ld.getDueDay()+"',";
        sql+="lendStatus='"+ ld.getLendStatus()+"' WHERE lendID='"+ld.getLendID()+"' AND bookID='"+ld.getBookID()+"';";
        db.update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }        
        db.disconnect();
    }
    public static void deleteLend(int lendID,int bookID){
        database db = new database();
        db.getConnect();
        db.update("DELETE FROM booklending WHERE lendID='"+lendID+"' AND bookID='"+bookID+"'");
        db.disconnect();
    }
    public static BookLending findLendByID(int lendID){
        database db = new database();
        db.getConnect();
        ResultSet rs = db.execution("SELECT * From booklending WHERE lendID="+ lendID);
        try {
            while(rs.next()){
                BookLending bl = new BookLending(rs.getInt(1));
                bl.setLendStudentID(rs.getInt(2));
                bl.setCreateDay(rs.getString(3));
                bl.setIssued_by(rs.getInt(4));
                return bl;
            }
        } catch (Exception e) {
            
        }
        db.disconnect();
        return null;
    }
    public static int newLendID(){
        database db=new database();
        db.getConnect();
        ResultSet rs=db.execution("SELECT Max(lendID) FROM lending_detail;");
        try{
            while(rs.next()){
                int id=rs.getInt(1)+1;
                db.disconnect();
                return id;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No  detail found");
        }
        db.disconnect();
        return -1;
    }    
}