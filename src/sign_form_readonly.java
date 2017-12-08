import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class sign_form_readonly extends JFrame {
	 JPanel contentPane;
	 JTextField txt1;
	 JTextField txt2;
	 JTextField txt3;
	 JTextField txt4;
	 JTextField txt5;
	 
	 String[] info;

	public sign_form_readonly() {
		setResizable(false);
		setTitle("회원정보 확인");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 207);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			File f = new File("Users.txt");
			BufferedReader reader = new BufferedReader(new FileReader("Users.txt"));
			
			String line = null;
			String[] splitedStr = null;
			while((line = reader.readLine()) != null) {
				splitedStr = null;
				splitedStr = line.split("\t");
				
				for(int i = 0; i < splitedStr.length; i++) {
					splitedStr[i] = splitedStr[i].trim();
					//splitedStr[i] = info[i];
				}
				reader.close();
			}
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "유저 정보가 존재하지 않습니다! 가입해주세요.", "에러", JOptionPane.ERROR_MESSAGE, null);
			if(JOptionPane.OK_OPTION == 0)
				dispose();
		}
		txt1.setText(info[0]);
		txt2.setText(info[1]);
		txt3.setText(info[2]);
		txt4.setText(info[3]);
		txt5.setText(info[4]);
		
		JLabel labelTop = new JLabel("회원가입 정보 확인창");
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
		label_5.setBounds(12, 141, 104, 18);
		contentPane.add(label_5);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setEnabled(false);
		txt1.setBounds(79, 28, 202, 22);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setEditable(false);
		txt2.setEnabled(false);
		txt2.setColumns(10);
		txt2.setBounds(79, 54, 202, 22);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setEditable(false);
		txt3.setEnabled(false);
		txt3.setColumns(10);
		txt3.setBounds(79, 82, 202, 22);
		contentPane.add(txt3);
		
		txt4 = new JTextField();
		txt4.setEditable(false);
		txt4.setEnabled(false);
		txt4.setColumns(10);
		txt4.setBounds(79, 110, 202, 22);
		contentPane.add(txt4);
		
		txt5 = new JTextField();
		txt5.setEditable(false);
		txt5.setEnabled(false);
		txt5.setBounds(108, 140, 173, 22);
		contentPane.add(txt5);
		txt5.setColumns(10);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new sign_form_readonly();
			}
		});
	}
}
