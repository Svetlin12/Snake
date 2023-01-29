package com.github.svetlin12.snake.components;

import com.github.svetlin12.snake.exceptions.SnakeOutOfBoundException;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

import static com.github.svetlin12.snake.utils.ScreenConstants.SCREEN_HEIGHT;
import static com.github.svetlin12.snake.utils.ScreenConstants.SCREEN_WIDTH;
import static com.github.svetlin12.snake.utils.ScreenConstants.UNIT_SIZE;

public class ScreenTile {
	
	private static final Random RANDOM_GENERATOR = new Random();
	private int x;
	private int y;
	
	protected static int generateRandomCoordinate(int boundingAxis) {
		return RANDOM_GENERATOR.nextInt(boundingAxis / UNIT_SIZE) * UNIT_SIZE;
	}
	
	public ScreenTile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(ScreenTile otherTile) {
		move(otherTile.x, otherTile.y);
	}
	
	public void move(int x, int y) {
		if (isOutsideScreen()) {
			throw new SnakeOutOfBoundException("The snake got outside of the field!");
		}
		
		this.x = x;
		this.y = y;
	}
	
	public void moveToDirection(Direction direction) {
		switch (direction) {
			case UP, DOWN -> y += direction.getScreenShift();
			case LEFT, RIGHT -> x += direction.getScreenShift();
		}
	}
	
	public boolean isOutsideScreen() {
		return x < 0 || x > SCREEN_WIDTH || y < 0 || y > SCREEN_HEIGHT;
	}
	
	public void draw(Graphics graphic, Color tileColor) {
		graphic.setColor(tileColor);
		graphic.drawRect(x, y, UNIT_SIZE, UNIT_SIZE);
		graphic.fillRect(x, y, UNIT_SIZE, UNIT_SIZE);
	}
	
	public boolean coincidesWithTile(ScreenTile otherTile) {
		return this.x == otherTile.x && this.y == otherTile.y;
	}
}
