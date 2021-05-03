package object;

import java.awt.*;

// https://blog.csdn.net/xietansheng/article/details/55669157?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-4&spm=1001.2101.3001.4242
public class UseCaseObject extends Shape{
    public UseCaseObject(Point point) {
        this.point1 = point;
        this.width = 90;
        this.height = 50;
        this.fontAlign = 20;
        this.objName = "Object Name";
        updatePortPosition();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.cyan);
        graphics2D.fillOval(point1.x, point1.y, width, height);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawOval(point1.x, point1.y, width, height);
        graphics2D.drawString(objName, point1.x + fontAlign, point1.y + 30);
        if (this.isSelected) {
            for (Port port : portsPosition) {
                port.draw(graphics2D);
            }
        }
    }
}
