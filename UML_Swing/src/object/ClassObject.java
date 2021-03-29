package object;

import java.awt.*;

// Use ClassObj because error exists when using ClassObject
public class ClassObject extends Shape{
    public ClassObject(Point point) {
        this.width = 100;
        this.height = 110;
        this.xForAlign = 20;
        this.point1 = point;
        this.objName = "Object Name";
        updatePortPosition();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        point2 = new Point(point1.x + width, point1.y);
        int spacing = height / 3; // 3 rectangles
        graphics2D.setColor(Color.cyan);
        graphics2D.fillRect(point1.x, point1.y, width, height);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(point1.x, point1.y, width, height);
        // https://pydoing.blogspot.com/2012/05/java-api-drawline.html
        graphics2D.drawLine(point1.x, point1.y + spacing, point2.x, point2.y + spacing);
        graphics2D.drawLine(point1.x, point1.y + spacing * 2, point2.x, point2.y + spacing * 2);
        graphics2D.drawString(objName,point1.x + xForAlign, point1.y + 20);

        // To-do: Show Port when in select mode and get selected
        if (this.isSelected) {
            for (Port port : portsPosition) {
                port.draw(graphics2D);
            }
        }
    }
}
