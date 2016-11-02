/**
 * 
 */
package pHW01_Calculator_T153337;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Time;

import javax.jws.WebParam.Mode;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 * Hau Vo - T153337
 *
 * 
 */
public class cHW01_Calculator_T153337 extends JFrame {
	JMenuBar mnbBar = new JMenuBar();
	JMenu mnuView = new JMenu("View");
	JMenu mnuEdit = new JMenu("Edit");
	JMenu mnuHelp = new JMenu("Help");
	JMenuItem mniSta = new JMenuItem("Standard");
	JMenuItem mniSci = new JMenuItem("Scientific");
	JMenuItem mniPro = new JMenuItem("Programmer");
	JMenuItem mniExi = new JMenuItem("Exit");
	JMenuItem mniCop = new JMenuItem("Copy");
	JMenuItem mniPas = new JMenuItem("Paste");
	JMenuItem mniAbo = new JMenuItem("About");
	JTextField txaContent = new JTextField(), txaDisible = new JTextField();

	JRadioButton optDegrees = new JRadioButton("Degrees");
	JRadioButton optRadians = new JRadioButton("Radians");
	JRadioButton optGrads = new JRadioButton("Grads");
	JRadioButton optHex = new JRadioButton("Hex");
	JRadioButton optDec = new JRadioButton("Dec");
	JRadioButton optOct = new JRadioButton("Oct");
	JRadioButton optBin = new JRadioButton("Bin");
	JRadioButton optQword = new JRadioButton("Qword");
	JRadioButton optDword = new JRadioButton("Dword");
	JRadioButton optWord = new JRadioButton("Word");
	JRadioButton optByte = new JRadioButton("Byte");
	ButtonGroup btnG = new ButtonGroup();
	JPanel panAngelUnits1 = new JPanel();
	JPanel panAngelUnits2 = new JPanel();
	JPanel panAngelUnits3 = new JPanel();
	ImageIcon imCop = new ImageIcon("C:/Users/HP/Downloads/Cal/1.png");
	ImageIcon imPas = new ImageIcon("C:/Users/HP/Downloads/Cal/2.png");
	ImageIcon imAbo = new ImageIcon("C:/Users/HP/Downloads/Cal/3.png");
	Font f = new Font("Times New Roman",Font.BOLD, 30);

	String[][] sStandard = { { "MC", "MR", "MS", "M+", "M-" }, { "<-", "CE", "C", "+/-", "sqrt" },
			{ "7", "8", "9", "/", "%" }, { "4", "5", "6", "*", "1/x" }, { "1", "2", "3", "-", "=" },
			{ "0", ".", "+", ",", "" } };
	//
	String[][] sScientific = { { " ", "Inv", "In", "(", ")" }, { "Int", "sinh", "sin", "x^2", "n!" },
			{ "dms", "cosh", "cos", "x^y", "√(y&x)" }, { "π", "tanh", "tan", "x^3", "√(3&x)" },
			{ "F-E", "Exp", "Mod", "log", "10^x" } };
	//
	String[][] sProgrammer = { { "", "Mod", "A" }, { "(", ")", "B" }, { "RoL", "RoR", "C" }, { "Or", "Xor", "D" },
			{ "Lsh", "Rsh", "E" }, { "Not", "And", "F" } };
	JButton[][] btnStandards = new JButton[6][5];
	JButton[][] btnScientific = new JButton[5][5];
	JButton[][] btnProgrammer = new JButton[6][3];
	JPanel panStandard = new JPanel();
	JPanel panScientific = new JPanel();
	JPanel panProgrammer = new JPanel();
	String s= "top";
	String s1 = "\n"+"\n"+"\n"+"\n"+"bottom";

	int w = 40, h = 40, d = 10;
	int x = 0, y = 0;

	public void txaStandard() {
		this.add(txaContent);
		txaContent.setColumns(16);
		
		txaContent.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txaContent.setText(s+s1);
		txaContent.setBounds(12, 10, 240, 80);
		//txaContent.setText("kasa");
		txaContent.setEditable(false);
		txaContent.setFont(f);
		
	}

