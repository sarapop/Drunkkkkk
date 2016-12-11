package ui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import lib.DrawingUtility;
import lib.GameProperties;
import main.Main;

public class TutorialScreen extends Pane {
	
	private Canvas canvas;

	public TutorialScreen() {
		super();
		// TODO Auto-generated constructor stub
		this.canvas = new Canvas(GameProperties.screenWidth, GameProperties.screenHeight);
		this.getChildren().add(this.canvas);
		this.paintComponenet();   
		Button button = new Button();
        button.setStyle("-fx-background-image: url('img/startbutton.jpg')");
        button.setPrefSize(133, 63);
        

        this.getChildren().add(button);
        button.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				Main.instance.changeSceneTo("gameScene");;
			}
		});
        button.setLayoutX(GameProperties.screenWidth/2 - 133/2);
        button.setLayoutY(525);
	}

	public void applyResize() {
		// TODO Auto-generated method stub
		this.canvas.setWidth(GameProperties.screenWidth);
		this.canvas.setHeight(GameProperties.screenHeight);
	}

	public void paintComponenet() {
		// TODO Auto-generated method stub
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		DrawingUtility.drawObject(gc, 0, 0, "tutorialscreen");
	}

}
