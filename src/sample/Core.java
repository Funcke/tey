package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Core {
    FileChooser fc = new FileChooser();
    @FXML TextArea Input;
    //Saves the file under the name of the first complete word in the text
    public void Save() {
        String content = Input.getText();
        int i = content.indexOf(' ');
        String name = content.substring(0, i) + ".txt";

        try {
            PrintWriter target = new PrintWriter(name, "utf-8");
            target.write(content);
            target.close();
        }
        catch(Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void open() {
        try {
            File file = fc.showOpenDialog(new Stage());
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            Input.setText("");

            while(line != null) {
                Input.appendText(line + "\n");
                line = br.readLine();
            }
        } catch(Exception err) {
            System.out.println("Error opening the choosen file appeared");
        }
    }

    public void Discard() {
        Input.setText("");
    }
}
