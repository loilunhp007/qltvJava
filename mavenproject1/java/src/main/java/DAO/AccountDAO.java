package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;

import java.sql.SQLException;
import Controller.database;
import Entity.Account;
import javafx.collections.*;
public class AccountDAO  {
    public static ObservableList<Account> loadAccount(){
        ObservableList<Account> list_ac=FXCollections.observableArrayList();
        database db=new database();
        db.getConnect();
        ResultSet rs= db.execution("SELECT ac.userID,ac.userName,ac.userPassword,ac.startDay,ac.outofDay,s.staffName FROM account ac join staff s on ac.staffid=s.staffID WHERE 1;");
        try {
            while(rs.next()){
                Account ac=new Account(rs.getInt(1));
                ac.setUserName(rs.getString(2));
                ac.setUserPassword(rs.getString(3));
                ac.setCreateday(rs.getString(4));
                ac.setOutofday(rs.getString(5));
                ac.setStaffName(rs.getString(6));
                list_ac.add(ac);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error while loading account");
        }
        db.disconnect();
        return list_ac; 
    }
    public static Account getAccountByID(int id){
        database db=new database();
        db.getConnect();
        String sql="Select * FROM account WHERE userID='"+id+"'";
        ResultSet rs=db.execution(sql);
        try{
        while(rs.next()){
            Account ac=new Account(rs.getInt(1));
                ac.setUserPassword(rs.getString(2));
                ac.setStaffID(rs.getInt(3));
                ac.setCreateday(rs.getString(4));
                ac.setOutofday(rs.getString(5));
                db.disconnect();
                return ac;
                }
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Can't get Account");
            }
            db.disconnect();
            return null;
    }
    public static void addAccount(Account ac){
        database db=new database();
        try {
            db.getConnect();
            String sql= "INSERT INTO account(userName,userPassword,startDay,outofDay,staffID) VALUES ('";
            sql +=ac.getUserName()+"','";
            sql +=ac.getUserPassword()+"','";
            sql +=ac.getCreateday()+"','";
            sql +=ac.getOutofday()+"','";
            sql +=ac.getStaffID()+"');";
            db.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
    }
    public static void deleteAccount(int acID){
        database db=new database();
        try {
            db.getConnect();
        db.update("DELETE FROM account WHERE account.userID="+acID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
    }
    public static void editAccount(Account ac){
        database db=new database();
        try {
            db.getConnect();
            String sql="UPDATE account SET ";
            sql+="userName='"+ac.getUserName()+"',userPassword='"+ac.getUserPassword()+
            "',staffID='"+ac.getStaffID()+"',startDay='"+ac.getCreateday()+"',outofDay='"+ac.getOutofday()+
            "' WHERE account.userID='"+ac.getUserID()+"';";
            db.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
    }
    public List<Account> findAccount(String name,String addr,String phone,String mail) {
        List<Account> list_ac=new ArrayList();
        database db=new database();
        db.getConnect();
        String sql="SELECT ac.userID,s.staffName,r.roleName FROM account ac join Staff s on ac.staffID=s.staffID join Role r on s.staff_roleID=r.roleID WHERE ";
        if(!name.isEmpty()){
            sql +="s.staffName='"+name+"'";
        }
        if(!addr.isEmpty()){
            sql +="s.staffAddr='"+addr+"'";
        }
        if(!phone.isEmpty()){
            sql +="s.staffPhone='"+phone+"'";
        }
        if(!mail.isEmpty()){
            sql +="s.staffAddr='"+addr+"'";
    }
    sql=sql.substring(0, sql.length()-4);
    ResultSet rs=db.execution(sql);
    try {
        while(rs.next()){
            Account ac=new Account(rs.getInt(1));
            ac.setUserName(rs.getString(2));
            ac.setUserPassword(rs.getString(3));
            ac.setStaffID(rs.getInt(4));
            ac.setCreateday(rs.getString(5));
            ac.setOutofday(rs.getString(6));
            list_ac.add(ac);
        }
    } catch (Exception e) {
        //TODO: handle exception
    }
    db.disconnect();
    return list_ac;
}
public Account findAccountByName(String userName) {
    database db=new database();
    db.getConnect();
    String sql="SELECT * FROM account WHERE account.username='%"+userName+"%'";
    ResultSet rs=db.execution(sql);
    try {
        while(rs.next()){
            Account ac=new Account(rs.getInt(1));
            ac.setUserName(rs.getString(2));
            ac.setUserPassword(rs.getString(3));
            ac.setStaffID(rs.getInt(4));
            ac.setCreateday(rs.getString(5));
            ac.setOutofday(rs.getString(6));
            return ac;
        }
    } catch (Exception e) {
        //TODO: handle exception
    }
    db.disconnect();
    return null;
    }

}