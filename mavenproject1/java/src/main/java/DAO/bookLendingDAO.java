package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;

import Controller.database;
import Entity.Book;
import Entity.BookLending;
import javafx.collections.*;

public class bookLendingDAO {
    public static ObservableList<BookLending> load(){
        ObservableList<BookLending> l_lending = FXCollections.observableArrayList();
        database db = new database();
        ResultSet rs= db.execution("SELECT bl.lendID,st.studentName,bl.createDay,s.staffName FROM booklending bl join student st on bl.lendStudentID = st.studentID join staff s on s.staffID=bl.issued_by WHERE 1;");
        try {
            while(rs.next()){
                BookLending bl=new BookLending(rs.getInt(1));
                bl.setStudentName(rs.getString(2));
                bl.setCreateDay(rs.getString(3));
                bl.setStaffName(rs.getString(4));
                l_lending.add(bl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Lending book error");
        }
        db.disconnect();
        return l_lending;
    }
    public static void addLend(BookLending bl){
        database db = new database();
        db.getConnect();
        String sql = "INSERT INTO booklending (lendStudentID,createDay,issued_by) VALUES ('";
        sql +=bl.getLendStudentID()+"','";
        sql += bl.getCreateDay() +"','";
        sql +=bl.getIssued_by()+"');";
        db.update(sql);
        db.disconnect();
    }
    public static void editLend(BookLending bl){
        database db=new database();
        db.getConnect();
        try {
            String sql="UPDATE booklending SET ";
        sql+="lendStudentID='"+ bl.getLendStudentID()+"',";
        sql+="createDay='"+ bl.getCreateDay()+"',";
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
                bl.setIssued_by(rs.getInt(4));
                return bl;
            }
        } catch (Exception e) {
            
        }
        db.disconnect();
        return null;
    }
}