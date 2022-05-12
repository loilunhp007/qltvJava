/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
/**
 *
 * @author Gaara
 */
public class database {
    private  static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    public void getConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qltv1","root","277997aa");
            stmt=con.createStatement();
        } catch (Exception e) {
            System.out.println("Kết nối không thành công");
        }
    }

    public Connection getCon() {
        return con;
    }

    public ResultSet execution(String sql) {
        try{
            rs=stmt.executeQuery(sql);
        }
        catch( SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e);
        }
        return rs;
    }
    public void update(String sql){
        try{
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updateStaff(PreparedStatement st){
        try{
            st.executeUpdate();
            System.out.println("Done");
        }
        catch(Exception e){
            e.printStackTrace();;
        }
    }

    public void disconnect(){
        try{
            if(rs !=null){
                rs.close();
                stmt.close();
                con.close();
            }
        }
        catch(Exception e){
          //  e.printStackTrace();
        }
    }
}
