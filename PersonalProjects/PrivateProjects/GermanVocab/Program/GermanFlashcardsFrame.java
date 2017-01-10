package Program;
import javax.swing.*;
import javax.swing.event.AncestorListener;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;



public class GermanFlashcardsFrame extends JFrame {


	protected static final Component GermanFlashcardsPractice = null;
	static GermanFlashcardsFrame frame;
	static JPanel practice;
	static JPanel test;
	static JPanel practiceInside;
	JPanel testInside;
	static JPanel practicePanel, testPanel;
	static int chapters[] = new int[12];
	static String types[] = {" "," "," "," "};
	static JMenuBar menuBar;
	static JToggleButton tglbtnEnglish;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GermanFlashcardsFrame();
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
	public GermanFlashcardsFrame() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		
		Image icon = new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		ImageIcon pic = new ImageIcon(getClass().getResource("/main background germany.jpg"));

		
		
		JLabel label = new JLabel(pic);
		setContentPane(label);
		
		
		
		//Transparent JPanel Test
		FlowLayout fl_label = new FlowLayout();
		fl_label.setVgap(25);
		fl_label.setAlignOnBaseline(true);
		getContentPane().setLayout(fl_label);
		
		loadPractice();
		
		getContentPane().add(new AlphaContainer(practice));

		loadPracticeInside();
		
		practice.add((practiceInside));
		
		loadMenu();
		
		setJMenuBar(menuBar);
		
		//loadPracticeWindow();

