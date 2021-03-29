package object;

import java.awt.*;

public class Port extends Shape{
    public int portWidth, portHeight;
    public Port(Point point) {
        this.point1 = point;
        this.portWidth = 8;
        this.portHeight = 8;
        this.depth = 0;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.fillRect(point1.x - 4, point1.y - 4, portWidth, portHeight);
    }

    @Override
    public void adjust(int offsetX, int offsetY) {
        this.point1.setLocation(point1.x + offsetX, point1.y + offsetY);
    }

    @Override
    public boolean inSide(Point point) {
        return false;
    }
}
