package com.github.svetlin12.snake.listeners;

import javax.swing.event.MouseInputListener;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

// abstract class for all the listeners
public abstract class OptionListener implements MouseInputListener {
    protected Color hoverColor = new Color(163, 33, 10);
    protected Color textColor;
    protected JLabel targetComponent;
    
    public OptionListener() {
    }

    public OptionListener(Color textColor, JLabel targetComponent) {
        this.textColor = textColor;
        this.targetComponent = targetComponent;
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
        targetComponent.setForeground(hoverColor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        targetComponent.setForeground(textColor);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
    
    public void setTargetComponent(JLabel targetComponent) {
        this.targetComponent = targetComponent;
    }
}
