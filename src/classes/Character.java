package classes;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

public abstract class Character {
	private Sprite characterSprite;
	private Texture characterTexture;
	private Vector2f characterPosition;
	private final RenderWindow window;
	private MovingBehavior movingBehavior;
	
	public Character(RenderWindow gameWindow) {
		window = gameWindow;
	}

	public void setSprite(String texturePath, IntRect textureRectangle) {
		try {
			characterTexture = new Texture();
			characterTexture.loadFromFile(Paths.get(texturePath));
			characterSprite = new Sprite(characterTexture);
			characterSprite.setTextureRect(textureRectangle);
		} catch (IOException exception) {
			System.out
					.println("Failed to load from file, please check if the file path is correct");
		}
	}

	public Sprite getSprite() {
		return characterSprite;
	}

	public void setPosition(Vector2f pos) {
		characterPosition = pos;
		characterSprite.setPosition(pos);
	}
	public void move(Vector2f displacement){
		characterSprite.move(displacement);
	}

	public Vector2f getPosition() {
		return characterPosition;
	}

	public RenderWindow getWindow() {
		return window;
	}
	
	public void setMovingBehavior(MovingBehavior mBehavior){
		movingBehavior = mBehavior;
	}
	
	public MovingBehavior getMovingBehavior(){
		return movingBehavior;
	}
	
	public void draw(){
		window.draw(this.characterSprite);
	}
	public void setScale(float width, float height){
		characterSprite.setScale(width, height);
	}
}
