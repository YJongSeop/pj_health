package pj_health;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.*;

class kh extends JFrame{
   
   JPanel P= new JPanel();
   JPanel PCENTER = new JPanel();
   JPanel PSOUTH = new JPanel();
   
   JTextField tf1 = new JTextField(5);
   JTextField tf2 = new JTextField(5);
   JTextField tf3 = new JTextField(5);
   
   JTextField tf5 = new JTextField(20);
   
   JButton bt1 = new JButton("���");
   JButton bt2 = new JButton("�����");

   JLabel  la1= new JLabel("����� ü��(kg)");
   JLabel la2= new JLabel("�޸��Ÿ�(km)");
   JLabel la3= new JLabel("Į�θ� �Һ�");
   JLabel la4 = new JLabel("���");
   
   GridLayout GL = new GridLayout(2,4);
   BorderLayout BL = new BorderLayout();
      
   KGC lis1 = new KGC();
   KMC lis2 = new KMC();
   
   
   kh(){
         setTitle("Į�θ�����");
         setVisible(true);
         setSize(500,300);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
      add(P);
      P.setLayout(BL);   
      P.add(PCENTER,BL.CENTER);
      P.add(PSOUTH,BL.SOUTH );
      
      PSOUTH.add(la4);
      PSOUTH.add(tf5);
      
      
      PCENTER.setLayout(GL);
      PCENTER.add(la1);
      PCENTER.add(la2);
      PCENTER.add(la3);
      PCENTER.add(bt1);
      PCENTER.add(tf1);
      PCENTER.add(tf2);
      PCENTER.add(tf3);
      
      PCENTER.add(bt2);
      
   
      bt1.addActionListener(lis1);
      bt2.addActionListener(lis2);
   
   }
   class KGC implements ActionListener{
      public void actionPerformed(ActionEvent arg0) {
         // TODO Auto-generated method stub
              
           double num = Double.parseDouble(tf1.getText());
           double num2 = Double.parseDouble(tf1.getText());
           double found = num/0.45359;
           double mile = num/1.609;
        double sum = found+mile;
        String to = Double.toString(sum);
        tf3.setText(to);
        
        if(sum>40){
           tf5.setText("�谡 �ڲ� �������������� ?");
           
        }else{
           tf5.setText("�ǰ��մϴ�");
           
        }
      }
   }
   class KMC implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent e) {
         // TODO Auto-generated method stub
         tf1.setText(null);
         tf2.setText(null);
         tf3.setText(null);    
      }
   } 
}

public class TestCal extends JFrame {
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new kh();
   }

}