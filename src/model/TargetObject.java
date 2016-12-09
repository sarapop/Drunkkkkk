package model;

import lib.RandomUtility;
import lib.ConfigurableOption;
import lib.IRenderableObject;
import lib.MotionUtility;

public abstract class TargetObject implements IRenderableObject {

	public boolean isDestroyed = false;
	protected int x;
	protected int y;
	protected int[] movingParameter;

	public TargetObject() {

		movingParameter = new int[3];
		
		if (RandomUtility.random(0, 1) == 1) {
			int a = movingParameter[1];
			movingParameter[1] = movingParameter[2];
			movingParameter[2] = a;
		}
		x = movingParameter[0];
		y = movingParameter[1];
	}

	public void move() {
		// TODO Auto-generated method stub
		if (isDestroyed)
			return;
		if (y > ConfigurableOption.screenHeight) {
			isDestroyed = true;
			return;
		}

		int[] coord;
		coord = MotionUtility.linearMotion(movingParameter[0], movingParameter[1], movingParameter[2],
				ConfigurableOption.screenHeight, y);

		x = coord[0];
		y = coord[1];
		y += 1;
	}

	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return Math.hypot(x - this.x, y - this.y) <= 6;
	}

	public boolean isVisible() {
		return !isDestroyed;
	}

}
