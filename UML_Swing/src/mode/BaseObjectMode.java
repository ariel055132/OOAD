package mode;

import object.Shape;
import gui.Canvas;
import java.awt.*;
import java.awt.event.MouseEvent;

public class BaseObjectMode {
    protected Point startPoint, endPoint;
    protected Canvas canvas = Canvas.getInstance();
    public void mousePressed(MouseEvent mouseEvent){

    }

    public void mouseReleased(MouseEvent mouseEvent){
    }

    public int checkInShape(Point point) {
        for (int i = canvas.getShapeList().size() - 1; i >= 0 ; i--) {
            if (canvas.getShapeList().get(i).inside(point)) {
                return i;
            }
        }
        return -1; // no shape
    }

    public void removeOldPort() {
        for (Shape shape: canvas.getShapeSelected()) {
            shape.setSelected(false);
        }
        canvas.getShapeSelected().clear();
    }
}
