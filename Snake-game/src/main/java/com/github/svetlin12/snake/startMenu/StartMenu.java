package com.github.svetlin12.snake.startMenu;

import com.github.svetlin12.snake.listeners.EndGameListener;
import com.github.svetlin12.snake.listeners.HelpListener;
import com.github.svetlin12.snake.listeners.StartGameListener;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu extends JFrame {

    private final JPanel header; // holds the name of the game
    private final JPanel menuOptions; // holds the options that the user can click
    private static StartMenu instance = null; // holds the Singleton instance
    private final int SCREEN_WIDTH = 600, SCREEN_HEIGHT = 600; // define the screen width and height size
    private final Font optionsFont = new Font("Segoe Script", Font.BOLD + Font.ITALIC, 30); // the font used for the options that are presented to the user
    private final Font headerFont = new Font("Segoe Script", Font.BOLD + Font.ITALIC, 70); // the font used for the name of the game
    private final Color textColor = new Color(33, 128, 58); // color of the text

    private StartMenu() {
        header = new JPanel();
        menuOptions = new JPanel();
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)); // set the size of the frame
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        this.getContentPane().setBackground(Color.BLACK); // set the whole background to black
        instance = this;
        decoratePanels(); // fill the empty panels we just created
    }

    public static StartMenu getInstance() {
        if (instance == null) {
            return new StartMenu();
        }
        return instance;
    }

    private void decoratePanels() {
        header.setLayout(new GridLayout(1, 1));
        header.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT / 3));

        // game name label
        JLabel headerLabel = new JLabel("Snake");
        headerLabel.setFont(headerFont);
        headerLabel.setForeground(textColor);
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setVerticalAlignment(JLabel.CENTER);

        header.add(headerLabel);

        menuOptions.setLayout(new GridLayout(3, 1));
        menuOptions.setPreferredSize(new Dimension(SCREEN_WIDTH, 2 * SCREEN_HEIGHT / 3));

        // start game option
        JLabel startGameLabel = new JLabel("Start Game");
        startGameLabel.setFont(optionsFont);
        startGameLabel.setForeground(textColor);
        startGameLabel.setVerticalAlignment(JLabel.CENTER);
        startGameLabel.setHorizontalAlignment(JLabel.CENTER);
        startGameLabel.addMouseListener(new StartGameListener(textColor, startGameLabel));

        // help option
        JLabel helpLabel = new JLabel("Help");
        helpLabel.setFont(optionsFont);
        helpLabel.setForeground(textColor);
        helpLabel.setVerticalAlignment(JLabel.CENTER);
        helpLabel.setHorizontalAlignment(JLabel.CENTER);
        helpLabel.addMouseListener(new HelpListener(textColor, helpLabel));

        // end game option
        JLabel quitGameLabel = new JLabel("End Game");
        quitGameLabel.setFont(optionsFont);
        quitGameLabel.setForeground(textColor);
        quitGameLabel.setVerticalAlignment(JLabel.CENTER);
        quitGameLabel.setHorizontalAlignment(JLabel.CENTER);
        quitGameLabel.addMouseListener(new EndGameListener(textColor, quitGameLabel));

        menuOptions.add(startGameLabel);
        menuOptions.add(helpLabel);
        menuOptions.add(quitGameLabel);

        menuOptions.setBackground(Color.BLACK);
        header.setBackground(Color.BLACK);

        instance.add(header);
        instance.add(menuOptions);
        instance.pack();
        instance.setLocationRelativeTo(null);
        instance.setVisible(true);
    }
}
