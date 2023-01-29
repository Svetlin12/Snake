package com.github.svetlin12.snake.components;

import com.github.svetlin12.snake.exceptions.SnakeBodyReachedMaximumCountException;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import static com.github.svetlin12.snake.components.ScreenTile.generateRandomCoordinate;
import static com.github.svetlin12.snake.utils.ScreenConstants.SCREEN_HEIGHT;
import static com.github.svetlin12.snake.utils.ScreenConstants.SCREEN_WIDTH;
import static com.github.svetlin12.snake.utils.ScreenConstants.UNIT_SIZE;


public class Snake {
	
	private static final Color SNAKE_HEAD_COLOR = new Color(71, 102, 27);
	private static final Color SNAKE_BODY_COLOR = new Color(146, 214, 51);
	private static final int MAX_SNAKE_BODY_SIZE = (SCREEN_HEIGHT / UNIT_SIZE) * (SCREEN_WIDTH / UNIT_SIZE);
	private static final int DEFAULT_SNAKE_BODY_SIZE = 4;
	
	private final Deque<ScreenTile> snakeBody;
	private final ScreenTile snakeHead;
	
	public Snake() {
		this.snakeBody = new LinkedList<>();
		for (int i = 0; i < DEFAULT_SNAKE_BODY_SIZE; i++) {
			snakeBody.add(new ScreenTile(0, 0));
		}
		this.snakeHead = new ScreenTile(generateRandomCoordinate(SCREEN_WIDTH), generateRandomCoordinate(SCREEN_HEIGHT));
	}
	
	public void draw(Graphics graphic) {
		snakeHead.draw(graphic, SNAKE_HEAD_COLOR);
		
		for (ScreenTile snakeBodyPart : snakeBody) {
			snakeBodyPart.draw(graphic, SNAKE_BODY_COLOR);
		}
	}
	
	public boolean isHeadAtApple(Apple apple) {
		return snakeHead.coincidesWithTile(apple);
	}
	
	public boolean isSnakeOutsidePlayingField() {
		return snakeHead.isOutsideScreen();
	}
	
	public boolean hasSnakeCollidedWithOwnBody() {
		for (ScreenTile snakeBodyPart : snakeBody) {
			if (snakeHead.coincidesWithTile(snakeBodyPart)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void move(Direction direction) {
		ScreenTile previousBodyPart = null;
		for (Iterator<ScreenTile> it = snakeBody.descendingIterator(); it.hasNext();) {
			ScreenTile currentBodyPart = it.next();
			
			if (previousBodyPart != null) {
				previousBodyPart.move(currentBodyPart);
			}
			
			previousBodyPart = currentBodyPart;
		}
		
		previousBodyPart.move(snakeHead); // move the front body part to the head's position
		
		snakeHead.moveToDirection(direction);
	}
	
	public void addToBody(ScreenTile newBodyPart) throws SnakeBodyReachedMaximumCountException {
		if (length() == MAX_SNAKE_BODY_SIZE) {
			throw new SnakeBodyReachedMaximumCountException("The Snake's body reached it's maximum size!");
		}
		
		snakeBody.addLast(newBodyPart);
	}
	
	public int length() {
		return snakeBody.size() + 1;
	}
	
	public int getEatenApples() {
		return length() - 1 - DEFAULT_SNAKE_BODY_SIZE;
	}
}
