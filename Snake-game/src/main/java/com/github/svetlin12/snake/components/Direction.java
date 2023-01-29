package com.github.svetlin12.snake.components;

import static com.github.svetlin12.snake.utils.ScreenConstants.UNIT_SIZE;

public enum Direction {
	UP(-UNIT_SIZE), DOWN(UNIT_SIZE), LEFT(-UNIT_SIZE), RIGHT(UNIT_SIZE);
	
	private final int screenShift;
	
	Direction(int screenShift) {
		this.screenShift = screenShift;
	}
	
	public int getScreenShift() {
		return screenShift;
	}
}
