package logic;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.KeyCode;
import lib.ConfigurableOption;
import lib.IRenderableHolder;
import lib.IRenderableObject;
import lib.InputUtility;
import lib.RandomUtility;
import main.Main;
import model.TargetObject;
import model.Waste;
import model.Drunkard;
import model.Liquor;

public class MainLogic {

	private Drunkard player;
	private List<TargetObject> onScreenObject = new ArrayList();
	private boolean game_end;
	private boolean readyToRender;
	private int nextObjectCreationDelay;

	public synchronized void onStart() {
		// TODO Auto-generated method stub
		player = new Drunkard();
		nextObjectCreationDelay = RandomUtility.random(ConfigurableOption.objectCreationMinDelay,
				ConfigurableOption.objectCreationMaxDelay);
		game_end = false;
		readyToRender = true;
	}

	public void logicUpdate() {
		// TODO Auto-generated method stub
		if (game_end)
			return;

		if (player.isDead()) {
			game_end = true;
			return;
		}

		createTarget();
		
		if (game_end) {
			Main.instance.toggleScene();
		}

		boolean triggerKey = InputUtility.getKeyTriggered(KeyCode.SPACE);
		if (triggerKey) {
			if (player.getPosition() == 0) {
				player.setPosition(1);
			} else if (player.getPosition() == 1) {
				player.setPosition(0);
			}
			
			player.setX(player.getPosition());
		}
		
		TargetObject target = null;
		target = getObject();
		if (target instanceof Liquor) {
			((Liquor) target).collect(player);
		} else if (target instanceof Waste) {
			((Waste) target).crash(player);
		}

		
		
		for (int i = onScreenObject.size() - 1; i >= 0; i--) {
			if (onScreenObject.get(i).isDestroyed) {
				onScreenObject.remove(i);
			}
		}

		for (TargetObject obj : onScreenObject) {
			obj.move();
			if (obj instanceof Liquor) {
				obj.outOfReached(player);
			}
		}

	}

	private TargetObject getObject() {
		TargetObject obj = null;
		for (TargetObject target : onScreenObject) {
			if (player.isSamePosition(target)) {
				obj = target;
			}

		}
		return obj;
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
			int targetType = RandomUtility.random(0, 1);
			if (targetType == 0) {
				onScreenObject.add(new Liquor());
			} else
				onScreenObject.add(new Waste());
		}
	}

	public synchronized void setIRenderableHolderList() {
		IRenderableHolder.getInstance().getEntities().clear();
		if (readyToRender) {
			for (TargetObject object : onScreenObject) {
				IRenderableHolder.getInstance().add((IRenderableObject) object);
			}
			IRenderableHolder.getInstance().add(player);
		}
	}

}
