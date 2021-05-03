package gui;

import mode.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// 6 buttons
public class ToolBar extends JToolBar {
    public ArrayList<ToolButton> buttonArrayList = new ArrayList<>();
    public MenuBar menuBar;
    public Canvas canvas;

    public ToolBar() {
        canvas = Canvas.getInstance();
        menuBar = MenuBar.getMenuBar();
        setLayout(new GridLayout(6,1));

        // right click image folder to obtain the file path
        ImageIcon select = new ImageIcon("src/image/select1.png");
        ToolButton selectButton = new ToolButton(select, new SelectMode());
        buttonArrayList.add(selectButton);
        add(selectButton);

        ImageIcon association = new ImageIcon("src/image/association2.png");
        ToolButton associationButton = new ToolButton(association, new AssociationLineMode());
        buttonArrayList.add(associationButton);
        add(associationButton);

        ImageIcon generalization = new ImageIcon("src/image/generalization1.png");
        ToolButton generalizationButton = new ToolButton(generalization, new GeneralizationLineMode());
        buttonArrayList.add(generalizationButton);
        add(generalizationButton);

        ImageIcon composition = new ImageIcon("src/image/composition1.png");
        ToolButton compositionButton = new ToolButton(composition, new CompositionLineMode());
        buttonArrayList.add(compositionButton);
        add(compositionButton);

        ImageIcon classImg = new ImageIcon("src/image/Class1.png");
        ToolButton classButton = new ToolButton(classImg, new ClassMode());
        buttonArrayList.add(classButton);
        add(classButton);

        ImageIcon usecase = new ImageIcon("src/image/useCase1.png");
        ToolButton usecaseButton = new ToolButton(usecase, new UseCaseMode());
        buttonArrayList.add(usecaseButton);
        add(usecaseButton);
    }

    // https://stackoverflow.com/questions/2536873/how-can-i-set-size-of-a-button
    public class ToolButton extends JButton{
        BaseObjectMode mode;
        public ToolButton (ImageIcon imageIcon, BaseObjectMode toolMode) {
            this.mode = toolMode;
            this.setIcon(imageIcon);
            this.setPreferredSize(new Dimension(100, 40));
            this.setOpaque(false);
            this.setBorderPainted(true);
            this.addActionListener(new ToolButtonListener());
        }

        public class ToolButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resetColor();
                System.out.println(mode);
                ((JButton) actionEvent.getSource()).setOpaque(true);
                ((JButton) actionEvent.getSource()).setBackground(Color.LIGHT_GRAY);
                Canvas.getInstance().setCurrentMode(mode);
                setMenuUnable();
            }

            void setMenuUnable() {
                menuBar.setUngroup(false);
                menuBar.setGroup(false);
                menuBar.setObjectname(false);
            }

            void resetColor() {
                for (ToolButton button : buttonArrayList) {
                    button.setBackground(new Color(0, 0, 0));
                    button.setOpaque(false);
                }
            }
        }
    }
}
