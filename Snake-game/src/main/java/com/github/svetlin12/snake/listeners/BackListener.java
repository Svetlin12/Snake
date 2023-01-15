package com.github.svetlin12.snake.listeners;

import com.github.svetlin12.snake.frames.HelpFrame;
import com.github.svetlin12.snake.startMenu.StartMenu;

import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class BackListener extends OptionListener {
    
    public BackListener() {
    }

    public BackListener(Color currColor, JLabel textComponent) {
        super(currColor, textComponent);
    }
    
    @Override
    public void mousePressed(MouseEvent e) { // upon pressing the "Back" option in the Help frame, switch over to the Start Menu frame
        HelpFrame.getInstance().setVisible(false);
        StartMenu.getInstance().setVisible(true);
    }
}
