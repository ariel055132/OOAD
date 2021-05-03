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
    public void mousePressed(MouseEvent mouseEvent) {
        startPoint = mouseEvent.getPoint();
        hasShape = checkInShape(startPoint);
        removeOldPort();
    }

    // https://pydoing.blogspot.com/2012/09/java-api-setSelected.html
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        setMenuBar();
        endPoint = mouseEvent.getPoint();
        // drag the area
        if (!endPoint.equals(startPoint)) {
            int offsetX = endPoint.x - startPoint.x;
            int offsetY = endPoint.y - startPoint.y;
            if (hasShape != -1) {
                Shape shape = canvas.getShapeList().get(hasShape);
                shape.adjust(offsetX, offsetY);
                System.out.println(mouseEvent.getPoint());
                shape.setDepth(90);
                shape.checkOverlap();
            }else if (hasShape == -1) {
                selectShape(offsetX, offsetY);
                for (Shape shape : canvas.getShapeSelected()) {
                    shape.setSelected(true);
                }
            }
            if (canvas.getShapeSelected().size() >= 2) {
                menuBar.setGroup(true);
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
            menuBar.setUngroup(true);
        }

        // edit the object name
        if (canvas.getShapeSelected().size() == 1) {
            menuBar.setObjectname(true);
        }

    }

    public void setMenuBar() {
        menuBar.setGroup(false);
        menuBar.setUngroup(false);
        menuBar.setObjectname(false);
    }

    // select Shapes that are in dragged area
    public void selectShape(int offsetX, int offsetY) {
        Rectangle bound; // bound of the dragged area
        // right bottom -> left top
        // right top -> left down
        // left bottom -> right top
        // left top -> right bottom
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
