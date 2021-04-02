package mode;

import object.CompositionLine;

import java.awt.event.MouseEvent;

public class CompositionLineMode extends BaseLineMode{
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        super.mousePressed(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        endPoint = mouseEvent.getPoint();
        if (checkWhetherAdd(endPoint)) {
            canvas.getLineList().add(new CompositionLine(startPort, endPort));
        }
    }
}
