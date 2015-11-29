package classes;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Keyboard.Key;

public class MainCharacter extends Character{
	public MainCharacter(RenderWindow window){
		super(window);
		setSprite("Pics/Human/Ash_Sprite.jpg", new IntRect(0, 10, 16, 26));
		Vector2i windowSize = window.getSize();
		setPosition(new Vector2f(windowSize.x/2, windowSize.y/2));
	}
	public void move(Key keyPressed){
		switch(keyPressed){
		case UP:
			break;
		case DOWN:
			break;
		case LEFT:
			break;
		case RIGHT:
			break;
		default:
			break;
		}
	}
}
