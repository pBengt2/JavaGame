import java.awt.Image;
import javax.swing.ImageIcon;

public class Character implements GameInfo{	
	private int x;
	private int y;
	
	private int width = DEFAULT_WIDTH;
	private int height = DEFAULT_HEIGHT;
	private Image charImage;
	String name;
	
	public Character(){
		
	}
	
	public Character(String fName){
		name = fName;
		loadImage(fName);
	}
	
	public void loadImage(String fName){
		ImageIcon ii = new ImageIcon(fName + ".png");
		charImage = ii.getImage();
		if (Global.size != 1)
			charImage = charImage.getScaledInstance(width * Global.size, height * Global.size, Image.SCALE_DEFAULT);			
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
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
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