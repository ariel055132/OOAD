package sample.object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class classObject extends Object{

    public classObject(double x, double y, GraphicsContext gc) {
        super(x, y, gc);
        drawObject();
    }

    @Override
    public void drawObject() {
        gc.setLineWidth(4);
        gc.setStroke(Color.GREENYELLOW);
        gc.strokeRect(getX(),getY(),objectWidth,objectHeight);
    }
}
