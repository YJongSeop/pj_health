import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
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

public class sign_form extends JFrame {
	 JPanel contentPane;
	 JTextField txt1;
	 JTextField txt2;
	 JTextField txt3;
	 JTextField txt4;
	 JTextField txt5;

	public sign_form() {
		setResizable(false);
		setTitle("회원가입 폼");
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
		
		JLabel labelTop = new JLabel("회원가입 정보 입력창");
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
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(79, 54, 202, 22);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(79, 82, 202, 22);
		contentPane.add(txt3);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(79, 110, 202, 22);
		contentPane.add(txt4);
		
		txt5 = new JTextField();
		txt5.setBounds(108, 142, 173, 22);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		JButton button_Left = new JButton("가입");
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
				JOptionPane.showMessageDialog(null, "가입 완료", "알림", JOptionPane.INFORMATION_MESSAGE);
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
				new sign_form();
			}
		});
	}
}
