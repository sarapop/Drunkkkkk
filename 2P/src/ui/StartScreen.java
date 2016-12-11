package ui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lib.GameProperties;
import lib.DrawingUtility;
import main.Main;

public class StartScreen extends Pane {
	
	private Canvas canvas;

	public StartScreen() {
		super();
		// TODO Auto-generated constructor stub
		this.canvas = new Canvas(GameProperties.screenWidth, GameProperties.screenHeight);
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
				Main.instance.changeSceneTo("gameScene");;
			}
		});
        button.setLayoutX(340);
        button.setLayoutY(410);
        
        Text owner = new Text("created and developed by PoP & McDonan");
        owner.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 10));
        owner.setLayoutX(300);
        owner.setLayoutY(525);
        this.getChildren().add(owner);
	}

	public void applyResize() {
		// TODO Auto-generated method stub
		this.canvas.setWidth(GameProperties.screenWidth);
		this.canvas.setHeight(GameProperties.screenHeight);
	}

	public void paintComponenet() {
		// TODO Auto-generated method stub
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		DrawingUtility.drawObject(gc, 0, 0, "startscreen");
	}

}
