package mode;

import object.CompositionLine;
import object.GeneralizationLine;

import java.awt.event.MouseEvent;

public class GeneralizationLineMode extends BaseLineMode{
    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = e.getPoint();
        if (checkWhetherAdd(endPoint)) {
            canvas.getSLineList().add(new GeneralizationLine(startPort, endPort));
        }
    }
}
