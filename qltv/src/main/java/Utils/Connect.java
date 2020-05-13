package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
                
    String dbName="qltv";
    String user="root";
    String password="";
    Connection connection;

    public Connection  getConnection()throws SQLException {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,user,password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }



}
