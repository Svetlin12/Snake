package com.github.svetlin12.snake.utils;

import javax.swing.*;
import java.awt.*;

public class FrameConigUtil {
	private FrameConigUtil() {
	}
	
	public static void setFrameSettings(JFrame frame) {
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void attachComponentsToFrame(JFrame frame, Component... components) {
		for (Component component : components) {
			frame.add(component);
		}
	}
}
