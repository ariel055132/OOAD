package sample.object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class Object {
    // Object width, height and the size of 4 ports
    double objectWidth = 120;
    double objectHeight = 60;
    double portSize = 6;
    GraphicsContext gc;

    // Coordinates for mouse cursor
    private double x;
    private double y;

    // getter method for private variable x and y
    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    // Selected by the user or not
    boolean selected;

    // Container of the port position
    private ArrayList<Position> portPosition;

    Object(double x, double y, GraphicsContext gc) {
        this.x = x;
        this.y = y;
        this.gc = gc;
        portPosition = updatePortPosition();
        selected = false;
    }

    // Rectangle starts from the left corner in JAVA
    private ArrayList<Position> updatePortPosition() {
        ArrayList<Position> newPortPosition = new ArrayList<>();
        Position leftPort = new Position(x, y + objectHeight/2);
        Position bottomPort = new Position(x + objectWidth/2, y + objectHeight);
        Position rightPort = new Position(x + objectWidth, y + objectHeight/2);
        Position topPort = new Position(x + objectWidth/2, y);
        newPortPosition.add(leftPort);
        newPortPosition.add(bottomPort);
        newPortPosition.add(rightPort);
        newPortPosition.add(topPort);
        return newPortPosition;
    }

    // Draw the four port of the sample.object
    private void drawPort() {
        gc.setFill(Color.BLACK);
        portPosition.forEach(obj->{ gc.fillRect(obj.getX(),obj.getY(),portSize,portSize);});
    }

    // Draw the sample.object
    public void drawObject() {};


}
