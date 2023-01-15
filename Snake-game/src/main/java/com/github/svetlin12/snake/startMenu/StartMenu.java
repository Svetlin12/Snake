package com.github.svetlin12.snake.startMenu;

import com.github.svetlin12.snake.listeners.EndGameListener;
import com.github.svetlin12.snake.listeners.HelpListener;
import com.github.svetlin12.snake.listeners.StartGameListener;
import com.github.svetlin12.snake.utils.LabelCreator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu extends JFrame {
    
    private static final String GAME_TITLE = "Snake";
    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    
    private static StartMenu instance;
    
    private final JPanel headerPanel;
    private final JPanel menuOptionsPanel;

    private StartMenu(JPanel headerPanel, JPanel menuOptionsPanel) {
        this.headerPanel = headerPanel;
        this.menuOptionsPanel = menuOptionsPanel;
        instance = this;
        initStartMenuSettings();
        decoratePanels();
    }
    
    private void initStartMenuSettings() {
        this.setTitle(GAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        this.getContentPane().setBackground(Color.BLACK);
    }
    
    private void decoratePanels() {
        setPanelProperties(headerPanel, new GridLayout(1, 1), new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT / 3));
        addLabelsToPanel(headerPanel, LabelCreator.createLargeLabelWith("Snake"));
        
        setPanelProperties(menuOptionsPanel, new GridLayout(3, 1), new Dimension(SCREEN_WIDTH, 2 * SCREEN_HEIGHT / 3));
        addLabelsToPanel(menuOptionsPanel,
                LabelCreator.createSmallLabelWith("Start Game", new StartGameListener()),
                LabelCreator.createSmallLabelWith("Help", new HelpListener()),
                LabelCreator.createSmallLabelWith("End Game", new EndGameListener()));

        attachPanelsToMenu(headerPanel, menuOptionsPanel);
        setMenuSettings();
    }
    
    private void setPanelProperties(JPanel panel, LayoutManager layout, Dimension dimension) {
        panel.setLayout(layout);
        panel.setPreferredSize(dimension);
        panel.setBackground(Color.BLACK);
    }
    
    private void addLabelsToPanel(JPanel panel, JLabel... labels) {
        for (JLabel label : labels) {
            panel.add(label);
        }
    }
    
    private void setMenuSettings() {
        instance.pack();
        instance.setLocationRelativeTo(null);
        instance.setVisible(true);
    }
    
    private void attachPanelsToMenu(JPanel... panels) {
        for (JPanel panel : panels) {
            instance.add(panel);
        }
    }
    
    public static StartMenu getInstance() {
        if (instance == null) {
            return new StartMenu(new JPanel(), new JPanel());
        }
        return instance;
    }
}