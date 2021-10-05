package Snake.src.listeners;

import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import Snake.src.snakeFrame.GameFrame;
import Snake.src.startMenu.StartMenu;
import java.awt.Color;

public class StartGameListener extends OptionListener {    

    public StartGameListener(Color currColor, JLabel textComponent) {
        super(currColor, textComponent);
    }

    @Override
    public void mousePressed(MouseEvent e) { // upon pressing the "Start Game" option, switch over to the game frame
        StartMenu.getInstance().setVisible(false);
        GameFrame.getInstance().setVisible(true);
    }
    
}
