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

public class StartScreen extends Pane {
	
	private Canvas canvas;

	public StartScreen() {
		super();
		// TODO Auto-generated constructor stub
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
				Main.instance.toggleScene();
			}
		});
        button.setLayoutX(340);
        button.setLayoutY(410);
        
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
