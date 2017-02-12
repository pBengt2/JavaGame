import java.awt.Image;
import javax.swing.ImageIcon;

public class Character{
	private int x;
	private int y;
	private Image charImage;
	
	
	public Character(){
		
	}
	
	public Character(String fName){
		loadImage(fName);
	}
	
	public void loadImage(String fName){
		System.out.println(fName + ": loading");
		ImageIcon ii = new ImageIcon(fName);
		charImage = ii.getImage();
	}
	
	public Image getImage(){
		return charImage;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setLocation(int xLoc, int yLoc){
		x = xLoc;
		y = yLoc;
	}
	
	public void changeLocation(int xChange, int yChange){
		x += xChange;
		y += yChange;
	}
}