package bank.management.system;

import javax.swing.*;
 
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JButton deposit,withdraw,fastcash,ministatement,pinchange,balance,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text=new JLabel("Select Withdrawl Amount...");
        text.setBounds(210, 300,700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit =new JButton("Rs 200");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw =new JButton("Rs 500");
        withdraw.setBounds(355, 415, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastcash =new JButton("Rs 2000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement =new JButton("RS 1000");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
       pinchange =new JButton("Rs 5000");
         pinchange.setBounds(170, 485, 150, 30);
         pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance =new JButton("Rs 10,000");
        balance.setBounds(355, 485, 150, 30);
        balance.addActionListener(this);
        image.add(balance);
        exit =new JButton("Back");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        
             

        
        getContentPane().setBackground(Color.WHITE);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
          setVisible(false);
          new Transaction(pinnumber).setVisible(true);
        
        }else{
          String amount =((JButton)ae.getSource()).getText().substring(3);
          Conn c=new  Conn();
          try{
              ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
              int balance =0;
              while(rs.next()){
                  if(rs.getString("type").equals("Deposit")){
                      balance += Integer.parseInt (rs.getString("amount"));
                  }else{
                      balance -=Integer.parseInt(rs.getString("amount"));
                  }
              }
              
              
              if (ae.getSource()!=exit && balance <Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null, "Insufficient fund");
                  return;
              }
              Date date = new Date();
              String query="insert into bank value('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Rs"+amount+"Debited Sucessfully");
              setVisible(false);
              new Transaction(pinnumber).setVisible(true);
              
          }catch(Exception e){
              System.out.println(e);
          }
        }
        
    }
    public static void main(String args[]){
        new FastCash("");
    }
    
}
