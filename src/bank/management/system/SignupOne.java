package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
    long random;
	JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
	JButton next;
	JRadioButton male,female,married,unmarried,other;
	JDateChooser dateChooser;
    SignupOne(){
       setLayout(null);
		Random ran=new Random();
		random=Math.abs((ran.nextLong()%9000L)+1000L);
		
		JLabel formno=new JLabel("APPLICATION FORM NO."+random);
		formno.setFont(new Font("Raleway",Font.BOLD,30));
		formno.setBounds(240, 20, 600, 40);
		add(formno);
                
        ImageIcon icon=new ImageIcon(getClass() .getResource("rr.png"));
	Image i1=icon.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i1);
	JLabel label=new JLabel(i3);
	label.setBounds(70, 10, 100, 100);
	label.setBackground(Color.WHITE);
	add(label);
                
                
		
		JLabel personalDetails=new JLabel("Page 1:PERSONAL DETAILS");
		personalDetails.setFont(new Font("Raleway",Font.BOLD,20));
		personalDetails.setBounds(290, 80, 400, 30);
		add(personalDetails);
                
                
                JLabel personalDetail=new JLabel("Welcome to SBI...");
		personalDetail.setFont(new Font("Raleway",Font.BOLD,20));
		personalDetail.setBounds(400, 0, 400, 30);
		add(personalDetail);
                
		
		JLabel name=new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		nameTextField=new JTextField();
		nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
                
                JLabel fname=new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
                fnameTextField=new JTextField();
		fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);
                
                
                JLabel dob=new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
                
                dateChooser=new JDateChooser();
                dateChooser.setBounds(300,240,400,30);
                dateChooser.setForeground(Color.WHITE);
                add(dateChooser);
                
                
                JLabel gender=new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
                
                male=new JRadioButton("Male");
                male.setForeground(Color.BLACK);
                male.setBackground(Color.WHITE);
                male.setBounds(300, 290, 60,30);
                add(male);
                
                female=new JRadioButton("Female");
                female.setBounds(450,290,100,30);
                female.setForeground(Color.BLACK);
                female.setBackground(Color.WHITE);
                add(female);
                ButtonGroup gendergroup = new ButtonGroup();
                gendergroup.add(male);
                gendergroup.add(female);
                
                JLabel email=new JLabel("Email Address:");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100, 340, 200, 30);
		add(email);
                emailTextField=new JTextField();
		emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
                
                
                JLabel marital=new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
                
               married=new JRadioButton("Married");
               married.setForeground(Color.BLACK);
               married.setBackground(Color.WHITE);
               married.setBounds(300, 390, 100,30);
                add(married);
                
               unmarried=new JRadioButton("Unmarried");
               unmarried.setBounds(450,390,100,30);
               unmarried.setForeground(Color.BLACK);
               unmarried.setBackground(Color.WHITE);
               add(unmarried);
              other=new JRadioButton("Other");
              other.setBounds(600,390,100,30);
              other.setForeground(Color.BLACK);
              other.setBackground(Color.WHITE);
              add(other);
              ButtonGroup maritalgroup=new ButtonGroup();
              maritalgroup.add(married);
              maritalgroup.add(unmarried);
              maritalgroup.add(other);
                
                
                JLabel address=new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100, 440, 200, 30);
		add(address);
                addressTextField=new JTextField();
		addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);
                
                JLabel city=new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100, 490, 200, 30);
		add(city);
                cityTextField=new JTextField();
		cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);
                JLabel state=new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100, 540, 200, 30);
		add(state);
                stateTextField=new JTextField();
		stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);
                JLabel pincode=new JLabel("Pin-Code:");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
                pinTextField=new JTextField();
		pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
		pinTextField.setBounds(300, 590, 400, 30);
		add(pinTextField);
		
		
	
		
		next=new JButton("NEXT");
		next.setBackground(Color.GRAY);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.addActionListener(this);
		next.setBounds(620, 660, 80, 30);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
    public void actionPerformed(ActionEvent ae){
        String formno="" + random;
        String name= nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(other.isSelected()){
            marital="Other";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();
        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                Conn c= new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
            
        }catch (Exception e){
            System.out.println(e);
        }  
    }


    public static void main(String args[]){
         new SignupOne();
    }  
}
