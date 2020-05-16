package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
                
    private static String dbName="qltv";
    private static String user="root";
    private static String password="";
    private static Connection connection;
    public static Connection  getConnection() throws SQLException{
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void testconnect(){
        try{
        connection=Connect.getConnection();
            System.out.println("connect ok");
        }
        catch (Exception e){
        }
            System.out.println("error");
        }
        
    }
