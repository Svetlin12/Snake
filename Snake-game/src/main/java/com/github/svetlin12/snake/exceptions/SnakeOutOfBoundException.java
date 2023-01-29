package com.github.svetlin12.snake.exceptions;

public class SnakeOutOfBoundException extends RuntimeException {
	public SnakeOutOfBoundException(String message) {
		super(message);
	}
	
	public SnakeOutOfBoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
