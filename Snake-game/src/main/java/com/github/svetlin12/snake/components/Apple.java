package com.github.svetlin12.snake.components;

import java.awt.Graphics;
import java.awt.Color;

import static com.github.svetlin12.snake.utils.ScreenConstants.SCREEN_HEIGHT;
import static com.github.svetlin12.snake.utils.ScreenConstants.SCREEN_WIDTH;

public class Apple extends ScreenTile {
	
	public Apple() {
		super(generateRandomCoordinate(SCREEN_WIDTH), generateRandomCoordinate(SCREEN_HEIGHT));
	}
	
	public void draw(Graphics graphic) {
		super.draw(graphic, Color.RED);
	}
}
