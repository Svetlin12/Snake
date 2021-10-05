package Snake.src.endFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Snake.src.listeners.BackToMainMenuListener;

public class EndGame extends JFrame {
    
    private final int SCREEN_WIDTH = 600, SCREEN_HEIGHT = 600;
    private final Font headerFont = new Font("Segoe Script", Font.BOLD + Font.ITALIC, 70);
    private final Font textFont = new Font("Segoe Script", Font.BOLD + Font.ITALIC, 30);
    private final Color textColor = new Color(191, 50, 15);
    private final int score; // the total score at the end of the game

    public EndGame(int score) {
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(new GridLayout(3, 1));
        this.getContentPane().setBackground(Color.BLACK);
        this.score = score;
        setFrame();
    }

    private void setFrame() {
        // header - "Game Over"
        JLabel gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setFont(headerFont);
        gameOverLabel.setForeground(textColor);
        gameOverLabel.setVerticalAlignment(JLabel.BOTTOM);
        gameOverLabel.setHorizontalAlignment(JLabel.CENTER);

        // a label stating the score at the end of the game
        JLabel scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(textFont);
        scoreLabel.setForeground(textColor);
        scoreLabel.setVerticalAlignment(JLabel.TOP);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);

        // option to go back to the main menu
        JLabel backLabel = new JLabel("Back to Main Menu");
        backLabel.setFont(textFont);
        backLabel.setForeground(textColor);
        backLabel.setVerticalAlignment(JLabel.TOP);
        backLabel.setHorizontalAlignment(JLabel.CENTER);
        backLabel.addMouseListener(new BackToMainMenuListener(textColor, backLabel, this));

        this.add(gameOverLabel);
        this.add(scoreLabel);
        this.add(backLabel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
