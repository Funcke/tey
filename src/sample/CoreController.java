package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class CoreController {
    @FXML FileChooser fc;
    @FXML Button Open;
    @FXML Button Save;
    @FXML Button Discard;
    @FXML GridPane Grid;
    @FXML TextArea Input;
    boolean nightMode = false;
    @FXML
    public void initialize() {
        fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("C-Source", "*.c"),
                new FileChooser.ExtensionFilter("C#-Source", ".cs"),
                new FileChooser.ExtensionFilter("Java-Source", "*.java"),
                new FileChooser.ExtensionFilter("All", "*.*")
        );
    }
    //Saves the file under the name of the first complete word in the text
    public void Save() {
        String content = Input.getText();

        try {
            File target = fc.showSaveDialog(new Stage());

            if(target !=  null) {
                WriteToFile(content, target);
            }
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

    public void WriteToFile(String content, File target) throws Exception {
        FileWriter fw = new FileWriter(target);
        fw.write(content);
        fw.close();
    }

    public void NightMode() {
        if(!this.nightMode) {
            Grid.setStyle("-fx-background-color: dimgray");
            Input.setStyle("text-area-background: dimgray");
            Open.setStyle("-fx-background-color: dimgray");
            Save.setStyle("-fx-background-color: dimgray");
            Discard.setStyle("-fx-background-color: dimgray");
            this.nightMode = true;
        }
        else {
            Grid.setStyle("-fx-background-color: white");
            Input.setStyle("text-area-background: white");
            Open.setStyle("-fx-background-color: white");
            Save.setStyle("-fx-background-color: white");
            Discard.setStyle("-fx-background-color: white");
            this.nightMode = false;
        }
    }
}

