package lib;

public interface IRenderable {
	public boolean isVisible();
	public int getZ();
	public void render(GraphicsContext gc);
}
