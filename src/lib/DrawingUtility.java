package lib;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DrawingUtility {
	
	protected static final Font standardFont = Font.font("Tahoma", FontWeight.BOLD, 30);
	protected static final Font smallFont = Font.font("Tahoma", FontWeight.MEDIUM, 9);
	protected static final Image bg = getImage("img/bg.png");
	protected static final Image overbg = getImage("img/overbg.png");
	protected static final Image startscreen = getImage("img/startscreen.jpg");
	protected static final Image drunkard = getImage("img/drunkard.png");
	protected static final Image liquor = getImage("img/liquor.png");
	protected static final Image waste = getImage("img/waste.png");

	private static Image getImage(String directory) {
		try {
			return new Image(ClassLoader.getSystemResource(directory).toString());
		} catch (Exception e) {
			return null;
		}
	}

	public static void drawObject(GraphicsContext gc, int x, int y, String name) {
		switch (name) {
			case "drunkard" : gc.drawImage(drunkard, x, y-15);
				break;
			case "liquor" : gc.drawImage(liquor, x-15, y-15);
				break;
			case "waste" : gc.drawImage(waste, x-15, y-15);
				break;
			case "startscreen" : gc.drawImage(startscreen, x, y);
		}
	}

	public static void drawStatusBar(GraphicsContext gc, int score, boolean pause) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, 800, 40);
		gc.setFont(standardFont);
		
		gc.setFill(Color.WHITE);
		gc.fillText("SCORE : " + score, 430 , 35);
	}

}
