package sample.mode;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import sample.object.Object;
import java.util.ArrayList;

public abstract class Mode {
    public Canvas canvas;
    public GraphicsContext gc;

    ArrayList<Object> objectArrayList;
    Object selectedObject;

    Mode() {
    }

    public void initCanvas(Canvas canvas) {
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D(); // used to draw inside canvas
    }

    public void setHandler() {}
    public void removeHandler() {}
    public void setObjectArrayList(ArrayList<Object> objectArrayList) {
        this.objectArrayList = objectArrayList;
    }
}
