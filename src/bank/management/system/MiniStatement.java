
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class MiniStatement extends JFrame implements ActionListener{
    JButton next;
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        JLabel balance=new JLabel();
        balance.setBounds(20,400,400,20);
        add(balance);
        
        
        
        
        JLabel bank=new JLabel("STATE BANK OF INDIA");
        bank.setBounds(100,20,400,20);
        bank.setForeground(new Color(59,88,128));
        bank.setFont(new Font("Raleway",Font.BOLD,20));
        add(bank);
        
        
        
        
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        try{
            Conn conn=new Conn();
           ResultSet rs= conn.s.executeQuery("select * from login where pin= '"+pinnumber+"'");
           while(rs.next()){
               card.setText("Card number:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
               card.setFont(new Font("Raleway",Font.BOLD,16));
               card.setForeground(Color.blue);
               
               
           }
        }catch (Exception e){
            System.out.println(e);
        }
        try{
           Conn conn= new Conn();
           int bal=0;
           ResultSet rs  = conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
           while(rs.next()){
               mini.setText(mini.getText()  + "<html>" + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br></html>");
                if(rs.getString("type").equals("Deposit")){
                      bal += Integer.parseInt (rs.getString("amount"));
                  }else{
                      bal -=Integer.parseInt(rs.getString("amount"));
                      
                  }
              
           }
           balance.setText("Your Current Account Balance is Rs:-"+bal);
           balance.setFont(new Font("Raleway",Font.BOLD,16));
        }catch (Exception e){
            System.out.println(e);
        }
        next=new JButton("EXIT");
		next.setBackground(Color.GRAY);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.addActionListener(this);
		next.setBounds(255, 520, 100, 30);
		add(next);
        
       
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(500,700);
        setLocation(20,20);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            setVisible(false);
            new Transaction("").setVisible(true);
        
        }
    }
    public static void main (String args[]){
        new MiniStatement("");
    }
}
