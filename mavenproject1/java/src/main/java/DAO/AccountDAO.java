package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import java.sql.SQLException;
import Controller.Connect;
import Entity.Account;

public class AccountDAO  {
    public static List<Account> loadAccount(){
        List<Account> list_ac=new ArrayList<Account>();
        Connect con=new Connect();
        con.getConnect();
        ResultSet rs= con.execution("SELECT * FROM account");
        try {
            while(rs.next()){
                Account ac=new Account(rs.getString(1));
                ac.setUserPassword(rs.getString(2));
                ac.setStaffID(rs.getInt(3));
                ac.setCreateday(rs.getString(4));
                ac.setOutofday(rs.getString(5));
                list_ac.add(ac);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error while loading account");
        }
        con.disconnect();
        return list_ac; 
    }
    public static Account getAccountByID(int id){
        Connect con=new Connect();
        con.getConnect();
        String sql="Select * FROM account WHERE userID='"+id+"'";
        ResultSet rs=con.execution("sql");
        try{
        while(rs.next()){
            Account ac=new Account(rs.getString(1));
                ac.setUserPassword(rs.getString(2));
                ac.setStaffID(rs.getInt(3));
                ac.setCreateday(rs.getString(4));
                ac.setOutofday(rs.getString(5));
                con.disconnect();
                return ac;
                }
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Can't get Account");
            }
            con.disconnect();
            return null;
    }
    public static void addAccount(Account ac){
        Connect con=new Connect();
        con.getConnect();
        String sql= "INSERT INTO account(userName,userPassword,staffID,createday,outofday) VALUES ('";
        sql +=ac.getUserName()+"','";
        sql +=ac.getUserPassword()+"','";
        sql +=ac.getStaffID()+"','";
        sql +=ac.getCreateday()+"','";
        sql +=ac.getOutofday()+");";
        con.update(sql);
        con.disconnect();
    }
    public static void deleteAccount(int acID){
        Connect con=new Connect();
        con.update("DELETE FROM account WHERE account.userID="+acID);
        con.disconnect();
    }
    public static void editAccount(Account ac){
        Connect con=new Connect();
        con.update("UPDATE account SET ");
        String sql="userName='"+ac.getUserName()+"',userPassword='"+ac.getUserPassword()+
        "',staffID="+ac.getStaffID()+"',createday='"+ac.getCreateday()+"',outofday='"+ac.getOutofday()+
        "' WHERE account.userID="+ac.getUserID()+";";
        con.update(sql);
        con.disconnect();
    }
    public List<Account> findAccount(String name,String addr,String phone,String mail) {
        List<Account> list_ac=new ArrayList();
        Connect con=new Connect();
        con.getConnect();
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
    ResultSet rs=con.execution(sql);
    try {
        while(rs.next()){
            Account ac=new Account(rs.getString(2));
            ac.setUserPassword(rs.getString(3));
            ac.setStaffID(rs.getInt(4));
            ac.setCreateday(rs.getString(5));
            ac.setOutofday(rs.getString(6));
            list_ac.add(ac);
        }
    } catch (Exception e) {
        //TODO: handle exception
    }
    con.disconnect();
    return list_ac;
}
public Account findAccountByID(int acID) {
    Connect con=new Connect();
    con.getConnect();
    String sql="SELECT * FROM account WHERE account.userID='"+acID+"'";
    ResultSet rs=con.execution(sql);
    try {
        while(rs.next()){
            Account ac=new Account(rs.getString(2));
            ac.setUserPassword(rs.getString(3));
            ac.setStaffID(rs.getInt(4));
            ac.setCreateday(rs.getString(5));
            ac.setOutofday(rs.getString(6));
            return ac;
        }
    } catch (Exception e) {
        //TODO: handle exception
    }
    con.disconnect();
    return null;
    }

}