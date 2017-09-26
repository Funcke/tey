package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.beans.EventHandler;

public class Controller {
    @FXML TextField un;
    @FXML TextField pw;
    @FXML Button discard;
    public void LogIn() {
        System.out.println(un.getText());
        System.out.println(pw.getText());
    }

    public void Discard() {
        Stage stage = (Stage) discard.getScene().getWindow();
        System.out.println("Closing");
        stage.close();
    }
}