		//practice.add(practicePanel);


	}
	

	public static GermanFlashcardsFrame getFrame(){
		return frame;
	}
	
	private static void loadPractice(){
		practice=new JPanel();
		practice.setPreferredSize(new Dimension(500,300));
		practice.setBackground(new Color(0,0,0,180));
		practice.setVisible(false);
		
		practice.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i<12; i++){
					chapters[i] = 0;
				}
				for (int i = 0; i<4 ; i++){
					types[i] = " ";
				}
				practice.setVisible(false);
				practiceInside.setVisible(true);
				if(practicePanel != null)
					practicePanel.setVisible(false);
				if(testPanel != null)
					testPanel.setVisible(false);
			}
		});
		btnExit.setBounds(411, 277, 89, 23);
		practice.add(btnExit);
	}
	
	private static void loadPracticeInside(){
		practiceInside = new JPanel();
		practiceInside.setOpaque(false);
		practiceInside.setBounds(10, 11, 480, 255);
		practiceInside.setBackground(new Color(0,0,0,150));
		
		practiceInside.setLayout(null);
		
		JLabel lblAskFor = new JLabel("Ask for:");
		lblAskFor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAskFor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAskFor.setForeground(Color.WHITE);
		lblAskFor.setBounds(10, 2, 210, 22);
		practiceInside.add(lblAskFor);
		
		tglbtnEnglish = new JToggleButton("English");
		tglbtnEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnEnglish.getText().equals("English")){
					tglbtnEnglish.setText("German");
				}
				else{
					tglbtnEnglish.setText("English");
				}
			}
		});
		tglbtnEnglish.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tglbtnEnglish.setBounds(243, 2, 99, 23);
		practiceInside.add(tglbtnEnglish);
		
		JLabel lblChapters = new JLabel("Chapters:");
		lblChapters.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChapters.setForeground(Color.WHITE);
		lblChapters.setBounds(91, 35, 91, 22);
		practiceInside.add(lblChapters);
		
		JCheckBox chckbxChapter = new JCheckBox("Chapter: 1");
		chckbxChapter.setOpaque(false);
		chckbxChapter.setForeground(Color.WHITE);
		chckbxChapter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxChapter.setBounds(10, 56, 108, 23);
		practiceInside.add(chckbxChapter);
		
		JCheckBox chckbxChapter_1 = new JCheckBox("Chapter: 2");
		chckbxChapter_1.setForeground(Color.WHITE);
		chckbxChapter_1.setOpaque(false);
		chckbxChapter_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxChapter_1.setBounds(10, 82, 108, 23);
		practiceInside.add(chckbxChapter_1);
		
		JCheckBox chckbxChapter_2 = new JCheckBox("Chapter: 3");
		chckbxChapter_2.setOpaque(false);
		chckbxChapter_2.setForeground(Color.WHITE);
		chckbxChapter_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxChapter_2.setBounds(10, 108, 108, 23);
		practiceInside.add(chckbxChapter_2);
		
		JCheckBox chckbxChapter_3 = new JCheckBox("Chapter: 4");
		chckbxChapter_3.setForeground(Color.WHITE);
		chckbxChapter_3.setOpaque(false);
		chckbxChapter_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxChapter_3.setBounds(10, 134, 108, 23);
		practiceInside.add(chckbxChapter_3);
		
		JCheckBox chckbxChapter_4 = new JCheckBox("Chapter: 5");
		chckbxChapter_4.setOpaque(false);
		chckbxChapter_4.setForeground(Color.WHITE);
		chckbxChapter_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxChapter_4.setBounds(10, 160, 108, 23);
		practiceInside.add(chckbxChapter_4);
		
		JCheckBox chckbxChapter_5 = new JCheckBox("Chapter: 6");
		chckbxChapter_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxChapter_5.setForeground(Color.WHITE);
		chckbxChapter_5.setOpaque(false);
		chckbxChapter_5.setBounds(132, 56, 107, 23);
		practiceInside.add(chckbxChapter_5);
		
		JCheckBox chckbxChapter_6 = new JCheckBox("Chapter: 7");
		chckbxChapter_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxChapter_6.setForeground(Color.WHITE);
		chckbxChapter_6.setOpaque(false);
		chckbxChapter_6.setBounds(132, 82, 107, 23);
		practiceInside.add(chckbxChapter_6);
		
		JCheckBox chckbxChapter_7 = new JCheckBox("Chapter: 8");
		chckbxChapter_7.setOpaque(false);
		chckbxChapter_7.setForeground(Color.WHITE);
		chckbxChapter_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxChapter_7.setBounds(132, 108, 107, 23);
		practiceInside.add(chckbxChapter_7);
		
		JCheckBox chckbxChapter_8 = new JCheckBox("Chapter: 9");
		chckbxChapter_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxChapter_8.setForeground(Color.WHITE);
		chckbxChapter_8.setOpaque(false);
		chckbxChapter_8.setBounds(132, 134, 107, 23);
		practiceInside.add(chckbxChapter_8);
		
		JCheckBox chckbxChapter_9 = new JCheckBox("Chapter: 10");
		chckbxChapter_9.setOpaque(false);
		chckbxChapter_9.setForeground(Color.WHITE);
		chckbxChapter_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxChapter_9.setBounds(132, 160, 107, 23);
		practiceInside.add(chckbxChapter_9);
		
		JCheckBox chckbxChapter_10 = new JCheckBox("Chapter: 11");
		chckbxChapter_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxChapter_10.setForeground(Color.WHITE);
		chckbxChapter_10.setOpaque(false);
		chckbxChapter_10.setBounds(243, 56, 108, 23);
		practiceInside.add(chckbxChapter_10);
		
		JCheckBox chckbxChapter_11 = new JCheckBox("Chapter: 12");
		chckbxChapter_11.setOpaque(false);
		chckbxChapter_11.setForeground(Color.WHITE);
		chckbxChapter_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxChapter_11.setBounds(243, 82, 116, 23);
		practiceInside.add(chckbxChapter_11);
		
		JCheckBox chckbxAll = new JCheckBox("All");
		chckbxAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!chckbxAll.isSelected()){
					chckbxChapter.setSelected(false);
					chckbxChapter_1.setSelected(false);
					chckbxChapter_2.setSelected(false);
					chckbxChapter_3.setSelected(false);
					chckbxChapter_4.setSelected(false);
					chckbxChapter_5.setSelected(false);
					chckbxChapter_6.setSelected(false);
					chckbxChapter_7.setSelected(false);
					chckbxChapter_8.setSelected(false);
					chckbxChapter_9.setSelected(false);
					chckbxChapter_10.setSelected(false);
					chckbxChapter_11.setSelected(false);
				}
				else{
					chckbxChapter.setSelected(true);
					chckbxChapter_1.setSelected(true);
					chckbxChapter_2.setSelected(true);
					chckbxChapter_3.setSelected(true);
					chckbxChapter_4.setSelected(true);
					chckbxChapter_5.setSelected(true);
					chckbxChapter_6.setSelected(true);
					chckbxChapter_7.setSelected(true);
					chckbxChapter_8.setSelected(true);
					chckbxChapter_9.setSelected(true);
					chckbxChapter_10.setSelected(true);
					chckbxChapter_11.setSelected(true);
				}
			}
		});
		chckbxAll.setOpaque(false);
		chckbxAll.setForeground(Color.WHITE);
		chckbxAll.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxAll.setBounds(244, 108, 71, 23);
		practiceInside.add(chckbxAll);
		
		JLabel lblComponent = new JLabel("Component:");
		lblComponent.setForeground(Color.WHITE);
		lblComponent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblComponent.setBounds(353, 35, 99, 21);
		practiceInside.add(lblComponent);
		
		JCheckBox chckbxVerbs = new JCheckBox("Verbs");
		chckbxVerbs.setOpaque(false);
		chckbxVerbs.setForeground(Color.WHITE);
		chckbxVerbs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxVerbs.setBounds(361, 56, 79, 23);
		practiceInside.add(chckbxVerbs);
		
		JCheckBox chckbxNouns = new JCheckBox("Nouns");
		chckbxNouns.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxNouns.setForeground(Color.WHITE);
		chckbxNouns.setOpaque(false);
		chckbxNouns.setBounds(361, 82, 91, 23);
		practiceInside.add(chckbxNouns);
		
		JCheckBox chckbxAdjectives = new JCheckBox("Adjectives");
		chckbxAdjectives.setOpaque(false);
		chckbxAdjectives.setForeground(Color.WHITE);
		chckbxAdjectives.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxAdjectives.setBounds(361, 108, 97, 23);
		practiceInside.add(chckbxAdjectives);
		
		JCheckBox chckbxPhrases = new JCheckBox("Phrases");
		chckbxPhrases.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxPhrases.setForeground(Color.WHITE);
		chckbxPhrases.setOpaque(false);
		chckbxPhrases.setBounds(361, 134, 97, 23);
		practiceInside.add(chckbxPhrases);
		
		JCheckBox chckbxAll_1 = new JCheckBox("All");
		chckbxAll_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!chckbxAll_1.isSelected()){
					chckbxVerbs.setSelected(false);
					chckbxNouns.setSelected(false);
					chckbxAdjectives.setSelected(false);
					chckbxPhrases.setSelected(false);
				}
				else{
					chckbxVerbs.setSelected(true);
					chckbxNouns.setSelected(true);
					chckbxAdjectives.setSelected(true);
					chckbxPhrases.setSelected(true);
				}
			}
		});
		chckbxAll_1.setOpaque(false);
		chckbxAll_1.setForeground(Color.WHITE);
		chckbxAll_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxAll_1.setBounds(361, 160, 99, 23);
		practiceInside.add(chckbxAll_1);
		
		JButton btnStart = new JButton("Flashcards");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chapters = new int[12];
				if(chckbxChapter.isSelected())
					chapters[0] = 1;
				if(chckbxChapter_1.isSelected())
					chapters[1] = 1;
				if(chckbxChapter_2.isSelected())
					chapters[2] = 1;
				if(chckbxChapter_3.isSelected())
					chapters[3] = 1;
				if(chckbxChapter_4.isSelected())
					chapters[4] = 1;
				if(chckbxChapter_5.isSelected())
					chapters[5] = 1;
				if(chckbxChapter_6.isSelected())
					chapters[6] = 1;
				if(chckbxChapter_7.isSelected())
					chapters[7] = 1;
				if(chckbxChapter_8.isSelected())
					chapters[8] = 1;
				if(chckbxChapter_9.isSelected())
					chapters[9] = 1;
				if(chckbxChapter_10.isSelected())
					chapters[10] = 1;
				if(chckbxChapter_11.isSelected())
					chapters[11] = 1;
				types = new String[4];
				types[0] = " ";
				types[1] = " ";
				types[2] = " ";
				types[3] = " ";
				if(chckbxVerbs.isSelected())
					types[0] = "Verbs";
				if(chckbxNouns.isSelected())
					types[1] = "Nouns";
				if(chckbxAdjectives.isSelected())
					types[2] = "Adjectives";
				if(chckbxPhrases.isSelected())
					types[3] = "Phrases";
				practiceInside.setVisible(false);
				//practicePanel.setVisible(true);
				loadPracticeWindow();
				practicePanel.setVisible(true);
				practice.add((practicePanel));
			}
		});
		
		btnStart.setForeground(new Color(0, 0, 0));
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnStart.setOpaque(false);
		btnStart.setBounds(228, 221, 116, 23);
		practiceInside.add(btnStart);
		
		
		JButton btnStartQuiz = new JButton("Quiz");
		btnStartQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chapters = new int[12];
				if(chckbxChapter.isSelected())
					chapters[0] = 1;
				if(chckbxChapter_1.isSelected())
					chapters[1] = 1;
				if(chckbxChapter_2.isSelected())
					chapters[2] = 1;
				if(chckbxChapter_3.isSelected())
					chapters[3] = 1;
				if(chckbxChapter_4.isSelected())
					chapters[4] = 1;
				if(chckbxChapter_5.isSelected())
					chapters[5] = 1;
				if(chckbxChapter_6.isSelected())
					chapters[6] = 1;
				if(chckbxChapter_7.isSelected())
					chapters[7] = 1;
				if(chckbxChapter_8.isSelected())
					chapters[8] = 1;
				if(chckbxChapter_9.isSelected())
					chapters[9] = 1;
				if(chckbxChapter_10.isSelected())
					chapters[10] = 1;
				if(chckbxChapter_11.isSelected())
					chapters[11] = 1;
				types = new String[4];
				types[0] = " ";
				types[1] = " ";
				types[2] = " ";
				types[3] = " ";
				if(chckbxVerbs.isSelected())
					types[0] = "Verbs";
				if(chckbxNouns.isSelected())
					types[1] = "Nouns";
				if(chckbxAdjectives.isSelected())
					types[2] = "Adjectives";
				if(chckbxPhrases.isSelected())
					types[3] = "Phrases";
				practiceInside.setVisible(false);
				//practicePanel.setVisible(true);
				loadTestWindow();
				testPanel.setVisible(true);
				practice.add((testPanel));
			}
		});
		btnStartQuiz.setForeground(new Color(0, 0, 0));
		btnStartQuiz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnStartQuiz.setOpaque(false);
		btnStartQuiz.setBounds(354, 221, 116, 23);
		practiceInside.add(btnStartQuiz);
		
		
		

	}
	
	public static void loadMenu(){


		menuBar = new JMenuBar();

		
		
		JMenu mnFile = new JMenu("File");
		mnFile.setBackground(new Color(0,0,0,255));
		menuBar.add(mnFile);
		
		JMenuItem mntmPractice = new JMenuItem("Begin");
		mntmPractice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				practice.setVisible(true);
				}
			});

		mnFile.add(mntmPractice);	
		JMenuItem mntmQuiz = new JMenuItem("Exit");
		mntmQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmQuiz);
		
		JMenu mnProfile = new JMenu("Profile");
		menuBar.add(mnProfile);
		
		JMenuItem mntmManage = new JMenuItem("Manage");
		mnProfile.add(mntmManage);
	}
	
	public static void loadPracticeWindow(){
		practicePanel = new GermanFlashcardsPractice(chapters,types,tglbtnEnglish.getText());
		practicePanel.setOpaque(false);
		practicePanel.setBounds(10, 11, 480, 255);
		practicePanel.setBackground(new Color(0,0,0,150));
		practicePanel.setFocusable(true);
		
	}
	
	public static void loadTestWindow(){
		testPanel = new GermanFlashcardsTest(chapters,types,tglbtnEnglish.getText());
		testPanel.setOpaque(false);
		testPanel.setBounds(10,11,480,255);
		testPanel.setBackground(new Color(0,0,0,150));
		testPanel.setFocusable(true);
	}
}
