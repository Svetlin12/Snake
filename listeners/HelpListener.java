package Snake.src.listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import Snake.src.helpFrame.HelpFrame;
import Snake.src.startMenu.StartMenu;

public class HelpListener extends OptionListener {

    public HelpListener(Color currColor, JLabel textComponent) {
        super(currColor, textComponent);
    }
    
    @Override
    public void mousePressed(MouseEvent e) { // upon clicking the "Help" option from the Start Menu, switch over to the Help frame
        StartMenu.getInstance().setVisible(false);
        HelpFrame.getInstance().setVisible(true);
    }
}
