import java.awt.event.KeyEvent;

public class Player extends Character implements GameInfo{
	private int speed = 4;
	private int xDir = 0;
	private int yDir = 0;
	
	public Player(String fName){
		name = fName;
		loadImage(fName);
	}
	
	public void move(){
		if (xDir != 0 && yDir != 0)
			changeLocation(xDir*3, yDir*3);
		else
			changeLocation(xDir*speed, yDir*speed);
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();		
		
		if (key == KeyEvent.VK_LEFT){
			xDir = -1;
		}
		else if (key == KeyEvent.VK_RIGHT){
			xDir = 1;
		}
		else if (key == KeyEvent.VK_UP){
			yDir = -1;
		}
		else if (key == KeyEvent.VK_DOWN){
			yDir = 1;
		}		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT){
			xDir = 0;
		}
		else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
			yDir = 0;
		}
	}
}