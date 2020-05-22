package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.database;
import Entity.Categories;

public class categoryDAO {
    public static List<Categories> load() {
        List<Categories> l_categories = new ArrayList<>();
        database db=new database();
        db.getConnect();
        ResultSet rs = db.execution("SELECT * From categories;");
        try {
            while(rs.next()){
                Categories cate = new Categories(rs.getInt(1));
                cate.setCategoryName(rs.getString(2));
                l_categories.add(cate);
            }
        } catch (Exception e) {
        }
        db.disconnect();
        return l_categories;
    }
    public static void addcategories(Categories cate){
        database db = new database();
        db.getConnect();
        String sql = "INSERT INTO categories (categoryName ) VALUES ('";
        sql +=cate.getCategoryName()+"','";
        db.update(sql);
        db.disconnect();
    }
    public static void deletecate(int categoryID){
        database db = new database();
        db.getConnect();
        db.update("DELETE FROM categories WHERE categoryID="+categoryID);
        db.disconnect();
    }
    public static void editcategories(Categories cate){
        database db=new database();
        db.getConnect();
        try {
            String sql="UPDATE categories SET ";
        sql+="categoriesName='"+ cate.getCategoryName()+ " WHERE categoryID="+cate.getCategoryID()+";";
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
        }
        db.disconnect();
        return null;
    }
}