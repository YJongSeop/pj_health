import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class DateData {
	Calendar today = Calendar.getInstance();
	int calYear = today.get(Calendar.YEAR); 
	int calMonth = today.get(Calendar.MONTH);
	int calDayOfMon = today.get(Calendar.DAY_OF_MONTH);
}

public class main_home extends JFrame {
	JPanel myPanel = new JPanel();
	//날짜 데이터 불러오는 객체 생성
	DateData dd = new DateData();
	
	//하단 알림문
	JLabel bottomInfo = new JLabel("건강 도우미에 오신것을 환영합니다!");
	
	//오늘의 날짜 표시
	SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");
	String todate = formatter.format(new Date());
	
	//종합 메뉴 컨트롤
	MyActionListener action = new MyActionListener();
	
	//달력 인스턴스 호출
	Calendar today = Calendar.getInstance();
	
	//전역 선언
	JLabel infoClock;
	static JLabel UserInfo;
	JTextArea textArea1;
	JTextArea textArea2;
	JTextArea textArea3;
	
	static String[] info = null;
	static String str = null;
	
	public static void main(String[] args) {
		LoadUserInfo();
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new main_home();
			}
		});
	}
	
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
		mnMenu_Info_2.addActionListener(action);
		mnMenu_Info.add(mnMenu_Info_2);
		
		JMenu mnMenu_Info2 = new JMenu("영양소");
		mnMenu.add(mnMenu_Info2);
		
		JMenuItem mnMenu_Nut = new JMenuItem("측정");
		mnMenu_Info2.add(mnMenu_Nut);
		mnMenu_Nut.addActionListener(action);
		
		JMenuItem mnMenu_NutInfo = new JMenuItem("정보");
		mnMenu_Info2.add(mnMenu_NutInfo);
		mnMenu_NutInfo.addActionListener(action);
		
		JMenuItem mnMenu_Calender = new JMenuItem("달력");
		mnMenu_Calender.addActionListener(action);
		
		JMenuItem mnMenu_BMICalculator = new JMenuItem("BMI 계산기");
		mnMenu.add(mnMenu_BMICalculator);
		mnMenu.add(mnMenu_Calender);
		mnMenu_BMICalculator.addActionListener(action);
		myPanel.setLayout(null);
		
		JLabel lb_Today = new JLabel("Today : ");
		lb_Today.setBounds(12, 12, 61, 18);
		myPanel.add(lb_Today);
		
		JLabel lb_Today_Value = new JLabel();
		lb_Today_Value.setToolTipText("현재 시간");
		lb_Today_Value.setBounds(63, 12, 70, 18);
		myPanel.add(lb_Today_Value);
		lb_Today_Value.setText(todate);
		
		JLabel bottomInfo = new JLabel("건강 도우미에 오신것을 환영합니다!");
		bottomInfo.setHorizontalAlignment(SwingConstants.CENTER);
		bottomInfo.setBounds(12, 267, 580, 18);
		myPanel.add(bottomInfo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 42, 170, 2);
		myPanel.add(separator);
		
		JPanel panel_todayDiet = new JPanel();
		panel_todayDiet.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Today Diet", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_todayDiet.setBounds(12, 49, 170, 206);
		myPanel.add(panel_todayDiet);
		panel_todayDiet.setLayout(null);
		
		textArea1 = new JTextArea();
		textArea1.setEditable(false);
		textArea1.setWrapStyleWord(true);
		textArea1.setLineWrap(true);
		textArea1.setBounds(3, 17, 145, 186);
		panel_todayDiet.add(textArea1);
		
		JScrollPane scrollPane1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setBounds(3, 18, 164, 185);
		panel_todayDiet.add(scrollPane1);
		
		JPanel panel_todayPlan = new JPanel();
		panel_todayPlan.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Today Plan", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_todayPlan.setBounds(194, 49, 216, 206);
		myPanel.add(panel_todayPlan);
		panel_todayPlan.setLayout(null);
		
	    textArea2 = new JTextArea();
	    textArea2.setEditable(false);
		textArea2.setWrapStyleWord(true);
		textArea2.setLineWrap(true);
		textArea2.setBounds(3, 15, 190, 188);
		panel_todayPlan.add(textArea2);
		
		JScrollPane scrollPane2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(4, 18, 209, 185);
		panel_todayPlan.add(scrollPane2);
		
		JPanel panel_todayMemo = new JPanel();
		panel_todayMemo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Today Memo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_todayMemo.setBounds(422, 49, 170, 206);
		myPanel.add(panel_todayMemo);
		panel_todayMemo.setLayout(null);
		
		textArea3 = new JTextArea();
		textArea3.setEditable(false);
		textArea3.setWrapStyleWord(true);
		textArea3.setLineWrap(true);
		textArea3.setBounds(3, 18, 144, 185);
		panel_todayMemo.add(textArea3);
		
		JScrollPane scrollPane3 = new JScrollPane(textArea3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane3.setBounds(4, 19, 165, 184);
		panel_todayMemo.add(scrollPane3);
		
		infoClock = new JLabel("");
		infoClock.setBounds(134, 12, 77, 18);
		myPanel.add(infoClock);
		
		JButton btReload = new JButton("Reload");
		btReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "내용을 다시 불러왔습니다.", "알림", JOptionPane.INFORMATION_MESSAGE, null);
				CheckMainMethod();
				CheckUser();
			}
		});
		btReload.setBounds(515, 12, 77, 23);
		myPanel.add(btReload);
		
		UserInfo = new JLabel("사용자 :");
		UserInfo.setBounds(422, 12, 87, 18);
		myPanel.add(UserInfo);
		CheckUser();
		
		ThreadControl threadCnl = new ThreadControl(); //스레드 시작, 현재 시간 표시
		threadCnl.start();
		
		CheckMainMethod();
	}
	
	//메인의 세개에 패널에 붙어있는 TextArea에 내용을 쏘기위한 파일의 유무 체크
	//없을 경우에는 내용이 없음을 표시해준다.
	private void CheckMainMethod() {
		try {
		File f1 = new File("MemoData/"+dd.calYear+((dd.calMonth+1)<10?"0":"")+(dd.calMonth+1)+
								 (dd.calDayOfMon<10?"0":"")+dd.calDayOfMon+"Type1"+".txt");
		if(f1.exists()){
			BufferedReader in = new BufferedReader(new FileReader("MemoData/"+dd.calYear+((dd.calMonth+1)<10?"0":"")+(dd.calMonth+1)+(dd.calDayOfMon<10?"0":"")+dd.calDayOfMon+"Type1"+".txt"));
			String memoAreaText= new String();
			while(true){
				String tempStr = in.readLine();
				if(tempStr == null) break;
				memoAreaText = memoAreaText + tempStr + System.getProperty("line.separator");
			}
			textArea1.setText(memoAreaText);
			in.close();	
		}
		else textArea1.setText("저장된 식단이 없습니다.");
		File f2 = new File("MemoData/"+dd.calYear+((dd.calMonth+1)<10?"0":"")+(dd.calMonth+1)+
								 (dd.calDayOfMon<10?"0":"")+dd.calDayOfMon+"Type2"+".txt");
		if(f2.exists()){
			BufferedReader in = new BufferedReader(new FileReader("MemoData/"+dd.calYear+((dd.calMonth+1)<10?"0":"")+(dd.calMonth+1)+(dd.calDayOfMon<10?"0":"")+dd.calDayOfMon+"Type2"+".txt"));
			String memoAreaText= new String();
			while(true){
				String tempStr = in.readLine();
				if(tempStr == null) break;
				memoAreaText = memoAreaText + tempStr + System.getProperty("line.separator");
			}
			textArea2.setText(memoAreaText);
			in.close();	
		}
		else textArea2.setText("저장된 계획에 없습니다.");
		File f3 = new File("MemoData/"+dd.calYear+((dd.calMonth+1)<10?"0":"")+(dd.calMonth+1)+
								 (dd.calDayOfMon<10?"0":"")+dd.calDayOfMon+"Type3"+".txt");
		if(f3.exists()){
			BufferedReader in = new BufferedReader(new FileReader("MemoData/"+dd.calYear+((dd.calMonth+1)<10?"0":"")+(dd.calMonth+1)+(dd.calDayOfMon<10?"0":"")+dd.calDayOfMon+"Type3"+".txt"));
			String memoAreaText= new String();
			while(true){
				String tempStr = in.readLine();
				if(tempStr == null) break;
				memoAreaText = memoAreaText + tempStr + System.getProperty("line.separator");
			}
			textArea3.setText(memoAreaText);
			in.close();	
		}
		else textArea3.setText("저장된 메모가 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void LoadUserInfo() {

		try {
			File f = new File("Users.txt");
			if(f.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader("Users.txt"));
				
				String line = "";
				
				while((line = reader.readLine()) != null) {
					info = line.split("\n");
				
					for(int i = 0; i < info.length; i++) {
						info[i] = info[i].trim();
						str= info[i];
					}
				}
			} else {
				int result = JOptionPane.showConfirmDialog(null, "데이터가 없습니다. 가입서를 작성해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
				UserInfo.setText("사용자 : Guest");
				if(JOptionPane.YES_OPTION == 0) {
					SwingUtilities.invokeLater(new Runnable(){
						public void run(){
							new sign_form();
						}
					});
				}
				else if (result == 2) System.exit(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void CheckUser() {
		try {
			File f = new File("Users.txt");
			if(f.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader("Users.txt"));
				
				String line = "";
				
				while((line = reader.readLine()) != null) {
					info = line.split("\n");
				
					for(int i = 0; i < info.length; i++) {
						info[i] = info[i].trim();
						str= info[i];
					}
				}
				reader.close();
				
				String[] result = str.split(",");
				UserInfo.setText("사용자 : " + result[0]);
			} else UserInfo.setText("사용자 : Guest");
		}catch(IOException e) {
					e.printStackTrace();
		}
	}
	
	
	class MyActionListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JMenuItem it = (JMenuItem)e.getSource();
			if(it.getText().equals("달력")) {
				new Calender();
			}
			if(it.getText().equals("개인정보 확인")) {
				new sign_form_readonly();
			}
			if(it.getText().equals("개인정보 수정")) {
				new sign_form_modify();
			}
			if(it.getText().equals("BMI 계산기")) {
				new BMICalculator();					
			}
			if(it.getText().equals("정보")) {
				new NutrientDB();
			}
			if(it.getText().equals("측정")) {
				new NutrientProc();
			}
		}
	}
	
	private class ThreadControl extends Thread {
		public void run () {
			while(true) {
				try {
					today = Calendar.getInstance();
					String amPm = (today.get(Calendar.AM_PM)==0?"AM":"PM");
					String hour;
					if(today.get(Calendar.HOUR) == 0) hour = "12"; 
						else if(today.get(Calendar.HOUR) == 12) hour = " 0";
					else hour = (today.get(Calendar.HOUR)<10?" ":"")+today.get(Calendar.HOUR);
					String min = (today.get(Calendar.MINUTE)<10?"0":"")+today.get(Calendar.MINUTE);
					String sec = (today.get(Calendar.SECOND)<10?"0":"")+today.get(Calendar.SECOND);
					infoClock.setText(amPm+" "+hour+":"+min+":"+sec);
					
					sleep(1000);
				} catch (InterruptedException e) {
					System.out.print("Thread : error");
				}
			}
		}
	}
}
