package object;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GroupObject extends Shape{
    private List<Shape> shapeList;

    public GroupObject(List<Shape>shapeList) {
        this.shapeList = new ArrayList<>();
        for (Shape shape : shapeList) {
            this.shapeList.add(shape);
        }
        System.out.println(this.shapeList.size());
    }

    public GroupObject() {
        System.out.println("Nothing Nothing Nothing");
    }

    @Override
    public void draw(Graphics2D g) {
        if (this.isSelected) {
            for (Shape shape : shapeList) {
                shape.setSelected(true);
                shape.draw(g);
            }
        } else {
            for (Shape shape : shapeList) {
                shape.setSelected(false);
                shape.draw(g);
            }
        }
    }

    @Override
    public List<Port> getPortsPosition() {
        List<Port> portPosition = new ArrayList<>();
        for (Shape shape : shapeList) {
            for (Port port : shape.getPortsPosition()) {
                portPosition.add(port);
            }
        }
        return portPosition;
    }

    @Override
    public void adjust(int offsetX, int offsetY) {
        for (Shape shape : shapeList) {
            shape.adjust(offsetX, offsetY);
            shape.depth = 90;
        }
    }

    // inside the dragged area ?
    @Override
    public boolean inSide(Point point) {
        for (Shape shape : shapeList) {
            if (shape.inSide(point)) {
                return true;
            }
        }
        return false;
    }

    public boolean isContain(Shape shape) {
        if (shapeList.contains(shape)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void checkOverlap() {
        int tmpDepth = 200;
        for (Shape shape : shapeList) {
            shape.checkOverlap();
            if (tmpDepth > shape.depth) {
                tmpDepth = shape.depth;
            }
        }
        this.depth = tmpDepth;
    }

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

    // getter method for shapeList
    @Override
    public List<Shape> getShapeList() {
        return shapeList;
    }

}
