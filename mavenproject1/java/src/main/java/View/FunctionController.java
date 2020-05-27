/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Book;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
/**
 * FXML Controller class
 *
 * @author Anh Quan
 */
public class FunctionController implements Initializable {
    ObservableList<Book> bookList = FXCollections.observableArrayList();
    
     
    @Override
    public void initialize( URL url, ResourceBundle rb){
        
    }
    
}

