package Snake.src.listeners;

import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import Snake.src.helpFrame.HelpFrame;
import Snake.src.startMenu.StartMenu;

public class BackListener extends OptionListener {

    public BackListener(Color currColor, JLabel textComponent) {
        super(currColor, textComponent);
    }
    
    @Override
    public void mousePressed(MouseEvent e) { // upon pressing the "Back" option in the Help frame, switch over to the Start Menu frame
        HelpFrame.getInstance().setVisible(false);
        StartMenu.getInstance().setVisible(true);
    }
}
