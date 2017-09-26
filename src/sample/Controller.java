package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        this.Open();
    }

    private void Open() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Core.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Main");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();

            Stage this_form = (Stage) discard.getScene().getWindow();
            this_form.close();
        }
        catch(Exception err)
        {
            ;
        }
    }

    public void Discard() {
        Stage stage = (Stage) discard.getScene().getWindow();
        System.out.println("Closing");
        stage.close();
    }
}
