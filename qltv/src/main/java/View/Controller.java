package View;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    public static class LoginFormController  implements Initializable {
        @FXML
        private JFXTextField usr;
        @FXML
        private JFXPasswordField passwd;
        @FXML
        private JFXComboBox<String> Role;
        @FXML
        private Button loginBtn;
        @FXML
        private Button clearBtn;
        /*public void handleButtonAction(ActionEvent event){
            if(event.getSource()== loginBtn){

            }
        }*/
        /**
         * Initializes the controller class.
         */
        @Override
        public void initialize(URL url, ResourceBundle rb) {
        }
        @FXML
        public void clearAll(){
            usr.clear();
            passwd.clear();
        }
        public void logIn(){
            String userName= usr.getText().toString();
            String userPassword= usr.getText().toString();
            String sql="SELECT * FROM account ac Where userName=? and userPassword=?";
        }
    }
}