	public void txaSciPro() {
		txaContent.setColumns(32);
		txaContent.setBounds(12, 10, 492, 80);
		txaContent.setEditable(false);
	}

	public void txaDis() {
		add(txaDisible);
		txaDisible.setVisible(true);
		txaDisible.setEditable(false);
		txaDisible.setBounds(12, 100, 492, 80);
		txaContent.setEditable(false);
		txaDisible.setText(" 0000");
	}

	public void panAU() {
		panAngelUnits1 = new JPanel();
		panAngelUnits1.setLayout(new GridLayout(1, 3));
		add(optDegrees);
		add(optGrads);
		add(optRadians);
		panAngelUnits1.add(optDegrees);
		panAngelUnits1.add(optGrads);
		panAngelUnits1.add(optRadians);
		panAngelUnits1.setBounds(12, 100, 240, 40);
		panAngelUnits1.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
		this.add(panAngelUnits1);
	}

	public void panPro() {
		panAngelUnits2 = new JPanel();
		panAngelUnits2.setLayout(new GridLayout(4, 1));
		panAngelUnits3 = new JPanel();
		panAngelUnits3.setLayout(new GridLayout(4, 1));
		add(optHex);
		add(optDec);
		add(optOct);
		add(optBin);
		add(optQword);
		add(optDword);
		add(optWord);
		add(optByte);
		panAngelUnits2.add(optHex);
		panAngelUnits2.add(optDec);
		panAngelUnits2.add(optOct);
		panAngelUnits2.add(optBin);
		panAngelUnits3.add(optQword);
		panAngelUnits3.add(optDword);
		panAngelUnits3.add(optWord);
		panAngelUnits3.add(optByte);
		panAngelUnits2.setBounds(12, 200, 80, 140);
		panAngelUnits2.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
		panAngelUnits2.setVisible(true);
		this.add(panAngelUnits2);

		panAngelUnits3.setBounds(12, 350, 80, 140);
		panAngelUnits3.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
		panAngelUnits3.setVisible(true);
		this.add(panAngelUnits3);

	}

	public void initComponent1() {
		txaStandard();
		
		panAngelUnits1.setVisible(false);
		panAngelUnits2.setVisible(false);
		panAngelUnits3.setVisible(false);
		txaDisible.setVisible(false);
		// Standard
		panStandard.setLayout(null);
		panStandard.setSize(getWidth(), getHeight());
		panStandard.setLocation(12, 95);
		Insets isMargin = new Insets(1, 1, 1, 1);
		y = 0;
		for (int i = 0; i < 6; i++) {
			x = 0;
			for (int j = 0; j < 5; j++) {
				btnStandards[i][j] = new JButton(sStandard[i][j]);
				panStandard.add(btnStandards[i][j]);
				btnStandards[i][j].setBounds(x, y, w, h);
				btnStandards[i][j].setMargin(isMargin);
				x = x + w + d;

			}
			y = y + h + d;
		}
		this.add(panStandard);
		// relocate for the last ROW
		btnStandards[4][4].setSize(w, h + d + h);
		btnStandards[5][0].setSize(w + d + w, h);
		btnStandards[5][1].setLocation(w + d + h + d, y - h - d);
		btnStandards[5][2].setLocation(w + d + w + d + w + d, y - h - d);
		// btnStandards[5][3].setVisible(true);
		// btnStandards[5][4].setVisible(true);
		panScientific.setVisible(false);
		panProgrammer.setVisible(false);
		panStandard.setVisible(true);
		panStandard.setBounds(12, 100, x + w, y + h);
		this.setSize(270, 450);

	}

