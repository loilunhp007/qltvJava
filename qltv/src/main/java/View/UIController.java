package View;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class UIController implements Initializable {
   @FXML
    private JFXTextField usr;
   @FXML
    private JFXPasswordField pass;
   @FXML
    private JFXComboBox<String> comboBox;
   @FXML
    private JButton btnLogin;
   @FXML
    private JButton btnCancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().add("Staff");
        comboBox.getItems().add("Student");
        comboBox.setValue("Staff");
    }
}

