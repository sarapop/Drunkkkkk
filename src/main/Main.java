package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.GameManager;
import ui.GameOverScreen;
import ui.GameScreen;
import ui.StartScreen;
import javafx.stage.WindowEvent;
import lib.GameloopUtility;
import lib.MainLogic;
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
	private boolean isGameSceneShown;
	private MainLogic gameLogic;
	
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
		
		this.gameLogic = new MainLogic();
		
		gameScreen = new GameScreen(gameLogic);
		this.gameScene = new Scene(gameScreen);
		gameScreen.requestFocusForCanvas();
		this.primaryStage.setScene(this.startScene);
		this.resizeStage();
		this.primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public synchronized void toggleScene(){
		if (!this.isGameSceneShown){
			this.gameLogic.onStart();
			GameloopUtility.runGameLoop(gameLogic);
			this.primaryStage.setScene(gameScene);
			System.out.println("To Game Screen");
		}
		this.isGameSceneShown = !this.isGameSceneShown;
	}
	
	public void resizeStage() {
		this.startScreen.applyResize();
		this.gameScreen.applyResize();
		this.overScreen.applyResize();
		this.primaryStage.sizeToScene();
	}
	
	public void drawStartScreen() {
		this.startScreen.paintComponenet();
	}
	
	public void drawGameScreen() {
		this.gameScreen.paintComponenet();
	}
	
	public void drawOverScreen() {
		this.overScreen.paintComponenet();
	}
}

