package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame{

    public MenuBar menuBar;
    public ToolBar toolBar;
    public Canvas canvas;

    public Main() {
        menuBar = MenuBar.getMenuBar();
        toolBar = new ToolBar();
        canvas = Canvas.getInstance();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(menuBar, BorderLayout.NORTH);
        getContentPane().add(toolBar, BorderLayout.WEST);
        getContentPane().add(canvas, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setTitle("UML Editor");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1280, 720);
        main.setLocationRelativeTo(null); // place the editor center
        main.setVisible(true);

        main.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        main.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int result=JOptionPane.showConfirmDialog((Component)e.getSource(),
                        "Are you sure you want to exit?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {System.exit(0);}
            }
        });

    }
}
