package model;

import javafx.scene.canvas.GraphicsContext;
import lib.AudioUtility;
import lib.DrawingUtility;
import lib.IRenderableObject;

public class Waste extends TargetObject implements IRenderableObject {

	public Waste() {
		super();
		// TODO Auto-generated constructor stub
		this.w = 78;
		this.h = 25;
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
		if (player.isSamePosition(this)) {
			//AudioUtility.playSound("crash");
			isDestroyed = true;
			player.setDead(true);
			return;
		}
	}
	
}
