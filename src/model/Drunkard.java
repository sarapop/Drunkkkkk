package model;

import javafx.scene.canvas.GraphicsContext;
import lib.DrawingUtility;
import lib.IRenderableObject;

public class Drunkard implements IRenderableObject {

	private int score = 0;
	private boolean pause = false;
	private boolean dead = false; 
	
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		DrawingUtility.drawStatusBar(gc, score, pause);
	}

	public boolean isPause() {
		// TODO Auto-generated method stub
		return pause;
	}

	public void setPause(boolean pause) {
		// TODO Auto-generated method stub
		this.pause = pause;
	}
	
	public int getScore() {
		return score;
	}
 
	public void increaseScore(int score) {
		this.score += score;
	}

	public boolean isDead() {
		// TODO Auto-generated method stub
		return dead;
	}
	
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
}
