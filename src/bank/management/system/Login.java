
package bank.management.system;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup,exit;
	JTextField t1;
	JPasswordField pin1;
	Login(){
            setLayout(null);
	setTitle("STATE BANK OF INDIA LALGANJ");
     ImageIcon icon=new ImageIcon(getClass() .getResource("rr.png"));
	Image i1=icon.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i1);
	JLabel label=new JLabel(i3);
	label.setBounds(70, 10, 100, 100);
	label.setBackground(Color.WHITE);
	add(label);
        
        JLabel text = new JLabel("WELCOME TO SBI (Lalganj,Valishali)");
        text.setFont(new Font("Osward",Font.BOLD,30));
        text.setBounds(200, 40, 600, 40);
        text.setBackground(Color.GRAY);
	text.setForeground(Color.WHITE);
        add(text);
        
        JLabel cardno = new JLabel("Card NO:");
        cardno.setFont(new Font("Raieway",Font.BOLD,28));
	cardno.setBounds(120,150,400, 40);
	cardno.setBackground(Color.GRAY);
	cardno.setForeground(Color.WHITE);
	add(cardno);
        
        t1=new JTextField();
	t1.setBounds(300, 150, 230, 30);
	t1.setFont(new Font("Arial",Font.BOLD,16));
	add(t1);
        
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raiway",Font.BOLD,28));
	pin.setBounds(120,220,400, 40);
	pin.setBackground(Color.GRAY);
	pin.setForeground(Color.WHITE);
	add(pin);
        
        pin1=new JPasswordField();
	pin1.setBounds(300, 220, 230, 30);
	pin1.setFont(new Font("Arial",Font.BOLD,16));
	add(pin1);
        
        login=new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.WHITE);
	login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.WHITE);
	clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);
        signup=new JButton("SIGN UP");
        signup.setBounds(340, 335, 150, 30);
        signup.setBackground(Color.WHITE);
	signup.setForeground(Color.BLACK);
        signup.addActionListener(this);
        add(signup);
        
	getContentPane().setBackground(new Color(59,88,128));
	setSize(800,400);
	setLocation(350,200);
       
	setVisible(true);
	}
        @Override
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==clear){
              t1.setText("");
	      pin1.setText("");
         
          } else if(ae.getSource()==login){
              Conn conn=new Conn();
              String cardnumber=t1.getText();
              String pinnumber=pin1.getText();
              String query = "select * from login where cardnumber= '"+cardnumber+"' and pin ='"+pinnumber+"'";
              try {
                  ResultSet rs=conn.s.executeQuery(query);
                  if(rs.next()){
                      setVisible(false);
                      new Transaction(pinnumber).setVisible(true);
                  }else{
                      JOptionPane.showMessageDialog(null,"Incorrect cardnumber or pin Thank you visit again");
                  }
              } catch (Exception e) {
                  System.out.println(e);
              } 
              } else if(ae.getSource()==signup){
              setVisible(false);
              new SignupOne().setVisible(true);
              
          }
        }
	

	public static void main(String[] args) {
		new Login();
		

	}
	
}

