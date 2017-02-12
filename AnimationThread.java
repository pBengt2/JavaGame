import java.awt.EventQueue;
import javax.swing.JFrame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnimationThread extends JFrame implements GameInfo{
	
	public AnimationThread(){
		initUI();
	}
	
	private void initUI(){
		add(new Board());
		
		setResizable(false);
		pack();
		
		setTitle("ThreadTest");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		try(BufferedReader br = new BufferedReader(new FileReader("gameSettings.set"))) {
			String line;

			line = br.readLine();
			line = br.readLine();
			Global.size = Integer.parseInt(line);
			
			if (Global.size < 1 || Global.size > 4){
				System.exit(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		EventQueue.invokeLater(new Runnable(){
			
			@Override
			public void run(){	
				JFrame ex = new AnimationThread();
				ex.setVisible(true);
			}
		});
	}
}




























