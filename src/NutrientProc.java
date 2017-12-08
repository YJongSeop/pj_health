import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.CommunicationException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class NutrientProc extends JFrame {
	JList list;
	JScrollPane scrollPane;
	private JTextField txtID; //TextField만 전역으로 생성되는 기분이다..
	private JTextField txtName;
	private JTextField txtKcal;
	private JTextField textNut1;
	private JTextField textNut2;
	private JTextField textNut3;
	private JTextField textNut4;
	private JTextField textNut5;
	private JTextField txtBottom_Kcal;
	private JTextField txtBottom_Nut1;
	private JTextField txtBottom_Nut2;
	private JTextField txtBottom_Nut3;
	private JTextField txtBottom_Nut4;
	private JTextField txtBottom_Nut5;
	JSlider slider1;
	JSlider slider2;
	JSlider slider3;
	JSlider slider4;
	JSlider slider5;
	JSlider slider6;
	
	
	//모델 선언
	DefaultListModel model = new DefaultListModel();
	
	//연결 부분
	Connection connect = ConnectDB();
	Statement s = null;
	PreparedStatement psmt = null;
	
	//더하기 빼기에 쓸 부분 - DB로부터 뜯어낸 값
	int nKcal = 0;
	double dNut1, dNut2, dNut3, dNut4, dNut5 = 0;
	
	//더하기 빼기에 쓸 부분 - 하단에 처묵할 값
	int nKcal_bottom = 0;
	double dNut1_bottom, dNut2_bottom, dNut3_bottom, dNut4_bottom, dNut5_bottom = 0;
	
	//main 함수. Runnable로 객체 선언함으로서 초기에 띄울때 사이즈 변경 안해도 애들 다 그대로 보인다.
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new NutrientProc();
			}
		});
	}
	
	public NutrientProc() {
		setTitle("영양소 계산기");
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X눌러서 창이 전부 꺼지면 곤란하다. 주석해줍시다.
		setSize(454,745);
		setResizable(false);
		getContentPane().setLayout(null);
				
		try{ // UI를 Windows 스타일에 따라가게끔
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //LookAndFeel Windows 스타일 적용
			SwingUtilities.updateComponentTreeUI(getContentPane());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try { //기본 모델을 하나 만들어서 이를 List에 집어넣는다.
			s = connect.createStatement();
			String sql = "select * from dbnutrient order by id asc";
			ResultSet rec = s.executeQuery(sql);
			int row = 0;
			while((rec!=null) && (rec.next())) {
				model.addElement(rec.getString("name"));
			}
			rec.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		list = new JList(model);
		list.setBorder(new TitledBorder(null, "목록", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list.setBounds(12, 10, 164, 279);
		getContentPane().add(list);
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String index_str = Integer.toString(list.getSelectedIndex());
				
				try { //희대의 삽질 구간이었다. 절대 연결종료는 함부로 하지 맙시다. 맨 하단부분에 선언 보류한거 있음
					s = connect.createStatement();
					String sql = "select * from dbnutrient limit "; //한 줄씩 호출하는 부분이다.
					String sql2 = ", 1";
					String sql_sum = sql + index_str + sql2;  //명령어 조합의 결과는 "select * from dbnutrient limit (index), 1"이 된다.
					ResultSet rec = s.executeQuery(sql_sum);
					
					while((rec.next())) {
						txtID.setText(rec.getString("id"));
						txtName.setText(rec.getString("name"));
						txtKcal.setText(Integer.toString(rec.getInt("kcal")));
						textNut1.setText(Double.toString(rec.getDouble("nut1")));
						textNut2.setText(Double.toString(rec.getDouble("nut2")));
						textNut3.setText(Double.toString(rec.getDouble("nut3")));
						textNut4.setText(Double.toString(rec.getDouble("nut4")));
						textNut5.setText(Double.toString(rec.getDouble("nut5")));
					}
					rec.close();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
				
		scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 6, 179, 279);
		getContentPane().add(scrollPane);
		
		JLabel lbID = new JLabel("ID :");
		lbID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbID.setBounds(209, 10, 78, 15);
		getContentPane().add(lbID);
		
		JLabel ldName = new JLabel("이름 :");
		ldName.setHorizontalAlignment(SwingConstants.RIGHT);
		ldName.setBounds(209, 35, 78, 15);
		getContentPane().add(ldName);
		
		JLabel lbKcal = new JLabel("칼로리(Kcal) :");
		lbKcal.setHorizontalAlignment(SwingConstants.RIGHT);
		lbKcal.setBounds(188, 60, 99, 15);
		getContentPane().add(lbKcal);
		
		JLabel lbNut1 = new JLabel("탄수화물(g) :");
		lbNut1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNut1.setBounds(209, 85, 78, 15);
		getContentPane().add(lbNut1);
		
		JLabel lbNut2 = new JLabel("단백질(g) :");
		lbNut2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNut2.setBounds(209, 110, 78, 15);
		getContentPane().add(lbNut2);
		
		JLabel lbNut3 = new JLabel("지   방(g) :");
		lbNut3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNut3.setBounds(209, 138, 78, 15);
		getContentPane().add(lbNut3);
		
		JLabel lbNut4 = new JLabel("당   류(g) :");
		lbNut4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNut4.setBounds(209, 163, 78, 15);
		getContentPane().add(lbNut4);
		
		JLabel lbNut5 = new JLabel("\uB098\uD2B8\uB968(mg) :");
		lbNut5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNut5.setBounds(209, 188, 78, 15);
		getContentPane().add(lbNut5);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(298, 6, 116, 21);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(298, 31, 116, 21);
		getContentPane().add(txtName);
		
		txtKcal = new JTextField();
		txtKcal.setEditable(false);
		txtKcal.setColumns(10);
		txtKcal.setBounds(298, 56, 116, 21);
		getContentPane().add(txtKcal);
		
		textNut1 = new JTextField();
		textNut1.setEditable(false);
		textNut1.setColumns(10);
		textNut1.setBounds(298, 81, 116, 21);
		getContentPane().add(textNut1);
		
		textNut2 = new JTextField();
		textNut2.setEditable(false);
		textNut2.setColumns(10);
		textNut2.setBounds(298, 106, 116, 21);
		getContentPane().add(textNut2);
		
		textNut3 = new JTextField();
		textNut3.setEditable(false);
		textNut3.setColumns(10);
		textNut3.setBounds(298, 134, 116, 21);
		getContentPane().add(textNut3);
		
		textNut4 = new JTextField();
		textNut4.setEditable(false);
		textNut4.setColumns(10);
		textNut4.setBounds(298, 159, 116, 21);
		getContentPane().add(textNut4);
		
		textNut5 = new JTextField();
		textNut5.setEditable(false);
		textNut5.setColumns(10);
		textNut5.setBounds(298, 184, 116, 21);
		getContentPane().add(textNut5);
		
		JButton btnPlus = new JButton("더하기");
		btnPlus.setBounds(196, 225, 109, 25);
		getContentPane().add(btnPlus);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nKcal = Integer.parseInt(txtKcal.getText());
				dNut1 = Double.parseDouble(textNut1.getText());
				dNut2 = Double.parseDouble(textNut2.getText());
				dNut3 = Double.parseDouble(textNut3.getText());
				dNut4 = Double.parseDouble(textNut4.getText());
				dNut5 = Double.parseDouble(textNut5.getText());
				
				nKcal_bottom += nKcal;
				dNut1_bottom +=  dNut1;
				dNut2_bottom +=  dNut2;
				dNut3_bottom +=  dNut3;
				dNut4_bottom +=  dNut4;
				dNut5_bottom +=  dNut5;
				
				//자릿수 강제적으로 제한걸어놓음. 안하면 뒷자리수가 우주로 간다..
				double dNut1_bottom2 = Double.parseDouble(String.format("%.2f", dNut1_bottom));
				double dNut2_bottom2 = Double.parseDouble(String.format("%.2f", dNut2_bottom));
				double dNut3_bottom2 = Double.parseDouble(String.format("%.2f", dNut3_bottom));
				double dNut4_bottom2 = Double.parseDouble(String.format("%.2f", dNut4_bottom));
				double dNut5_bottom2 = Double.parseDouble(String.format("%.2f", dNut5_bottom));
				
				txtBottom_Kcal.setText(Integer.toString(nKcal_bottom));
				txtBottom_Nut1.setText(Double.toString(dNut1_bottom2));
				txtBottom_Nut2.setText(Double.toString(dNut2_bottom2));
				txtBottom_Nut3.setText(Double.toString(dNut3_bottom2));
				txtBottom_Nut4.setText(Double.toString(dNut4_bottom2));
				txtBottom_Nut5.setText(Double.toString(dNut5_bottom2));
				
				slider1.setValue(nKcal_bottom);
				slider2.setValue(Math.round((long)dNut1_bottom2));
				slider3.setValue(Math.round((long)dNut2_bottom2));
				slider4.setValue(Math.round((long)dNut3_bottom2));
				slider5.setValue(Math.round((long)dNut4_bottom2));
				slider6.setValue(Math.round((long)dNut5_bottom2));
			}
		});
		
		JButton btnReset = new JButton("초기화");
		btnReset.setBounds(317, 225, 109, 25);
		getContentPane().add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText(null);
				txtName.setText(null);
				txtKcal.setText(null);
				textNut1.setText(null);
				textNut2.setText(null);
				textNut3.setText(null);
				textNut4.setText(null);
				textNut5.setText(null);
				txtBottom_Kcal.setText(null);
				txtBottom_Nut1.setText(null);
				txtBottom_Nut2.setText(null);
				txtBottom_Nut3.setText(null);
				txtBottom_Nut4.setText(null);
				txtBottom_Nut5.setText(null);
				slider1.setValue(0);
				slider2.setValue(0);
				slider3.setValue(0);
				slider4.setValue(0);
				slider5.setValue(0);
				slider6.setValue(0);
				JOptionPane.showMessageDialog(null, "내용을 전부 초기화 하였습니다.", "알림", JOptionPane.INFORMATION_MESSAGE, null);
			}
		});
		
		JButton btnMinus = new JButton("빼   기");
		btnMinus.setBounds(196, 260, 109, 25);
		getContentPane().add(btnMinus);
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nKcal = Integer.parseInt(txtKcal.getText());
				dNut1 = Double.parseDouble(textNut1.getText());
				dNut2 = Double.parseDouble(textNut2.getText());
				dNut3 = Double.parseDouble(textNut3.getText());
				dNut4 = Double.parseDouble(textNut4.getText());
				dNut5 = Double.parseDouble(textNut5.getText());
				
				nKcal_bottom -= nKcal;
				dNut1_bottom -= dNut1;
				dNut2_bottom -= dNut2;
				dNut3_bottom -= dNut3;
				dNut4_bottom -= dNut4;
				dNut5_bottom -= dNut5;
				
				//0 밑으로 가서 음수가 나오는 사태를 방지한다. 최소값은 0으로 수렴
				if(nKcal_bottom <= 0) {
					nKcal_bottom = 0;
				}
				if(dNut1_bottom <= 0) {
					dNut1_bottom = 0;
				}
				if(dNut2_bottom <= 0) {
					dNut2_bottom = 0;
				}
				if(dNut3_bottom <= 0) {
					dNut3_bottom = 0;
				}
				if(dNut4_bottom <= 0) {
					dNut4_bottom = 0;
				}
				if(dNut5_bottom <= 0) {
					dNut5_bottom = 0;
				}
				
				double dNut1_bottom2 = Double.parseDouble(String.format("%.2f", dNut1_bottom));
				double dNut2_bottom2 = Double.parseDouble(String.format("%.2f", dNut2_bottom));
				double dNut3_bottom2 = Double.parseDouble(String.format("%.2f", dNut3_bottom));
				double dNut4_bottom2 = Double.parseDouble(String.format("%.2f", dNut4_bottom));
				double dNut5_bottom2 = Double.parseDouble(String.format("%.2f", dNut5_bottom));
				
				txtBottom_Kcal.setText(Integer.toString(nKcal_bottom));
				txtBottom_Nut1.setText(Double.toString(dNut1_bottom2));
				txtBottom_Nut2.setText(Double.toString(dNut2_bottom2));
				txtBottom_Nut3.setText(Double.toString(dNut3_bottom2));
				txtBottom_Nut4.setText(Double.toString(dNut4_bottom2));
				txtBottom_Nut5.setText(Double.toString(dNut5_bottom2));
				
				slider1.setValue(nKcal_bottom);
				slider2.setValue(Math.round((long)dNut1_bottom2));
				slider3.setValue(Math.round((long)dNut2_bottom2));
				slider4.setValue(Math.round((long)dNut3_bottom2));
				slider5.setValue(Math.round((long)dNut4_bottom2));
				slider6.setValue(Math.round((long)dNut5_bottom2));
			}
		});
		
		JButton buttonExit = new JButton("종   료");
		buttonExit.setBounds(317, 260, 109, 25);
		getContentPane().add(buttonExit);
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try { //연결 종료 부분인데, 최초에 List에 때려박는 시점에서 이게 실행되어버리면 값을 불러오지 못한다..
					//일단 비활성화하려고 했지만 종료할때 끝내게 만드는 기발한 생각을 했으니 여기에 넣는다.
					if(s != null) {
						s.close();
						connect.close();
					}
				} catch(SQLException e2) {
					e2.printStackTrace();
				}
				dispose(); // 해당 창만 종료
			}
		});
		
		JLabel lbBottomInfo1 = new JLabel("탄수화물 총량(g)");
		lbBottomInfo1.setBounds(10, 388, 99, 15);
		getContentPane().add(lbBottomInfo1);
		
		JLabel lbBottomInfo2 = new JLabel("단백질 총량(g)");
		lbBottomInfo2.setBounds(10, 448, 99, 15);
		getContentPane().add(lbBottomInfo2);
		
		JLabel lbBottomInfo3 = new JLabel("지방 총량(g)");
		lbBottomInfo3.setBounds(10, 508, 99, 15);
		getContentPane().add(lbBottomInfo3);
		
		JLabel lbBottomInfo4 = new JLabel("당류 총량(g)");
		lbBottomInfo4.setBounds(10, 568, 99, 15);
		getContentPane().add(lbBottomInfo4);
		
		JLabel lbBottomInfo5 = new JLabel("\uB098\uD2B8\uB968 \uCD1D\uB7C9(mg)");
		lbBottomInfo5.setBounds(10, 628, 99, 15);
		getContentPane().add(lbBottomInfo5);
		
		JLabel lbBottomInfo_Last = new JLabel("※ 영양 섭취 기준은 보통 성인 남성 권장 섭취량을 기준으로 합니다.");
		lbBottomInfo_Last.setHorizontalAlignment(SwingConstants.CENTER);
		lbBottomInfo_Last.setBounds(10, 688, 416, 15);
		getContentPane().add(lbBottomInfo_Last);
		
		txtBottom_Kcal = new JTextField();
		txtBottom_Kcal.setEditable(false);
		txtBottom_Kcal.setColumns(10);
		txtBottom_Kcal.setBounds(121, 319, 65, 21);
		getContentPane().add(txtBottom_Kcal);
		
		txtBottom_Nut1 = new JTextField();
		txtBottom_Nut1.setEditable(false);
		txtBottom_Nut1.setBounds(121, 385, 65, 21);
		getContentPane().add(txtBottom_Nut1);
		txtBottom_Nut1.setColumns(10);
		
		txtBottom_Nut2 = new JTextField();
		txtBottom_Nut2.setEditable(false);
		txtBottom_Nut2.setBounds(121, 445, 65, 21);
		getContentPane().add(txtBottom_Nut2);
		txtBottom_Nut2.setColumns(10);
		
		txtBottom_Nut3 = new JTextField();
		txtBottom_Nut3.setEditable(false);
		txtBottom_Nut3.setBounds(121, 505, 65, 21);
		getContentPane().add(txtBottom_Nut3);
		txtBottom_Nut3.setColumns(10);
		
		txtBottom_Nut4 = new JTextField();
		txtBottom_Nut4.setEditable(false);
		txtBottom_Nut4.setBounds(121, 565, 65, 21);
		getContentPane().add(txtBottom_Nut4);
		txtBottom_Nut4.setColumns(10);
		
		txtBottom_Nut5 = new JTextField();
		txtBottom_Nut5.setEditable(false);
		txtBottom_Nut5.setBounds(121, 625, 65, 21);
		getContentPane().add(txtBottom_Nut5);
		txtBottom_Nut5.setColumns(10);
		
		slider1 = new JSlider();
		slider1.setPaintTicks(true);
		slider1.setValue(0);
		slider1.setMaximum(2750);
		slider1.setEnabled(false);
		slider1.setBounds(5, 341, 421, 15);
		getContentPane().add(slider1);
		
		slider2 = new JSlider();
		slider2.setValue(0);
		slider2.setMaximum(410);
		slider2.setPaintTicks(true);
		slider2.setEnabled(false);
		slider2.setBounds(5, 413, 421, 15);
		getContentPane().add(slider2);
		
		slider3 = new JSlider();
		slider3.setMaximum(105);
		slider3.setValue(0);
		slider3.setPaintTicks(true);
		slider3.setEnabled(false);
		slider3.setBounds(5, 473, 421, 15);
		getContentPane().add(slider3);
		
		slider4 = new JSlider();
		slider4.setMaximum(50);
		slider4.setValue(0);
		slider4.setPaintTicks(true);
		slider4.setEnabled(false);
		slider4.setBounds(5, 533, 421, 15);
		getContentPane().add(slider4);
		
		slider5 = new JSlider();
		slider5.setValue(0);
		slider5.setPaintTicks(true);
		slider5.setEnabled(false);
		slider5.setBounds(5, 593, 421, 15);
		getContentPane().add(slider5);
		
		slider6 = new JSlider();
		slider6.setMaximum(1800);
		slider6.setValue(0);
		slider6.setPaintTicks(true);
		slider6.setEnabled(false);
		slider6.setBounds(5, 651, 421, 15);
		getContentPane().add(slider6);
		
		//여기서부터는 그냥 레이블 노가다. 매우 부족 부족.. 어쩌구 그런거만
		
		JLabel lblNewLabel = new JLabel("\uB9E4\uC6B0 \uBD80\uC871");
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 426, 43, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uB2E4\uC18C \uBD80\uC871");
		label.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label.setBounds(95, 426, 43, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uBCF4\uD1B5");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_1.setBounds(194, 426, 43, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uB2E4\uC18C \uACFC\uB2E4");
		label_2.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_2.setBounds(293, 426, 43, 15);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uB9E4\uC6B0 \uACFC\uB2E4");
		label_3.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_3.setBounds(376, 426, 43, 15);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\uB9E4\uC6B0 \uBD80\uC871");
		label_4.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_4.setBounds(10, 488, 43, 15);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\uB2E4\uC18C \uBD80\uC871");
		label_5.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_5.setBounds(95, 488, 43, 15);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\uBCF4\uD1B5");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_6.setBounds(194, 488, 43, 15);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\uB2E4\uC18C \uACFC\uB2E4");
		label_7.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_7.setBounds(293, 488, 43, 15);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\uB9E4\uC6B0 \uACFC\uB2E4");
		label_8.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_8.setBounds(376, 488, 43, 15);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("\uB9E4\uC6B0 \uBD80\uC871");
		label_9.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_9.setBounds(11, 549, 43, 15);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("\uB2E4\uC18C \uBD80\uC871");
		label_10.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_10.setBounds(96, 549, 43, 15);
		getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("\uBCF4\uD1B5");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_11.setBounds(195, 549, 43, 15);
		getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("\uB2E4\uC18C \uACFC\uB2E4");
		label_12.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_12.setBounds(294, 549, 43, 15);
		getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("\uB9E4\uC6B0 \uACFC\uB2E4");
		label_13.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_13.setBounds(377, 549, 43, 15);
		getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("\uB9E4\uC6B0 \uBD80\uC871");
		label_14.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_14.setBounds(11, 609, 43, 15);
		getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("\uB2E4\uC18C \uBD80\uC871");
		label_15.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_15.setBounds(96, 609, 43, 15);
		getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("\uBCF4\uD1B5");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_16.setBounds(195, 609, 43, 15);
		getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("\uB2E4\uC18C \uACFC\uB2E4");
		label_17.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_17.setBounds(294, 609, 43, 15);
		getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("\uB9E4\uC6B0 \uACFC\uB2E4");
		label_18.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_18.setBounds(377, 609, 43, 15);
		getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("\uB9E4\uC6B0 \uBD80\uC871");
		label_19.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_19.setBounds(11, 664, 43, 15);
		getContentPane().add(label_19);
		
		JLabel label_20 = new JLabel("\uB2E4\uC18C \uBD80\uC871");
		label_20.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_20.setBounds(96, 664, 43, 15);
		getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel("\uBCF4\uD1B5");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_21.setBounds(195, 664, 43, 15);
		getContentPane().add(label_21);
		
		JLabel label_22 = new JLabel("\uB2E4\uC18C \uACFC\uB2E4");
		label_22.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_22.setBounds(294, 664, 43, 15);
		getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel("\uB9E4\uC6B0 \uACFC\uB2E4");
		label_23.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_23.setBounds(377, 664, 43, 15);
		getContentPane().add(label_23);
		
		
		//깔쌈하게 하나 나눠봤음
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 300, 411, 2);
		getContentPane().add(separator);
		
		JLabel lblkcal = new JLabel("\uCE7C\uB85C\uB9AC \uCD1D\uB7C9(kcal)");
		lblkcal.setBounds(10, 322, 99, 15);
		getContentPane().add(lblkcal);
		
		JLabel label_25 = new JLabel("\uB9E4\uC6B0 \uBD80\uC871");
		label_25.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_25.setBounds(10, 360, 43, 15);
		getContentPane().add(label_25);
		
		JLabel label_26 = new JLabel("\uB2E4\uC18C \uBD80\uC871");
		label_26.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_26.setBounds(95, 360, 43, 15);
		getContentPane().add(label_26);
		
		JLabel label_27 = new JLabel("\uBCF4\uD1B5");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_27.setBounds(194, 360, 43, 15);
		getContentPane().add(label_27);
		
		JLabel label_28 = new JLabel("\uB2E4\uC18C \uACFC\uB2E4");
		label_28.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_28.setBounds(293, 360, 43, 15);
		getContentPane().add(label_28);
		
		JLabel label_29 = new JLabel("\uB9E4\uC6B0 \uACFC\uB2E4");
		label_29.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		label_29.setBounds(376, 360, 43, 15);
		getContentPane().add(label_29);
		
		
		
		
	}
	private Connection ConnectDB() {
		String Driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost/dbnutrient?characterEncoding=euc-kr&user=root&password=root";
		String USER = "root";
		String PASS = "root";
		try {
			Class.forName(Driver);
			return DriverManager.getConnection(URL);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
