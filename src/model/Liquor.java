package model;

import javafx.scene.canvas.GraphicsContext;
import lib.AudioUtility;
import lib.ConfigurableOption;
import lib.DrawingUtility;
import lib.IRenderableObject;

public class Liquor extends TargetObject implements IRenderableObject {

	public Liquor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		DrawingUtility.drawObject(gc, x, y, "liquor");
	}

	public void collect(Drunkard player) {
		if (isDestroyed)
			return;
		if (this.isSamePosition(player)) {
			AudioUtility.playSound("collect");
			isDestroyed = true;
			player.increaseScore(10);
			return;
		}
	}
	
	public void outOfReached(Drunkard player) {
		if (isDestroyed)
			return;
		if (this.y == ConfigurableOption.screenHeight) {
			AudioUtility.playSound("no");
			isDestroyed = true;
			player.setDead(true);
			return;
		}
	}
}
