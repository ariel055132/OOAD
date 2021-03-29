package object;

import java.awt.*;
import java.awt.geom.GeneralPath;

// https://blog.csdn.net/u010953266/article/details/42774163
public class GeneralizationLine extends Line{

    public GeneralizationLine(Port startPort, Port endPort) {
        super(startPort, endPort);
        this.width = 8;
        this.height = 8;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        GeneralPath triangle = new GeneralPath();
        triangle.moveTo(endPoint.x, endPoint.y);
        triangle.lineTo(x3, y3);
        triangle.lineTo(x4, y4);
        triangle.closePath();
        graphics2D.draw(triangle);
    }
}
