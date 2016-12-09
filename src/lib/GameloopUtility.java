package lib;

import javafx.animation.AnimationTimer;
import logic.MainLogic;
import main.Main;

public class GameloopUtility {
	
	public static final int TICK_PER_SECONDS = 60;
	public static AnimationTimer animationTimer;

	public static void runGameLoop(MainLogic gameLogic) {
		// TODO Auto-generated method stub
		 
		 animationTimer = new AnimationTimer() {
			 public void handle(long now) {
				 try {
					 Main.instance.drawGameScreen();
					 gameLogic.logicUpdate();
					 InputUtility.postUpdate();
				 } catch (Exception e) {
					 e.printStackTrace();
					 GameloopUtility.animationTimer.stop();
				 }
		 	}
		 };
		 animationTimer.start();
	}

}
