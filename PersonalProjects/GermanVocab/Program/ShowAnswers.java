package Program;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ShowAnswers extends JPanel {

	JPanel contentPane;
	/**
	 * Create the panel.
	 */
	public ShowAnswers(String s) {
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnAnswerdisplay = new JTextPane();
		txtpnAnswerdisplay = new JTextPane();
		txtpnAnswerdisplay.setEditable(false);
		txtpnAnswerdisplay.setFont(new Font("Prestige Elite Std", Font.PLAIN, 16));
		SimpleAttributeSet attText = new SimpleAttributeSet();
		StyleConstants.setAlignment(attText, StyleConstants.ALIGN_CENTER);
		StyleConstants.setForeground(attText, Color.WHITE);
		StyleConstants.setFontSize(attText, 16);
		StyleConstants.setFontFamily(attText, "Prestige Elite Std");
		txtpnAnswerdisplay.setParagraphAttributes(attText, true);
		txtpnAnswerdisplay.setForeground(Color.WHITE);
		txtpnAnswerdisplay.setOpaque(true);
		txtpnAnswerdisplay.setCaretColor(Color.WHITE);
		txtpnAnswerdisplay.setBounds(10, 11, 460, 66);

		contentPane.add(txtpnAnswerdisplay);
		
		
		txtpnAnswerdisplay.setText(s);
		contentPane.add(txtpnAnswerdisplay, BorderLayout.CENTER);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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