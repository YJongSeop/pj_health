import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NutrientDB  extends JFrame{
	String[] listValues = new String[] {"탄수화물", "지방", "단백질", "무기염류", "비타민 A", "비타민 D", 
													   "비타민 E", "비타민 K", "비타민 B", "비타민 C"};
	
	//전역 객체
	JList list;
	JScrollPane pane;
	JScrollPane scrollPane;
	JTextArea textArea;
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension ScreenSize = tk.getScreenSize();
	
	public NutrientDB() {
		setSize(600,500);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("영양소 사전");
		getContentPane().setLayout(null);
		
		try{
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //LookAndFeel Windows 스타일 적용
			SwingUtilities.updateComponentTreeUI(getContentPane());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JLabel topInfo = new JLabel("<html>영양소 사전에 오신것을 환영합니다. 주요 영양소에 대한 정보를 알 수 있습니다."
				+ "<br> 원하는 목차를 클릭하면 해당 영양소에 대한 정보를 보여줍니다. </html>");
		topInfo.setBounds(12, 10, 490, 43);
		getContentPane().add(topInfo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "내용", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(158, 63, 424, 398);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(3, 17, 329, 249);
		panel.add(textArea);
		
		scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(3, 19, 418, 376);
		scrollPane.setAutoscrolls(false);
		panel.add(scrollPane);
		
		list = new JList(listValues);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				int index = list.getSelectedIndex(); //최초 시작(맨위 리스트)는 0으로 시작한다 주의!
				

				
				if(index == 0) { // 탄수화물
					textArea.setText(
					"탄화수소(hydrocarbon)의 일종이다. \n\n"
					+ "우리 인체의 에너지를 생산하는 주 원소로, 영양학적으로는 1g당 4kcal의 열량을 가진다.\n"
					+ "구성원소는 지질(lipid)과 같이 C, H, O이며, 탄수화물이란 이름은 대개의 탄수화물의 분자식이  Cn(H2O)m의 형태라"
					+ "'탄소'와 '물'이 화합한 수화물로 착각한 데에서 유래한다. \n"
					+ "우리가 흔히 단맛을 느끼는 당류와 당류가 결합되어 만들어진 곡물류에서 다량 함유되어 있는 녹말, 그리고 섬유질 등이 전부 탄수화물의 범위에 속한다. \n"
					+ "크게 포도당(glucose), 과당(fructose)을 말하는 <단당류>,\n"
					+ "설탕(sucrose), 유당(lactose), 맥아당(maltose)의 <이당류>,\n"
					+ "올리고당류(oligosaccharide), 녹말, 글리코겐(glycogen), 셀룰로오스의 <다당류>로 분류한다.\n\n"
					+ "섭취된 탄수화물은 분해, 변형되어 최종적으로는 6탄당인 포도당의 상태로 우리 몸에서 이용된다."
					+ "녹말은 이러한 당의 집합체로서 매우 훌륭한 에너지원이지만 셀룰로오스는 분해효소가 없기 때문에 체외로 그냥 배출된다."
					+ "셀룰로오스는 부피가 크고 수분을 많이 흡수하기 때문에 변비를 예방하는 데 도움이 된다. 다만 섬유가 길어야 효과를 보기 때문에 야채주스 같은 것을 먹는것 보다는 과일을 먹는것이 좋다. \n\n"
					+ "우리의 뇌와 적혈구는 포도당을 최우선적인 에너지원으로 쓰기 때문에 장기간의 단식은 악영향을 끼칠 수 있다. 일단 지질을 분해해서 어느 정도의 보충은 가능하지만 생리적 균형을 깨트리기 때문에 이는 매우 위험하니 꼭 균형잡힌 식사를 하자."
					);
					textArea.setSelectionStart(0);
					textArea.setSelectionEnd(0);
				} else if(index == 1) { //지방
					textArea.setText(
					"지질의 한 종류이며, 간혹 체지방과 혼란이 있는데, 체지방은 지방의 일종이다. \n" +
					"영양학적으로는 1g에 9kcal의 열량을 가지고 있다. \n\n"
					+ "관절의 윤활, 내부 장기의 보호, 단열, 세포막 구성등 폭넓게 중요한 역할을 하는 물질이다.\n"
					+ "사람에게도 상당 부분을 차지하는데, 보통 남자는 12~22%, 여자는 15~25% 정도다. 대체로 가슴과 엉덩이에 많고, 여자는 남자보다 근육이 적어서 비율이 좀 더 높은 편이다. \n\n"
					+ "식품에 있어서는 굉장이 중요한 역할을 하는 물질이다. 맛과 향을 책임지는 풍미성분들의 대부분은 지용성이다. 지방은 산업혁명에서도 중요하게 여겨졌으며, 집중된 엄청난 양의 인구수를 먹이기 위해서는 기존의 단백질과 탄수화물 보다는 고열량의 지방이 필요하기 때문이다. \n"
					+ "실제로도 한 문명이 산업화를 시작하면 싸고 고지방 음식인 '튀김' 음식이 대세를 타기 시작하는 것을 알 수있다. 다만 현대인은 과하게 축적되서 문제이기 때문에 시간이 갈수록 급증하는 성인병의 원인이 되는 물질이기도 하다. 이는 극단적인 예이기도 하지만서도. \n\n"
					+ "고기, 생선, 달걀, 견과류 등의 식재료가 상대적으로 지방의 함량이 높다.\n\n"
					+ "다이어트 할 때, 우선 지방을 피하고 보는 경향이 있는데, 사실 같은 칼로리라면 지방을 피하는 것보다는 탄수화물을 줄이는 게 훨씬 효과적이다. 역으로 총 섭취 칼로리가 훨씬 높음에도 지방을 많이 먹고 탄수화물을 확 줄이는게 단순히 지방 섭취를 줄이는 것보다 훨씬, 많이 빠진다!"
					+ " 단백질과 지방 섭취를 늘리고 탄수화물을 줄여서 살을 빼는 건 생물학적으로도 일리 있는 주장이다. 지방 축적에 주 역할을 하는 혈당 변화를 최소화 할 수 있기 때문이다. 이러한 우리나라에서도 유행했던 LCHF(Low Carb High Fat), 속칭 저탄수 고지방 다이어트의 핵심이다.\n\n"
					+ "다만 그렇다고 탄수화물을 먹지 않거나 하는건 바람직하지 않고, 적게 먹는것은 생각보다 훨씬 힘들다는것을 감안해야한다. 지방 섭취율 또한 최대 권장량이 30프로 이므로, 이걸 초과할수도 없다. 이 섭취율을 무기질, 단백질, 비타민 등으로 어떻게 때문다고 해도"
					+ " 결국에는 탄수화물을 일정 퍼센트 이상 섭취해야 어떤 영양소든 최대 권장량을 넘지 않는다는 결론이 나오니 이를 유의하면서 체크하도록 하자."
					);
					textArea.setSelectionStart(0);
					textArea.setSelectionEnd(0);
				} else if(index == 2) { //단백질
					textArea.setText(
					"인체를 비롯한 지구 상의 모든 생물체를 구성하는 물질 중 하나, 한마디로 생명의 근원이자 원천이다. \n\n"
					+ "영양학적으로 1g에 4kcal의 열량을 가지고 있다. \n\n"
					+ "생물체 내에서 단백질은 만능이라 해도 좋을 정도로 다양한 사용처를 가진다. 생물체 내에서 일어나는 복잡한 화학 반응을 일으키는 효소들은 대부분 단백질이다. 근욕과 같이 몸을 구성하는 역할을 할 뿐만 아니라 면역에 중요한 항체도 단백질이고, DNA 사슬을 감아 뭉치고 유전정보를 저장하는 '히스톤'도 단백질이다.\n\n"
					+ "단백질이 들어간 식재료라고 해서 모두 같은것은 아니다. 사실 단백질은 몸 속에 들어가면 단백질 분해효소인 트립신을 통해 아미노산으로 잘게 쪼개져서 단백질 자체는 등급을 매길 필요가 없다. 한우를 먹든 닭가슴살을 먹는 동일한 효과다."
					+ "문제가 되는것은 단백질 자체의 경우는 필수 아미노산의 비율이며, 전체 단백질에서 필수아미노산의 함량이 얼마나 높냐가 단백질의 질을 좌우한다.\n\n"
					+ "우리 몸은 단백질을 아미노산으로 분해하여 소장의 융털에서 최종적으로 흡수한다. 이 흡수한 아미노산을 가지고 다시 우리몸을 구성하는 단백질로 재구성하게 되는데, 이를 아미노산 대사라고 한다. 조직 단백질 일수도 있으며, 효소나 호르몬, 항체등의 다른 대사일수도 있다. \n\n"
					+ "하지만 무조건 적인 단백질의 섭취가 꼭 좋은것은 아니다. 식품을 잘 고를때 포화지방이나 첨가물등의 혼합 여부도 중요하다. 햄, 소시지 같은 가공육들은 하급한 단백질이라 나쁜게 아니라 포화지방, 밀가루 등을 섞고 유해한 첨가제등을 넣기 때문에 나쁜것이다. 이런 정크푸드와 연을 끊는것이 건강을 지키는 중요한 행동이 될 것이다."
					);
					textArea.setSelectionStart(0);
					textArea.setSelectionEnd(0);
				} else if(index == 3) { //무기염류
					textArea.setText(
					"흔히 부르는 미네랄(Mineral)이 무기염류이다. 무기질이라고 부르기도 하며, 인체에 필요한 무기화합물들을 통틀어서 말한다. \n\n"
					+ "인체의 구성 성분이며, 단백질-지방-탄수화물-비타민과 함께 5대 영양소의 하나다. 인체 내에서 여러 가지 생리적 활동에 참여하고 있다.\n\n"
					+ "미량으로도 충분하지만, 없어서는 안되는 것들이다. 따라서 이들 무기염류의 섭취가 부족하면 각종 결핍증을 유발하며, 이들의 섭취가 매우 중요하다! \n\n"
					+ "칼슘(Ca)·인(P)·칼륨(K)·나트륨(Na)·염소(Cl)·마그네슘(Mg)·철(Fe)·아이오딘(I)·구리(Cu)·아연(Zn)·망간(Mn)·크로뮴(Cr)·바나듐(V)·몰리브덴(Mo) 등 이 있다.\n\n"
					+ "칼슘은 체중의 약 2%를 차지하며, 그 대부분이 인산칼슘의 형태로 뼈와 이(齒)의 성분을 이룬다. 이밖에 혈장 중에 약간 존재하며 근육 및 신경의 기능조절, 혈액응고에 필요하다. 칼슘이 부족하면 구루병이 생기거나 근육운동의 부조화가 일어난다.\n\n"
					+ "부갑상선 호르몬은 혈장 중의 칼슘 농도를 정상으로 유지시키는 작용이 있다. 그래서 부갑상선을 제거하면 혈장 내 칼슘 함량이 내려가 테타니라고 하는 특수한 경련을 일으켜 사망한다.\n\n"
					+ "인은 칼슘 다음으로 체내에 많다. 그 대부분은 인산칼슘으로서 뼈와 이(齒)에 존재하고 나머지는 인(燐)지질·핵산으로서 모든 조직을 구성한다. 또 생물체 내의 물질대사에 기본적으로 중요한 역할을 한다. 음식물 속의 인산화합물은 소화에 의해 무기인산염이 되어 흡수된다. 무기인산염이 되어도 흡수되는 것은 2분의 1 정도다. 영양 소요량으로서 1인 1일당 1g으로 되어 있으나, 한국인은 곡물을 많이 먹기 때문에 1.3g으로 약간 과다하게 섭취하고 있다.\n\n" 
					+ "칼륨은 세포 외액에는 적지만 세포 내에는 다량 존재하며, 세포기능에 중요한 역할을 한다. 혈장 중의 칼륨은 근육 및 신경의 기능조절에 필요하고 이것이 너무 저하되면 근육마비를 일으킨다. 채소류에 많이 함유되어 있으며, 보통 매일 2∼3%를 취하면 결핍을 일으키는 일은 없다. \n\n" 
					+ "나트륨은 칼륨과 반대로 세포 내에는 적고 세포 외액에 주로 존재하며, 삼투압(渗透壓)을 바르게 유지한다. 음식에는 보통 식염의 형식으로 섭취되어 소변으로 배설되지만, 식염의 섭취가 없으면 즉시 신장에서의 나트륨 배설이 정지되어 결핍은 일어나지 않는다. 그러나 땀이 심하게 날 때에는 식염분이 땀과 함께 대량 상실된다. 그러므로 식염을 충분히 보충하지 않으면 나트륨 상실을 초래하여 혈압저하, 근육경련 등의 장애를 일으킨다. \n\n"
					+ "염소는 보통 나트륨에 수반하여 체내에 분포하며, 위액의 염산으로서 분비된다. 식염으로서 나트륨과 함께 섭취되어 대사도 거의 나트륨과 같다. 한국인은 매일 10∼20g 이상의 식염을 섭취하고 있다. \n\n" 
					+ "마그네슘은 체내 약 0.1%를 차지하며 칼슘과 함께 뼈에 함유되어 있다. 마그네슘은 근육과 신경의 기능을 유지하고, 에너지를 발생시키며 단백질 합성의 촉매로 작용한다. 칼슘, 칼륨, 나트륨 등 다른 무기염류의 대사에도 영향을 미치므로 마그네슘이 체내에 부족시 질병에 걸리거나 기존의 질병이 악화될 수 있다. 마그네슘은 녹색 야채, 호두·땅콩과 같은 견과류, 정제하지 않은 곡물 등에 많이 들어 있다. \n\n"
					+ "철은 체내의 절반 이상이 적혈구인 헤모글로빈의 성분으로서 산소 운반에 관여한다. 장에서 흡수하는 것은 무기철염이고, 2가철염(二價鐵鹽)이 3가철염보다 흡수는 좋으나, 어느 쪽이든 흡수율은 몇 %에 불과하다. \n\n"
					+ "그러나 출혈에 의한 빈혈, 성장기 등에서는 수요가 커서 흡수율도 좋아진다. 태아는 출산 전에 간에 철을 저장해 둔다. 하지만 수유기간이 너무 길면 철 저장이 고갈되어 빈혈을 일으킨다. 성인의 필요량은 1일 10mg 정도이며, 출혈성 질환·월경개시기·임신·출산·성장기에는 수요가 높아져 음식의 종류에 주의하지 않으면 결핍되기 쉽다. \n\n"
					+ "아이오딘은 갑상선에 대부분이 모여 그 호르몬의 구성 성분이다. 바다에서 떨어진 내륙지방에서는 아이오딘의 결핍으로 갑상선 기능이 마비되어, 지방병성 갑상선종이 다발한다. 아메리카 내륙의 주(州)에서는 법령으로 식염에 아이오딘염(鹽)을 혼입시켜 질병을 예방하고 있다. 한국인은 아이오딘이 풍부한 해조류를 먹고, 음료수에도 아이오딘이 함유되어 있어서 아이오딘 결핍 현상이 적다.\n\n"
					+ "구리·망가니즈·아연은 모두 동물실험에서 필수불가결한 원소임이 판명되었다. 그러나 극히 미량만 있으면 족하기 때문에 인간에게서는 결핍이 나타나지 않는다. 구리가 결핍되면 헤모글로빈의 생성이 줄어들어 빈혈을 일으킨다. 망가니즈가 결핍되면 동물은 생식능력을 잃고, 아연이 결핍되면 성장하는 데에 지장을 받는다.\n\n"
					+ "크로뮴이 모자랄 경우, 좀 더 정확히는 장기간 수액으로만 영양을 섭취한 사람들에게서 나타날 경우, 심각한 내당능 장애, 체중 감소를 일으키며,  몰리브덴이 모자랄 경우, 이란 - 중국 북부(베이징도 포함된다)에서 식도암의 발병율이 높아진다는 논문이 있으며, 바나듐은 닭과 쥐에서 실험을 한 결과 모자르면 성장이 느려지고 생식능력이 저하된다는 결과가 있다.\n\n"
					+ "플루오린이 음료수 속에 적당량(100만분의 1 정도) 있으면 충치가 적다는 통계 가 있다. 그래서 외국에서는 수돗물에 플루오린화물을 가하는 곳도 있다. 그러나 물 속에 플루오린의 함량이 과다하면 반상치(斑狀齒)라 하여 이(齒)의 표면에 반점이 생기고 약해진다. 오늘날에는 특히 어린이들의 치아에 플루오린을 도포하여 충치를 예방한다. 게다가 플루오린은 원소 중 가장 큰 반응성을 보이는 물질만큼이나 엄청난 독성을 지닌다."
					);
					textArea.setSelectionStart(0);
					textArea.setSelectionEnd(0);
				} else if(index == 4) { //비타민 A
					textArea.setText(
					"지용성 비타민의 한 종류. 정상적인 성장과 발달, 생식, 상피세포의 분화, 세포 분열, 유전자 조절 그리고 정상적인 면역반응에 중요한 역할을 한다. 비타민 A는 기본 분자인 레티놀과 시각색소로 작용하는 레티날, 세포 분화를 조절하는 세포 내 신호전달물질인 레티노산 등 다양한 레티노이드 형태로 존재한다. 녹황색 채소나 해조류에 함유된 베타카로틴은 장과 간에서 레티놀로 전환될 수 있어 비타민 A 전구체로 간주된다. \n\n"
					+ "결핍 증상으로 야맹증이 유명하다. 안구의 시야인식기작에 중요한 물질이기 때문. 그 외 안구건조증이 나타날 수 있고 심할 경우 사망에 이를 수 있다. 과용시 세포막의 안정성 저해, 간 조직 손상, 지방간, 기형아 출산, 골격 약화 등의 부작용이 나타난다.\n\n"
					+ "비타민 A는 간, 우유, 달걀, 지방이 많은 생선 등의 동물성 식품과 비타민 A 전구체가 많이 함유된 녹황색 채소, 과일과 같은 식물성 식품에서 섭취할 수 있다. 식물의 비타민 A는 카로틴이라는 전구체 형태로 함유되어 있는데, 카로틴(베타카로틴)은 레티놀 분자 두 개가 선형으로 이어진 형태를 이루고 있으며, 소화과정에서 반으로 쪼개져서 두 개의 레티놀 분자로 변환된다.\n\n"
					+ "비타민 A의 단위는 RAE(Retinol Activity Equivalents, 레티놀 활성당량)으로 표시한다. 채소보다 동물성 식품이 훨씬 RAE 수치가 높기 때문에 동물성 식품으로 섭취하는 편이 효율이 좋다.\n\n"
					+ "구조나 이명을 보면 알겠지만, 알코올의 일종이기도 하다.\n\n\n"
					+ "지용성으로 몸밖으로 배출이 잘 되지 않기 때문에 한번에 체중 1kg당 25,000 IU 이상 섭취하게 되면 급성 간독성이 일어나 죽을 수도 있다. 또한 체중 1kg당 4,000 IU(예컨대 체중 70kg 성인의 경우 280,000 IU)를 지속적으로 꾸준히 섭취할 경우 만성 독성이 나타날 수 있다. 특히 조심해야 할 식품이 있으니 바로 북극곰의 간이다. \n\n"
					+ "북극곰은 비타민A가 극도로 풍부한 먹이사슬의 정점에서 살아가기 위해서 대다수의 동물을 죽일 정도의 비타민A도 견뎌내는 것이 가능하다. 물범 등을 사냥하면서 통해서 축적된 비타민A는 북극곰의 간에 쌓이게 되고 결과적으로 북극곰의 간은 생물에게 매우 위험한 유독성 물질이 되었다. 물론 어떻게 될지는 모르겠지만 혹시나가 사실이 될수도 있다. 상식으로 알아두자."
					);
					textArea.setSelectionStart(0);
					textArea.setSelectionEnd(0);
				} else if(index == 5) { //비타민 D
					textArea.setText(
					"지용성 비타민의 한 종류. 칼슘 대사를 조절하여 체내 칼슘 농도의 항상성과 뼈의 건강을 유지하는데 관여하고 세포의 증식 및 분화의 조절, 면역기능 등에 관여하는 것으로 알려져 있다. 부족시 구루병, 골연화증, 골다공증의 위험이 높아지고 심혈관계 질환, 당뇨병, 일부 암 등의 발병 위험이 증가하는 것으로 보고되고 있다. 특히, 비타민 D는 스테로이드 호르몬과 유사한 프로호르몬으로 작용하는 것으로 알려지면서 그 중요성이 부각되고 있다.\n\n"
					+ "고리구조를 일부 파손시킨 스테로이드라는 매우 특이한 물질이다. 비타민 D의 합성이 실제로 콜레스테롤류를 자외선을 통해 반응시켜 이루어진다. 비타민 D는 대사되면서 칼시트리올이라는 스테로이드 호르몬 비스무리한 것으로 바뀐다. 필수적으로 섭취해야하는 영양성분중에서는 혼자 굉장히 이질적인 위치에 있는 물질. 분명 이거 신호전달물질일 뿐더러, 그것도 스테로이드 비스무리한 건데 어째 섭취해야만 한다.\n\n"
					+ "인체에 쓸모가 있는 종류로는 콜레칼시페롤(D3)과 에르고칼시페리롤(D2)의 두 종류가 있다. 전자는 동물에, 후자는 균류(버섯, 곰팡이)에 많이 들어 있다. 대부분의 동물과 균류 대부분 종에서 비타민 D가 필수적으로 포함되어 있는 반면에, 식물은 토마토 등 일부 종에서만 소량 발견된다. \n\n"
					+ "콜레칼시페롤은 피부에서 자외선을 통해 합성되며, 여러 식품을 통해 섭취할 수도 있다. 에르고칼시페리롤은 주로 균류가 에르고스테롤이라는 콜레스테롤과 자외선으로 합성한 것을 섭취함으로 얻을 수 있다. 둘다 결국에는 칼시트리올로 대사되지만, 인체에서 직접 합성해서 쓰는 형태인 콜레칼시페롤이 더 유용하다고 여겨지는 듯.\n\n"
					+ "사람은 식품을 통해 섭취하거나 피부에 자외선을 받아서 콜레스테롤에서 만들어낸다. 햇빛으로 충분한 비타민 D를 얻으려면 일주일에 한두 시간 정도는 햇빛을 받아줘야한다. 태양이 내리쬐는 여름이 아니라면 더욱 시간이 필요하다. 피부에서 만들어 내거나 식품에서 흡수한 비타민 D는 간과 신장에서 수산화되어 활성 비타민으로서 일을 하게 된다. 그런데 식품으로 섭취한 비타민D는 간에서 자외선이나 햇빛의 도움 없이 CYP2R1이 활성화하므로 굳이 햇볕을 따로 쬘 필요는 없다는 의견이 있다. 이에 대해 일부 전문가들은 음식으로만 비타민D를 보충하려 하는 걸 추천하지 않으나, 문제는 자외선은 1군 발암물질이며 눈에도 손상을 입힌다는 것. \n\n"
					+ "보건복지부에서 발행한 2015년 한국인 영양소 섭취기준에 의하면 한국인이 주로 먹는 자연식품에는 비타민D가 많은 식품이 적어 섭취만으로 비타민D를 보충하기가 상당히 어렵다고 한다.\n\n" 
					+ "비타민 D가 가장 풍부한 음식은 생선류이며 소위 '등푸른 생선'이라고 불리는 종류에 많다. 대구의 간유 1 티스푼 또는 연어, 정어리, 고등어, 참치, 삼치 100~200g 정도면 1일 권장량의 100%에 해당하는 400IU를 섭취할 수 있다. 달걀 등 동물의 알이나 버섯, 견과류, 우유 및 유제품, 육류의 간 등에도 들어있긴 한데 이것만으로 1일 권장량만큼 채우려면 굉장히 많이 먹어야 한다. 성인기준 그냥 우유라면 경우 약 3.3리터를 마셔야 일일 권장량이 되고, 달걀은 10알, 표고버섯은 500g 정도. 단일 식품 섭취로 비타민D를 보충하려면 생선류와 목이버섯 정도 말고는 답이 없다. 한국에서 생선을 먹긴 하지만 매일 먹는 사람은 드물고, 목이버섯은 건조중량 기준 1~2g이면 하루 권장량을 채울 수 있으나 한식에선 그리 친숙한 식재료는 아니다. 따라서 비타민 D를 강화한 식품(주로 오렌지 쥬스나 유제품, 시리얼 등)으로 섭취하는 것도 권장하고 있다. 아래에 서술되지만 한국인은 햇볕을 쬐는 양도 부족하고 전반적으로 비타민 D 부족이라 섭취가 어려운만큼 더욱 신경써서 비타민 D를 섭취할 수 있도록 식단을 짜야 한다. \n\n"
					+ "칼슘 대사의 필수요소로, 대부분의 칼슘 보충제는 칼슘에 비타민 D를 혼합한 형태로 되어 있다. 비타민D 결핍증으로 당뇨병, 유방암, 전립선암, 폐암, 대장암, 골다공증, 고혈압, 피부병(건선, 습진, 흑색종 등), 비만, 구루병, 근육통, 충치, 천식, 피곤, 자폐증, 시력감퇴, 난청, 불면증, 편두통, 정신분열증, 우울증, 기억력감퇴, 치매가 있다. 햇볕이 부족한 극지방에 근접한 국가에 거주하는 사람일수록 암 발병률이 높다. 그래서 비타민D결핍이 암 발병에도 영향을 주는 것으로 파악되고 있다."
					);
					textArea.setSelectionStart(0);
					textArea.setSelectionEnd(0);
				} else if(index == 6) { //비타민 E
					textArea.setText(
					"비타민E는 지용성 비타민의 일종으로서 화학명은 \"토코페롤\"이다."
					+ "각종 독소와 발암물질(수은, 납, 오존, 아산화질소)로부터 인체를 지켜준다. 혈관의 탄력을 유지하고 생체막에서 지방질(LDL)의 산화를 억제해서 세포막을 산화시키지 않으려는 작용을 하는 강력한 항 노화물질이다. 또한, 적혈구 보호, 세포호흡, 헴 합성 및 혈소판 응집에 관여한다. \n\n"
					+ "심장혈관질환, 협심증, 동맥경화증, 혈전 정맥염 치료에 효과적이라고 주장하는 이들도 있으나 현재 의학계에서 비타민E의 효과가 다른 대조군에 비해 다른 점이 없다는 사실이 드러나 국내외 치료기관에서는 비타민E를 치료제로 처방하지 않는다. 마찬가지로 비타민E는 몇몇 나라에서 식품으로 분류되며 의약품으로의 판매를 허가하지 않고 있지만, 캐나다 등 어떤 나라들에서는 피부에 남은 흉터에 대한 처방 등의 목적으로 비타민E 연고를 구매하는 것이 가능하다고도 한다.\n\n"
					+ "암, 특히 구강암, 후두암, 전립선암 등 종양치료에 효과가 있으나 동시에 발암을 일으켜 재발 가능성을 높인다는 것이 최근 발견되었다.  당연한게 항산화제인 비타민E 는 산화제인 활성산소의 작용을 억제한다. 활성산소는 각종 염증과 노화를 일으키는 주범이기도 하지만 암세포를 공격하며 사멸시키는 역할도 한다. 이는 비타민C 와 같은 다른 종류의 항산화제도 마찬가지다. 고로 가족력이 있다거나 흡연자같은 발암인자가 있는 사람은 모든종류의 항산화제 복용에 주의해야 한다. 하지만 야채나 과일로서 흡수되는 경우는 예외인듯 하다. \n\n"
					+ "결핍되면 노화, 불임 등의 증상이 나타나며, 부작용으로 발암, 출혈, 설사, 두통 등의 증상이 나타난다.\n\n" 
					+ "비타민E가 많은 음식에는식물성 기름, 견과류, 토마토, 감귤, 키위, 브로콜리, 현미, 무, 호박 등이 있다. 영양제에 포함되어 있는 비타민E는 전부 석유에서 추출한 것이다. 이는 식품에서 추출하게 되면 폐기율이 높아 지나치게 비용이 상승하기 때문이다. 일부 학자들은 석유에서 토코페롤을 추출하여 합성하는 과정에서 발암성을 띄게 된다는 가설을 제시하기도 하였으나 최근의 연구는 견과류에서 추출한 비타민E를 사용하였기 때문에 비타민E 자체에 위험성이 있음이 확인되었다. \n\n"
					);
					textArea.setSelectionStart(0);
					textArea.setSelectionEnd(0);
				} else if(index == 7) { //비타민 K
					textArea.setText(
					"비타민 K, 사슬이 어떤 형태냐에 따라 필로퀴논(Phylloquinone; K1)과 메나퀴논(Menaquinone; K2)으로 나뉜다. 필로퀴논은 주로 식물에서 합성되고 메나퀴논은 박테리아에 의해 합성된다. 지용성 비타민의 한 종류이다. 결핍 시 골(뼈) 손실을 일으키거나 지혈에 어려움을 겪을 수 있고, 출혈을 야기시키기도 한다. 반대로 얘기하면, 과다하게 섭취하면 혈전을 일으키거나 할 수 있다는 뜻. 뭐든지 남용하면 안 좋다. 특히 지용성 비타민은 몸에 축적되므로 섭취에 주의하자. 이외에 독성으로 용혈작용, 황달, 과빌리루빈혈증, 알러지, 고혈압, 심장통증 등이 있다.\r\n" + 
					"인체 내에서 합성되는 비타민이다. 정확히는 인체 내가 아니라, 장 내 대장균의 일종이 합성해내는 것이다. 따라서 항생제의 장기간 사용 등 대장균이 파괴되지 않는 정상적인 상태면 따로 섭취할 필요성이 없는 비타민이다. \n\n"
					+ "대부분의 채소(양배추, 상추, 파슬리, 브로콜리, 콩, 시금치, 부추, 케일, 순무, 오이(껍질), 냉이, 녹차, 클로렐라 등등), 소간, 선지, 돼지간, 그리고 식물성 기름(올리브 오일, 콩기름, 마요네즈 등) 에 많이 들어있다. \n\n"
					+ "비타민 K가 결핍되게 되면 다양한 원인에 의해 결핍증이 나타나게 된다. 우선 흔한 이유 중 하나로, 금식(NPO)을 하는 환자에게 항생제를 투여할 경우 흔히 나타나게 된다. 이는, 위에 서술되었듯, 비타민K장 내 대장균에 의해 합성되고 생산되는데, 항생제로 인해 대장균이 억제되고 금식 때문에 음식을 통한 공급이 차단되면서 증상이 나타나게 된다. 또한 지용성 비타민의 흡수 장애(malabsorption)으로 인해 발생하기도 한다. 이는 만성췌장염, 크론병 및 궤양성 대장염(ulcerative colitis) 등의 염증상 장 질환, 폐색성황달(obstructive jaundice)을 일으키는 다양한 원인 - 췌장암, 총담관결석증(choledocholithiasis), 원발 쓸개관 간경화(PBC) 및 원발 경화성 담관염(PSC) 등으로 인해 비타민K 결핍이 보이게 된다. 또한 와파린(warfarin) 투여 시 증상이 나타나기도 한다. \n\n"
					);
					textArea.setSelectionStart(0);
					textArea.setSelectionEnd(0);
				} else if(index == 8) { //비타민 B
					textArea.setText(
					"수용성 비타민의 일종이며, 아데닌(Adenine), 인산아데노신(Adenosine monophosphate), 파라아미노안식향산(4-Aminobenzoic acid), 판감산(Pangamic acid), 디메틸글리신(Dimethylglycine), 카르니틴(Carnitine), 콜린(Choline) 등은 인체에서 합성이 가능하다. \n\n"
					+ "비타민 B 복합체는 신체에서 각종 물질 대사에 작용하는 물질들이다. 물론 이중에서 체내 합성이 가능한 것들은 실질적으로 비타민으로 취급하지 않으며, 따라서 비타민 B 복합체의 결번들을 이룬다. \n\n"
					+ "비타민B복합체는 여러 수용성 비타민의 복합체로서, 세포의 물질 대사를 돕는 조효소의 역할을 하는 것으로 알려져 있다. 일본에서는 비타민 B군(群)이라고 부른다. \n\n"
					+ "복합체라고 불리는 이유는, 원래 비타민 B 복합체를 구성하는 물질들, 즉 물질 대사의 조효소 역할을 하는 비타민B라는 하나의 물질이 존재한다고 추정되어 비타민 B로 명명되었기 때문이며, 이후 연구를 통하여 여러 복합적인 물질들이 물질 대사에 관여하는 것이 밝혀져, 비타민 B의 역할, 즉 세포 대사에 관여 하는 수용성 조효소를 묶어 분류한 것이 비타민 B 복합체다. \n\n"
					+ "채식주의자들에게는 다른 비타민보다 특히 결핍되기 쉬운 비타민인데, B1로 분류되는 티아민은 정말 짧은 체내 반감기로 엄청나게 부실한 저장성을 자랑한다. 그리고 B12는 인체에서 합성되지 않고, 이걸 합성이 가능한 생물은 효모 내지는 일부의 해조류, 그리고 고기를 통해 섭취하는 것 말곤 답이 없다. 식물 중에서 일부 해조류에도 존재는 하지만 대부분의 해조류는 이성질체인 pseudovitamin B12으로, 이것은 인간을 포함한 포유류에서는 불활성되어 생물학적으로 사용이 불가능, 동시에 섭취시 비타민 B12의 흡수를 방해한다. 김 종류에 상당량 있긴 하지만 서구권에서는 동양권 요리로 접하지 않는이상 김을 먹을 가능성이 없다. 이때문에 효모 추출물(마마이트 등)이나 비타민 영양제로 따로 섭취해 반드시 보충해야한다. \n\n"
					+ "인체에는 물질 대사기능의 증진 및 보조, 피부 및 근육 조직의 유지, 면역 및 신경 작용 증진, 혈구 및 세포 성장, 암 예방에 도움을 준다."
					);
					textArea.setSelectionStart(0);
					textArea.setSelectionEnd(0);
				} else if(index == 9) { //비타민 C
					textArea.setText(
					"수용성 비타민 중의 하나로, 아스코르브산(ascorbic acid)라고도 한다. 생물의 에너지 대사과정에서 필수적인 조효소로 작용하며 항산화 작용에도 관여하는 물질이다. 다른 동물들의 경우 체내에서 어느정도 자체적으로 합성이 가능하나, 사람을 포함한 영장류와 설치류 중 기니피그는 체내의 아스코르브산 합성에 관여하는 효소가 결핍되어 있기 때문에 반드시 외부에서 섭취해야만 한다. \n\n"
					+ "하루 10mg만 먹어도 괴혈병을 예방할 수 있으며 60mg이면 4~6주 동안 괴혈병을 방지할 수 있다고 한다. 모 실험에선 20대남성 기준 200mg이 최적량이라고 하기도 한다. 밑에 후술하겠지만 고용량 비타민c 용법에선 하루에 무려 3g~12g(보통 6~10g사이)의 비타민c를 먹어야한다고 주장하기도 한다.\n\n" 
					+ "수용성이기 때문에 다량 섭취해도 신체에 저장되지 않으며, 소모되고 남는 것은 소변으로 빠져나가 버리기 때문에 지용성 비타민에 비해 과량섭취해도 안전하다. 그래도 고용량 요법 같은 과다복용시엔 부작용을 겪을 수 있는데 대표적인게 설사나 속쓰림 또는 방귀 정도이지만 요로결석의 위험성을 증가시킨다는 연구들도 존재한다. 치사량도 있긴한데 11,900mg/kg. 60kg의 성인이라면 714g, 즉 레모나 3500개 분량 혹은 비타500 1428개 분량. 걱정할건 없는게 후자의 경우 1/10을 채 먹기 전에 물중독으로 사망한다. \n\n"
					+ "비타민C가 관여하는 에너지 대사 작용은 주로 낮에 일어나기 때문에 취침하는 밤보다는 낮에 섭취하는 것이 더 좋다고 한다. 또 수용성이라 몇 시간 후면 체외로 배출되기 때문에 몇시간 간격으로 식후에 나눠먹는 것이 좋다. \n\n"
					+ "특유의 오각형 고리 구조 때문에 약 70도 이상의 열을 가하면 구조가 깨진다. 햇빛에 말려도 마찬가지고, 갈아서 먹더라도 채소 내의 비타민C 분해 효소인 아스코르비나아제가 비타민C를 파괴한다. 오이의 경우가 대표적이다. 이 때문에 채소를 갈아먹는 것보다 되도록이면 날 것으로 먹는게 좋다. \n\n"
					+ "자연계에도 흔히 존재하고, 음료 등에 첨가되는 안식향산나트륨과 반응하여 1급 발암물질인 벤젠으로 합성될 수 있기 때문에, 이 사실이 대중에게 잘 알려진 2006년경 논란이 되었던 적이 있으나, 벤젠의 주요 섭취경로나 위험도를 생각해봤을 때 이러한 섭취경로가 인간에게 영향을 주기는 어렵다고 알려져 있다. \n\n"
					+ "한편 동물 중에는 인간이나 기니피그 정도를 제외하고는 세포 내 포도당을 비타민C로 바꾸는 유전자가 들어있다. 인간의 경우 진화과정에서 그 유전자가 탈락했기 때문에 괴혈병에 걸린다고. 그렇기 때문에 인간을 제외한 육식동물이 채식을 하지 않고서도 살 수 있는 이유 중 하나다. \n\n"
					+ "비타민C의 부족은 괴혈병(Scurvy)을 유발할 수 있다. 20세기 초까지만 해도 비타민 C의 존재 자체가 알려져 있지 않았고, 주요한 비타민 C의 공급원인 신선한 과일과 채소를 제대로 섭취하기가 어려웠기 때문에 해군이나 선원들을 중심으로 괴혈병이 창궐하였다. 오늘날에는 비교적 과일과 채소가 흔하며 비타민 제제도 존재하므로 비타민 C를 구하는 것 자체는 쉬우나, 이런저런 이유 때문에 올바른 식생활을 하기가 어려운 사람들도 많다. \n\n"
					+ "비타민C하면 레몬이 유명하고 노란색이나 신 맛이 떠오르기도 하지만 사실 이건 착색, 착향이다. 같은 무게로 따지면 레몬보다는 파프리카나 피망, 고추 등에 함유된 비타민C가 더 많다. 이외 라임이나 매실에도 많이 들어있다."
					);
					textArea.setSelectionStart(0);
					textArea.setSelectionEnd(0);
				} else textArea.setText("아직 생성되지 않은 문서입니다.");
			}
		});
		list.setBounds(22, 83, 189, 217);
		getContentPane().add(list);
		
		pane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setBounds(12, 63, 140, 178);
		getContentPane().add(pane);
		
		
	}
	
	
	
	public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			new NutrientDB();
		}
	});	
	}
}
