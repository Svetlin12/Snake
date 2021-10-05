package Snake.src.listeners;

import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class EndGameListener extends OptionListener {

    public EndGameListener(Color currColor, JLabel textComponent) {
        super(currColor, textComponent);
    }

    @Override
    public void mousePressed(MouseEvent e) { // upon pressing the option "End Game" stop the program
        System.exit(0);
    }
}
