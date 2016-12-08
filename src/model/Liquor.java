package model;

import javafx.scene.canvas.GraphicsContext;
import lib.DrawingUtility;
import lib.IRenderableObject;

public class Liquor extends TargetObject implements IRenderableObject{

	public Liquor(int z, int movingDuration) {
		super(z, movingDuration);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		DrawingUtility.drawObject(gc, x, y, "liquor");
	}

}
