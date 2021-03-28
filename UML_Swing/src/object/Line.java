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
        // add depth ?
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
        double x_3 = endPoint.x - arrXY_1[0]; // (x3,y3)是第一端点
        double y_3 = endPoint.y - arrXY_1[1];
        double x_4 = endPoint.x - arrXY_2[0]; // (x4,y4)是第二端点
        double y_4 = endPoint.y - arrXY_2[1];

        // Convert the double to int for drawLine
        Double X3 = new Double(x_3);
        x3 = X3.intValue();
        Double Y3 = new Double(y_3);
        y3 = Y3.intValue();
        Double X4 = new Double(x_4);
        x4 = X4.intValue();
        Double Y4 = new Double(y_4);
        y4 = Y4.intValue();

        // 画线
        graphics2D.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        // 画箭头的一半
        //graphics2D.drawLine(endPoint.x, endPoint.y, x3, y3);
        // 画箭头的另一半
        //graphics2D.drawLine(endPoint.x, endPoint.y, x4, y4);
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
