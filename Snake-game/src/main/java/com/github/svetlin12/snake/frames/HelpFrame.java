package com.github.svetlin12.snake.frames;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.github.svetlin12.snake.listeners.BackListener;
import com.github.svetlin12.snake.utils.FrameConigUtil;
import com.github.svetlin12.snake.utils.LabelCreator;

import static com.github.svetlin12.snake.startMenu.StartMenu.GAME_TITLE;
import static com.github.svetlin12.snake.utils.ScreenConstants.SCREEN_HEIGHT;
import static com.github.svetlin12.snake.utils.ScreenConstants.SCREEN_WIDTH;

public class HelpFrame extends JFrame {
    
    private static HelpFrame helpFrameInstance;

    private HelpFrame() {
        helpFrameInstance = this;
        setFrameSettings();
        constructHelpInfo();
    }
    
    private void setFrameSettings() {
        this.setTitle(GAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(new GridLayout(6, 1));
        this.getContentPane().setBackground(Color.BLACK);
    }

    private void constructHelpInfo() {
        JLabel headerLabel = LabelCreator.createLargeLabelWith("Controls");
        JLabel upKeysHelpInfoLabel = LabelCreator.createSmallLabelWith("\u2191,W \u2014 Make the snake go up");
        JLabel downKeysHelpInfoLabel = LabelCreator.createSmallLabelWith("\u2193,S \u2014 Make the snake go down");
        JLabel leftKeysHelpInfoLabel = LabelCreator.createSmallLabelWith("\u2190,A \u2014 Make the snake go left");
        JLabel rightKeysHelpInfoLabel = LabelCreator.createSmallLabelWith("\u2192,D \u2014 Make the snake go right");
        JLabel backLabel = LabelCreator.createSmallLabelWith("Back", new BackListener());
        
        FrameConigUtil.attachComponentsToFrame(helpFrameInstance, headerLabel, upKeysHelpInfoLabel, downKeysHelpInfoLabel,
                leftKeysHelpInfoLabel, rightKeysHelpInfoLabel, backLabel);
        FrameConigUtil.setFrameSettings(helpFrameInstance);
    }
    
    public static HelpFrame getHelpFrameInstance() {
        if (helpFrameInstance == null) {
            return new HelpFrame();
        }
        return helpFrameInstance;
    }
}
