package mode;

import object.AssociationLine;

import java.awt.event.MouseEvent;

public class AssociationLineMode extends BaseLineMode{
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        super.mousePressed(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        endPoint = mouseEvent.getPoint();
        if (checkWhetherAdd(endPoint)) {
            canvas.getLineList().add(new AssociationLine(startPort, endPort));
        }
    }
}
