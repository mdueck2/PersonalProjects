package Program;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowAnswer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAnswer frame = new ShowAnswer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowAnswer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextPane txtpnAnswerdisplay = new JTextPane();
		txtpnAnswerdisplay.setText("answerDisplay");
		contentPane.add(txtpnAnswerdisplay, BorderLayout.CENTER);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
			}
		});
		contentPane.add(button, BorderLayout.EAST);
		button.setPreferredSize(new Dimension(100,0));
		button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		button.setBackground(new Color(0,0,0,0));
		button.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/rightArrow.png"))
				.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH)));
		button.setPressedIcon(new ImageIcon(new ImageIcon(getClass().getResource("/rightArrowPressed.png"))
				.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH)));
	}

}
