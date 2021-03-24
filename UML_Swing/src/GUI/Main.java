package GUI;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    private MenuBar menuBar;
    //private ToolBar toolBar;
    //private Canvas canvas;

    public Main() {
        menuBar = new MenuBar();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(menuBar, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setTitle("UML Editor");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1000, 550);
        main.setVisible(true);
    }
}
