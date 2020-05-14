package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.*;


public class Connect {
                
    String dbName="qltv";
    String user="root";
    String password="";
    static Connection connection;

    public Connection getConnection() throws SQLException {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, user, password);
            return connection;
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static int checkAccount(final String username, final String password) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT userName, userPassword FROM account");
            while (rs.next()) {
                if (username.equals(rs.getString("userName")) && password.equals(rs.getString("userPassword"))) {
                    return 1;
                } else
                    return 0;
            }
        } catch (final Exception e) {
            
        }       
        return 0;
    }

    /*public static ArrayList<Account> listAccount() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT userName, userPassword FROM account");            
        } catch (Exception e) {
            
        }
        return rs;       
    }
    */

}
