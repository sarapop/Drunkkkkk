package model;

import lib.ConfigurableOption;
import lib.IRenderableObject;
import lib.RandomUtility;

public abstract class TargetObject implements IRenderableObject {

	public boolean isDestroyed = false;
	protected int x;
	protected int y;
	protected int h;
	protected int w;
	protected int position;

	public TargetObject() {
		y = 0;
		position = RandomUtility.random(0, 1);
		switch (position) {
		case (0) : this.x = ConfigurableOption.screenWidth/8 - this.w/2;
			break;
		case (1) : this.x = ConfigurableOption.screenWidth/8 - this.w/2 + ConfigurableOption.screenWidth/4;
			break;
		}
	}
	
	public int getPosition() {
		return position;
	}

	public void move() {
		// TODO Auto-generated method stub
		if (isDestroyed)
			return;
		if (y > ConfigurableOption.screenHeight) {
			isDestroyed = true;
			return;
		} else {
			y++;
		}

	}
	
	public void outOfReached(Drunkard player) {
		if (isDestroyed)
			return;
		if (this.y + this.h == ConfigurableOption.screenHeight) {
			//AudioUtility.playSound("no");
			isDestroyed = true;
			player.setDead(true);
			return;
		}
	}

}
