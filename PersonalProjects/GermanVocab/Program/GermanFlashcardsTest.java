package Program;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Stack;

import javax.swing.JRadioButton;

public class GermanFlashcardsTest extends JPanel {
	JPanel test;
	static JPanel answer;
	static Quiz quiz;
	static Stack<Card> previousCards = new Stack();
	static Card currentCard;
	static JTextPane gerDisplay, engDisplay, textPane;
	static int grade = 0, total, counter = -1;
	static JLabel lblA,lblB,lblC,lblD;
	static ButtonGroup group;
	static JRadioButton rdbtnAanswer,rdbtnBanswer,rdbtnCanswer,rdbtnDanswer;
	static String dir;

	/**
	 * Create the panel.
	 */
	public GermanFlashcardsTest(int[] chapters, String[] types, String d) {
		dir = d;
		setLayout(null);
		quiz = new Quiz(chapters, types);
		total = quiz.getDeck().getStack().size();
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Prestige Elite Std", Font.PLAIN, 16));
		SimpleAttributeSet attText = new SimpleAttributeSet();
		StyleConstants.setAlignment(attText, StyleConstants.ALIGN_CENTER);
		StyleConstants.setForeground(attText, Color.WHITE);
		StyleConstants.setFontSize(attText, 16);
		StyleConstants.setFontFamily(attText, "Prestige Elite Std");
		textPane.setParagraphAttributes(attText, true);
		textPane.setForeground(Color.WHITE);
		textPane.setOpaque(false);
		textPane.setCaretColor(Color.WHITE);
		textPane.setBounds(10, 11, 460, 66);

		add(textPane);

		JButton btnNewButton = new JButton("Next");
		btnNewButton.setLocation(370, 88);
		btnNewButton.setSize(100, 125);
		btnNewButton.setText("");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Poor Richard", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnswer();
				group.clearSelection();			
				counter++;
				displayQuestion();
				

				if(counter==total){
					textPane.setText("No more cards\nScore: "+grade+"/"+total);
					btnNewButton.setEnabled(false);
				}
				test.repaint();
			}
		});
		
		add(btnNewButton, BorderLayout.EAST);
		btnNewButton.setPreferredSize(new Dimension(100,0));
		btnNewButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnNewButton.setOpaque(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btnNewButton.setBackground(new Color(0,0,0,0));
		btnNewButton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/rightArrow.png"))
				.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH)));
		btnNewButton.setPressedIcon(new ImageIcon(new ImageIcon(getClass().getResource("/rightArrowPressed.png"))
				.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH)));

		lblA = new JLabel("A.");
		lblA.setForeground(Color.WHITE);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblA.setBounds(10, 88, 16, 14);
		add(lblA);

		lblB = new JLabel("B.");
		lblB.setForeground(Color.WHITE);
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblB.setBounds(10, 113, 16, 14);
		add(lblB);

		lblC = new JLabel("C.");
		lblC.setForeground(Color.WHITE);
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblC.setBounds(10, 138, 16, 14);
		add(lblC);

		lblD = new JLabel("D.");
		lblD.setForeground(Color.WHITE);
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblD.setBounds(10, 163, 16, 14);
		add(lblD);
		
		rdbtnAanswer = new JRadioButton("aAnswer");
		rdbtnAanswer.setForeground(Color.WHITE);
		rdbtnAanswer.setMultiClickThreshhold(1L);
		rdbtnAanswer.setOpaque(false);
		rdbtnAanswer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnAanswer.setBounds(40, 84, 324, 23);
		add(rdbtnAanswer);
		
		rdbtnBanswer = new JRadioButton("bAnswer");
		rdbtnBanswer.setForeground(Color.WHITE);
		rdbtnBanswer.setMultiClickThreshhold(1L);
		rdbtnBanswer.setOpaque(false);
		rdbtnBanswer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnBanswer.setBounds(40, 109, 324, 23);
		add(rdbtnBanswer);
		
		rdbtnCanswer = new JRadioButton("cAnswer");
		rdbtnCanswer.setForeground(Color.WHITE);
		rdbtnCanswer.setMultiClickThreshhold(1L);
		rdbtnCanswer.setOpaque(false);
		rdbtnCanswer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnCanswer.setBounds(40, 134, 324, 23);
		add(rdbtnCanswer);
		
		rdbtnDanswer = new JRadioButton("dAnswer");
		rdbtnDanswer.setForeground(Color.WHITE);
		rdbtnDanswer.setMultiClickThreshhold(1L);
		rdbtnDanswer.setOpaque(false);
		rdbtnDanswer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnDanswer.setBounds(40, 159, 324, 23);
		add(rdbtnDanswer);
		test = new JPanel();
		test.setSize(new Dimension(550,350));
		test.setBackground(new Color(0,0,0,150));
		
		group = new ButtonGroup();
		group.add(rdbtnAanswer);
		group.add(rdbtnBanswer);
		group.add(rdbtnCanswer);
		group.add(rdbtnDanswer);
	}
	
	private static Stack<Card> getSpread(Card current, Stack<Card> stack, Stack<Card> previous){
		Card temp1 = new Card(current.getChapter(),current.getType(),current.getGer(),current.getEng());
		Stack<Card> temp2 = (Stack<Card>)previous.clone();
		Stack<Card> temp3 = (Stack<Card>)stack.clone();
		while(!temp3.isEmpty())
			temp2.push(temp3.pop());
		previous.push(current);
		Collections.shuffle(temp2);
		Stack<Card> temp = new Stack();
		temp.push(temp1);
		temp.push(temp2.pop());
		temp.push(temp2.pop());
		temp.push(temp2.pop());
		return temp;
	}
	
	private static void displayQuestion(){
		if(!quiz.getDeck().getStack().isEmpty()){
			currentCard = quiz.getDeck().getStack().pop();
			//previousCards.push(currentCard);
			Stack<Card> pool = getSpread(currentCard, quiz.getDeck().getStack(), previousCards);
			Stack order = new Stack();
			order.push(0);
			order.push(1);
			order.push(2);
			order.push(3);
			Collections.shuffle(order);
			Collections.shuffle(pool);

			if(dir.equals("English")){
				textPane.setText(currentCard.getGer());
				while(!order.isEmpty()){
					int i = (int)order.pop();
					if(i==0){
						rdbtnAanswer.setText(pool.pop().getEng());
					}
					else if(i==1){
						rdbtnBanswer.setText(pool.pop().getEng());
					}
					else if(i==2){
						rdbtnCanswer.setText(pool.pop().getEng());
					}
					else{
						rdbtnDanswer.setText(pool.pop().getEng());
					}
				}
			}
			if(dir.equals("German")){
				textPane.setText(currentCard.getEng());
				while(!order.isEmpty()){
					int i = (int)order.pop();
					if(i==0){
						rdbtnAanswer.setText(pool.pop().getGer());
					}
					else if(i==1){
						rdbtnBanswer.setText(pool.pop().getGer());
					}
					else if(i==2){
						rdbtnCanswer.setText(pool.pop().getGer());
					}
					else{
						rdbtnDanswer.setText(pool.pop().getGer());
					}
				}
			}
		}
	}
	
	private static void checkAnswer(){
		if(rdbtnAanswer.isSelected()){
			if(dir.equals("German")){
				if(rdbtnAanswer.getText().equals(previousCards.peek().getGer()))
					grade++;
				else
					JOptionPane.showMessageDialog(null, "Correct answer: \n"+previousCards.peek().getGer());
			}
			else if(dir.equals("English")){
				if(rdbtnAanswer.getText().equals(previousCards.peek().getEng()))
					grade++;
				else
					JOptionPane.showMessageDialog(null, "Correct answer: \n"+previousCards.peek().getEng());
			}
		}
		else if(rdbtnBanswer.isSelected()){
			if(dir.equals("German")){
				if(rdbtnBanswer.getText().equals(previousCards.peek().getGer()))
					grade++;
				else
					JOptionPane.showMessageDialog(null, "Correct answer: \n"+previousCards.peek().getGer());
			}
			else if(dir.equals("English")){
				if(rdbtnBanswer.getText().equals(previousCards.peek().getEng()))
					grade++;
				else
					JOptionPane.showMessageDialog(null, "Correct answer: \n"+previousCards.peek().getEng());
			}
		}
		else if(rdbtnCanswer.isSelected()){
			if(dir.equals("German")){
				if(rdbtnCanswer.getText().equals(previousCards.peek().getGer()))
					grade++;
				else
					JOptionPane.showMessageDialog(null, "Correct answer: \n"+previousCards.peek().getGer());
			}
			else if(dir.equals("English")){
				if(rdbtnCanswer.getText().equals(previousCards.peek().getEng()))
					grade++;
				else
					JOptionPane.showMessageDialog(null, "Correct answer: \n"+previousCards.peek().getEng());
			}
		}
		else if(rdbtnDanswer.isSelected()){
			if(dir.equals("German")){
				if(rdbtnDanswer.getText().equals(previousCards.peek().getGer()))
					grade++;
				else
					JOptionPane.showMessageDialog(null, "Correct answer: \n"+previousCards.peek().getGer());
			}
			else if(dir.equals("English")){
				if(rdbtnDanswer.getText().equals(previousCards.peek().getEng()))
					grade++;
				else
					JOptionPane.showMessageDialog(null, "Correct answer: \n"+previousCards.peek().getEng());
			}
		}
	}
}
