import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class sign_form_modify extends JFrame {
	 JPanel contentPane;
	 JTextField txt1;
	 JTextField txt2;
	 JTextField txt3;
	 JTextField txt4;
	 JTextField txt5;
	 
	 String[] info = null;
	 String str = null;

	public sign_form_modify() {
		setResizable(false);
		setTitle("회원정보 변경폼");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 242);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try{
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //LookAndFeel Windows 스타일 적용
			SwingUtilities.updateComponentTreeUI(getContentPane()) ;
		}catch(Exception e){
			//bottomInfo.setText("ERROR : LookAndFeel setting failed");
		}
		
		try {
			File f = new File("Users.txt");
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
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//, 단위로 끊어서 정보를 집어넣는다.
		String[] result = str.split(",");
		
		JLabel labelTop = new JLabel("회원 정보 변경하기");
		labelTop.setHorizontalAlignment(SwingConstants.CENTER);
		labelTop.setBounds(0, 0, 281, 18);
		contentPane.add(labelTop);
		
		JLabel label = new JLabel("이름 :");
		label.setBounds(12, 28, 55, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("생년월일 :");
		label_1.setBounds(12, 56, 64, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("키 :");
		label_2.setBounds(12, 84, 55, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("몸무게 :");
		label_3.setBounds(12, 112, 55, 18);
		contentPane.add(label_3);
		
		JLabel label_5 = new JLabel("기타사항 :");
		label_5.setBounds(12, 143, 104, 18);
		contentPane.add(label_5);
		
		txt1 = new JTextField();
		txt1.setBounds(79, 28, 202, 22);
		contentPane.add(txt1);
		txt1.setColumns(10);
		txt1.setText(result[0]);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(79, 54, 202, 22);
		contentPane.add(txt2);
		txt2.setText(result[1]);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(79, 82, 202, 22);
		contentPane.add(txt3);
		txt3.setText(result[2]);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(79, 110, 202, 22);
		contentPane.add(txt4);
		txt4.setText(result[3]);
		
		txt5 = new JTextField();
		txt5.setBounds(108, 142, 173, 22);
		contentPane.add(txt5);
		txt5.setColumns(10);
		txt5.setText(result[4]);
		
		JButton button_Left = new JButton("수정");
		button_Left.setBounds(41, 176, 98, 28);
		contentPane.add(button_Left);
		button_Left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String St_txt1 = txt1.getText();
				String St_txt2 = txt2.getText();
				String St_txt3 = txt3.getText();
				String St_txt4 = txt4.getText();
				String St_txt5 = txt5.getText();
				
				String info = St_txt1 + "," + St_txt2 + "," + St_txt3 + "," + St_txt4 + "," + St_txt5;
				try {
				File f = new File("Users.txt");
					if(info.length() > 0) {
						BufferedWriter out = new BufferedWriter(new FileWriter("Users.txt"));
						out.write(info);
						out.close();
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "수정 완료", "알림", JOptionPane.INFORMATION_MESSAGE);
				if(JOptionPane.OK_OPTION == 0) {
					dispose();
				}
			}
		});
		
		JButton button_Right = new JButton("초기화");
		button_Right.setBounds(147, 176, 98, 28);
		contentPane.add(button_Right);
		button_Right.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				txt1.setText(null);
				txt2.setText(null);
				txt3.setText(null);
				txt4.setText(null);
				txt5.setText(null);			
				JOptionPane.showMessageDialog(null, "내용을 초기화 하였습니다.", "알림", JOptionPane.INFORMATION_MESSAGE, null);
			}
		});
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new sign_form_modify();
			}
		});
	}
}
