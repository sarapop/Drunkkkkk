package model;

import lib.RandomUtility;
import lib.ConfigurableOption;
import lib.IRenderableObject;

public abstract class TargetObject implements IRenderableObject {

	public boolean isDestroyed = false;
	protected int x;
	protected int y;

	public TargetObject() {
		int random = RandomUtility.random(-1, 1);
		switch (random) {
		case (-1) : this.x = ConfigurableOption.screenWidth/4 - 65;
			break;
		case (1) : this.x = ConfigurableOption.screenWidth/4 - 65 + ConfigurableOption.screenWidth/2;
			break;
		}
		y = 0;
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

	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return Math.hypot(x - this.x, y - this.y) <= 6;
	}

	public boolean isSamePosition(Drunkard other) {
		if (this.x == other.getX() && this.y == other.getY()) {
			return true;
		} else {
			return false;
		}
	}

}
