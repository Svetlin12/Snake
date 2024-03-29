package com.github.svetlin12.snake.listeners;

import com.github.svetlin12.snake.frames.HelpFrame;
import com.github.svetlin12.snake.startMenu.StartMenu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class HelpListener extends OptionListener {
    
    public HelpListener() {
    }

    public HelpListener(Color currColor, JLabel textComponent) {
        super(currColor, textComponent);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        StartMenu.getMenuFrameInstance().setVisible(false);
        HelpFrame.getHelpFrameInstance().setVisible(true);
    }
}
