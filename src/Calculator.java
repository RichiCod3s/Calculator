import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener  {

	JFrame frame;
	JTextField textfield;
	
	//array of number buttons
	JButton[] numberButtons = new JButton[10];
	
	// array of function buttons - *, -, Delete etc
	JButton[] functionButtons = new JButton[9];
	JButton addButton,subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
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
	    negButton = new JButton("(-)");
		
		// add buttons to array 
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		
		//loop through buttons to do a few things with function buttons
		for(int i=0; i<9; i++) {
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
		delButton.setBounds(130, 430, 125, 50);
		clrButton.setBounds(250, 430, 104, 50);
		negButton.setBounds(50, 430, 80, 50);
		
		//panel
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10)); // rows, columns, hgap, vgap - making a grid layout
		
		// add function and number buttons to panel
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		
		//adding to frame
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(negButton);
		frame.add(textfield); // add textfield to JFrame
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
	
	Calculator calc = new Calculator();
	
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// add functionality to buttons
		for(int i = 0; i< 10; i++) {
			if(e.getSource() == numberButtons[i]) { // identify which number button was pressed
				textfield.setText(textfield.getText().concat(String.valueOf(i))); // writes text(number/ variable i) to the text field and concats(adds)each number
			}
		}
		
		// decimal
		if(e.getSource()== decButton) {
			textfield.setText(textfield.getText().concat(".")); 
		}
		
		// operators
		// assign string (parse it) to num1 after operator is pressed
		if(e.getSource()== addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		
		if(e.getSource()== subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		
		if(e.getSource()== mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		
		if(e.getSource()== divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		// assign string to num 2 after = button pressed
		// Perform calculation 
		if(e.getSource()== equButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			// calculation
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
				
			case '-':
				result = num1 - num2;
				break;
			
			case '*':
				result = num1 * num2;
				break;
				
			case '/':
				result = num1 / num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		
		// clear and delete buttons
		
		if(e.getSource()== clrButton) {
			textfield.setText(""); // clears the text
		}
		
		
		if(e.getSource() == delButton) {
		    String string = textfield.getText(); // Get the current content of the text field
		    textfield.setText(""); // Clear the text field

		    // Iterate through the characters in the string, except the last one
		    for (int i = 0; i < string.length() - 1; i++) {
		        // Append each character to the text field, effectively omitting the last character
		        textfield.setText(textfield.getText() + string.charAt(i));
		    }
		}
		

		if(e.getSource() == negButton) {
		 double temp = Double.parseDouble(textfield.getText()); // take what's in the textfield and assign to temp.
		 temp *= -1;  // make negative
		 textfield.setText(String.valueOf(temp)); // assign negative number to textfield.
		    }
		
		
	}
}