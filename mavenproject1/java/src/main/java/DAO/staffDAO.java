package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.database;
import Entity.Staff;

public class staffDAO {
    public static List<Staff> load(){
        List<Staff> l_staff= new ArrayList<>();
        database db=new database();
        db.getConnect();
        ResultSet rs = db.execution("SELECT * From staff;");
        try {
            while(rs.next()){
                Staff staff = new Staff(rs.getInt(1));
                staff.setStaffName(rs.getString(2));
                staff.setStaffDOB(rs.getString(3));
                staff.setStaffAddr(rs.getString(4));
                staff.setStaffGender(rs.getString(5));
                staff.setStaffPhone(rs.getString(6));
                staff.setStaff_role(rs.getInt(7));
                l_staff.add(staff);
            }
        } catch (Exception e) {
        }
        db.disconnect();
        return l_staff;
    }
    public static void addStaff(Staff staff){
        database db = new database();
        db.getConnect();
        String sql = "INSERT INTO staff (staffName,staffdob,staffAddr,staffGender,staffPhone,staff_roleID ) VALUES ('";
        sql +=staff.getStaffName()+"','";
        sql += staff.getStaffDOB() +"','";
        sql += staff.getStaffAddr() +"','";
        sql +=staff.getStaffGender()+"','";
        sql +=staff.getStaffPhone()+"','";
        sql +=staff.getStaff_role()+"');";
        db.update(sql);
        db.disconnect();
    }
    public static void deleteStaff(int staffID){
        database db = new database();
        db.getConnect();
        db.update("DELETE FROM staff WHERE staffID="+staffID);
        db.disconnect();
    }
    public static void editStaff(Staff staff){
        database db=new database();
        db.getConnect();
        try {
            String sql="UPDATE staff SET ";
        sql+="staffName='"+ staff.getStaffName()+"',";
        sql+="staffAuthorID='"+ staff.getStaffDOB()+"',";
        sql+="staffCategoryID='"+ staff.getStaffAddr()+"',";
        sql+="staffPublisher='"+ staff.getStaffGender()+"',";
        sql+="staffPrice='"+staff.getStaffPhone()+"',";
        sql+="staffPages='"+staff.getStaff_role()+"' WHERE staffID="+staff.getStaffID()+";";
        db.update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }        
        db.disconnect();
    }
    public static Staff findstaffByID(int staffID){
        database db = new database();
        db.getConnect();
        ResultSet rs = db.execution("SELECT * From staff WHERE staffID="+staffID);
        try {
            while(rs.next()){
                Staff staff = new Staff(rs.getInt(1));
                staff.setStaffName(rs.getString(2));
                staff.setStaffDOB(rs.getString(3));
                staff.setStaffAddr(rs.getString(4));
                staff.setStaffGender(rs.getString(5));
                staff.setStaffPhone(rs.getString(6));
                staff.setStaff_role(rs.getInt(7));
                return staff;
            }
        } catch (Exception e) {
            
        }
        db.disconnect();
        return null;
    }

}