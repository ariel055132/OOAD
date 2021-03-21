package sample.object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class usecaseObject extends Object{

    public usecaseObject(double x, double y, GraphicsContext gc) {
        super(x, y, gc);
        drawObject();
    }

    @Override
    public void drawObject() {
        gc.setLineWidth(4);
        gc.setStroke(Color.AQUA);
        gc.strokeOval(getX(), getY(), objectWidth, objectHeight);
    }
}
