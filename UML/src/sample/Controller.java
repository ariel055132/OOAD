package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import sample.object.Object;
import sample.mode.Mode;
import sample.mode.ModeFactory;

import java.util.ArrayList;

public class Controller {
    @FXML private Button selectBtn;
    @FXML private Button associationBtn;
    @FXML private Button generalizationBtn;
    @FXML private Button compositionBtn;
    @FXML private Button classBtn;
    @FXML private Button caseBtn;

    @FXML private MenuItem groupBtn;
    @FXML private MenuItem unGroupBtn;
    @FXML private MenuItem changeNameBtn;
    @FXML private MenuItem closeBtn;

    @FXML private Canvas canvas;

    private Mode mode;
    private final ModeFactory modeFactory = new ModeFactory();
    private final ArrayList<Button> buttonArrayList = new ArrayList<>();
    private final ArrayList<Object> objectArrayList = new ArrayList<>();

    public Controller() {
    }

    @FXML
    public void initialize() {
        initBtnArrayList();
        closeBtn.setOnAction(e->closeAction());
    }

    @FXML
    private void initBtnArrayList() {
        buttonArrayList.add(selectBtn);
        buttonArrayList.add(associationBtn);
        buttonArrayList.add(generalizationBtn);
        buttonArrayList.add(compositionBtn);
        buttonArrayList.add(classBtn);
        buttonArrayList.add(caseBtn);
        buttonArrayList.forEach(btn->{
            btn.setOnAction(e->clickBtn(btn));
            //System.out.println("OK");
        });
    }

    @FXML
    private void clickBtn(Button btn) {
        if (mode != null) {
            mode.removeHandler();
        }
        mode = modeFactory.getMode(btn.getId());
        mode.initCanvas(canvas);
        mode.setObjectArrayList(objectArrayList);
        mode.setHandler();
    }

    @FXML
    private void closeAction() {
        Stage stage = (Stage) selectBtn.getScene().getWindow();
        stage.close();
    }

}
