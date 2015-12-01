package classes;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;

public class Game {
	private RenderWindow gameWindow;
	private MainCharacter player;
	//temporary variables
	boolean mDown;
	boolean mUp;
	boolean mRight;
	boolean mLeft;
	//temporary variables
	public Game(){
		gameWindow = new RenderWindow(new VideoMode(640, 480), "Pokemon Fantasy");
		//gameWindow.setFramerateLimit(30);
		player = new MainCharacter(gameWindow);
	}
	public void run(){
		while(gameWindow.isOpen()){
			processEvents();
			updateScene();
			renderScene();
		}
	}
	private void processEvents(){
		for(Event event:gameWindow.pollEvents()){
			switch(event.type){
			case CLOSED:
				gameWindow.close();
				break;
			case KEY_PRESSED:
				handleUserInput(event.asKeyEvent(), true);
				break;
			case KEY_RELEASED:
				handleUserInput(event.asKeyEvent(), false);
				break;
			default:
				break;
			}
		}
	}
	private void handleUserInput(KeyEvent keyEvent, boolean isPressed){
		switch(keyEvent.key){
		case UP:
			mUp = isPressed;
			break;
		case DOWN:
			mDown = isPressed;
			break;
		case LEFT:
			mLeft = isPressed;
			break;
		case RIGHT:
			mRight = isPressed;
			break;
		default:
			break;
		}
	}
	private void updateScene(){
		Vector2f movement=new Vector2f(0, 0);
		if(mUp){
			movement = new Vector2f(0.0f, -1.0f);
		}
		if(mDown){
			movement = new Vector2f(0.0f, 1.0f);
		}
		if(mRight){
			movement = new Vector2f(1.0f, 0.0f);
		}
		if(mLeft){
			movement = new Vector2f(-1.0f, 0.0f);
		}
		player.move(movement);
	}
	private void renderScene(){
		gameWindow.clear();
		player.draw();
		gameWindow.display();
	}
}
