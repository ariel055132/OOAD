package object;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GroupObject extends Shape{
    private List<Shape> shapeList;

    public GroupObject(List<Shape>shapeList) {
        this.shapeList = new ArrayList<>();
        this.shapeList.addAll(shapeList);
        System.out.println(this.shapeList.size());
    }

    // getter method for shapeList
    @Override
    public List<Shape> getShapeList() {
        return shapeList;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        if (this.isSelected) {
            for (Shape shape : shapeList) {
                shape.setSelected(true);
                shape.draw(graphics2D);
            }
        } else {
            for (Shape shape : shapeList) {
                shape.setSelected(false);
                shape.draw(graphics2D);
            }
        }
    }

    @Override
    public List<Port> getPortsPosition() {
        List<Port> portPosition = new ArrayList<>();
        for (Shape shape : shapeList) {
            portPosition.addAll(shape.getPortsPosition());
        }
        return portPosition;
    }

    @Override
    public void adjust(int offsetX, int offsetY) {
        for (Shape shape : shapeList) {
            shape.adjust(offsetX, offsetY);
            shape.depth = 99;
        }
    }

    // inside the dragged area or not
    @Override
    public boolean inside(Point point) {
        for (Shape shape : shapeList) {
            if (shape.inside(point)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void checkOverlap() {
        int tmpDepth = 110;
        for (Shape shape : shapeList) {
            shape.checkOverlap();
            if (tmpDepth > shape.depth) {
                tmpDepth = shape.depth;
            }
        }
        this.depth = tmpDepth;
    }

    // intersect?
    public boolean isIntersected(Rectangle rectangle) {
        for (Shape shape : shapeList) {
            if (rectangle.intersects(shape.getOwnShape())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isInRectangle(Rectangle bound) {
        for (Shape shape : shapeList) {
            if (shape.isInRectangle(bound)) {
                return true;
            }
        }
        return false;
    }
}
