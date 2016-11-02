package pHW01_Calculator_T153337;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author TamNguyen T155132
 *
 */
public class calculator extends JFrame {
	JButton[][] btnStandard = new JButton[6][5],
				btnScientific = new JButton[5][5],
				btnProgrammer = new JButton[5][5];
	JRadioButton radD = new JRadioButton("Degrees"),
			radR = new JRadioButton("Radians"),
			radG = new JRadioButton("Grads");
	ButtonGroup btnG = new ButtonGroup();
	JPanel panStandard = new JPanel(), panScientific = new JPanel(), panProgammer = new JPanel();
	int w = 40, h = 40, d = 10;
	int x = 0, y = 0;
	JMenuBar mnBar = new JMenuBar();
	JMenu mnView = new JMenu("View"),
			mnEdit = new JMenu("Edit"),
			mnHelp = new JMenu("Help");
	JMenuItem mniOpen = new JMenuItem("Open"),
			mniExit = new JMenuItem("Exit"),
			mniStandard = new JMenuItem("Standard"),
			mniScientific = new JMenuItem("Scientific"),
			mniProgrammer = new JMenuItem("Programmer"),
	mniCoppy = new JMenuItem("Coppy"),
	mniPaste = new JMenuItem("Paste"),
	mniAbout = new JMenuItem("About Me");
	JTextArea txaContent = new JTextArea();
	ImageIcon iselect = new ImageIcon("select.jpg"),
			icoppy = new ImageIcon("coppy.png"),
			ipaste = new ImageIcon("paste.png"),
			iabout = new ImageIcon("about.png");
	Insets isMargin = new Insets(1, 1, 1, 1);
			
	
	String[][] sStandard = { { "MC", "MR", "MS", "M+", "M-" }, { "<-", "CE", "C", "+/-", "sqrt" },

			{ "7", "8", "9", "/", "%" }, { "4", "5", "6", "*", "1/x" }, { "1", "1", "3", "-", "=" },
			{ "0", ".", "+", "/","" } };
	public  calculator() {
		// TODO Auto-generated constructor stub
	
		this.setLayout(null);
		initComponent();
		this.setResizable(false);
		this.setPreferredSize(new Dimension(255,450));
		pack();
		//add
		
		
		mnBar.add(mnView);
		mnBar.add(mnEdit);
		mnBar.add(mnHelp);
		
		mnView.add(mniStandard);
		mnView.add(mniScientific);
		mnView.add(mniProgrammer);
		mnView.addSeparator();
		mnView.add(mniExit);
		
		
		mnEdit.add(mniCoppy);
		mnEdit.add(mniPaste);
		
		mnHelp.add(mniAbout);
		this.add(txaContent);
		
		setJMenuBar(mnBar);
		
		
		//icon
		
		mniCoppy.setIcon(icoppy);
		mniPaste.setIcon(ipaste);
		mniAbout.setIcon(iabout);

		//action
		ActionListener act = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()== mniStandard){
					initComponent();
					
				}else if(e.getSource()== mniScientific){
					//mniStandard.setIcon("");
					initComponent2();
					
					mniScientific.setIcon(iselect);
				}else if(e.getSource()==mniProgrammer){
					
				}else if(e.getSource()== mniExit){
					ExitAp();
				}
			}
		};
		mniStandard.addActionListener(act);
		mniScientific.addActionListener(act);
		mniProgrammer.addActionListener(act);
		mniExit.addActionListener(act);
		mniCoppy.addActionListener(act);
		mniPaste.addActionListener(act);
		mniAbout.addActionListener(act);
	}

	public void initComponent() {
		panStandard.setLayout(null);		
		y = 0;
		for (int i = 0; i < 6; i++) {
			x = 0;
			for (int j = 0; j < 5; j++) {
				btnStandard[i][j] = new JButton(sStandard[i][j]);
				panStandard.add(btnStandard[i][j]);
				btnStandard[i][j].setBounds(x, y, w, h);
				btnStandard[i][j].setMargin(isMargin);
				x = x + w + d;
			}
			y = y + h + d;
		}
		mniStandard.setIcon(iselect);
		this.add(panStandard);
		Mode(1);
		//special button
		btnStandard[4][4].setSize(w,2*h+d);
		btnStandard[5][0].setSize(w*2+d,h);
		btnStandard[5][1].setLocation(w*2+d*2,y-h-d);
		btnStandard[5][2].setLocation(w*3+d*3,y-h-d);
		btnStandard[5][3].setVisible(false);
		btnStandard[5][4].setVisible(false);
	}
	public void initComponent2() {
		panScientific.setLayout(null);	
		//add button group
		btnG.add(radD);
		btnG.add(radR);
		btnG.add(radG);
		add(radD);
		add(radR);
		add(radG);
		radD.setBounds(5, 100, 80, 50);
		radR.setBounds(90, 100, 80, 50);
		radG.setBounds(170,100, 80, 50);
		
		
	String[][] sScientific = {{"","Inv","In","(",")"},
			{"Int","sinh","sin","x^2","n!"},
			{"dms","cosh","cos","x^y","x^1/y"},
			{"PI","tanh","tan","x^3","x^1/3"},
			{"F-E","Exp","Mod","log","10^x"}
	};
	y=0;
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
	
		Mode(2);
		//special button
	}
	public void initComponent3() {
		panProgammer.setLayout(null);	
	String[][] sProgrammer = {{"","Inv","In","(",")"},
			{"Int","sinh","sin","x^2","n!"},
			{"dms","cosh","cos","x^y","x^1/y"},
			{"PI","tanh","tan","x^3","x^1/3"},
			{"F-E","Exp","Mod","log","10^x"}
	};
	y=0;
	for (int i = 0; i < 5; i++) {
		x = 0;
		for (int j = 0; j < 5; j++) {
			btnProgrammer[i][j] = new JButton(sProgrammer[i][j]);
			panProgammer.add(btnScientific[i][j]);
			btnProgrammer[i][j].setBounds(x, y, w, h);
			btnProgrammer[i][j].setMargin(isMargin);
			x = x + w + d;
		}
		y = y + h + d;
	}
		this.add(panProgammer);
	
		Mode(3);
		//special button
	}


	public void Mode(int mode) {
		if (mode == 1) {
			panStandard.setVisible(true);
			panScientific.setVisible(false);
			panProgammer.setVisible(false);
			panStandard.setBounds(5, 100, x + w, y + h);
			this.setSize(255,455);
			txaContent.setBounds(5,0,240,90);
			
		}else if(mode == 2){
			panStandard.setVisible(true);
			panScientific.setVisible(true);
			panProgammer.setVisible(false);
			panScientific.setBounds(5, 150,x + w, y + h);
			panStandard.setBounds(255, 100, x + w, y + h);
			txaContent.setBounds(5,0,500,90);
			this.setSize(520,455);
		
			
		}else if(mode ==3){
			panStandard.setVisible(true);
			panScientific.setVisible(false);
			panProgammer.setVisible(true);
			panProgammer.setBounds(5, 100, x + w, y + h);
			this.setSize(5*w+4*d+30,6*h+4*d+150);
			txaContent.setBounds(x+30, y+30, w+100, h);
			//mniProgrammer.setIcon(iselect);
		}
	}
	public void ExitAp(){
		int result = JOptionPane.showConfirmDialog(null, "Are you sure ?","comfirm",JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

	// special button

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculator main = new  calculator();
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		main.setVisible(true);
	}

}
