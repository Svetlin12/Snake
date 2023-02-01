package com.github.svetlin12.snake.frames;

import com.github.svetlin12.snake.components.Apple;
import com.github.svetlin12.snake.components.Direction;
import com.github.svetlin12.snake.components.Snake;
import com.github.svetlin12.snake.exceptions.SnakeBodyReachedMaximumCountException;
import com.github.svetlin12.snake.utils.FontsUtil;
import com.github.svetlin12.snake.utils.LabelCreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;
import javax.swing.JPanel;

import static com.github.svetlin12.snake.utils.ScreenConstants.SCREEN_HEIGHT;
import static com.github.svetlin12.snake.utils.ScreenConstants.SCREEN_WIDTH;
import static com.github.svetlin12.snake.utils.ScreenConstants.UNIT_SIZE;

public class GamePanel extends JPanel implements ActionListener {
    private static final int TIMER_DELAY = 100; // the longer the delay is, the more time between each execution of actionPerformed()
    private static final FontsUtil FONTS_UTIL = new FontsUtil(LabelCreator.FONT_NAME, LabelCreator.FONT_STYLE);
    private final Timer timer; // defines that by each tick of the timer, the actionPerformed() method will be executed
    private Direction currentDirection = Direction.RIGHT;
    private final Snake snake;
    private Apple apple;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new PlayerKeyboardListener());
        this.snake = new Snake();
        this.apple = new Apple();
        timer = new Timer(TIMER_DELAY, this);
        timer.start();
    }

    protected void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        snake.draw(graphic);
        apple.draw(graphic);
        
        String scoreAnnouncer = "Score: " + snake.getEatenApples();
        graphic.setFont(FONTS_UTIL.getSmallFont());
        int scoreAnnouncerSize = graphic.getFontMetrics().stringWidth(scoreAnnouncer); // get the width of the score string
        graphic.drawString(scoreAnnouncer, SCREEN_WIDTH / 2 - scoreAnnouncerSize / 2, UNIT_SIZE); // position the score string at the top center part of the string
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move(currentDirection);
    
        if (snake.hasSnakeCollidedWithOwnBody() || snake.isSnakeOutsidePlayingField()) {
            proceedToEndFrame();
        }
        else if (snake.isHeadAtApple(apple)) {
            try {
                snake.addToBody(apple);
                apple = new Apple();
            } catch (SnakeBodyReachedMaximumCountException ex) {
                proceedToEndFrame();
            }
        }
    
        repaint();
    }
    
    private void changeCurrentDirectionTo(Direction newDirection) {
        if (newDirection == Direction.NO_DIRECTION || getOppositeDirection() == newDirection) {
            return;
        }
        
        currentDirection = newDirection;
    }
    
    private Direction getOppositeDirection() {
        return switch (currentDirection) {
            case UP -> Direction.DOWN;
            case DOWN -> Direction.UP;
            case RIGHT -> Direction.LEFT;
            case LEFT -> Direction.RIGHT;
            default -> Direction.NO_DIRECTION;
        };
    }
    
    protected class PlayerKeyboardListener implements KeyListener {
    
        @Override
        public void keyTyped(KeyEvent e) {
            // No implementation
        }
    
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            
            Direction newDirection = Direction.NO_DIRECTION;
            
            if (isButtonUpEvent(keyCode)) {
                newDirection = Direction.UP;
            }
            else if (isButtonDownEvent(keyCode)) {
                newDirection = Direction.DOWN;
            }
            else if (isButtonLeftEvent(keyCode)) {
                newDirection = Direction.LEFT;
            }
            else if (isButtonRightEvent(keyCode)) {
                newDirection = Direction.RIGHT;
            }
            
            changeCurrentDirectionTo(newDirection);
        }
        
        private boolean isButtonUpEvent(int keyCode) {
            return keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W;
        }
        
        private boolean isButtonDownEvent(int keyCode) {
            return keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S;
        }
        
        private boolean isButtonLeftEvent(int keyCode) {
            return keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A;
        }
        
        private boolean isButtonRightEvent(int keyCode) {
            return keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D;
        }
    
        @Override
        public void keyReleased(KeyEvent e) {
            // No implementation
        }
    
    }
    private void proceedToEndFrame() {
        timer.stop();
        GameFrame.getGameFrameInstance().restartInstance();
        new EndGame(snake.getEatenApples());
    }
}