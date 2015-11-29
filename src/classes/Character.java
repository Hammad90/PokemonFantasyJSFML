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
			characterTexture.loadFromFile(Paths.get(texturePath));
			characterSprite.setTexture(characterTexture);
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
	}

	public Vector2f getPosition() {
		return characterPosition;
	}

	public RenderWindow getWindow() {
		return window;
	}
	
	public void setMovingBehavior(MovingBehavior movingBehavior){
		this.movingBehavior = movingBehavior;
	}
	
	
}
