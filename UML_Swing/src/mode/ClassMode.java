package mode;

import object.ClassObject;
import object.Shape;

import java.awt.event.MouseEvent;

public class ClassMode extends BaseObjectMode{
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Shape shape = new ClassObject(e.getPoint());
        canvas.getShapeList().add(shape);
    }
}
