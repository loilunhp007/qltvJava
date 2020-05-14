package View;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import org.w3c.dom.events.MouseEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;

public class UIController implements Initializable {
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPass;
    @FXML
    private JFXComboBox<String> comboBox;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCancel;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().add("Nhân viên");
    }
}
