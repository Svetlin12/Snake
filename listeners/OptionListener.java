package Snake.src.listeners;

import javax.swing.event.MouseInputListener;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

// abstract class for all the listeners
public abstract class OptionListener implements MouseInputListener {
    protected Color hoverColor = new Color(163, 33, 10); // defines the color to which the text's color should change
    protected Color prevColor; // the color of the previous text
    protected JLabel component; // the component which text's color is changed

    public OptionListener(Color currColor, JLabel textComponent) {
        component = textComponent;
        prevColor = currColor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    // change text color on hover
    @Override
    public void mouseEntered(MouseEvent e) {
        component.setForeground(hoverColor);
    }

    // revert text color back to the original upon the mouse exiting the component containing the text
    @Override
    public void mouseExited(MouseEvent e) {
        component.setForeground(prevColor);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
