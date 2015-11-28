import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard.Key;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.Event.Type;
import org.jsfml.window.event.KeyEvent;


public class MainProgram {

	public static void main(String[] args) {
		
		RenderWindow window = new RenderWindow(new VideoMode(800, 600), "Hello");
		
		window.setFramerateLimit(30);
		
		Texture t = new Texture();
		try{
			t.loadFromFile(Paths.get("Pics/Ash_Sprite.jpg"), new IntRect(0, 10, 16, 26));
			System.out.println(t.getSize().x+" "+t.getSize().y);
			t.setSmooth(true);
		}catch(IOException ioex){
			System.out.println(ioex.getMessage());
		}
		
		Sprite s = new Sprite(t);
		s.setPosition(0, 0);
		s.setScale(3.5f, 3.5f);
		
		while(window.isOpen()){
			for(Event e:window.pollEvents()){
				if(e.type == Event.Type.CLOSED){
					window.close();
				}
				if(e.type == Event.Type.KEY_PRESSED){
					KeyEvent key = e.asKeyEvent();
					if(key.key == Key.ESCAPE){
						window.close();
					}
						
				}
				window.clear();
				window.draw(s);
				window.display();
			}
		}
	}

}
