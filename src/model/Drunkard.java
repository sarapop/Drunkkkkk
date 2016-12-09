package model;

import javafx.scene.canvas.GraphicsContext;
import lib.ConfigurableOption;
import lib.DrawingUtility;
import lib.IRenderableObject;

public class Drunkard implements IRenderableObject {

	private int x,y;
	private int position = -1;
	private int score = 0;
	private boolean dead = false; 
	
	public Drunkard() {
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		DrawingUtility.drawStatusBar(gc, score);
		DrawingUtility.drawObject(gc, ConfigurableOption.screenWidth/4 - 65, ConfigurableOption.screenHeight - 175, "drunkard");
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
	
	public void setX(int position) {
		switch (position) {
			case (-1) : this.x = ConfigurableOption.screenWidth/4 - 65;
				break;
			case (1) : this.x = ConfigurableOption.screenWidth/4 - 65 + ConfigurableOption.screenWidth/2;
				break;
			default : this.x = ConfigurableOption.screenWidth/4 - 65;
				break;
		}
	}
}
