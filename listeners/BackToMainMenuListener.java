package Snake.src.listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import Snake.src.endFrame.EndGame;
import Snake.src.startMenu.StartMenu;

public class BackToMainMenuListener extends OptionListener {

    private EndGame endFrame = null;

    public BackToMainMenuListener(Color currColor, JLabel textComponent, EndGame endFrame) {
        super(currColor, textComponent);
        this.endFrame = endFrame;
        this.hoverColor = new Color(33, 128, 58);
    }
    
    @Override
    public void mousePressed(MouseEvent e) { // upon pressing the option "Back to Main Menu" in the end game frame, switch over to the Start Menu frame
        endFrame.setVisible(false);
        endFrame = null;
        StartMenu.getInstance().setVisible(true);
    }
}
