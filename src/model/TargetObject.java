package model;

import lib.ConfigurableOption;
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
		position = RandomUtility.random(0, 1);
		switch (position) {
		case (0) : this.x = ConfigurableOption.screenWidth/8 - this.width/2;
			break;
		case (1) : this.x = ConfigurableOption.screenWidth/8 - this.width/2 + ConfigurableOption.screenWidth/4;
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
		if (y > ConfigurableOption.screenHeight) {
			exist = false;
			return;
		} else {
			y++;
		}

	}
	
	public void outOfReached(Drunkard player) {
		if (!exist)
			return;
		if (this.y + this.height == ConfigurableOption.screenHeight) {
			//AudioUtility.playSound("no");
			exist = false;
			player.setExist(false);
			return;
		}
	}
	
	public boolean exist() {
		return exist;
	}

}
