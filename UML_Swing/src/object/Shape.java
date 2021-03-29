package object;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import gui.Canvas;

public abstract class Shape {
    public Point point1, point2;
    public int width, height;
    public int depth = 90;  // depth of object
    public boolean isSelected = false;
    public String objName;
    public List<Port> portsPosition = new ArrayList<>();
    public int xForAlign;  // for string alignment

    public abstract void draw(Graphics2D g);

    public Port findNearestPort(Point p) {
        int i;
        double distance = 100000000;
        Port tmpPort = null;
        for (i = 0; i < 4; i++) {
            if (distance > getDistance(this.portsPosition.get(i).point1, p)) {
                distance = getDistance(this.portsPosition.get(i).point1, p);
                tmpPort = this.portsPosition.get(i);
            }
        }
        return tmpPort;
    }

    public double getDistance(Point point1, Point point2){
        double distance = Math.sqrt((point1.x-point2.x)*(point1.x-point2.x)+(point1.y-point2.y)*(point1.y-point2.y));
        return distance;
    }

    // updatePortPosition in UML JAVA FX
    public void updatePortPosition() {
        Port rightPort = new Port(new Point(point1.x+width, point1.y+height/2));
        Port leftPort = new Port(new Point(point1.x, point1.y+height/2));
        Port bottomPort = new Port(new Point(point1.x + width / 2,  point1.y + height));
        Port topPort = new Port(new Point(point1.x + width / 2,  point1.y));
        portsPosition.add(rightPort);
        portsPosition.add(leftPort);
        portsPosition.add(bottomPort);
        portsPosition.add(topPort);
    }

    // Adjust the position according to the offset of X and Y
    public void adjust(int offsetX, int offsetY) {
        Point newpoint1 = new Point(this.getPoint1().x + offsetX, this.getPoint1().y + offsetY);
        this.setPoint1(newpoint1);
        for (Shape shape: this.getPortsPosition()) {
            shape.adjust(offsetX, offsetY);
        }
    }

    // Edit Object Name in Class Object and UseCase Object
    public void setObjName(String objName) {
        int halfLeft = (this.width - objName.length()*6)/ 2;
        this.xForAlign = halfLeft;
        this.objName = objName;
    }

    public List<Port> getPortsPosition() {
        return portsPosition;
    }

    public boolean isInRectangle(Rectangle bound) {
        Rectangle shapeRange = new Rectangle(this.getPoint1().x, this.getPoint1().y, this.getWidth(), this.getHeight());
        if (bound.contains(shapeRange))
            return true;
        else return false;
    }

    // Point inside the object?
    public boolean inSide(Point point) {
        if (point.x >= point1.x && point.x <= point1.x + width) {
            if (point.y >= point1.y && point.y <= point1.y + height) {
                return true;
            }
        }
        return false;
    }

    // The following 4 function are similar as Position in Java FX
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Point getPoint1() {
        return point1;
    }
    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public void checkOverlap() {
        for (Shape shape:Canvas.getInstance().getShapeList()){
            //compare with other and check intersect
            if (!shape.equals(this) && shape.isIntersected(this.getOwnShape())) {
                if (shape.depth <= this.depth)
                    this.depth = shape.depth - 1;
                else
                    this.depth--;
            }
        }
    }


    public Rectangle getOwnShape() { //if line can be covered, it should be change
        return new Rectangle(point1.x, point1.y, this.width, this.height);
    }
    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }
    public void setSelected(boolean b) {
        this.isSelected = b;
    }

    public boolean isIntersected(Rectangle r) {
        if (this.getOwnShape().intersects(r)) {
            return true;
        }
        return false;
    }

    public List<Shape> getShapeList() {
        return null;
    }

}
