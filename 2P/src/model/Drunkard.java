package model;

import javafx.scene.canvas.GraphicsContext;
import lib.GameProperties;
import lib.DrawingUtility;
import lib.IRenderableObject;

public class Drunkard implements IRenderableObject {

	private int x;
	private int width = 65;
	private int height = 175;
	private int y;
	private int position;
	private int score = 0;
	private boolean exist = true; 
	private boolean pause = false;
	
	public Drunkard(int position) {
		// TODO Auto-generated constructor stub
		this.setX(position);
		this.y = GameProperties.screenHeight - this.height;
		this.setPosition(position);
	}

	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		DrawingUtility.drawStatus(gc, score, pause, this);
		DrawingUtility.drawObject(gc, this.x, this.y, "drunkard");
		
		if (!this.exist) {
			DrawingUtility.drawScore(gc, this.getScore());
		}
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
		if (this.position == other.position && this.y <= other.y + other.height) {
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
			case (0) : this.x = GameProperties.screenWidth/8 - this.width/2;
				break;
			case (1) : this.x = GameProperties.screenWidth/8 - this.width/2 + GameProperties.screenWidth/4;
				break;
			case (2) : this.x = GameProperties.screenWidth/8 - this.width/2 + GameProperties.screenWidth/2;
				break;
			case (3) : this.x = GameProperties.screenWidth/8 - this.width/2 + GameProperties.screenWidth/4 + GameProperties.screenWidth/2;
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
	
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}
}
