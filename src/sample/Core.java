package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.PrintWriter;

public class Core {
    @FXML TextArea Input;
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

    public void Open() {

    }

    public void Discard() {
        Input.setText("");
    }
}
