package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

import mode.BaseObjectMode;
import object.GroupObject;
import object.Shape;
import object.Line;

public class Canvas extends JPanel {
    private static Canvas instance = null;
    private List<Shape> shapeList  = new ArrayList<>();
    private List<Line> lineList  = new ArrayList<>();
    private List<Shape> shapeSelected = new ArrayList<>();
    private BaseObjectMode currentMode;
    private MenuBar menuBar;

    private Canvas()  {
        menuBar = MenuBar.getMenuBar();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentMode !=  null) {
                    currentMode.mousePressed(e);
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (currentMode !=  null) {
                    currentMode.mouseReleased(e);
                    repaint();
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                menuBar.setNameItem(false);
            }
        });
    }

    public static Canvas getInstance() {
        if (instance == null) {
            instance = new Canvas();
        }
        return instance;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setStroke(new BasicStroke(2.0f));

        Collections.sort(shapeList,new depthComparator());

        for (Shape shape: shapeList) {
            shape.draw(graphics2D);
        }

        for (Line line: lineList) {
            line.draw(graphics2D);
        }

    }

    public void setCurrentMode(BaseObjectMode mode) {
        currentMode = mode;
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }
    public List<Shape> getShapeSelected() {
        return shapeSelected;
    }
    public List<Line> getSLineList() {
        return lineList;
    }


    class depthComparator implements Comparator<Shape> {
        public int compare(Shape shape1, Shape shape2) {
            return shape2.getDepth() - shape1.getDepth();
        }
    }

    // change the object name of the specified object
    public void changeName() {
        String input;
        input = JOptionPane.showInputDialog("Input your new object name");
        if (input != null && input != "")
            // only one object can edit the name
            shapeSelected.get(0).setObjName(input);
    }

    // group multiple object
    public void groupObj() {
        getShapeList().add(0, new GroupObject(getShapeSelected()));
        Iterator<Shape> iterator = getShapeList().iterator();
        while (iterator.hasNext()) {
            if (getShapeSelected().contains(iterator.next())) {
                iterator.remove();
            }
        }
        getShapeSelected().clear();
        getShapeSelected().add(getShapeList().get(0));
        menuBar.setUnGroupItem(true);
    }

    // ungroup object
    public void unGroupObj() {
        for (Shape shape: getShapeSelected().get(0).getShapeList()) {
            getShapeList().add(0, shape);
            shape.setSelected(false);
        }
        getShapeList().remove(getShapeSelected().get(0));
    }


}
