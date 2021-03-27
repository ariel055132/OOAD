package mode;

import gui.Canvas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class Mode implements MouseListener, MouseMotionListener {
    public Canvas canvas = Canvas.getInstance();

    public void mousePressed(MouseEvent mouseEvent) {

    }

    public void mouseReleased(MouseEvent mouseEvent) {

    }

    public void mouseClicked(MouseEvent mouseEvent) {

    }

}
