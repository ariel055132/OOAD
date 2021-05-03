package gui;

// Trying to copy as the same as JAVAFX MenuBar
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Is Menubar a JMenuBar? Yes
public class MenuBar extends JMenuBar {
    public static MenuBar menuBar = null;
    private JMenuItem group, ungroup, changeObjectName;
    private JMenu file, edit;

    public static MenuBar getMenuBar() {
        if (menuBar == null) {
            menuBar =  new MenuBar();
        }
        return menuBar;
    }

    public MenuBar() {
        file = new JMenu("File");
        this.add(file);

        edit = new JMenu("Edit");
        this.add(edit);

        group = new JMenuItem("Group");
        group.addActionListener(new groupListener());
        group.setEnabled(false);
        edit.add(group);

        ungroup = new JMenuItem("UnGroup");
        ungroup.addActionListener(new ungroupListener());
        ungroup.setEnabled(false);
        edit.add(ungroup);

        changeObjectName = new JMenuItem("Change Object Name");
        changeObjectName.addActionListener(new changeObjectNameListener());
        changeObjectName.setEnabled(false);
        edit.add(changeObjectName);
    }

    public void setGroup(boolean enable) {
        group.setEnabled(enable);
    }
    public void setUngroup(boolean enable) {
        this.ungroup.setEnabled(enable);
    }
    public void setObjectname(boolean enable) {
        this.changeObjectName.setEnabled(enable);
    }

}
