package mode;

import object.ClassObject;
import object.Shape;

import java.awt.event.MouseEvent;

public class ClassMode extends BaseObjectMode{
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        Shape shape = new ClassObject(mouseEvent.getPoint());
        canvas.getShapeList().add(shape);
    }
}
