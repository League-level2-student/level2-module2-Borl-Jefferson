import javax.swing.JFrame;
import javax.swing.JPanel;

public class Runner {
	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;
		
public static void main(String[] args) {
JFrame jeff = new JFrame();
	JPanel jepp = new JPanel();
	LeagueInvaders li = new LeagueInvaders();
	jeff.add(jepp);
	jeff.pack();
	setup(jeff);
	
}
public static void setup(JFrame fm) {
	GamePanel gp = new GamePanel();
	
	fm.setVisible(true);
	fm.setSize(WIDTH, HEIGHT);
	fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
