import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.*;
import javax.swing.event.*;
import java.text.*;
import java.util.*;

class mainFunction {
}

class Calender_th extends Thread {
	public void run() {
		new Calender();
	}
}
class sign_form_th extends Thread {
	public void run() {
		new sign_form();
	}
}
class BMICalculator_th extends Thread {
	public void run() {
		new BMICalculator();
	}
}

public class main_home extends JFrame {
	JPanel myPanel = new JPanel();
	
	MyActionListener action = new MyActionListener();
	
	JLabel bottomInfo = new JLabel("�ǰ� ����̿� ���Ű��� ȯ���մϴ�!");
	
	//��ɺ� ������ ȣ��
	Calender_th cal = new Calender_th();
	sign_form_th sign = new sign_form_th();
	BMICalculator_th Bmi = new BMICalculator_th();
	
	//������ ��¥ ǥ��
	SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String todate = formatter.format(new Date());
	
	public main_home() {
		
		try{
			//UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //LookAndFeel Windows ��Ÿ�� ����
			//SwingUtilities.updateComponentTreeUI(mainFrame) ;
		}catch(Exception e){
			bottomInfo.setText("ERROR : LookAndFeel setting failed");
		}
		
		setTitle("�ǰ� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 365);
		setVisible(true);
		setContentPane(myPanel);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("�޴�");
		menuBar.add(mnMenu);
		
		JMenu mnMenu_Info = new JMenu("��������");
		mnMenu.add(mnMenu_Info);
		
		JMenuItem mnMenu_Info_1 = new JMenuItem("�������� Ȯ��");
		mnMenu_Info_1.addActionListener(action);
		mnMenu_Info.add(mnMenu_Info_1);
		
		JMenuItem mnMenu_Info_2 = new JMenuItem("�������� ����");
		mnMenu_Info.add(mnMenu_Info_2);
		
		JMenuItem mnMenu_Info_3 = new JMenuItem("�߰� ������ �Է�");
		mnMenu_Info.add(mnMenu_Info_3);
		
		JMenu mnMenu_Info2 = new JMenu("\uC601\uC591\uC18C");
		mnMenu.add(mnMenu_Info2);
		
		JMenuItem mnMenu_Nut = new JMenuItem("\uCE21\uC815");
		mnMenu_Info2.add(mnMenu_Nut);
		
		JMenuItem mnMenu_NutInfo = new JMenuItem("\uC815\uBCF4");
		mnMenu_Info2.add(mnMenu_NutInfo);
		
		JMenuItem mnMenu_TodayDiet = new JMenuItem("�Ĵ�");
		mnMenu.add(mnMenu_TodayDiet);
		
		JMenuItem mnMenu_Calender = new JMenuItem("�޷�");
		mnMenu_Calender.addActionListener(action);
		
		JMenuItem mnMenu_BMICalculator = new JMenuItem("BMI \uACC4\uC0B0\uAE30");
		mnMenu.add(mnMenu_BMICalculator);
		mnMenu.add(mnMenu_Calender);
		myPanel.setLayout(null);
		
		JLabel lb_Today = new JLabel("Today : ");
		lb_Today.setBounds(12, 12, 43, 18);
		myPanel.add(lb_Today);
		
		JLabel lb_Today_Value = new JLabel();
		lb_Today_Value.setToolTipText("���� �ð�");
		lb_Today_Value.setBounds(67, 12, 115, 18);
		myPanel.add(lb_Today_Value);
		lb_Today_Value.setText(todate);
		
		JLabel bottomInfo = new JLabel("�ǰ� ����̿� ���Ű��� ȯ���մϴ�!");
		bottomInfo.setHorizontalAlignment(SwingConstants.CENTER);
		bottomInfo.setBounds(12, 281, 580, 18);
		myPanel.add(bottomInfo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 42, 170, 2);
		myPanel.add(separator);
		
		JPanel panel_todayDiet = new JPanel();
		panel_todayDiet.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uC624\uB298\uC758 \uC2DD\uB2E8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_todayDiet.setBounds(12, 49, 170, 206);
		myPanel.add(panel_todayDiet);
		
	}
	
	class MyActionListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JMenuItem it = (JMenuItem)e.getSource();
			
			if(it.getText().equals("�޷�")) {
				cal.run();
			}
			
			if(it.getText().equals("�������� Ȯ��")) {
				sign.run();
			}
			
			if(it.getText().equals("BMI ����")) {
				Bmi.run();
			}
		}
	}
	
	public static void main(String[] args) {
		new main_home();
	}
}
