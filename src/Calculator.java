import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener  {

	JFrame frame;
	JTextField textfield;
	
	//array of number buttons
	JButton[] numberButtons = new JButton[10];
	
	// array of function buttons - *, -, Delete etc
	JButton[] functionButtons = new JButton[8];
	JButton addButton,subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		
		// frame
		frame = new JFrame("Calculator"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		//textfield
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50); // x coordinate, y cord, width, height
		textfield.setFont(myFont);
		textfield.setEditable(false); // this ensures user cannot edit the textfield top of JFrame (Calculator);
		
		//buttons for frame
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		
		// add buttons to array 
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		
		
		//loop through buttons to do a few things with function buttons
		for(int i=0; i<8; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false); // gets rid of outline around the buttons - esthetic
		}
		
		// number buttons
		for(int i=0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i)); // converts int value to string 
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false); // gets rid of outline around the buttons - esthetic
		}
		
		// set bounds of del and clr buttons - x, y, width, height 
		
		delButton.setBounds(50, 430, 145, 50);
		clrButton.setBounds(205, 430, 145, 50);
		
		
		
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield); // add textfield to JFrame
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
	
	Calculator calc = new Calculator();
	
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}