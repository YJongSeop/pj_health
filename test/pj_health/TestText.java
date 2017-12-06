package pj_health;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

class DataManager {
	int calYear;
	int calMonth;
	int calDayOfMon;
	Calendar today = Calendar.getInstance();
	
	public void setToday() {
		calYear = today.get(Calendar.YEAR);
		calMonth = today.get(Calendar.MONTH);
		calDayOfMon = today.get(Calendar.DAY_OF_MONTH);
	}
}
public class TestText extends JFrame {
	JLabel lbLabelStatus;
	JLabel RadioStatus;
	JTextArea	textArea;
	JButton	btClear;
	JButton btSave;
	JButton btDelete;
	JRadioButton rbRadio1;
	JRadioButton rbRadio2;
	JRadioButton rbRadio3;
	JScrollPane scrollPane;

	int CheckSum;
	
	DataManager dm = new DataManager();
	
	BtnActionListener btnlis = new BtnActionListener();
	SelectItemListener sellis = new SelectItemListener();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	TestText() {
		setSize(648,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("텍스트 편집기 실험작");
		getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 10, 448, 306);
		getContentPane().add(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		lbLabelStatus = new JLabel("Welcome!");
		lbLabelStatus.setBounds(358, 328, 250, 26);
		getContentPane().add(lbLabelStatus);
		
		btClear = new JButton("\uCD08\uAE30\uD654");
		btClear.setBounds(22, 326, 98, 28);
		getContentPane().add(btClear);
		btClear.addActionListener(btnlis);
		
		btSave = new JButton("\uC800\uC7A5\uD55C\uB2E4");
		btSave.setBounds(132, 326, 98, 28);
		getContentPane().add(btSave);
		btSave.addActionListener(btnlis);
		
		btDelete = new JButton("\uC9C0\uC6B4\uB2E4");
		btDelete.setBounds(242, 326, 98, 28);
		getContentPane().add(btDelete);
		btDelete.addActionListener(btnlis);
		
		rbRadio1 = new JRadioButton("\uC2DD\uB2E8");
		buttonGroup.add(rbRadio1);
		rbRadio1.setBounds(487, 6, 121, 26);
		getContentPane().add(rbRadio1);
		rbRadio1.addItemListener(sellis);
		
		rbRadio2 = new JRadioButton("\uACC4\uD68D");
		buttonGroup.add(rbRadio2);
		rbRadio2.setBounds(487, 34, 121, 26);
		getContentPane().add(rbRadio2);
		rbRadio2.addItemListener(sellis);
		
		rbRadio3 = new JRadioButton("\uD14C\uC2A4\uD2B8");
		buttonGroup.add(rbRadio3);
		rbRadio3.setBounds(487, 62, 121, 26);
		getContentPane().add(rbRadio3);
		rbRadio3.addItemListener(sellis);
		
		RadioStatus = new JLabel("\uC120\uD0DD\uB41C \uC0C1\uD0DC");
		RadioStatus.setBounds(487, 96, 121, 18);
		getContentPane().add(RadioStatus);
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 9, 459, 306);
		getContentPane().add(scrollPane);
		
		
	}
	
