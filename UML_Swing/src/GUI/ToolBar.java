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
    public String[] imageNameList;
    public ToolBar() {
        setLayout(new GridLayout(6,1));

        // right click image folder to obtain the file path
        ImageIcon select = new ImageIcon("src/image/select1.png");
        ToolButton selectButton = new ToolButton(select, new SelectMode());
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


    // Is ToolButton a JButton/Button? Yes
    public class ToolButton extends JButton{
        BaseObjectMode mode;
        JButton currentClicked = null;
        Canvas canvas;
        public ToolButton (ImageIcon imageIcon, BaseObjectMode toolMode) {
            this.mode = toolMode;
            //System.out.println(toolMode.toString());
            setIcon(imageIcon);
            // https://stackoverflow.com/questions/2536873/how-can-i-set-size-of-a-button
            setPreferredSize(new Dimension(100, 40));
            setOpaque(false);
            setBorderPainted(true);
            addActionListener(new ToolButtonListener());
        }

        public class ToolButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetColor();
                System.out.println(mode);
                ((JButton)e.getSource()).setOpaque(true);
                ((JButton)e.getSource()).setBackground(Color.LIGHT_GRAY);
                Canvas.getInstance().setCurrentMode(mode);
            }
        }

        void resetColor() {
            for (ToolButton button : buttonArrayList) {
                button.setBackground(new Color(0,0,0));
                button.setOpaque(false);
            }
        }


    }
}
