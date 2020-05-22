package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.database;
import Entity.Book;
import Entity.BookLending;

public class bookLendingDAO {
    public static List<BookLending> load(){
        List<BookLending> l_lending= new ArrayList<>();
        database db = new database();
        ResultSet rs= db.execution("SELECT * FROM booklending;");
        try {
            while(rs.next()){
                BookLending bl=new BookLending(rs.getInt(1));
                bl.setLendStudentID(rs.getInt(2));
                bl.setCreateDay(rs.getString(3));
                bl.setSetdueday(rs.getString(4));
                bl.setIssued_by(rs.getInt(5));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        db.disconnect();
        return l_lending;
    }
    public static void addLend(BookLending bl){
        database db = new database();
        db.getConnect();
        String sql = "INSERT INTO booklending (lendID,lendStudentID,createDay,setdueDay,issued_by) VALUES ('";
        sql +=bl.getStudentUserID()+"','";
        sql += bl.getCreateDay() +"','";
        sql += bl.getSetdueday() +"','";
        sql +=bl.getIssued_by()+"');";
        db.update(sql);
        db.disconnect();
    }
    public static void editLend(BookLending bl){
        database db=new database();
        db.getConnect();
        try {
            String sql="UPDATE booklending SET ";
        sql+="lendStudentID='"+ bl.getStudentUserID()+"',";
        sql+="createDay='"+ bl.getCreateDay()+"',";
        sql+="setdueDay'"+ bl.getSetdueday()+"',";
        sql+="issued_by='"+bl.getIssued_by()+"' WHERE lendID="+bl.getLendID()+";";
        db.update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }        
        db.disconnect();
    }
    public static void deleteLend(int lendID){
        database db = new database();
        db.getConnect();
        db.update("DELETE FROM booklending WHERE lendID="+lendID);
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
                bl.setSetdueday(rs.getString(4));
                bl.setIssued_by(rs.getInt(5));
                return bl;
            }
        } catch (Exception e) {
            
        }
        db.disconnect();
        return null;
    }
}