	class SelectItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			JRadioButton bt = (JRadioButton)e.getItemSelectable();
			
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(bt.getText().equals("식단")) {
					CheckSum = 1;
					RadioStatus.setText("현재 모드 : 식단");
				} else if(bt.getText().equals("계획")) {
					CheckSum = 2;
					RadioStatus.setText("현재 모드 : 계획");
				} else if(bt.getText().equals("테스트")) {
					CheckSum = 3;
					RadioStatus.setText("현재 모드 : 테스트");
				}
			}
		}
	}
	
	class BtnActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton)e.getSource();
			
			if(bt.getText().equals("초기화")) {
				textArea.setText(null);
				lbLabelStatus.setText("깔끔하게 지웠습니다.");
			} else if(bt.getText().equals("저장한다")) {
				try {
					File f = new File("MemoData");
					if(!f.isDirectory()) f.mkdir();
					
					String memo = textArea.getText();
					if(memo.length() > 0) {
						if(CheckSum == 1) {
							BufferedWriter out = new BufferedWriter(new FileWriter("MemoData/"+dm.calYear+((dm.calMonth+1)<10?"0":"")+(dm.calMonth+1)+(dm.calDayOfMon<10?"0":"")+dm.calDayOfMon+"Type1"+".txt"));
							lbLabelStatus.setText(dm.calYear+((dm.calMonth+1)<10?"0":"")+(dm.calMonth+1)+(dm.calDayOfMon<10?"0":"")+dm.calDayOfMon+"Type1"+".txt"+" 파일로 저장하였습니다.");
							String str = textArea.getText();
							out.write(str);  
							out.close();
						} else if (CheckSum == 2) {
							BufferedWriter out = new BufferedWriter(new FileWriter("MemoData/"+dm.calYear+((dm.calMonth+1)<10?"0":"")+(dm.calMonth+1)+(dm.calDayOfMon<10?"0":"")+dm.calDayOfMon+"Type2"+".txt"));
							lbLabelStatus.setText(dm.calYear+((dm.calMonth+1)<10?"0":"")+(dm.calMonth+1)+(dm.calDayOfMon<10?"0":"")+dm.calDayOfMon+"Type2"+".txt"+" 파일로 저장하였습니다.");
							String str = textArea.getText();
							out.write(str);  
							out.close();
						} else if (CheckSum == 3) {
							BufferedWriter out = new BufferedWriter(new FileWriter("MemoData/"+dm.calYear+((dm.calMonth+1)<10?"0":"")+(dm.calMonth+1)+(dm.calDayOfMon<10?"0":"")+dm.calDayOfMon+"Type3"+".txt"));
							lbLabelStatus.setText(dm.calYear+((dm.calMonth+1)<10?"0":"")+(dm.calMonth+1)+(dm.calDayOfMon<10?"0":"")+dm.calDayOfMon+"Type3"+".txt"+" 파일로 저장하였습니다.");
							String str = textArea.getText();
							out.write(str);  
							out.close();
						}
					}
					else
						lbLabelStatus.setText("메모부터 작성해줘요");
				} catch(IOException e1) {
					lbLabelStatus.setText("파일 쓰기 실패");
				}
			} else if(bt.getText().equals("지운다")) {
				textArea.setText("");
				if(CheckSum == 1) {
					File f =new File("MemoData/"+dm.calYear+((dm.calMonth+1)<10?"0":"")+(dm.calMonth+1)+(dm.calDayOfMon<10?"0":"")+dm.calDayOfMon+"Type1"+".txt");
					if(f.exists()) {
						f.delete();
						lbLabelStatus.setText("메모를 지웠습니다.");
					} else {
						lbLabelStatus.setText("메모가 없네요");
					}
				} else if (CheckSum == 2) {
					File f =new File("MemoData/"+dm.calYear+((dm.calMonth+1)<10?"0":"")+(dm.calMonth+1)+(dm.calDayOfMon<10?"0":"")+dm.calDayOfMon+"Type2"+".txt");
					if(f.exists()) {
						f.delete();
						lbLabelStatus.setText("메모를 지웠습니다.");
					} else {
						lbLabelStatus.setText("메모가 없네요");
					}
				} else if (CheckSum == 3) {
					File f =new File("MemoData/"+dm.calYear+((dm.calMonth+1)<10?"0":"")+(dm.calMonth+1)+(dm.calDayOfMon<10?"0":"")+dm.calDayOfMon+"Type3"+".txt");
					if(f.exists()) {
						f.delete();
						lbLabelStatus.setText("메모를 지웠습니다.");
					} else {
						lbLabelStatus.setText("메모가 없네요");
					}
				}
			}
		}
	}
	private class ThreadControl extends Thread {
		public void run() {
			try {
				sleep(0);
			} catch(InterruptedException e) {
				System.out.println("Thread:Error");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new TestText();
			}
		});
	}
}
