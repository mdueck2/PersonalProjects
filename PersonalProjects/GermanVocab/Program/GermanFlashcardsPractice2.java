package Program;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class GermanFlashcardsPractice2 extends JFrame {

	private JPanel contentPane;

	JPanel practice;
	Quiz quiz;
	Stack<Card> previousCards = new Stack();
	Card currentCard;
	JTextArea gerDisplay, engDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(int[] chapters, String[] types, String dir) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GermanFlashcardsPractice2 frame = new GermanFlashcardsPractice2(chapters, types, dir);
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
	public GermanFlashcardsPractice2(int[] chapters, String[] types, String dir) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!quiz.getDeck().getStack().isEmpty()){
					currentCard = quiz.getDeck().getStack().pop();
					previousCards.push(currentCard);
					if(dir.equals("English")){
						gerDisplay.setText(currentCard.getGer());
						
					}
					if(dir.equals("German")){
						engDisplay.setText(currentCard.getEng());
					}
				}
				else{
					gerDisplay.setText("Deck Empty");
					engDisplay.setText("Deck Empty");
				}
			}
		});
		btnNext.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		add(btnNext, BorderLayout.EAST);
		btnNext.setPreferredSize(new Dimension(100,0));
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setPreferredSize(new Dimension(100, 0));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!previousCards.isEmpty()){
					currentCard = previousCards.pop();
					quiz.getDeck().getStack().push(currentCard);
					if(dir.equals("English")){
						gerDisplay.setText(currentCard.getGer());
						
					}
					if(dir.equals("German")){
						engDisplay.setText(currentCard.getEng());
					}
				}
				else{
					gerDisplay.setText("Deck Empty");
					engDisplay.setText("Deck Empty");
				}
			}
		});
		btnPrevious.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		add(btnPrevious, BorderLayout.WEST);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dir.equals("English")){
					engDisplay.setText(currentCard.getEng());
					
				}
				if(dir.equals("German")){
					gerDisplay.setText(currentCard.getGer());
				}
			}
		});
		btnShow.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		add(btnShow, BorderLayout.SOUTH);
		btnShow.setPreferredSize(new Dimension(0,50));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setBounds(10, 78, 260, 49);
		panel.add(rigidArea);
		
		gerDisplay = new JTextArea();
		gerDisplay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		gerDisplay.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		gerDisplay.setLineWrap(true);
		gerDisplay.setBounds(10, 11, 260, 67);
		panel.add(gerDisplay);
		
		engDisplay = new JTextArea();
		engDisplay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		engDisplay.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		engDisplay.setLineWrap(true);
		engDisplay.setBounds(10, 127, 260, 67);
		panel.add(engDisplay);
		quiz = new Quiz(chapters, types);
		practice = new JPanel();
		practice.setBackground(new Color(0,0,0,255));
		
		
		
		
		
		
		quiz = new Quiz(chapters, types);
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
