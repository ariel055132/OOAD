package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeObjectNameListener implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent){
        Canvas.getInstance().changeName();
        Canvas.getInstance().repaint();
    }
}
