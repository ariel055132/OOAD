package mode;

import java.awt.*;
import object.Shape;
import java.awt.event.MouseEvent;

public class SelectMode extends BaseObjectMode{
    public int hasShape;
    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();

    }

    // https://pydoing.blogspot.com/2012/09/java-api-setSelected.html
    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = e.getPoint();
        if (!endPoint.equals(startPoint)) {
            int offsetX = endPoint.x - startPoint.x;
            int offsetY = endPoint.x - startPoint.x;
            if (hasShape == -1) {
                selectShape(offsetY, offsetY);
                for (Shape shape : canvas.getShapeSelected()) {
                    shape.setSelected(true);
                }
            }else if (hasShape != -1) {
                Shape shape = canvas.getShapeList().get(hasShape);
                shape.adjust(offsetX, offsetY);
                shape.setDepth(90);
                //shape.checkOverlap();
            }
            if (canvas.getShapeSelected().size() >= 2) {

            }
        }

    }

    // select Shapes that are in dragged area
    public void selectShape(int offsetX, int offsetY) {
        Rectangle bound = null; // bound of the dragged area
        if (offsetX < 0) {
            if (offsetY < 0) {
                bound = new Rectangle(endPoint.x, endPoint.y, -offsetX, -offsetY);
            } else {
                bound = new Rectangle(endPoint.x, startPoint.y, -offsetX, offsetY);
            }
        } else {
            if (offsetY < 0) {
                bound = new Rectangle(startPoint.x, endPoint.y, offsetX, -offsetY);
            } else {
                bound = new Rectangle(startPoint.x, startPoint.y, offsetX, offsetY);
            }
        }
        for (Shape shape : canvas.getShapeList()) {
            if (shape.isInRectangle(bound)) {
                canvas.getShapeSelected().add(shape);
            }
        }
    }
}
