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
	
	JLabel bottomInfo = new JLabel("건강 도우미에 오신것을 환영합니다!");
	
	//기능별 스레드 호출
	Calender_th cal = new Calender_th();
	sign_form_th sign = new sign_form_th();
	BMICalculator_th Bmi = new BMICalculator_th();
	
	//오늘의 날짜 표시
	SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String todate = formatter.format(new Date());
	
	public main_home() {
		
		try{
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //LookAndFeel Windows 스타일 적용
			SwingUtilities.updateComponentTreeUI(myPanel) ;
		}catch(Exception e){
			bottomInfo.setText("ERROR : LookAndFeel setting failed");
		}
		
		setTitle("건강 도우미");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 365);
		setVisible(true);
		setContentPane(myPanel);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("메뉴");
		menuBar.add(mnMenu);
		
		JMenu mnMenu_Info = new JMenu("개인정보");
		mnMenu.add(mnMenu_Info);
		
		JMenuItem mnMenu_Info_1 = new JMenuItem("개인정보 확인");
		mnMenu_Info_1.addActionListener(action);
		mnMenu_Info.add(mnMenu_Info_1);
		
		JMenuItem mnMenu_Info_2 = new JMenuItem("개인정보 수정");
		mnMenu_Info.add(mnMenu_Info_2);
		
		JMenuItem mnMenu_Info_3 = new JMenuItem("추가 데이터 입력");
		mnMenu_Info.add(mnMenu_Info_3);
		
		JMenu mnMenu_Info2 = new JMenu("\uC601\uC591\uC18C");
		mnMenu.add(mnMenu_Info2);
		
		JMenuItem mnMenu_Nut = new JMenuItem("\uCE21\uC815");
		mnMenu_Info2.add(mnMenu_Nut);
		
		JMenuItem mnMenu_NutInfo = new JMenuItem("\uC815\uBCF4");
		mnMenu_Info2.add(mnMenu_NutInfo);
		
		JMenuItem mnMenu_TodayDiet = new JMenuItem("식단");
		mnMenu.add(mnMenu_TodayDiet);
		
		JMenuItem mnMenu_Calender = new JMenuItem("달력");
		mnMenu_Calender.addActionListener(action);
		
		JMenuItem mnMenu_BMICalculator = new JMenuItem("BMI \uACC4\uC0B0\uAE30");
		mnMenu.add(mnMenu_BMICalculator);
		mnMenu.add(mnMenu_Calender);
		myPanel.setLayout(null);
		
		JLabel lb_Today = new JLabel("Today : ");
		lb_Today.setBounds(12, 12, 61, 18);
		myPanel.add(lb_Today);
		
		JLabel lb_Today_Value = new JLabel();
		lb_Today_Value.setToolTipText("현재 시간");
		lb_Today_Value.setBounds(63, 12, 115, 18);
		myPanel.add(lb_Today_Value);
		lb_Today_Value.setText(todate);
		
		JLabel bottomInfo = new JLabel("건강 도우미에 오신것을 환영합니다!");
		bottomInfo.setHorizontalAlignment(SwingConstants.CENTER);
		bottomInfo.setBounds(12, 281, 580, 18);
		myPanel.add(bottomInfo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 42, 170, 2);
		myPanel.add(separator);
		
		JPanel panel_todayDiet = new JPanel();
		panel_todayDiet.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Today Diet", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_todayDiet.setBounds(12, 49, 170, 206);
		myPanel.add(panel_todayDiet);
		panel_todayDiet.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(3, 17, 164, 186);
		panel_todayDiet.add(textArea);
		
		JPanel panel_todayPlan = new JPanel();
		panel_todayPlan.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Today Plan", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_todayPlan.setBounds(194, 49, 216, 206);
		myPanel.add(panel_todayPlan);
		panel_todayPlan.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEnabled(false);
		textArea_1.setEditable(false);
		textArea_1.setBounds(3, 17, 210, 185);
		panel_todayPlan.add(textArea_1);
		
		JPanel panel_todayMemo = new JPanel();
		panel_todayMemo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Today Memo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_todayMemo.setBounds(422, 49, 170, 206);
		myPanel.add(panel_todayMemo);
		panel_todayMemo.setLayout(null);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEnabled(false);
		textArea_2.setEditable(false);
		textArea_2.setBounds(3, 18, 164, 185);
		panel_todayMemo.add(textArea_2);
		
	}
	
	class MyActionListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JMenuItem it = (JMenuItem)e.getSource();
			
			if(it.getText().equals("달력")) {
				cal.run();
			}
			
			if(it.getText().equals("개인정보 확인")) {
				sign.run();
			}
			
			if(it.getText().equals("BMI 계산기")) {
				Bmi.run();
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new main_home();
			}
		});
	}
}
