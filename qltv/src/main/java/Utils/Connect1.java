/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Utils;

import java.sql.Connection;
import java.sql.*;


/**
 *
 * @author Gaara
 */
public class Connect1 {
    private  static Connection con;
    
    public static Connection getConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qltv","root","7826");
            
            
        } catch (final Exception e) {
            System.out.println("Kết nối không thành công");
        }
            
        return con;
    }
    public static String testConnect() {
        try{
            con = Connect1.getConnect();
            return "Kết nối thành công";
        }
        catch(final Exception e) {
            return "Kết nối thất bại";
        }
    } 
}
