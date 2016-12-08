package ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import lib.ConfigurableOption;

public class GameOverScreen extends StackPane {

private Canvas canvas;
	
	public GameOverScreen (){
		super();
		this.canvas = new Canvas(ConfigurableOption.screenWidth, ConfigurableOption.screenHeight);
		this.getChildren().add(this.canvas);
	}
	
	public void paintComponenet(){
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
		gc.fillRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
	}
	
	public void requestFocusForCanvas(){
		this.requestFocus();
	}
	
	public void applyResize(){
		this.canvas.setWidth(ConfigurableOption.screenWidth);
		this.canvas.setHeight(ConfigurableOption.screenHeight);
	}
}
