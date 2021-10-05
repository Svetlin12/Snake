package Snake.src.snakeFrame;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    private static GameFrame instance = null; // holds the Singleton instance
    private GamePanel panelInstance = null;

    private GameFrame() {
        panelInstance = new GamePanel();
        this.add(panelInstance);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(false);
        this.setLocationRelativeTo(null);
        instance = this;
    }

    public static GameFrame getInstance() {
        if (instance == null) {
            return new GameFrame();
        }

        // if there is already an existing instance and it's game panel is null, then create a new game panel and add it to the instance
        if (instance.panelInstance == null) {
            instance.panelInstance = new GamePanel();
            instance.add(instance.panelInstance);
        }

        return instance;
    }

    // whenever the game ends, remove the game panel object and hide the game frame
    public void restartInstance() {
        if (!panelInstance.getRunningState()) {
            instance.remove(panelInstance);
            panelInstance = null;
            instance.setVisible(false);
        }
    }
}