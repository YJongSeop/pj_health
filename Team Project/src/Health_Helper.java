import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class personal_information extends JFrame{
	private JPanel pa = new JPanel();

	private JPanel pae = new JPanel();
	private JPanel paw = new JPanel();
	private JPanel pas = new JPanel();
	private JPanel pan = new JPanel();
	
	private BorderLayout bl = new BorderLayout();
	private GridLayout gl = new GridLayout(7,2);
	
	private JButton bt1 = new JButton("가입");
	
	private JLabel name = new JLabel("이름: ");
	private JLabel birth = new JLabel("생년월일: ");
	private JLabel height = new JLabel("키: ");
	private JLabel weight = new JLabel("몸무게: ");
	private JLabel allergy  = new JLabel("알레르기: ");
	private JLabel inedible = new JLabel("못 먹는 음식: ");
	private JLabel etc = new JLabel("기타 추가 사항: ");
	private JLabel lb1 = new JLabel("회원가입 정보 입력창");
	
	private JTextField name1 = new JTextField(10);
	private JTextField birth1 = new JTextField(10);
	private JTextField height1 = new JTextField("        cm");
	private JTextField weight1 = new JTextField("        kg");
	private JCheckBox allergy1 = new JCheckBox();
	private JTextArea inedible1 = new JTextArea();
	private JTextArea etc1 = new JTextArea();
	
	//private MyMouseListener ml = new MouseListener();
	
	personal_information(){
		setTitle("개인정보");
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		add(pan,BorderLayout.NORTH);
		pan.add(lb1);
		
		add(pa,BorderLayout.CENTER);
		pa.setLayout(gl);
		
		pa.add(name);
		pa.add(name1);
		pa.add(birth);
		pa.add(birth1);
		pa.add(height);
		pa.add(height1);
		pa.add(weight);
		pa.add(weight1);
		pa.add(allergy);
		pa.add(allergy1);
		pa.add(inedible);
		pa.add(inedible1);
		pa.add(etc);
		pa.add(etc1);
		
		add(pas,BorderLayout.SOUTH);
		pas.add(bt1);
		
	}

	
}
class Health_Helper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new personal_information();
	}

}
