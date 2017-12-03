import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class sign_form extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;

	public sign_form() {
		setTitle("\uD68C\uC6D0\uAC00\uC785 \uD3FC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 390);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785 \uC815\uBCF4 \uC785\uB825\uCC3D");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 281, 18);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\uC774\uB984 :");
		label.setBounds(12, 28, 55, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C :");
		label_1.setBounds(12, 56, 64, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\uD0A4 :");
		label_2.setBounds(12, 84, 55, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\uBAB8\uBB34\uAC8C :");
		label_3.setBounds(12, 112, 55, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\uC54C\uB808\uB974\uAE30 :");
		label_4.setBounds(12, 140, 75, 18);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\uC12D\uCDE8 \uBD88\uAC00 \uC74C\uC2DD :");
		label_5.setBounds(12, 197, 104, 18);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\uAE30\uD0C0 \uC0AC\uD56D :");
		label_6.setBounds(12, 225, 75, 18);
		contentPane.add(label_6);
		
		JCheckBox ck1 = new JCheckBox("\uC720\uC81C\uD488");
		ck1.setBounds(77, 136, 64, 26);
		contentPane.add(ck1);
		
		JCheckBox ck2 = new JCheckBox("\uC0DD\uC120\uB958");
		ck2.setBounds(149, 136, 64, 26);
		contentPane.add(ck2);
		
		JCheckBox ck3 = new JCheckBox("\uD574\uC0B0\uBB3C");
		ck3.setBounds(217, 136, 64, 26);
		contentPane.add(ck3);
		
		JCheckBox ck4 = new JCheckBox("\uACFC\uC77C\uB958");
		ck4.setBounds(77, 164, 64, 26);
		contentPane.add(ck4);
		
		JCheckBox ck5 = new JCheckBox("\uACAC\uACFC\uB958");
		ck5.setBounds(149, 164, 64, 26);
		contentPane.add(ck5);
		
		JCheckBox ck6 = new JCheckBox("\uCD08\uCF5C\uB9BF");
		ck6.setBounds(217, 164, 64, 26);
		contentPane.add(ck6);
		
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
		txt5.setBounds(108, 196, 173, 22);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 253, 261, 49);
		contentPane.add(textArea);
		
		JButton button_Left = new JButton("\uAC00\uC785");
		button_Left.setBounds(43, 312, 98, 28);
		contentPane.add(button_Left);
		
		JButton button_Right = new JButton("\uCD08\uAE30\uD654");
		button_Right.setBounds(149, 312, 98, 28);
		contentPane.add(button_Right);
	}
	
	public static void main(String[] args) {
		new sign_form();
	}
}
