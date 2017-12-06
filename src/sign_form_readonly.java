import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	 JScrollPane scrollPane;

	public sign_form_readonly() {
		setResizable(false);
		setTitle("회원가입 폼");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 366);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel label_4 = new JLabel("알레르기 :");
		label_4.setBounds(12, 140, 75, 18);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("섭취 불가 음식 :");
		label_5.setBounds(12, 197, 104, 18);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("기타 사항 :");
		label_6.setBounds(12, 225, 75, 18);
		contentPane.add(label_6);
		
		JCheckBox ck1 = new JCheckBox("유제품");
		ck1.setEnabled(false);
		ck1.setBounds(77, 136, 64, 26);
		contentPane.add(ck1);
		
		JCheckBox ck2 = new JCheckBox("생선류");
		ck2.setEnabled(false);
		ck2.setBounds(149, 136, 64, 26);
		contentPane.add(ck2);
		
		JCheckBox ck3 = new JCheckBox("갑각류");
		ck3.setEnabled(false);
		ck3.setBounds(217, 136, 64, 26);
		contentPane.add(ck3);
		
		JCheckBox ck4 = new JCheckBox("과일류");
		ck4.setEnabled(false);
		ck4.setBounds(77, 164, 64, 26);
		contentPane.add(ck4);
		
		JCheckBox ck5 = new JCheckBox("견과류");
		ck5.setEnabled(false);
		ck5.setBounds(149, 164, 64, 26);
		contentPane.add(ck5);
		
		JCheckBox ck6 = new JCheckBox("초콜렛");
		ck6.setEnabled(false);
		ck6.setBounds(217, 164, 64, 26);
		contentPane.add(ck6);
		
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
		txt5.setBounds(108, 196, 173, 22);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(12, 253, 261, 49);
		contentPane.add(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 253, 279, 50);
		contentPane.add(scrollPane);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new sign_form_readonly();
			}
		});
	}
}
