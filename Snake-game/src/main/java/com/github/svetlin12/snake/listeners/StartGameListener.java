package com.github.svetlin12.snake.listeners;

import com.github.svetlin12.snake.frames.GameFrame;
import com.github.svetlin12.snake.startMenu.StartMenu;

import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class StartGameListener extends OptionListener {
    
    public StartGameListener() {
    }

    public StartGameListener(Color currColor, JLabel textComponent) {
        super(currColor, textComponent);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        StartMenu.getInstance().setVisible(false);
        GameFrame.getInstance().setVisible(true);
    }
    
}
