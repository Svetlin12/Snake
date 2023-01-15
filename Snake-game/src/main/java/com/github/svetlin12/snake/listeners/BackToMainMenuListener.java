package com.github.svetlin12.snake.listeners;

import com.github.svetlin12.snake.frames.EndGame;
import com.github.svetlin12.snake.startMenu.StartMenu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class BackToMainMenuListener extends OptionListener {

    private EndGame endFrame;
    
    public BackToMainMenuListener() {
    }

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
