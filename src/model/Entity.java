package model;

public abstract class Entity {
	
	protected int x,y;
	protected boolean isDestroyed;
	protected int nextX,nextY;
	protected boolean isDestroyedInNextState;
	private int movingDelay;
	private int movingDelayCounter;
	
	public Entity(int x,int y) {
		this.x = x;
		this.y = y;
		movingDelayCounter = movingDelay;

		calculateNextState();
	}
	
	public abstract void update();
	
	protected abstract void calculateNextState();
	
	protected boolean move() {
		boolean move = false;
		if (!isDestroyed) {
			if (movingDelayCounter == 0) {
				x = nextX;
				y = nextY;
				isDestroyed = isDestroyedInNextState;
				calculateNextState();
				movingDelayCounter = movingDelay;
				move = true;
			} else {
				movingDelayCounter--;
			}
		}
		return move;
	}
	
	public boolean isSamePosition(Entity other) {
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
	
	public boolean isDestroyed() {
		return isDestroyed;
	}
	
	public int getNextX() {
		return nextX;
	}
	
	public int getNextY() {
		return nextY;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
}
