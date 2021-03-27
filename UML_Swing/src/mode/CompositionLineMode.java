package mode;

import object.AssociationLine;
import object.CompositionLine;

import java.awt.event.MouseEvent;

public class CompositionLineMode extends BaseLineMode{
    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = e.getPoint();
        if (checkWhetherAdd(endPoint)) {
            canvas.getSLineList().add(new CompositionLine(startPort, endPort));
        }
    }
}
