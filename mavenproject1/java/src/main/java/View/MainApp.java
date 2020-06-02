package View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;



public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Lending.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Library Management");
        stage.setScene(scene);
        stage.setMinHeight(600);
        stage.setMinWidth(823);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}