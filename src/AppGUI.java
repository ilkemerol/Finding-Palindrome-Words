import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AppGUI extends JFrame{
	private static int WIDTH = 600;
	private static int HEIGTH = 400;
	
	JPanel appPanel = new JPanel();
	JLabel headLine;
	JLabel outputHeadLine;
	JLabel logo;
	Icon accenture;
	JButton startoperation;
	JTextArea inputArea;
	JTextArea outputArea;
	
	public AppGUI(String Header){
		//GUI Begin
		super(Header);
		setLayout(new BorderLayout());
		setBounds(0, 0, WIDTH, HEIGTH);
		
		JMenuBar menubar = new JMenuBar();
		JMenu File = new JMenu("FILE");
		menubar.add(File);
		JMenuItem ResetGUI = new JMenuItem("Reset Current GUI");
		JMenuItem Info = new JMenuItem("Information and Guide");
		JMenuItem Exit = new JMenuItem("Exit");
		File.add(ResetGUI);
		File.add(Info);
		File.add(Exit);
		setJMenuBar(menubar);
		
		headLine = new JLabel("Please Enter the Word in the Box");
		headLine.setForeground(Color.WHITE);
		headLine.setBounds(10, 10, 300, 15);
		
		inputArea = new JTextArea();
		JScrollPane ScrollInput = new JScrollPane(inputArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ScrollInput.setBounds(10, 30, 570, 75);
		
		startoperation = new JButton(">>");
		startoperation.setBounds(15, 150, 50, 25);
		
		outputHeadLine = new JLabel("Result");
		outputHeadLine.setForeground(Color.WHITE);
		outputHeadLine.setBounds(10, 230, 300, 15);
		
		outputArea = new JTextArea();
		outputArea.setEditable(false);
		JScrollPane ScrollOutput = new JScrollPane(outputArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ScrollOutput.setBounds(10, 250, 570, 75);
		
		
		
		appPanel.setLayout(null);
		appPanel.setBackground(Color.darkGray);
		appPanel.add(headLine);
		appPanel.add(ScrollInput);
		appPanel.add(startoperation);
		appPanel.add(outputHeadLine);
		appPanel.add(ScrollOutput);
		
		Listener list = new Listener();
		startoperation.addActionListener(list);
		ResetGUI.addActionListener(list);
		Info.addActionListener(list);
		Exit.addActionListener(list);
		
		add(appPanel);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		//GUI End
	}
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent click){
			if(click.getActionCommand() == "Reset Current GUI"){
				inputArea.setText("");
				outputArea.setText("");
			}
			if(click.getActionCommand() == "Information and Guide"){
				JOptionPane.showMessageDialog(appPanel, "NULL", "Error!", JOptionPane.INFORMATION_MESSAGE);
			}
			if(click.getActionCommand() == "Exit"){
				System.exit(0);
			}
			if(click.getActionCommand() == ">>"){
				String input = inputArea.getText();
				if(input.length() == 0 || input.length() == 1){
					JOptionPane.showMessageDialog(appPanel, "Sorry! Please, Write at least two word. Because, every single word is palindrome :)", "Error!", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					String[] splitStr = null;
					splitStr = input.split(" |\n");
					for(int i=0; i<splitStr.length; i++){
						String sendStr = splitStr[i];
						PalindromeChecker obj = new PalindromeChecker(sendStr);
						outputArea.append(sendStr + "--> " + obj.operation() + "\n");
					}
					
				}
			}
		}
	}
	public static void main(String args[]){
		new AppGUI("Accenture Project");
	}
}