	public void initComponent2() {
		panAU();
		txaSciPro();
		txaDisible.setVisible(false);
		panAngelUnits2.setVisible(false);
		panAngelUnits3.setVisible(false);
		panScientific.setLayout(null);
		Insets isMargin = new Insets(1, 1, 1, 1);
		y = 0;
		for (int i = 0; i < 5; i++) {
			x = 0;
			for (int j = 0; j < 5; j++) {
				btnScientific[i][j] = new JButton(sScientific[i][j]);
				panScientific.add(btnScientific[i][j]);
				btnScientific[i][j].setBounds(x, y, w, h);
				btnScientific[i][j].setMargin(isMargin);
				x = x + w + d;
			}
			y = y + h + d;
		}
		this.add(panScientific);
		panStandard.setVisible(true);
		panScientific.setVisible(true);
		panProgrammer.setVisible(false);
		panScientific.setBounds(12, 150, getWidth(), getHeight());
		panStandard.setBounds(262, 100, getWidth(), getHeight());
		this.setSize(520, 455);

	}

	public void initComponent3() {
		txaSciPro();
		txaDis();
		panPro();
		panAngelUnits1.setVisible(false);
		panProgrammer.setLayout(null);
		Insets isMargin = new Insets(1, 1, 1, 1);
		y = 0;
		for (int i = 0; i < 6; i++) {
			x = 0;
			for (int j = 0; j < 3; j++) {
				btnProgrammer[i][j] = new JButton(sProgrammer[i][j]);
				panProgrammer.add(btnProgrammer[i][j]);
				btnProgrammer[i][j].setBounds(x, y, w, h);
				btnProgrammer[i][j].setMargin(isMargin);
				x = x + w + d;
			}
			y = y + h + d;
		}
		this.add(panProgrammer);
		panStandard.setVisible(true);
		panScientific.setVisible(false);
		panProgrammer.setVisible(true);
		panProgrammer.setBounds(112, 200, getWidth(), getHeight());
		panStandard.setBounds(262, 200, getWidth(), getHeight());
		this.setSize(520, 555);
	}

	//
	public void displayMode(int mode) {
		if (mode == 1) {
			initComponent1();
		}
		if (mode == 2) {
			initComponent2();
		}
		if (mode == 3) {
			initComponent3();
		}
	}

	public void Exit() {
		System.exit(0);
	}

	public void Menu() {
		// thêm vào menu View
		mnuView.add(mniSta);
		mnuView.add(mniSci);
		mnuView.add(mniPro);
		mnuView.addSeparator();
		mnuView.add(mniExi);
		// thêm vào menu Edit
		mnuEdit.add(mniCop);
		mnuEdit.add(mniPas);
		// thêm vào menu Help
		mnuHelp.add(mniAbo);
		// thêm vào menu Bar
		mnbBar.add(mnuView);
		mnbBar.add(mnuEdit);
		mnbBar.add(mnuHelp);
		// thêm icon vào mnuitem
		mniCop.setIcon(imCop);
		mniPas.setIcon(imPas);
		mniAbo.setIcon(imAbo);
		// thêm hotkey
		mniAbo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
		mniExi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
		mniPro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
		mniSci.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		mniSta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
		mniCop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		mniPas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.ALT_MASK));

		// đặt Menu chính
		setJMenuBar(mnbBar);

	}

	public cHW01_Calculator_T153337() {
		// TODO Auto-generated constructor stub

		setTitle("Calculator");
		this.setLayout(null);
		setPreferredSize(new Dimension(270, 450));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		this.setResizable(false);
		Menu();
		initComponent1();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == mniExi) {
					Exit();
				} else if (e.getSource() == mniSta) {
					displayMode(1);
				} else if (e.getSource() == mniSci) {
					displayMode(2);
				} else if (e.getSource() == mniPro) {
					displayMode(3);
				}

			}
		};
		mniExi.addActionListener(action);
		mniSta.addActionListener(action);
		mniSci.addActionListener(action);
		mniPro.addActionListener(action);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cHW01_Calculator_T153337 wMain = new cHW01_Calculator_T153337();
		// end program as closing window.
		wMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// show the window
		wMain.setVisible(true);
	}

}
