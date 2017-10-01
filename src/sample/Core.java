package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Core {
    @FXML TextArea Input;
    @FXML
    public void initialize() {
        try {
            Path path = Paths.get("Edit.txt");
            byte[] content = Files.readAllBytes(path);
            String scontent = new String(content, Charset.forName("UTF8"));
            Input.setText(scontent);
        }
        catch(Exception err){
            System.out.println("File could not be opened");
        }
    }
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

    public void Discard() {
        Input.setText("");
    }
}
