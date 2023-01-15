package com.github.svetlin12.snake.frames;

import javax.swing.JFrame;

import static com.github.svetlin12.snake.startMenu.StartMenu.GAME_TITLE;

public class GameFrame extends JFrame {
    private static GameFrame gameFrameInstance;
    private static GamePanel panelInstance;

    private GameFrame(GamePanel gamePanel) {
        gameFrameInstance = this;
        panelInstance = gamePanel;
        setGameFrameSettings();
    }
    
    private void setGameFrameSettings() {
        this.add(panelInstance);
        this.setTitle(GAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    public static GameFrame getGameFrameInstance() {
        if (gameFrameInstance == null) {
            return new GameFrame(new GamePanel());
        }

        if (panelInstance == null) {
            addNewPanelInstance();
        }

        return gameFrameInstance;
    }
    
    private static void addNewPanelInstance() {
        panelInstance = new GamePanel();
        gameFrameInstance.add(panelInstance);
    }

    public void restartInstance() {
        if (!panelInstance.getRunningState()) {
            removePanelInstance();
        }
    }
    
    private void removePanelInstance() {
        gameFrameInstance.remove(panelInstance);
        panelInstance = null;
        hideFrame();
    }
    
    private void hideFrame() {
        gameFrameInstance.setVisible(false);
    }
}