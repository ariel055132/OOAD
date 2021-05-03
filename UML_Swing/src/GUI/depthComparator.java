package gui;

import object.Shape;

import java.util.Comparator;

public class depthComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        return shape2.getDepth() - shape1.getDepth();
    }
}
