package lib;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Drunkard;

public class DrawingUtility {

	protected static final Font font = Font.font("Tahoma", FontWeight.BOLD, 30);
	protected static final Image bg = getImage("img/bg.jpg");
	protected static final Image overbg = getImage("img/overbg.png");
	protected static final Image startscreen = getImage("img/startscreen.jpg");
	protected static final Image drunkard = getImage("img/drunkard.gif");
	protected static final Image liquor = getImage("img/liquor.png");
	protected static final Image waste = getImage("img/waste.png");
	protected static final Image resume = getImage("img/resume.png");

	private static Image getImage(String directory) {
		try {
			return new Image(ClassLoader.getSystemResource(directory).toString());
		} catch (Exception e) {
			return null;
		}
	}

	public static void drawObject(GraphicsContext gc, double x, double y, String name) {
		switch (name) {
		case "drunkard":
			gc.drawImage(drunkard, x, y);
			break;
		case "liquor":
			gc.drawImage(liquor, x, y);
			break;
		case "waste":
			gc.drawImage(waste, x, y);
			break;
		case "startscreen":
			gc.drawImage(startscreen, x, y);
			break;
		case "bg":
			gc.drawImage(bg, x, y);
			break;
		case "overbg":
			gc.drawImage(overbg, x, y);
			break;
		}
	}

	public static void drawStatus(GraphicsContext gc, int score, boolean pause, Drunkard drunkard) {
		gc.setFont(font);
		gc.setFill(Color.WHITE);
		if (drunkard.getPosition() == 0 || drunkard.getPosition() == 1) {
			gc.fillText("" + score, GameProperties.screenWidth/8, font.getSize()*1.5);
		} else if (drunkard.getPosition() == 2 || drunkard.getPosition() == 3) {
			gc.fillText("" + score, GameProperties.screenWidth/8 - drunkard.getWidth()/2 + GameProperties.screenWidth/4 + GameProperties.screenWidth/2, font.getSize()*1.5);
		}
		
		if (pause) {
			// gc.drawImage(resume, GameProperties.GameScreenWidth/2 -
			// resume.getWidth()/2, GameProperties.screenHeight/2 -
			// resume.getHeight()/2);
		}
	}

	public static void drawScore(GraphicsContext gc, int score) {
		gc.setFont(font);
		gc.setFill(Color.WHITE);
		gc.fillText("" + score, 10, 35);
	}

}
