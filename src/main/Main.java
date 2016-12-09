package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ui.GameOverScreen;
import ui.GameScreen;
import ui.StartScreen;
import javafx.stage.WindowEvent;
import lib.GameloopUtility;
import logic.MainLogic;
import javafx.event.EventHandler;

public class Main extends Application {
	
	public static Main instance;
	private Stage primaryStage;
	private Scene startScene;
	private Scene overScene;
	private Scene gameScene;
	private GameScreen gameScreen;
	private GameOverScreen overScreen;
	private StartScreen startScreen;
	private MainLogic gameLogic;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		instance = this;
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Let's Get Drunk");
		//this.primaryStage.getIcons().add(new Image(ClassLoader.getSystemResource("img/icon.png").toString()));
		this.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		this.gameLogic = new MainLogic();
		
		this.startScreen = new StartScreen();
		this.startScene = new Scene(startScreen);
		
		this.gameScreen = new GameScreen(gameLogic);
		this.gameScene = new Scene(gameScreen);
		
		this.overScreen = new GameOverScreen();
		this.overScene = new Scene(overScreen);
		gameScreen.requestFocusForCanvas();
		this.primaryStage.setScene(this.startScene);
		this.resizeStage();
		this.primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public synchronized void changeSceneTo(String scene) {
		if (scene == "gameScene") {
			this.gameLogic.onStart();
			GameloopUtility.runGameLoop(gameLogic);
			this.primaryStage.setScene(gameScene);
			System.out.println("To Game Screen");
		} else if (scene == "overScene") {
			this.gameLogic.onExit();
			this.primaryStage.setScene(overScene);
			System.out.println("To Over Screen");
		} else if (scene == "startScene") {
			this.primaryStage.setScene(startScene);
			System.out.println("To Start Screen");
		}
	}
	
	public void resizeStage() {
		this.startScreen.applyResize();
		this.gameScreen.applyResize();
		this.overScreen.applyResize();
		this.primaryStage.sizeToScene();
	}
	
	public void drawGameScreen() {
		this.gameScreen.paintComponenet();
	}
	
	public void drawOverScreen() {
		this.overScreen.paintComponenet();
	}
}

