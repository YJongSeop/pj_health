import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class BMICalculator extends JFrame {
	private JTextField txt1;
	private JTextField txt2;
	JLabel lbResult = new JLabel("");
	
	double num1, num2, result_label, result_label2;
	int result_slide;
	
	String BMI;
	
	Container contentPane;
	
	public BMICalculator() {
		try{
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//LookAndFeel Windows 스타일 적용
			//SwingUtilities.updateComponentTreeUI(BMICalculator) ;
		}catch(Exception e){
			lbResult.setText("ERROR : LookAndFeel setting failed");
		}
		contentPane = getContentPane();
		setTitle("BMI Calculator");
		setSize(240, 300);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD0A4 :");
		lblNewLabel.setBounds(9, 43, 38, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uBAB8\uBB34\uAC8C :");
		label.setBounds(9, 74, 55, 18);
		getContentPane().add(label);
		
		txt1 = new JTextField();
		txt1.setBounds(63, 39, 143, 22);
		getContentPane().add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(63, 72, 143, 22);
		getContentPane().add(txt2);
		txt2.setColumns(10);
		
		JSlider bmiSlider = new JSlider();
		bmiSlider.setEnabled(false);
		bmiSlider.setValue(0);
		bmiSlider.setMaximum(40);
		bmiSlider.setBounds(9, 158, 200, 16);
		getContentPane().add(bmiSlider);
		
		JLabel InfoBmi = new JLabel("\uACC4\uC0B0\uD558\uB824\uB294 BMI \uC815\uBCF4 \uC785\uB825\uD558\uAE30");
		InfoBmi.setHorizontalAlignment(SwingConstants.CENTER);
		InfoBmi.setBounds(9, 10, 197, 18);
		getContentPane().add(InfoBmi);
		
		JButton calBtn = new JButton("\uACC4\uC0B0");
		calBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txt1.getText().equals("") || txt2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "값을 입력해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
				} else {
				num1 = Double.parseDouble(txt1.getText()) * 0.01;
				num2 = Double.parseDouble(txt2.getText());
				
				result_label = num2 / Math.pow(num1, 2);
				result_label2 = Double.parseDouble(String.format("%.2f", result_label));
						
				result_slide = Math.round((long)result_label);
				//result_slide = Integer.parseInt(String.valueOf(Math.round(result_label)));
				bmiSlider.setValue(result_slide);
				
				if(result_label < 18.5) {
					BMI = "저체중";
				} else if(result_label >= 18.5 && result_label <=23) {
					BMI = "정상";
				} else if(result_label > 23 && result_label <= 25) {
					BMI = "과체중";
				} else if(result_label > 25 && result_label <= 30) {
					BMI = "비만";
				} else if(result_label > 30) {
					BMI = "고도비만";
				}
				
				lbResult.setText("<html>" + "체지방량은 "+result_label2+"이며,"+"<br>" +"당신은 "+BMI+" 상태입니다." + "</html>");
			}
		}
			
		});
		calBtn.setBounds(9, 109, 92, 28);
		getContentPane().add(calBtn);
		
		JButton clearBtn = new JButton("\uCD08\uAE30\uD654");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt1.setText(null);
				txt2.setText(null);
				lbResult.setText("내용을 초기화 하였습니다.");
			}
		});
		clearBtn.setBounds(113, 109, 93, 28);
		getContentPane().add(clearBtn);
		
		JLabel lb1 = new JLabel("\uC800\uCCB4\uC911");
		lb1.setFont(new Font("Dialog", Font.BOLD, 10));
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setBounds(9, 143, 33, 18);
		getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("\uC815\uC0C1");
		lb2.setFont(new Font("Dialog", Font.BOLD, 10));
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		lb2.setBounds(56, 175, 22, 18);
		getContentPane().add(lb2);
		
		JLabel lb3 = new JLabel("\uACFC\uCCB4\uC911");
		lb3.setFont(new Font("Dialog", Font.BOLD, 10));
		lb3.setHorizontalAlignment(SwingConstants.CENTER);
		lb3.setBounds(91, 143, 33, 18);
		getContentPane().add(lb3);
		
		JLabel lb4 = new JLabel("\uBE44\uB9CC");
		lb4.setFont(new Font("Dialog", Font.BOLD, 10));
		lb4.setHorizontalAlignment(SwingConstants.CENTER);
		lb4.setBounds(144, 176, 22, 18);
		getContentPane().add(lb4);
		
		JLabel lb5 = new JLabel("\uACE0\uB3C4\uBE44\uB9CC");
		lb5.setHorizontalAlignment(SwingConstants.CENTER);
		lb5.setFont(new Font("Dialog", Font.BOLD, 10));
		lb5.setBounds(177, 143, 44, 18);
		getContentPane().add(lb5);
		lbResult.setBounds(9, 206, 197, 43);
		getContentPane().add(lbResult);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BMICalculator();
	}
}
