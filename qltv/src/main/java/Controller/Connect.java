/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controller;

import java.sql.Connection;
import java.sql.*;


/**
 *
 * @author Gaara
 */
public class Connect {
    private static Connection con;    
    static Statement stmt = null;
    static ResultSet rs = null;

    public static Connection getConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qltv", "root", "7826");

        } catch ( Exception e) {
            System.out.println("Kết nối không thành công");
        }

        return con;
    }

    public static String testConnect() {
        try {
            con = Connect.getConnect();
            return "Kết nối thành công";
        } catch (final Exception e) {
            return "Kết nối thất bại";
        }
    }

    public static int listAccount() {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT userName, userPassword FROM account");            
        } catch (Exception e) {
            
        }       
        return 0;
    }

    public static int checkAccount(String username, String password) {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT userName, userPassword FROM account");
            while (rs.next()) {
                if (username.equals(rs.getString("userName")) && password.equals(rs.getString("userPassword"))) {
                    return 1;
                }
                else return 0;
            }
        } catch (Exception e) {
            
        }       
        return 0;
    }

}
