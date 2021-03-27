package mode;

import object.AssociationLine;

import java.awt.event.MouseEvent;

public class AssociationLineMode extends BaseLineMode{
    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = e.getPoint();
        if (checkWhetherAdd(endPoint)) {
            canvas.getSLineList().add(new AssociationLine(startPort, endPort));
        }
    }
}
