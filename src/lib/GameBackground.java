package lib;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class GameBackground implements IRenderableObject {

	private Image bgImage = null;
	private int currentY = 0;
	private int imageHeight;

	public GameBackground() {
		bgImage = DrawingUtility.bg;
		if (bgImage != null)
			imageHeight = (int) bgImage.getHeight();
		else
			imageHeight = 0;

	}

	public void updateBackground() {
		currentY++;
		if (currentY >= imageHeight)
			currentY = 0;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void render(GraphicsContext gc) {
		if (bgImage == null)
			return;
		int currentDrawingX = 0;
		int currentDrawingY = 0;

		while (currentDrawingX < ConfigurableOption.screenWidth) {
			WritableImage croppedImage = new WritableImage(bgImage.getPixelReader(), currentY, 0, imageHeight - currentY,
					(int) bgImage.getWidth());
			gc.drawImage(croppedImage, currentDrawingX, currentDrawingY);
			currentDrawingX += bgImage.getWidth();
		}
		currentDrawingY += imageHeight - currentY;
		currentDrawingX = 0;

		while (currentDrawingY < ConfigurableOption.screenHeight) {
			while (currentDrawingX < ConfigurableOption.screenWidth) {
				gc.drawImage(bgImage, currentDrawingX, currentDrawingY);
				currentDrawingX += bgImage.getWidth();
			}
			currentDrawingY += imageHeight;
			currentDrawingX = 0;
		}
	}

}
