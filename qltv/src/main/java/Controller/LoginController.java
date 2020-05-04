package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
    /**
     * FXML Controller class
     *
     * @author Anh Quan
     */
    public static class LoginFormUIController implements Initializable {

        @FXML
        private TextField usr;
        @FXML
        private TextField passwd;
        @FXML
        private TextField job;
        @FXML
        private Button loginBtn;
        @FXML
        private Button clearBtn;
        @FXML
        private Button regBtn;

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
    }
}
