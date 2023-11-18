package bank.management.system;

import Conn.Conn;
import java.awt.Font;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

 import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameField,fathernameField,emailField,addressField,cityField,stateField,pincodeField;
    JRadioButton maleRadioButton,femaleRadioButton,marriedRadioButton,unmarriedRadioButton,otherRadioButton;
    JButton nextButton;
    JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        JLabel appno=new JLabel("APPLICATION FORM NO. "+random);
        appno.setFont(new Font("Raleway",Font.BOLD,25));
        appno.setBounds(100, 20, 500, 40);
        add(appno);
        
        JLabel personalDetailsLabel=new JLabel("Page 1: Personal Details");
        personalDetailsLabel.setFont(new Font("Osward", Font.BOLD,20));
        personalDetailsLabel.setBounds(200, 60, 250, 25);
        add(personalDetailsLabel);

        JLabel nameLabel=new JLabel("Name:");
        nameLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        nameLabel.setBounds(50, 100, 175, 20);
        add(nameLabel);

        nameField=new JTextField(275);
        nameField.setBounds(230, 105, 275, 20);
        add(nameField);

        JLabel fathernameLabel=new JLabel("Father's Name:");
        fathernameLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        fathernameLabel.setBounds(50, 130, 175, 20);
        add(fathernameLabel);

        fathernameField=new JTextField(275);
        fathernameField.setBounds(230, 135, 275, 20);
        add(fathernameField);

        JLabel dobLabel=new JLabel("Date of Birth:");
        dobLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        dobLabel.setBounds(50, 155, 175, 20);
        add(dobLabel);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(230, 160, 275, 20);
        add(dateChooser);

        JLabel genderLabel=new JLabel("Gender:");
        genderLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        genderLabel.setBounds(50, 180, 175, 20);
        add(genderLabel);

        maleRadioButton=new JRadioButton("Male");
        femaleRadioButton=new JRadioButton("Female");
        maleRadioButton.setBackground(Color.WHITE);
        femaleRadioButton.setBackground(Color.WHITE);
        maleRadioButton.setBounds(230, 180, 100, 20);
        femaleRadioButton.setBounds(330, 180, 100, 20);
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        add(maleRadioButton);
        add(femaleRadioButton);

        JLabel emailLabel=new JLabel("Email:");
        emailLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        emailLabel.setBounds(50, 205, 175, 20);
        add(emailLabel);

        emailField=new JTextField(275);
        emailField.setBounds(230, 205, 275, 20);
        add(emailField);

        JLabel maritalstatusLabel=new JLabel("Marital Status:");
        maritalstatusLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        maritalstatusLabel.setBounds(50, 230, 175, 20);
        add(maritalstatusLabel);

        marriedRadioButton=new JRadioButton("Married");
        unmarriedRadioButton=new JRadioButton("Unmarried");
        otherRadioButton=new JRadioButton("Other");
        marriedRadioButton.setBackground(Color.WHITE);
        unmarriedRadioButton.setBackground(Color.WHITE);
        otherRadioButton.setBackground(Color.WHITE);
        marriedRadioButton.setBounds(230, 230, 100, 20);
        unmarriedRadioButton.setBounds(330, 230, 100, 20);
        otherRadioButton.setBounds(430, 230, 100, 20);
        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(otherRadioButton);
        maritalGroup.add(marriedRadioButton);
        maritalGroup.add(unmarriedRadioButton);
        add(marriedRadioButton);
        add(unmarriedRadioButton);
        add(otherRadioButton);

        JLabel addressLabel=new JLabel("Address:");
        addressLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        addressLabel.setBounds(50, 255, 175, 20);
        add(addressLabel);

        addressField=new JTextField(275);
        addressField.setBounds(230, 260, 275, 20);
        add(addressField);

        JLabel cityLabel=new JLabel("City:");
        cityLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        cityLabel.setBounds(50, 280, 175, 20);
        add(cityLabel);

        cityField=new JTextField(275);
        cityField.setBounds(230, 285, 275, 20);
        add(cityField);

        JLabel stateLabel=new JLabel("State:");
        stateLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        stateLabel.setBounds(50, 310, 175, 20);
        add(stateLabel);
        
        stateField=new JTextField(275);
        stateField.setBounds(230, 315, 275, 20);
        add(stateField);
        
        JLabel pincodeLabel=new JLabel("Pin Code:");
        pincodeLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        pincodeLabel.setBounds(50, 335, 175, 20);
        add(pincodeLabel);

        pincodeField=new JTextField(275);
        pincodeField.setBounds(230, 345, 275, 20);
        add(pincodeField);
        
        nextButton=new JButton("Next");
        nextButton.setBounds(400, 390, 100, 20);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        add(nextButton);
        
        nextButton.addActionListener((ActionListener) this);
        
        setSize(600,600);
        setVisible(true);
        setLocation(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno=random+"";
        String name=nameField.getText();
        String fname=fathernameField.getText();
        String email=emailField.getText();
        String address=addressField.getText();
        String city=cityField.getText();
        String state=stateField.getText();
        String pincode=pincodeField.getText(); 
        String dob= ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(maleRadioButton.isSelected()) gender="Male";
        else if(femaleRadioButton.isSelected()) gender="Female";
        String maritalstatus=null;
        if(marriedRadioButton.isSelected()) maritalstatus="Married";
        else if(unmarriedRadioButton.isSelected()) maritalstatus="Unmarried";
        else if(otherRadioButton.isSelected()) maritalstatus="Other";
        if(!name.equals("") && !fname.equals("") && !email.equals("") && !address.equals("") && !city.equals("") && 
                !state.equals("") && !pincode.equals("") && !dob.equals("") && !gender.equals(null) && !maritalstatus.equals(null)){
            try{
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"','"+maritalstatus+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            catch(Exception ex){
                System.out.println(ex);            
            }
        }else{
            String message="One or more field/s is empty.";
            JOptionPane.showMessageDialog(null, message);
        } 
    }
    public static void main(String[] args) {
        new SignupOne();
    }

    
}
