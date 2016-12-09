package logic;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.KeyCode;
import lib.ConfigurableOption;
import lib.GameAnimation;
import lib.GameBackground;
import lib.IRenderableHolder;
import lib.IRenderableObject;
import lib.InputUtility;
import lib.RandomUtility;
import model.TargetObject;
import model.Waste;
import model.Drunkard;
import model.Liquor;

public class MainLogic {

	private GameBackground background;
	private Drunkard player;
	private List<TargetObject> onScreenObject = new ArrayList();
	private List<GameAnimation> onScreenAnimation = new ArrayList();
	private boolean game_end;
	private boolean readyToRender;
	private int nextObjectCreationDelay;

	public synchronized void onStart() {
		// TODO Auto-generated method stub
		background = new GameBackground();
		nextObjectCreationDelay = RandomUtility.random(ConfigurableOption.objectCreationMinDelay,
				ConfigurableOption.objectCreationMaxDelay);
		game_end = false;
		readyToRender = true;
	}

	public void logicUpdate() {
		// TODO Auto-generated method stub
		if (game_end)
			return;
		boolean triggerKey = InputUtility.getKeyTriggered(KeyCode.ENTER);
		if (triggerKey) {
			player.setPause(!player.isPause());
		}
		if (player.isPause()) {
			return;
		}
		background.updateBackground();
		if (player.isDead()) {
			game_end = true;
			return;
		}

		createTarget();

		triggerKey = InputUtility.getKeyTriggered(KeyCode.SPACE);
		if (triggerKey) {
			player.setPosition(player.getPosition() * -1);
		}

		for (GameAnimation obj : onScreenAnimation) {
			obj.updateAnimation();
		}
		for (int i = onScreenObject.size() - 1; i >= 0; i--) {
			if (onScreenObject.get(i).isDestroyed) {
				onScreenObject.remove(i);
			}
		}
		for (int i = onScreenAnimation.size() - 1; i >= 0; i--) {
			if (!((GameAnimation) onScreenAnimation.get(i)).isVisible()) {
				onScreenAnimation.remove(i);
			}
		}
	}

	public synchronized void onExit() {
		// TODO Auto-generated method stub
		onScreenObject.clear();
		readyToRender = false;
	}

	private void createTarget() {
		if (nextObjectCreationDelay > 0) {
			nextObjectCreationDelay -= 1;
		} else {
			nextObjectCreationDelay = RandomUtility.random(ConfigurableOption.objectCreationMinDelay,
					ConfigurableOption.objectCreationMaxDelay);
		}

		int targetType = RandomUtility.random(0, 1);
		if (targetType == 0) {
				onScreenObject.add(new Liquor());
			} else
				onScreenObject.add(new Waste());
	}

	public synchronized void setIRenderableHolderList() {
		IRenderableHolder.getInstance().getEntities().clear();
		if (readyToRender) {
			for (TargetObject object : onScreenObject) {
				IRenderableHolder.getInstance().add((IRenderableObject) object);
			}
			for (GameAnimation object : onScreenAnimation) {
				IRenderableHolder.getInstance().add(object);
			}
			IRenderableHolder.getInstance().add(player);
			IRenderableHolder.getInstance().add(background);
		}
	}

}
