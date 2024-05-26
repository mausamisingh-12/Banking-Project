
package bank.management.system;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        
       ImageIcon icon=new ImageIcon(getClass() .getResource("atm.jpg"));
	Image i1=icon.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i1);
	JLabel label=new JLabel(i3);
	label.setBounds(70, 10, 100, 100);
	label.setBackground(Color.WHITE);
	add(label);
        
        
        
        back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        label.add(back);
        
        
        Conn c=new  Conn();
        int balance =0;
          try{
              ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
              
              while(rs.next()){
                  if(rs.getString("type").equals("Deposit")){
                      balance += Integer.parseInt (rs.getString("amount"));
                  }else{
                      balance -=Integer.parseInt(rs.getString("amount"));
                  }
              }
          }catch (Exception e){
                      System.out.println(e);
                      }
        
        
        
        JLabel text=new JLabel("Your Current Account Balance is Rs"+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        label.add(text);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
