package com.github.svetlin12.snake.utils;

import com.github.svetlin12.snake.listeners.OptionListener;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class LabelCreator {
	public static final Color GREEN_TEXT_COLOR = new Color(33, 128, 58);
	private static final String FONT_NAME = "Segoe Script";
	private static final int FONT_STYLE = Font.BOLD + Font.ITALIC;
	private static final FontsUtil FONTS_UTIL = new FontsUtil(FONT_NAME, FONT_STYLE);
	
	private LabelCreator() {
	}
	
	public static JLabel createLargeLabelWith(String text) {
		return createLabelWith(text, FONTS_UTIL.getLargeFont(), null);
	}
	
	public static JLabel createLargeLabelWith(String text, OptionListener listener) {
		return createLabelWith(text, FONTS_UTIL.getLargeFont(), listener);
	}
	
	public static JLabel createSmallLabelWith(String text) {
		return createLabelWith(text, FONTS_UTIL.getSmallFont(), null);
	}
	
	public static JLabel createSmallLabelWith(String text, OptionListener listener) {
		return createLabelWith(text, FONTS_UTIL.getSmallFont(), listener);
	}
	
	private static JLabel createLabelWith(String text, Font font, OptionListener listener) {
		JLabel label = new JLabel(text);
		label.setFont(font);
		label.setForeground(GREEN_TEXT_COLOR);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		configureListener(listener, label);
		label.addMouseListener(listener);
		return label;
	}
	
	private static void configureListener(OptionListener listener, JLabel listenedComponent) {
		if (listener == null) {
			return;
		}
		
		listener.setTextColor(GREEN_TEXT_COLOR);
		listener.setTargetComponent(listenedComponent);
	}
}
