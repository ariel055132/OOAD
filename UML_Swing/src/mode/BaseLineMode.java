package mode;

import object.Port;
import object.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class BaseLineMode extends BaseObjectMode{
    public Port startPort, endPort;
    public Shape startShape, endShape;

    public void mousePressed(MouseEvent mouseEvent) {
        startPoint = mouseEvent.getPoint();
        int tmp = checkInShape(startPoint);
        if (tmp != -1) {
            startShape = canvas.getShapeList().get(tmp);
            if (startShape.getShapeList() == null) {
                startPort = startShape.findNearestPort(startPoint);
            } else {
                // no shape
                startShape = null;
            }
        }
    }

    public void mouseReleased(MouseEvent mouseEvent) {}

    public boolean checkWhetherAdd(Point endPoint) {
        int tmp = checkInShape(endPoint);
        if (tmp != -1 && startShape != null) {
            endShape = canvas.getShapeList().get(tmp);
            if (endShape.getShapeList() == null && !startShape.equals(endShape)) {
                endPort = endShape.findNearestPort(endPoint);
                return true;
            }
        }
        return false;
    }
}
