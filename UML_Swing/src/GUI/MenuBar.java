package GUI;

// Trying to copy as the same as JAVAFX MenuBar

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        // File menu
        JMenu fileMenu = new JMenu("File");
        add(fileMenu);

        // To-do
        JMenuItem one = new JMenuItem("One");
        fileMenu.add(one);

        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        add(editMenu);

        // To-do
        
    }

}
