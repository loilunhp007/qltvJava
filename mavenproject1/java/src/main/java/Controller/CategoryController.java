/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.scene.control.*;

import DAO.categoryDAO;
import Entity.Categories;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.collections.*;
import javafx.scene.control.cell.*;
/**
 * FXML Controller class
 *
 * @author lapgo
 */
public class CategoryController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private Button addBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private Button update;
    @FXML
    private Button clear;
    @FXML
    private TableView<Categories> tableCate;
    @FXML
    private TableColumn<Categories, Integer> t_id;
    @FXML
    private TableColumn<Categories, String> t_name;
    @FXML
    ObservableList<Categories> l_cate =FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCate();
        onSelect();
    }    
    @FXML
    public void loadCate(){
        database db=new database();
        try{
            db.getConnect();
            l_cate=categoryDAO.load();

        }catch(Exception e){
            Logger.getLogger(CategoryController.class.getName());
        }finally{}
        t_id.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
        t_name.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        tableCate.setItems(l_cate);
    }
    //        ADD student Start
    
    public void addCateBtn(ActionEvent event) throws Exception{
        Categories cate= new Categories();
        String Name=name.getText();
        cate.setCategoryName(Name);
        categoryDAO.addcategories(cate);
        clearALL();
        loadCate();
    }
    public void updateCateBtn(ActionEvent event) throws Exception{
        //error
        Categories cate= new Categories();
        int idd=Integer.parseInt(id.getText());
        String Name=name.getText();
        cate.setCategoryID(idd);
        cate.setCategoryName(Name);
        categoryDAO.editcategories(cate);
        loadCate();
    }

//delete start
    public void removeCateBtn(ActionEvent event){
        Alert.AlertType type=Alert.AlertType.CONFIRMATION;
        Alert al=new Alert(type,"");
        al.setTitle("Confirm");
        al.setContentText("Are you sure you want to delete this?");
        Optional<ButtonType> res= al.showAndWait();
        if(res.get() == ButtonType.OK){
            int idd=Integer.parseInt(id.getText());
            categoryDAO.deletecate(idd);
            loadCate();
        }
      
    }
//delete end    
    
    //          Add student end
    public void onSelect() {
        this.tableCate.setRowFactory(param -> {
            TableRow row = new TableRow();
            row.setOnMouseClicked(et -> {
                Categories cate = this.tableCate.getSelectionModel().getSelectedItem();
                this.id.setText(Integer.toString(cate.getCategoryID()));
                this.name.setText((cate.getCategoryName()));
            });
            return row;
        });
    }

    public void clearALL(){
        id.clear();
        name.clear();
    }
}
