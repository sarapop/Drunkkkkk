package ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import lib.ConfigurableOption;
import lib.DrawingUtility;

public class StartScreen extends StackPane {
	
	private Canvas canvas;

	public StartScreen() {
		super();
		// TODO Auto-generated constructor stub
		this.canvas = new Canvas(ConfigurableOption.screenWidth, ConfigurableOption.screenHeight);
		this.getChildren().add(this.canvas);
	}

	public void applyResize() {
		// TODO Auto-generated method stub
		this.canvas.setWidth(ConfigurableOption.screenWidth);
		this.canvas.setHeight(ConfigurableOption.screenHeight);
	}

	public void paintComponenet() {
		// TODO Auto-generated method stub
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		DrawingUtility.drawObject(gc, 0, 0, "startscreen");
	}
	
	public void requestFocusForCanvas(){
		this.requestFocus();
	}

}
