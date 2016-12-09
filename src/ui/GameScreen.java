package ui;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import lib.ConfigurableOption;
import lib.DrawingUtility;
import lib.IRenderableHolder;
import lib.IRenderableObject;
import lib.InputUtility;
import logic.MainLogic;

public class GameScreen extends StackPane{
	private MainLogic mainLogic;
	private Canvas canvas;
	
	public GameScreen(MainLogic mainLogic){
		super();
		this.canvas = new Canvas(ConfigurableOption.screenWidth/2, ConfigurableOption.screenHeight);
		
		this.mainLogic = mainLogic;
		this.getChildren().add(this.canvas);
		this.paintComponenet();
		addListener();
	}
	
	public void paintComponenet(){
		((MainLogic) mainLogic).setIRenderableHolderList();
		
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		DrawingUtility.drawObject(gc, 0, 0, "bg");
		for(IRenderableObject renderable : IRenderableHolder.getInstance().getEntities()){
			renderable.render(gc);
		}
	}
	
	public void requestFocusForCanvas(){
		this.requestFocus();
	}
	
	public void applyResize(){
		this.canvas.setWidth(ConfigurableOption.screenWidth/2);
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
