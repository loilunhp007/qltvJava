package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;

import Controller.database;
import Entity.Categories;
import javafx.collections.*;
public class categoryDAO {
    public static ObservableList<Categories> load() {
        ObservableList<Categories> l_cate = FXCollections.observableArrayList();
        database db=new database();
        db.getConnect();
        ResultSet rs = db.execution("SELECT * FROM categories");
        try {
            while(rs.next()){
                Categories cate = new Categories(rs.getInt(1));
                cate.setCategoryName(rs.getString(2));
                l_cate.add(cate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return l_cate;
    }
    public static void addcategories(Categories cate){
        database db = new database();
        db.getConnect();
       try{
        String sql = "INSERT INTO `categories` (categoryName) VALUES ('";
        sql +=cate.getCategoryName()+"');";
        db.update(sql);
       }catch(Exception e){
        JOptionPane.showMessageDialog(null,"error");
    }
        db.disconnect();
    }
    public static void deletecate(int categoryID){
        database db = new database();
        db.getConnect();
        try{db.update("DELETE FROM categories WHERE categoryID="+categoryID);}
        catch(Exception e){
            e.printStackTrace();
        }
        db.disconnect();
    }
    public static void editcategories(Categories cate){
        database db=new database();
        db.getConnect();
        try {
            String sql="UPDATE categories SET ";
        sql+="categoryName='"+ cate.getCategoryName()+"' WHERE categoryID='"+cate.getCategoryID()+"';";
        db.update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }        
        db.disconnect();
    }
    public static Categories findcategoriesByID(int categoryID){
        database db = new database();
        db.getConnect();
        ResultSet rs = db.execution("SELECT * From categories WHERE categoryID="+categoryID);
        try {
            while(rs.next()){
                Categories cate = new Categories(rs.getInt(1));
                cate.setCategoryName(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return null;
    }
}