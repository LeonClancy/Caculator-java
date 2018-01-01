import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Caculator3 extends JFrame implements ActionListener {

	private JTextField text;
	private String output = "";
	static boolean firstFlag = true;
	static boolean secondFlag = false;
	static int len = 0;
	static float op1 = 0;
	static float op2 = 0;
	static String opp = "";private JTextField text;
	private String output = "";
	static boolean firstFlag = true;
	static boolean secondFlag = false;
	static int len = 0;
	static float op1 = 0;
	static float op2 = 0;
	static String opp = "";

	String str[] = { "Inf", "00","del", "C", "7", "8", "9", "/", "4", "5", "6",
			"x", "1", "2", "3", "-", "0", ".", "=", "+" };

	public Caculator3() {
		super("Simple Caculator"); 

		Container c = this.getContentPane();
		BorderLayout borderLayout = (BorderLayout) c.getLayout();
		borderLayout.setHgap(40);
		borderLayout.setVgap(20);

		c.setLayout(borderLayout);

		text = new JTextField();
		text.setHorizontalAlignment(SwingConstants.TRAILING);
		text.setPreferredSize(new Dimension(12, 50));
		text.setColumns(10);
		text.setEditable(false);
		// c.add(text, BorderLayout.NORTH

		JPanel table = new JPanel();
		table.setLayout(new GridLayout(5, 4, 5, 5));
		table.setBackground(Color.pink);
		setLayout(new BorderLayout());

		for (int i = 0; i < str.length; i++) {
			JButton button = new JButton(str[i]);
			button.addActionListener(this);
			table.add(button);
		}
		
		c.add(text, BorderLayout.NORTH);
		c.add(table, BorderLayout.CENTER);
		
		setSize(242,304);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// this.setResizable(false);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()=="1" ||   
           e.getActionCommand()=="2" ||   
           e.getActionCommand()=="3" ||   
           e.getActionCommand()=="4" ||   
           e.getActionCommand()=="5" ||   
           e.getActionCommand()=="6" ||   
           e.getActionCommand()=="7" ||   
           e.getActionCommand()=="8" ||   
           e.getActionCommand()=="9" ||   
           e.getActionCommand()=="0" ||   
           e.getActionCommand()=="00" ||   
           e.getActionCommand()==".") {
			output += e.getActionCommand();
			text.setText(output);
		}
		
		if (firstFlag && 
			  (e.getActionCommand() == "+" ||   
		       e.getActionCommand() == "-" ||   
		       e.getActionCommand() == "x" ||   
		       e.getActionCommand() == "/")) {
			op1 = Float.parseFloat(text.getText());   
            len = text.getText().length();   
            opp = e.getActionCommand();   
            output += e.getActionCommand();   
            text.setText(output);
            firstFlag = false;
            secondFlag = true;
		}
		
		if (secondFlag && e.getActionCommand()=="=") {
			op2 = Float.parseFloat(text.getText().substring(len+1));  
			switch (opp) {
			case "+": add(); 		break;
			case "-": minus(); 		break;
			case "x": mutiply(); 	break;
			case "/": divide();		break;
			}
			text.setText(output);
			op1 = Float.parseFloat(output);
			firstFlag = true;
			secondFlag = false;
		}
		
		if (e.getActionCommand()=="C") {
			output = "";
			text.setText(output);
			firstFlag = true;
			secondFlag = false;
			len = 0;
			op1 = 0;
			op2 = 0;
			opp = "";
		}
		
		if (e.getActionCommand()=="del") {
			String content = text.getText();
            int remain = content.length(); 
            String last = content.substring(remain-1);
            if (last.equals("+") ||
            	last.equals("-") ||
            	last.equals("x") ||
            	last.equals("/")) {
            	firstFlag = true;
    			secondFlag = false;
    			len = 0;
    			op1 = 0;
    			op2 = 0;
    			opp = "";
            }
			output = output.substring(0, remain-1);
			text.setText(output);
		}
		
		if (e.getActionCommand()=="Inf") {
			output = "XDD Caculator";
			text.setText(output);
		}
	}
	
	public void add() {
		output = (op1 + op2)+"";
	}
	public void minus() {
		output = (op1 - op2)+"";
	}
	public void mutiply() {
		output = (op1 * op2)+"";
	}
	public void divide() {
		output = (op1 / op2)+"";
	}

	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		Caculator3 caculator = new Caculator3();
	}
}
