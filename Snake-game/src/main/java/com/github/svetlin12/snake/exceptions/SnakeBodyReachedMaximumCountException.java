package com.github.svetlin12.snake.exceptions;

public class SnakeBodyReachedMaximumCountException extends Exception {
	public SnakeBodyReachedMaximumCountException(String message) {
		super(message);
	}
	
	public SnakeBodyReachedMaximumCountException(String message, Throwable cause) {
		super(message, cause);
	}
}
