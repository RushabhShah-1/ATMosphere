package bank.management.system;

import Conn.Conn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener{
    JLabel text,cardno,pin;
    JTextField cardField,pinField;
    JButton login,signup,clear;
    Login(){
        setTitle("Automated Teller Machine");
        setLayout(null);
        // getContentPane()
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon logo=new ImageIcon(i2);
        JLabel logoJLabel=new JLabel(logo);
        logoJLabel.setBounds(70,10,50,50);
        add(logoJLabel);

        text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 40));
        text.setBounds(130, 10, 500, 50);
        add(text);

        cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 30));
        cardno.setBounds(70, 100, 200, 30);
        add(cardno);

        cardField=new JTextField(150);
        cardField.setBounds(300, 105, 250, 30);
        add(cardField);

        pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 30));
        pin.setBounds(70, 150, 200, 30);
        add(pin);

        pinField=new JTextField(150);
        pinField.setBounds(300, 155, 250, 30);
        add(pinField);

        login=new JButton("LOGIN");
        login.setBounds(300, 200, 75, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(475, 200, 75, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(375, 240, 100, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);
        
        login.addActionListener(this);
        signup.addActionListener(this);
        clear.addActionListener(this);

        setSize(600, 500);
        setVisible(true);
        setLocation(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="LOGIN"){
            try{
                Conn c=new Conn();
                String usercardno=cardField.getText();
                String userpin=pinField.getText();
                if(!usercardno.isEmpty() && !userpin.isBlank()){
                    String query="select * from accounts where cardno="+usercardno+" and pin="+userpin;
                    ResultSet rs= c.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(usercardno).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Enter Correct Card Number & PIN");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Card Number or PIN cannot be empty.");
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        else if(e.getActionCommand()=="SIGN UP"){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        else if(e.getActionCommand()=="CLEAR"){
            cardField.setText("");
            pinField.setText("");
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }

}
