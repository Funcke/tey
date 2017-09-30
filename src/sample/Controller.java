package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.io.*;

public class Controller {
    @FXML TextField un;
    @FXML TextField pw;
    @FXML Button login;
    @FXML Label warning;
    public void LogIn() {
        System.out.println(un.getText());
        System.out.println(pw.getText());
        if(this.Control(un.getText(), pw.getText())) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("local.csv"));
                bw.write(un.getText() + ";" + pw.getText());
                bw.close();
            }
            catch (IOException err) {
                System.out.println(err.getMessage());
            }
            this.Open();

        }
        else
            warning.setText("Wrong Log in date");
    }

    private boolean Control(String uname, String pword) {
        try {
            BufferedReader source = new BufferedReader(new FileReader("user.csv"));
            String line = source.readLine();

            while (line != null) {
                if (line.split(";")[0].equals(un.getText()) && line.split(";")[1].equals(pw.getText()))
                    return true;
                line = source.readLine();
            }
        }
        catch(Exception err){
            System.out.println(err.getMessage());
        }
        return false;
    }

    private void Open() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Core.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Main");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();

            Stage this_form = (Stage) login.getScene().getWindow();
            this_form.close();
        }
        catch(IOException err)
        {
            System.out.println("error creating the new form\n");
        }

    }

    public void Sign_up () {
        String uName = un.getText();
        String pWord = pw.getText();
        String line;
        try {
            BufferedReader data = new BufferedReader(new FileReader("user.csv"));

            line = data.readLine();
            while (line != null) {
                if (line.equals(uName + ';' + pWord)){
                    warning.setText("Attention! This user already exists!");
                    break;
                }
                line = data.readLine();
            }

            data.close();

            BufferedWriter entry = new BufferedWriter(new FileWriter("user.csv", true));
            entry.write(uName + ";" + pWord + "\n");
            entry.close();
        }
        catch(Exception err)
        {
            System.out.println(err.getMessage());
        }

    }


    public void Discard() {
        Stage stage = (Stage) login.getScene().getWindow();
        System.out.println("Closing");
        stage.close();
    }
}
