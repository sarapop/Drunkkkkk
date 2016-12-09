package model;

import javafx.scene.canvas.GraphicsContext;
import lib.ConfigurableOption;
import lib.DrawingUtility;
import lib.IRenderableObject;

public class Drunkard implements IRenderableObject {

	private int x;
	private static final int y = ConfigurableOption.screenHeight - 175;
	private int position = 0;
	private int score = 0;
	private boolean exist = true; 
	private boolean pause = false;
	
	public Drunkard() {
		// TODO Auto-generated constructor stub
		this.setX(position);
	}

	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		DrawingUtility.drawStatusBar(gc, score, pause);
		DrawingUtility.drawObject(gc, this.x, Drunkard.y, "drunkard");
	}

	public int getScore() {
		return score;
	}
 
	public void increaseScore(int score) {
		this.score += score;
	}

	@Override
	public boolean exist() {
		// TODO Auto-generated method stub
		return exist;
	}
	
	public void setExist(boolean exist) {
		this.exist = exist;
	}
	
	public boolean isSamePosition(TargetObject other) {
		if (this.position == other.position && Drunkard.y <= other.y + other.height) {
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
			case (0) : this.x = ConfigurableOption.screenWidth/8 - 65/2;
				break;
			case (1) : this.x = ConfigurableOption.screenWidth/8 - 65/2 + ConfigurableOption.screenWidth/4;
				break;
			default : this.x = ConfigurableOption.screenWidth/8 - 65/2;
				break;
		}
	}

	public boolean isPause() {
		// TODO Auto-generated method stub
		return pause;
	}

	public void setPause(boolean pause) {
		// TODO Auto-generated method stub
		this.pause = pause;
	}
}
