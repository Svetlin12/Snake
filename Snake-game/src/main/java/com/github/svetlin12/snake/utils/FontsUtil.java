package com.github.svetlin12.snake.utils;

import java.awt.Font;

public class FontsUtil {
	
	private static final int SMALL_FONT_SIZE = 30;
	private static final int LARGE_FONT_SIZE = 70;
	
	private Font smallFont;
	private Font largeFont;
	private final String fontName;
	private final int fontStyle;
	
	public FontsUtil(String fontName, int fontStyle) {
		this.fontName = fontName;
		this.fontStyle = fontStyle;
		initFonts();
	}
	
	private void initFonts() {
		smallFont = new Font(fontName, fontStyle, SMALL_FONT_SIZE);
		largeFont = new Font(fontName, fontStyle, LARGE_FONT_SIZE);
	}
	
	public Font getSmallFont() {
		return smallFont;
	}
	
	public Font getLargeFont() {
		return largeFont;
	}
}
