import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class StartWindow {

	public JSlider sizeSlider;
	public JSlider velocitySlider;
	public JSlider rSlider;
	public JSlider gSlider;
	public JSlider bSlider;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow window = new StartWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		velocitySlider = new JSlider(JSlider.HORIZONTAL, 1, 50, 25);
		velocitySlider.setBounds(0, 40, 244, 41);
		velocitySlider.setMajorTickSpacing(5);
		velocitySlider.setPaintTicks(true);
		frame.getContentPane().add(velocitySlider);
		
		sizeSlider = new JSlider(JSlider.HORIZONTAL, 10, 100, 55);
		sizeSlider.setBounds(0, 120, 244, 41);
		sizeSlider.setMajorTickSpacing(5);
		sizeSlider.setPaintTicks(true);
		frame.getContentPane().add(sizeSlider);
		
		rSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 125);
		rSlider.setBounds(0, 240, 244, 41);
		rSlider.setMajorTickSpacing(15);
		rSlider.setPaintTicks(true);
		frame.getContentPane().add(rSlider);
		
		gSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 125);
		gSlider.setBounds(0, 320, 244, 41);
		gSlider.setMajorTickSpacing(15);
		gSlider.setPaintTicks(true);
		frame.getContentPane().add(gSlider);
		
		bSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 125);
		bSlider.setBounds(0, 400, 244, 41);
		bSlider.setMajorTickSpacing(15);
		bSlider.setPaintTicks(true);
		frame.getContentPane().add(bSlider);
		
		JLabel vLabel = new JLabel("Set Velocity", SwingConstants.CENTER);
		vLabel.setBounds(0, 0, 244, 40);
		frame.getContentPane().add(vLabel);
		
		JLabel sLabel = new JLabel("Set Size", SwingConstants.CENTER);
		sLabel.setBounds(0, 80, 244, 41);
		frame.getContentPane().add(sLabel);
		
		JLabel cLabel = new JLabel("Set Color", SwingConstants.CENTER);
		cLabel.setBounds(0, 160, 244, 41);
		frame.getContentPane().add(cLabel);
		
		JLabel rLabel = new JLabel("RED", SwingConstants.CENTER);
		rLabel.setBounds(0, 200, 244, 41);
		rLabel.setForeground(Color.RED);
		frame.getContentPane().add(rLabel);
		
		JLabel gLabel = new JLabel("GREEN", SwingConstants.CENTER);
		gLabel.setBounds(0, 280, 244, 41);
		gLabel.setForeground(Color.GREEN);
		frame.getContentPane().add(gLabel);
		
		JLabel bLabel = new JLabel("BLUE", SwingConstants.CENTER);
		bLabel.setBounds(0, 360, 244, 41);
		bLabel.setForeground(Color.BLUE);
		frame.getContentPane().add(bLabel);
		
		JButton btnNewButton = new JButton("Let's bounce!");
		btnNewButton.setBounds(10, 445, 224, 40);
		btnNewButton.addActionListener(new NewWindowListener());
		frame.getContentPane().add(btnNewButton);
	}
	
	private class NewWindowListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int X = frame.getWidth()/2;
			int Y = frame.getHeight()/2;
			int radius = sizeSlider.getValue();
			int velocity = velocitySlider.getValue();
			int R = rSlider.getValue();
			int G = gSlider.getValue();
			int B = bSlider.getValue();
			new BallFrame(X, Y, radius, velocity, R, G, B).setVisible(true);
		}
		
	}
}
