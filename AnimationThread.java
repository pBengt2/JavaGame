import java.awt.EventQueue;
import javax.swing.JFrame;

public class AnimationThread extends JFrame{
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
		EventQueue.invokeLater(new Runnable(){
			
			@Override
			public void run(){
				JFrame ex = new AnimationThread();
				ex.setVisible(true);
			}
		});
	}
}




























