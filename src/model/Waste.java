package model;

import javafx.scene.canvas.GraphicsContext;
import lib.AudioUtility;
import lib.DrawingUtility;
import lib.IRenderableObject;

public class Waste extends TargetObject implements IRenderableObject {

	public Waste() {
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
		DrawingUtility.drawObject(gc, x, y, "waste");
	}
	
	public void crash(Drunkard player) {
		if (isDestroyed)
			return;
		if (this.isSamePosition(player)) {
			AudioUtility.playSound("crash");
			isDestroyed = true;
			player.setDead(true);
			return;
		}
	}
	
}
