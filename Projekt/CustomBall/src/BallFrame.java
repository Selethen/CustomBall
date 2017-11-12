import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class BallFrame extends JFrame {

	private BouncingBall contentPane;

	public BallFrame(int X, int Y, int radius, int velocity, int R, int G, int B) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new BouncingBall(X, Y, radius, velocity, velocity, R, G, B);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.letsBounce();
	}
}
