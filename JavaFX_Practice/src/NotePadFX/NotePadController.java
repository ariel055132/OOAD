package NotePadFX;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.ColorPicker;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class NotePadController implements Initializable {
    @FXML
    public TextArea notes;

    @FXML
    public void closeItem(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm");
        alert.setHeaderText("");
        alert.setContentText("Quit the program?");
        alert.showAndWait();
        ButtonType result = alert.getResult();
        if (result == ButtonType.OK) {
            Platform.exit();
            System.out.println("Closed");
        }
    }

    @FXML
    public void aboutItem(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About US");
        alert.setHeaderText("");
        alert.setContentText("A notepad made with JavaFX");
        alert.showAndWait();
    }

    public void saveItem(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("TXT", "*.txt")
        );
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                outputStream.write(notes.getText().getBytes());
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void loadItem(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT", "*.txt")
        );
        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null && file.exists()) {
            notes.setText(readFile(file));
        }
        /*
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(String.valueOf(file))))) {
            String line;
            while((line = reader.readLine()) != null) {

                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    public String readFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String text;
            while((text = bufferedReader.readLine()) != null) {
                stringBuilder.append(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void clearItem(ActionEvent event) {
        notes.clear();
    }


    public void changeFontColor(ActionEvent event) {
        ColorPicker colorPicker = new ColorPicker(Color.BLACK);

    }


}
