import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable{
	private int bWidth = 640;
	private int bHeight = 360;
	private int initX = 40;	
	private int initY = 40;	
	private int DELAY = 25;
	
	private int sizeScalar = 1;
	private Image testImage;
	private Thread animator;
	private Character testChar;
	
	public Board() {
		initBoard();
	}
	
	public Board(int size){
		sizeScalar = size;
		initBoard();
	}
	
	private void initBoard(){
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(bWidth*sizeScalar, bHeight*sizeScalar));
		setDoubleBuffered(true);
		
		testChar = new Character("testCharacter.png");
		testChar.setLocation(initX*sizeScalar, initY*sizeScalar);
	}
	
	@Override
	public void addNotify(){
		super.addNotify();
		
		animator = new Thread(this);
		animator.start();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		drawCharacters(g);
	}	
	
	private void drawCharacters(Graphics g){
		g.drawImage(testChar.getImage(), testChar.getX(), testChar.getY(), this);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void cycle(){
		testChar.changeLocation(1 *sizeScalar, 1 *sizeScalar);
		
		if (testChar.getY() > bHeight)
			testChar.setLocation(initY, initX);
	}
	
	@Override
	public void run(){
		long beforeTime, timeDiff, sleep;
		
		beforeTime = System.currentTimeMillis();
		
		while (true){
			cycle();
			repaint();
			
			timeDiff = System.currentTimeMillis()-beforeTime;
			sleep = DELAY - timeDiff;
			
			if (sleep < 0){
				sleep = 2;
			}
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e){
				System.out.println("Interrupted: " + e.getMessage());
			}
			
			beforeTime = System.currentTimeMillis();
		}
	}
}

















