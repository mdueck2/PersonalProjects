package Program;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.Stack;

import javax.swing.event.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.awt.BorderLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Component;

public class GermanFlashcardsPractice extends JPanel {
	JPanel practice;
	Quiz quiz;
	Stack<Card> previousCards = new Stack();
	Card currentCard;
	JTextPane gerDisplay, engDisplay;
	
	
	
	/**
	 * Create the panel.
	 */
	public GermanFlashcardsPractice(int[] chapters, String[] types, String dir) {
		setLayout(new BorderLayout(0, 0));
		
		quiz = new Quiz(chapters, types);
		
		
		JButton btnNext = new JButton("Next");

		btnNext.setText("");
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Poor Richard", Font.PLAIN, 16));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!quiz.getDeck().getStack().isEmpty()){
					currentCard = quiz.getDeck().getStack().pop();
					previousCards.push(currentCard);
					if(dir.equals("English")){
						gerDisplay.setText(currentCard.getGer());
						engDisplay.setText("");
						
					}
					if(dir.equals("German")){
						engDisplay.setText(currentCard.getEng());
						gerDisplay.setText("");
					}
				}
				else{
					gerDisplay.setText("Deck Empty");
					engDisplay.setText("Deck Empty");
				}
				practice.repaint();
			}
		});
		add(btnNext, BorderLayout.EAST);
		btnNext.setPreferredSize(new Dimension(100,0));
		btnNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnNext.setOpaque(false);
		btnNext.setFocusPainted(false);
		btnNext.setBorderPainted(false);
		btnNext.setContentAreaFilled(false);
		btnNext.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btnNext.setBackground(new Color(0,0,0,0));
		btnNext.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/rightArrow.png"))
				.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH)));
		btnNext.setPressedIcon(new ImageIcon(new ImageIcon(getClass().getResource("/rightArrowPressed.png"))
				.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH)));
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setText("");
		btnPrevious.setForeground(Color.WHITE);
		btnPrevious.setFont(new Font("Poor Richard", Font.PLAIN, 16));
		btnPrevious.setBackground(Color.LIGHT_GRAY);
		btnPrevious.setPreferredSize(new Dimension(100, 0));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!previousCards.isEmpty()){
					currentCard = previousCards.pop();
					quiz.getDeck().getStack().push(currentCard);
					if(dir.equals("English")){
						gerDisplay.setText(currentCard.getGer());
						engDisplay.setText("");
						
					}
					if(dir.equals("German")){
						engDisplay.setText(currentCard.getEng());
						gerDisplay.setText("");
					}
				}
				else{
					gerDisplay.setText("Deck Empty");
					engDisplay.setText("Deck Empty");
				}
			}
		});
		add(btnPrevious, BorderLayout.WEST);
		btnPrevious.setPreferredSize(new Dimension(100,0));
		btnPrevious.setOpaque(false);
		btnPrevious.setFocusPainted(false);
		btnPrevious.setBorderPainted(false);
		btnPrevious.setContentAreaFilled(false);
		btnPrevious.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btnPrevious.setBackground(new Color(0,0,0,0));
		btnPrevious.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/leftArrow.png"))
				.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH)));
		btnPrevious.setPressedIcon(new ImageIcon(new ImageIcon(getClass().getResource("/leftArrowPressed.png"))
				.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH)));
		
		JButton btnShow = new JButton("Show");
		btnShow.setText("");
		btnShow.setBackground(Color.LIGHT_GRAY);
		btnShow.setForeground(Color.WHITE);
		btnShow.setFont(new Font("Poor Richard", Font.PLAIN, 16));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dir.equals("English")&&!gerDisplay.getText().equals("Deck Empty")&&!gerDisplay.getText().equals("")){
					engDisplay.setText(currentCard.getEng());
					
				}
				if(dir.equals("German")&&!engDisplay.getText().equals("Deck Empty")&&!engDisplay.getText().equals("")){
					gerDisplay.setText(currentCard.getGer());
				}
			}
		});
		btnShow.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		add(btnShow, BorderLayout.SOUTH);
		btnShow.setPreferredSize(new Dimension(0,50));
		btnShow.setOpaque(false);
		btnShow.setFocusPainted(false);
		btnShow.setBorderPainted(false);
		btnShow.setContentAreaFilled(false);
		btnShow.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btnShow.setBackground(new Color(0,0,0,0));
		btnShow.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/lookup.png"))
				.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnShow.setPressedIcon(new ImageIcon(new ImageIcon(getClass().getResource("/lookupPressed.png"))
				.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setBounds(10, 78, 260, 49);
		panel.add(rigidArea);
		
		gerDisplay = new JTextPane();
		gerDisplay.setForeground(Color.BLACK);
		SimpleAttributeSet attGer = new SimpleAttributeSet();
		StyleConstants.setAlignment(attGer, StyleConstants.ALIGN_CENTER);
		gerDisplay.setParagraphAttributes(attGer, true);
		gerDisplay.setEditable(false);
		gerDisplay.setFont(new Font("Prestige Elite Std", Font.PLAIN, 16));
		gerDisplay.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		gerDisplay.setBounds(10, 11, 260, 67);
		panel.add(gerDisplay);
		
		engDisplay = new JTextPane();
		engDisplay.setForeground(Color.BLACK);
		SimpleAttributeSet attEng = new SimpleAttributeSet();
		StyleConstants.setAlignment(attEng, StyleConstants.ALIGN_CENTER);
		engDisplay.setParagraphAttributes(attEng, true);
		engDisplay.setFont(new Font("Prestige Elite Std", Font.PLAIN, 16));
		engDisplay.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		engDisplay.setBounds(10, 127, 260, 67);
		panel.add(engDisplay);
		
		practice = new JPanel();
		practice.setBackground(new Color(0,0,0,255));
		practice = new JPanel();
		practice.setBackground(new Color(0,0,0,255));

	}
	
	public JPanel getContentPane(){
		return practice;
	}
	
	private void next(){
		
	}
	
	private void previous(){
		
	}
}
