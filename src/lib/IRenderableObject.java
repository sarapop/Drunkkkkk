package lib;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderableObject {
	public boolean isVisible();
	public void render(GraphicsContext gc);
}
