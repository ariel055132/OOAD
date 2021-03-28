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
    private static Canvas instance = null; // for singleton
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2.0f));

        Collections.sort(shapeList,new depthComparator());

        for (Shape s: shapeList) {
            s.draw(g2);
        }

        for (Line l: lineList) {
            l.draw(g2);
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
        public int compare(Shape s1, Shape s2) {
            return s2.getDepth() - s1.getDepth();  //倒序
        }
    }


    public void changeName() {
        String input;
        input = JOptionPane.showInputDialog("Input your new object name");
        if (input != null && input != "")
            // only one object can edit the name
            shapeSelected.get(0).setObjName(input);
    }


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


    public void unGroupObj() {
        for (Shape s: getShapeSelected().get(0).getShapeList()) {
            getShapeList().add(0, s);
            s.setSelected(false);
        }
        getShapeList().remove(getShapeSelected().get(0));
    }


}
