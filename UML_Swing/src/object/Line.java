package object;

import java.awt.*;

// draw the arrowhead
public class Line {
    public Point point1;
    public Point startPoint, endPoint;
    public Port startPort, endPort;
    public int width, height; // for arrowhead
    public int x3, y3, x4, y4 = 0; // put them here for using them in AssociationLine, CompositionLine and GeneralizationLine

    public Line(Port startPort, Port endPort) {
        this.startPoint = startPort.point1;
        this.endPoint = endPort.point1;
        this.startPort = startPort;
        this.endPort = endPort;
        // depth can be add
    }

    // Reference
    // https://blog.csdn.net/xidiangejun/article/details/5525241
    // drawAL and rotateVec function
    public void draw(Graphics2D graphics2D) {
        Point startPoint = startPort.point1; // int sx, int sy
        Point endPoint = endPort.point1; // int ex, int ey
        double arrowheadAngle = Math.atan(width / height); // angle of arrowhead
        double arrowheadLength = Math.sqrt(width * width + height * height); // length of arrowhead
        double[] arrXY_1 = rotateVec(endPoint.x - startPoint.x, endPoint.y - startPoint.y, arrowheadAngle, true, arrowheadLength);
        double[] arrXY_2 = rotateVec(endPoint.x - startPoint.x, endPoint.y - startPoint.y, -arrowheadAngle, true, arrowheadLength);
        // (x3,y3)是第一端点
        x3 = (int) (endPoint.x - arrXY_1[0]);
        y3 = (int) (endPoint.y - arrXY_1[1]);
        // (x4,y4)是第二端点
        x4 = (int) (endPoint.x - arrXY_2[0]);
        y4 = (int) (endPoint.y - arrXY_2[1]);

        // straight line
        graphics2D.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        graphics2D.fillRect(startPoint.x - 4, startPoint.y - 4, 8, 8);
        graphics2D.fillRect(endPoint.x - 4, endPoint.y - 4, 8, 8);
    }

    // Reference
    // http://2017cg.blogspot.com/2017/10/20171005.html
    public static double[] rotateVec(int px, int py, double ang, boolean isChLen, double newLen) {
        double mathsstr[] = new double[2];
        // 向量旋轉函式，参数含义分别是x分量、y分量、旋转角、是否改变长度、新长度
        double vx = px * Math.cos(ang) - py * Math.sin(ang);
        double vy = px * Math.sin(ang) + py * Math.cos(ang);
        if (isChLen) {
            double d = Math.sqrt(vx * vx + vy * vy);
            vx = vx / d * newLen;
            vy = vy / d * newLen;
            mathsstr[0] = vx;
            mathsstr[1] = vy;
        }
        return mathsstr;
    }
}
