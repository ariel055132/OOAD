package object;

import java.awt.*;

public class AssociationLine extends Line{

    public AssociationLine(Port startPort, Port endPort) {
        super(startPort, endPort);
        this.width = 8;
        this.height = 8;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);

        graphics2D.drawLine(endPoint.x, endPoint.y, x3, y3);
        graphics2D.drawLine(endPoint.x, endPoint.y, x4, y4);
        // draw the arrowhead and the line
        graphics2D.fillRect(startPoint.x-4, startPoint.y-4, 8, 8);
        graphics2D.fillRect(endPoint.x-4, endPoint.y-4, 8, 8);
    }
}
