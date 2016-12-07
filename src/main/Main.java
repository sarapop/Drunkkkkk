package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.GameManager;
import ui.GameOverScreen;
import ui.GameScreen;
import ui.StartScreen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.GameManager;
import ui.GameOverScreen;
import ui.GameScreen;
import ui.StartScreen;
import javafx.stage.WindowEvent;
import javafx.event.EventHandler;

public class Main extends Application {
	private Stage primaryStage;
	private Scene startScene;
	private Scene overScene;
	private Scene gameScene;
	private GameManager gameManage;
	private GameScreen gameScreen;
	private GameOverScreen overScreen;
	private StartScreen startScreen;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(""); //What should we name this game *^*
		this.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
	}
	public static void main(String[] args) {
		Application.launch(args);
		
	}
	
}

