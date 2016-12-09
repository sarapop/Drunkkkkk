package ui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import lib.ConfigurableOption;
import lib.DrawingUtility;
import main.Main;

public class GameOverScreen extends Pane {

private Canvas canvas;
	
	public GameOverScreen (){
		super();
		this.canvas = new Canvas(ConfigurableOption.screenWidth, ConfigurableOption.screenHeight);
		this.getChildren().add(this.canvas);
		this.paintComponenet();   
		Button button = new Button();
        button.setStyle("-fx-background-image: url('img/startbutton.png')");
        button.setPrefSize(133, 63);
        

        this.getChildren().add(button);
        button.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				Main.instance.changeSceneTo("startScene");
			}
		});
        button.setLayoutX(340);
        button.setLayoutY(410);
	}
	
	public void paintComponenet(){
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		DrawingUtility.drawObject(gc, 0, 0, "overbg");
	}

	
	public void applyResize(){
		this.canvas.setWidth(ConfigurableOption.screenWidth);
		this.canvas.setHeight(ConfigurableOption.screenHeight);
	}
}
