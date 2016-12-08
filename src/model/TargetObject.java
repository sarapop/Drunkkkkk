package model;

import lib.RandomUtility;
import lib.IRenderableObject;
import lib.MotionUtility;

public abstract class TargetObject implements IRenderableObject {

	public boolean isDestroyed = false;
	protected int x;
	protected int y;
	protected int z = 0;
	protected int[] movingParameter;
	protected int movingDuration;
	protected int movingDurationCounter = 0;

	public TargetObject(int z, int movingDuration) {
		this.z = z;
		this.movingDuration = movingDuration;

		movingParameter = new int[4];
		
		if (RandomUtility.random(0, 1) == 1) {
			int a = movingParameter[0];
			int b = movingParameter[1];
			movingParameter[0] = movingParameter[2];
			movingParameter[1] = movingParameter[3];
			movingParameter[2] = a;
			movingParameter[3] = b;
		}
		x = movingParameter[0];
		y = movingParameter[1];
	}

	public void move() {
		// TODO Auto-generated method stub
		if (isDestroyed)
			return;
		if (movingDurationCounter > movingDuration) {
			isDestroyed = true;
			return;
		}

		int[] coord;
		coord = MotionUtility.linearMotion(movingParameter[0], movingParameter[1], movingParameter[2],
				movingParameter[3], movingDuration, movingDurationCounter);

		x = coord[0];
		y = coord[1];
		movingDurationCounter += 1;
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
