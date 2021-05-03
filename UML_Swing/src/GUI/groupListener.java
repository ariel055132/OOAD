package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class groupListener implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent){
        Canvas.getInstance().groupObj();
    }
}
