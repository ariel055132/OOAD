package mode;

import java.awt.*;
import object.Shape;
import java.awt.event.MouseEvent;
import gui.MenuBar;

public class SelectMode extends BaseObjectMode{
    public int hasShape;
    private MenuBar menuBar;

    public SelectMode() {
        this.menuBar = MenuBar.getMenuBar();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
        hasShape = checkInShape(startPoint);
        removeOldPort();
    }

    // https://pydoing.blogspot.com/2012/09/java-api-setSelected.html
    @Override
    public void mouseReleased(MouseEvent e) {
        menuBar.setGroupItem(false);
        menuBar.setUnGroupItem(false);
        menuBar.setNameItem(false);
        endPoint = e.getPoint();
        // drag the area
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
                shape.checkOverlap();
            }
            if (canvas.getShapeSelected().size() >= 2) {
                menuBar.setGroupItem(true);
            }
        } else {
            if (hasShape != -1) {
                Shape shape = canvas.getShapeList().get(hasShape);
                shape.setSelected(true);
                canvas.getShapeSelected().add(shape);
                shape.checkOverlap();
            }
        }

        // ungroup
        if (canvas.getShapeSelected().size() != 0 && canvas.getShapeSelected().get(0).getShapeList() != null) {
            menuBar.setUnGroupItem(true);
        }

        // edit the object name
        if (canvas.getShapeSelected().size() == 1) {
            menuBar.setNameItem(true);
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
