package LoginJavaFX;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class Login {
    @FXML
    public Text actionTarget;

    @FXML
    protected void submit(ActionEvent event) {
        actionTarget.setText("Success");
    }

}
