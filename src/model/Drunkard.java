package model;

import javafx.scene.canvas.GraphicsContext;
import lib.DrawingUtility;
import lib.IRenderableObject;

public class Drunkard implements IRenderableObject {

	private int x,y;
	private int position = -1;
	private int score = 0;
	private boolean pause = false;
	private boolean dead = false; 
	
	public Drunkard(int x, int y, int position) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.position = position;
	}
	
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
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
	
	public boolean isSamePosition(TargetObject other) {
		if (this.x == other.x && this.y == other.y) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
}
