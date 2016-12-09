package ui;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import lib.ConfigurableOption;
import lib.IRenderableHolder;
import lib.IRenderableObject;
import lib.InputUtility;
import logic.MainLogic;

public class GameScreen extends StackPane{
	private MainLogic mainLogic;
	private Canvas canvas;
	
	public GameScreen(MainLogic mainLogic){
		super();
		this.canvas = new Canvas(ConfigurableOption.screenWidth, ConfigurableOption.screenHeight);
		
		this.mainLogic = mainLogic;
		this.getChildren().add(this.canvas);
		addListener();
	}
	
	public void paintComponenet(){
		((MainLogic) mainLogic).setIRenderableHolderList();
		
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
		gc.fillRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
		for(IRenderableObject renderable : IRenderableHolder.getInstance().getEntities()){
			renderable.render(gc);
		}
	}
	
	public void requestFocusForCanvas(){
		this.requestFocus();
	}
	
	public void applyResize(){
		this.canvas.setWidth(ConfigurableOption.screenWidth);
		this.canvas.setHeight(ConfigurableOption.screenHeight);
	}

	private void addListener() {
		
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				System.out.println("KeyPressed : " + event.getCode().toString());
				if (!InputUtility.getKeyPressed(event.getCode()))
					InputUtility.setKeyTriggered(event.getCode(), true);
				InputUtility.setKeyPressed(event.getCode(), true);
			}
		});

		this.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				System.out.println("KeyReleased : " + event.getCode().toString());
				InputUtility.setKeyPressed(event.getCode(), false);
			}
		});
	}
}
