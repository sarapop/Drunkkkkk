package model;

import lib.IRenderableObject;

public abstract class TargetObject implements IRenderableObject {

	public boolean isDestroyed = false;
	protected int x;
	protected int y;
	protected int z = 0;

	public void move() {
		// TODO Auto-generated method stub
		if (isDestroyed) return;
	}

	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return Math.hypot(x - this.x, y - this.y) <= 6;
	}

	public int getZ() {
		// TODO Auto-generated method stub
		return z;
	}
	
	public boolean isVisible() {
		return !isDestroyed;
	}

}
