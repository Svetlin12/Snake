package Snake.src.snakeFrame;

import java.awt.*;
import java.awt.event.*;
import java.util.EnumMap;
import java.util.Map;
import java.util.Random;
import javax.swing.Timer;
import Snake.src.endFrame.EndGame;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {
    
    private enum Direction { // the directions in which the snake can go
        UP, DOWN, RIGHT, LEFT
    }

    private Map<Direction, Integer> directionValues = new EnumMap<Direction, Integer>(Direction.class); // defines where to move according to each direction from the above enum
    
    private Random randomInt = new Random(); // will be used to generate random numbers (the x and y coordinates of the apple)
    private final int SCREEN_WIDTH = 600, SCREEN_HEIGHT = 600; // define screen width and height of the program
    private final int UNIT_SIZE = 25; // define the size of each block
    private Timer timer; // defines that by each tick of the timer, the actionPerformed() method will be executed, meaning that this will create the snake motion
    private final int DELAY = 100; // the longer the delay is, the more time between each execution of actionPerformed()
    private boolean running = true; // determine whether the game is not yet over
    private int appleX = 0; // x coordinate of the apple
    private int appleY = 0; // y coordinate of the apple
    private int score = 0;
    private int[] snakeX = new int[(SCREEN_WIDTH / UNIT_SIZE) * (SCREEN_HEIGHT / UNIT_SIZE)]; // the x coordinates of the snake's body; max snake body size is the amount of units inside the playing screen
    private int[] snakeY = new int[(SCREEN_WIDTH / UNIT_SIZE) * (SCREEN_HEIGHT / UNIT_SIZE)];; // the y coordinates of the snake's body
    private Direction currentDirection = Direction.RIGHT; // by default start going rightwards
    private int snakeLength = 4; // by default the body of the snake is 4 pieces (including the head)
    private Font mainFont = new Font("Segoe Script", Font.BOLD + Font.ITALIC, 30); // the font used to display the score tab
    private final Color snakeHeadColor = new Color(71, 102, 27); // the color of the snake's head
    private final Color snakeBodyColor = new Color(146, 214, 51); // the color of the snake's body without the head

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)); // set the size of the screen
        this.setBackground(Color.BLACK); // set background color to black
        this.setFocusable(true);
        this.addKeyListener(new MyKeyListener()); // add a key listener for the movement of the snake
        startGame(); // initialise everything else
    }

    private void startGame() {
        // start at top left end of the window
        snakeX[0] = 0;
        snakeY[0] = 0;

        // initialise the value for each direction in the enum
        directionValues.put(Direction.UP, -UNIT_SIZE);
        directionValues.put(Direction.DOWN, UNIT_SIZE);
        directionValues.put(Direction.LEFT, -UNIT_SIZE);
        directionValues.put(Direction.RIGHT, UNIT_SIZE);
        
        generateNewApple(); // generate an apple at a random place
        timer = new Timer(DELAY, this); // initialize the timer (after each DELAY, actionPerformed() method will be executed)
        timer.start(); /// start the timer
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g); // draw the snake's body
        drawApple(g); // draw the apple
        
        // the score tab
        String scoreAnnouncer = "Score: " + score;
        g.setFont(mainFont);
        int scoreAnnouncerSize = g.getFontMetrics().stringWidth(scoreAnnouncer); // get the width of the score string
        g.drawString(scoreAnnouncer, SCREEN_WIDTH / 2 - scoreAnnouncerSize / 2, UNIT_SIZE); // position the score string at the top center part of the string
    }

    // draw the snake's body
    private void draw(Graphics g) {
        
        for (int i = 0; i < snakeLength; i++) {
            if (i == 0) {
                g.setColor(snakeHeadColor);
            }

            g.drawRect(snakeX[i], snakeY[i], UNIT_SIZE, UNIT_SIZE);
            g.fillRect(snakeX[i], snakeY[i], UNIT_SIZE, UNIT_SIZE);

            if (i == 0) {
                g.setColor(snakeBodyColor);
            }
        }
    }

    // generate coordinates for the new apple using the randomInt variable of type Random
    private void generateNewApple() {
        appleX = randomInt.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        appleY = randomInt.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
    }

    // draw the apple
    private void drawApple(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
    }

    private void move() {
        if (!running) { // do nothing if game is stopped
            return;
        }

        // get each part of the snake excluding the head at the position of it's predecessing part
        for (int i = snakeLength - 1; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        // move the head to the direction of the user's wish
        switch (currentDirection) {
            case UP:
                snakeY[0] += directionValues.get(currentDirection);
                break;
            case DOWN:
                snakeY[0] += directionValues.get(currentDirection);
                break;
            case LEFT:
                snakeX[0] += directionValues.get(currentDirection);
                break;
            case RIGHT:
                snakeX[0] += directionValues.get(currentDirection);
                break;
        }
    }

    // check whether the snake's head has collided with any of its body parts
    private boolean checkSnakeCollision() {
        for (int i = 1; i < snakeLength; i++) {
            if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                return true;
            }
        }

        return false;
    }

    // check whether the snake has collided with either it's own body parts or the playing screen's ends
    private boolean checkCollision() {
        if (snakeX[0] < 0 || snakeX[0] > SCREEN_WIDTH || snakeY[0] < 0 || snakeY[0] > SCREEN_HEIGHT) { // if out of bounds
            running = false;
            return true;
        }
        else if (checkSnakeCollision()) { // if the head collides with other snake parts
            running = false;
            return true;
        }
        return false;
    }

    // check if the head has reached the apple
    private boolean checkApple() {
        if (snakeX[0] == appleX && snakeY[0] == appleY) {
            return true;
        }
        return false;
    }

    public boolean getRunningState() {
        return running;
    }

    // turn to the end game frame when the game is over
    private void proceedToEndFrame() {
        GameFrame.getInstance().restartInstance();
        new EndGame(score);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move(); // move the snake with each tick of the timer
            if (checkCollision()) {
                proceedToEndFrame(); // if the snake has collided anywhere, switch over to the end game frame
                return;
            }
            if (checkApple()) {
                // add a new body part at the tail of the snake
                snakeX[snakeLength] = appleX;
                snakeY[snakeLength] = appleY;
                snakeLength++; // increase the snake's size
                score++; // increase the total score
                generateNewApple();
            }
            repaint(); // repaint the frame so that the new snake position is shown
        }
    }

    // check whether the direction that the user has inputted is incorrect
    private boolean checkDirection(Direction d) {
        if (currentDirection == Direction.UP && d == Direction.DOWN) { // going up, presses down
            return true;
        }
        else if (currentDirection == Direction.DOWN && d == Direction.UP) { // going down, presses up
            return true;
        }
        else if (currentDirection == Direction.LEFT && d == Direction.RIGHT) { // going left, presses right
            return true;
        }
        else if (currentDirection == Direction.RIGHT && d == Direction.LEFT) { // going right, presses left
            return true;
        }
        return false;
    }

    protected class MyKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            // check where the user wants to move the snake and change the current direction accordingly
            switch (keyCode) {
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (!checkDirection(Direction.DOWN)) {
                        currentDirection = Direction.DOWN;
                    }
                    break;
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (!checkDirection(Direction.UP)) {
                        currentDirection = Direction.UP;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (!checkDirection(Direction.LEFT)) {
                        currentDirection = Direction.LEFT;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (!checkDirection(Direction.RIGHT)) {
                        currentDirection = Direction.RIGHT;
                    }
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}