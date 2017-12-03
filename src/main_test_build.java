import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.*;
import javax.swing.event.*;
import java.text.*;
import java.util.*;

public class main_test_build extends JFrame{
	private JPanel myPanel = new JPanel();
	private MyActionListener action = new MyActionListener();
	
	Date d = new Date();
	String s = d.toString();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_test_build frame = new main_test_build();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public main_test_build() {
		setTitle("\uAC74\uAC15 \uB3C4\uC6B0\uBBF8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 365);
		setContentPane(myPanel);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("\uBA54\uB274");
		menuBar.add(mnMenu);
		
		JMenu mnMenu_Info = new JMenu("\uAC1C\uC778\uC815\uBCF4");
		mnMenu.add(mnMenu_Info);
		
		JMenuItem mnMenu_Info_1 = new JMenuItem("\uAC1C\uC778\uC815\uBCF4 \uD655\uC778");
		mnMenu_Info.add(mnMenu_Info_1);
		
		JMenuItem mnMenu_Info_2 = new JMenuItem("\uAC1C\uC778\uC815\uBCF4 \uC218\uC815");
		mnMenu_Info.add(mnMenu_Info_2);
		
		JMenuItem mnMenu_Info_3 = new JMenuItem("\uCD94\uAC00 \uB370\uC774\uD130 \uC0BD\uC785");
		mnMenu_Info.add(mnMenu_Info_3);
		
		JMenuItem mnMenu_TodayDiet = new JMenuItem("\uC624\uB298\uC758 \uC2DD\uB2E8");
		mnMenu.add(mnMenu_TodayDiet);
		
		JMenuItem mnMenu_Calender = new JMenuItem("\uB2EC\uB825");
		mnMenu_Calender.addActionListener(action);
		mnMenu.add(mnMenu_Calender);
		
		JLabel lb_Today = new JLabel("Today : ");
		lb_Today.setBounds(12, 12, 55, 18);
		myPanel.add(lb_Today);
		
		JLabel lb_Today_Value = new JLabel("");
		lb_Today_Value.setBounds(79, 12, 150, 18);
		myPanel.add(lb_Today_Value);
	}
	
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			JMenuItem mit = (JMenuItem)e.getSource();
			
			if(mit.getText().equals("ดÞทย")) {
				new Calender();
			}
		}
	}
}

