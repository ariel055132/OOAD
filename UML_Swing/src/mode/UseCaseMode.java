package mode;

import object.Shape;
import object.UseCaseObject;
import java.awt.event.MouseEvent;

public class UseCaseMode extends BaseObjectMode{
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        Shape shape = new UseCaseObject(mouseEvent.getPoint());
        canvas.getShapeList().add(shape);
    }
}
