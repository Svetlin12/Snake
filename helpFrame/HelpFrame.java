package Snake.src.helpFrame;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Snake.src.listeners.BackListener;

public class HelpFrame extends JFrame {
    
    private static HelpFrame instance = null;
    private final int SCREEN_WIDTH = 600, SCREEN_HEIGHT = 600;
    private final Font headerFont = new Font("Segoe Script", Font.BOLD + Font.ITALIC, 70);
    private final Font textFont = new Font("Segoe Script", Font.BOLD + Font.ITALIC, 30);
    private final Color textColor = new Color(33, 128, 58);

    private HelpFrame() {
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(new GridLayout(6, 1));
        this.getContentPane().setBackground(Color.BLACK);
        instance = this;
        constructHelpInfo();
    }

    public static HelpFrame getInstance() {
        if (instance  == null) {
            return new HelpFrame();
        }
        return instance;
    }

    private void constructHelpInfo() {
        // header label
        JLabel header = new JLabel("Controls");
        header.setFont(headerFont);
        header.setForeground(textColor);
        header.setVerticalAlignment(JLabel.CENTER);
        header.setHorizontalAlignment(JLabel.CENTER);

        // controls for going upwards
        JLabel up = new JLabel("\u2191,W \u2014 Make the snake go up");
        up.setFont(textFont);
        up.setForeground(textColor);
        up.setVerticalAlignment(JLabel.CENTER);
        up.setHorizontalAlignment(JLabel.CENTER);

        // controls for going downwards
        JLabel down = new JLabel("\u2193,S \u2014 Make the snake go down");
        down.setFont(textFont);
        down.setForeground(textColor);
        down.setVerticalAlignment(JLabel.CENTER);
        down.setHorizontalAlignment(JLabel.CENTER);

        // controls for going leftwards
        JLabel left = new JLabel("\u2190,A \u2014 Make the snake go left");
        left.setFont(textFont);
        left.setForeground(textColor);
        left.setVerticalAlignment(JLabel.CENTER);
        left.setHorizontalAlignment(JLabel.CENTER);

        // controls for going rightwards
        JLabel right = new JLabel("\u2192,D \u2014 Make the snake go right");
        right.setFont(textFont);
        right.setForeground(textColor);
        right.setVerticalAlignment(JLabel.CENTER);
        right.setHorizontalAlignment(JLabel.CENTER);

        // option to go back to the start menu
        JLabel back = new JLabel("Back");
        back.setFont(textFont);
        back.setForeground(textColor);
        back.setVerticalAlignment(JLabel.CENTER);
        back.setHorizontalAlignment(JLabel.CENTER);
        back.addMouseListener(new BackListener(textColor, back));

        instance.add(header);
        instance.add(up);
        instance.add(down);
        instance.add(left);
        instance.add(right);
        instance.add(back);
        instance.pack();
        instance.setLocationRelativeTo(null);
        instance.setVisible(true);
    }
}
