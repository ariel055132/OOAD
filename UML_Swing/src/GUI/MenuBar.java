package gui;

// Trying to copy as the same as JAVAFX MenuBar

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Is Menubar a JMenuBar? Yes
public class MenuBar extends JMenuBar {
    public static MenuBar menuBar = null;
    private JMenuItem group, ungroup, changeObjectName;

    public MenuBar() {
        // File menu
        JMenu fileMenu = new JMenu("File");
        add(fileMenu);

        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        add(editMenu);

        // To-do Group function
        group = new JMenuItem("Group");
        group.addActionListener(new groupItemListener());
        group.setEnabled(false);
        editMenu.add(group);

        // To-do UnGroup function
        ungroup = new JMenuItem("UnGroup");
        ungroup.addActionListener(new unGroupItemListener());
        ungroup.setEnabled(false);
        editMenu.add(ungroup);

        // To-do change Object Name function
        changeObjectName = new JMenuItem("Change Object Name");
        changeObjectName.addActionListener(new nameItemListener());
        changeObjectName.setEnabled(false);
        editMenu.add(changeObjectName);

    }

    public static MenuBar getMenuBar() {
        if (menuBar == null) {
            menuBar =  new MenuBar();
        }
        return menuBar;
    }


    class groupItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Canvas.getInstance().groupObj();
        }
    }

    class unGroupItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Canvas.getInstance().unGroupObj();
        }
    }
    class nameItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Canvas.getInstance().changeName();
            Canvas.getInstance().repaint();
        }
    }

    public void setGroupItem(boolean enable) {
        group.setEnabled(enable);
    }

    public void setUnGroupItem(boolean enable) {
        this.ungroup.setEnabled(enable);
    }

    public void setNameItem(boolean enable) {
        this.changeObjectName.setEnabled(enable);
    }

}
