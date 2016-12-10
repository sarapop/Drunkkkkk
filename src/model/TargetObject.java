package model;

import lib.AudioUtility;
import lib.GameProperties;
import lib.IRenderableObject;
import lib.RandomUtility;

public abstract class TargetObject implements IRenderableObject {

	public boolean exist = true;
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	protected int position;

	public TargetObject() {
		y = 0;
	}
	
	public void initializeX(int width) {
		position = RandomUtility.random(0, 1);
		switch (position) {
			case (0) : this.x = GameProperties.GameScreenWidth/4 - width/2;
				break;
			case (1) : this.x = GameProperties.GameScreenWidth/4 - width/2 + GameProperties.GameScreenWidth/2;
				break;
		}
	}
	
	public int getPosition() {
		return position;
	}

	public void move() {
		// TODO Auto-generated method stub
		if (!exist)
			return;
		if (y > GameProperties.screenHeight) {
			exist = false;
			return;
		} else {
			y += 3;
		}

	}
	
	public void outOfReached(Drunkard player) {
		if (!exist)
			return;
		if (this.y + this.height == GameProperties.screenHeight) {
			AudioUtility.playSound("no");
			exist = false;
			player.setExist(false);
			return;
		}
	}
	
	public boolean exist() {
		return exist;
	}

}
