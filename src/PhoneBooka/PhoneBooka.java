package PhoneBooka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class phone{
   String name;
   String tel;
   String Address;
   phone(String name,String tel,String Address){
       this.name=name;this.tel = tel;this.Address = Address; 
   }
}
public class PhoneBooka extends JFrame{
   JButton jb1 = new JButton("��ȸ");
   JButton jb2 = new JButton("�˻�");
   JButton jb3 = new JButton("����");
   JButton jb4 = new JButton("����");
   JTextArea jta = new JTextArea();
   JScrollPane js = new JScrollPane(jta);
   JTextField jt1 = new JTextField();
   JTextField jt2 = new JTextField();
   JTextField jt3 = new JTextField();
   HashMap<String, phone> map = new HashMap<String,phone>();
   String name ="";
   String tel = "";
   String Address = "";
   phone p;
   PhoneBooka(){
      setTitle("Phone Book");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      
      JPanel jp1 = new JPanel();
      jp1.setLayout(new GridLayout(1,4));
      jb1.addActionListener(new MyActionAll());
      jb2.addActionListener(new MyActionSearch());
      jb3.addActionListener(new MyActionAdd());
      jb4.addActionListener(new MyActionRem());
      jp1.add(jb1);jp1.add(jb2);
      jp1.add(jb3);jp1.add(jb4);
      jp1.setSize(400,30);
      jp1.setLocation(460,50);
      add(jp1);
      
      JPanel jp2 = new JPanel();
      jp2.setLayout(new GridLayout(3,1));
      jp2.add(new JLabel("��    ��"));jp2.add(new JLabel("��ȭ��ȣ"));
      jp2.add(new JLabel("��    ��"));
      jp2.setSize(80,90);
      jp2.setLocation(460,150);
      add(jp2);
      JPanel jp3 = new JPanel();
      jp3.setLayout(new GridLayout(3,1));
      jp3.add(jt1);jp3.add(jt2);jp3.add(jt3);
      jp3.setSize(320,90);
      jp3.setLocation(540,150);
      add(jp3);
      
      js.setSize(430,280);
      js.setLocation(10,10);
      add(js);
      setSize(900,350);
      setVisible(true);
   }
   class MyActionAdd implements ActionListener{
      public void actionPerformed(ActionEvent e){
         name = jt1.getText();
         Address =jt2.getText();
         tel = jt3.getText();
         
         p = new phone(name,tel,Address);
         map.put(name, p);
         jta.append(name + " �߰��Ϸ�\n");
         jt1.setText(null);jt2.setText(null);
         jt3.setText(null);
      }
   }
   class MyActionSearch implements ActionListener{
      public void actionPerformed(ActionEvent e){
         name = jt1.getText();
         p = map.get(name);
         if(p!=null){
            jta.append(" �̸� : "+p.name+" ��ȭ��ȣ : "+p.tel+" �ּ� : "+p.Address+"\n");
         }
         else{
            jta.append(" "+name + " ��ϵ��� ���� ���");
         }
         jt1.setText(null);
      }
   }
   class MyActionAll implements ActionListener{
      public void actionPerformed(ActionEvent e){
         
         Set<String>key = map.keySet();
         Vector<String>v=new Vector<String>();
         v.addAll(key);
         Collections.sort(v);
         jta.append("��ü����\n");
         for(int i=0;i<v.size();i++){
            String name = v.get(i);
            phone phones = map.get(name);
            jta.append(" �̸� : "+phones.name+" ��ȭ��ȣ : "+phones.tel+" �ּ� : "+phones.Address+"\n");
            }
      }
   }
   class MyActionRem implements ActionListener{
      public void actionPerformed(ActionEvent e){
         name = jt1.getText();
         p= map.get(name);
         if(p!=null){
            map.remove(name);
            jta.append(name + " �����Ϸ�\n");
         }
         else{
            jta.append(name + " ��ϵ��� ���� ���");
         }
         jt1.setText(null);
      }
   }
   public static void main(String[] args) {
      new PhoneBooka();
   }
} 