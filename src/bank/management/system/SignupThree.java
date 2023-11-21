package bank.management.system;

import Conn.Conn;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener{
    String formno;
    long cardno,pinno;
    JRadioButton savingAcc,fixeddepoAcc,currAcc,recurrdepoAcc;
    JCheckBox atmCard,internetBanking,mobileBanking,emailSmsAlert,chequeBook,e_statement,confirmCheckBox;
    JButton submit,cancel;

    public SignupThree(String formno){
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3"+"(Form No: "+formno+")");
        
        this.formno=formno;
        JLabel accountDetailsLabel=new JLabel("Page 3: Account Details");
        accountDetailsLabel.setFont(new Font("Osward",Font.BOLD,20));
        accountDetailsLabel.setBounds(175, 60, 250, 30);
        add(accountDetailsLabel);
        
        JLabel accountLabel=new JLabel("Account Type");
        accountLabel.setFont(new Font("Osward",Font.BOLD,20));
        accountLabel.setBounds(50, 120, 250, 30);
        add(accountLabel);
        
        savingAcc=new JRadioButton("Saving Account");
        savingAcc.setBounds(50, 160, 150, 20);
        add(savingAcc) ;
        
        fixeddepoAcc=new JRadioButton("Fixed Depoist Account");
        fixeddepoAcc.setBounds(250, 160, 200, 20);
        add(fixeddepoAcc);
        
        currAcc=new JRadioButton("Current Account");
        currAcc.setBounds(50, 190, 150, 20);
        add(currAcc);
        
        recurrdepoAcc=new JRadioButton("Recurring Depoist Account");
        recurrdepoAcc.setBounds(250, 190, 250, 20);
        add(recurrdepoAcc) ;
        
        ButtonGroup accounttypeGroup=new ButtonGroup();
        accounttypeGroup.add(savingAcc);
        accounttypeGroup.add(fixeddepoAcc);
        accounttypeGroup.add(currAcc);
        accounttypeGroup.add(recurrdepoAcc);
        
        JLabel cardLabel=new JLabel("Card Number");
        cardLabel.setFont(new Font("Osward",Font.BOLD,20));
        cardLabel.setBounds(50, 230, 150, 30);
        add(cardLabel);
        
        Random ran=new Random();
        cardno=(Math.abs(ran.nextLong()%90000000L))+4315811100000000L;
        System.out.println(cardno);
        JLabel cardnoLabel=new JLabel("XXXX-XXXX-XXXX-"+String.valueOf(cardno).substring(12));
        cardnoLabel.setFont(new Font("Osward",Font.BOLD,20));
        cardnoLabel.setBounds(250,230,250,30);
        add(cardnoLabel);
        JLabel carddetailsLabel=new JLabel("(Your 14 Digit Card Number)");
        carddetailsLabel.setFont(new Font("Osward",Font.BOLD,10));
        carddetailsLabel.setBounds(50, 261, 250, 12);
        add(carddetailsLabel);
        
        JLabel pinLabel=new JLabel("PIN");
        pinLabel.setFont(new Font("Osward",Font.BOLD,20));
        pinLabel.setBounds(50, 300, 150, 30);
        add(pinLabel);
        
        pinno=ran.nextInt(Integer.MAX_VALUE)%9000L;
        System.out.println(pinno);
        JLabel pinnoLabel=new JLabel("XXXX");
        pinnoLabel.setFont(new Font("Osward",Font.BOLD,20));        
        pinnoLabel.setBounds(250,300,100,30);
        add(pinnoLabel);
        
        JLabel yourpindetailsLabel=new JLabel("Your 4 Digit Password");
        yourpindetailsLabel.setFont(new Font("Osward",Font.BOLD,10));
        yourpindetailsLabel.setBounds(50, 331, 250, 12);
        add(yourpindetailsLabel);
        
        JLabel servicesLabel=new JLabel("Services Required");
        servicesLabel.setFont(new Font("Osward",Font.BOLD,20));
        servicesLabel.setBounds(50, 360, 250, 30);
        add(servicesLabel);
        
        atmCard=new JCheckBox("ATM Card");
        atmCard.setBounds(50, 400, 150, 20);
        add(atmCard);
        
        internetBanking=new JCheckBox("Internet Banking");
        internetBanking.setBounds(200, 400, 150, 20);
        add(internetBanking);
        
        mobileBanking=new JCheckBox("Mobile Banking");
        mobileBanking.setBounds(350, 400, 150, 20);
        add(mobileBanking);
        
        emailSmsAlert=new JCheckBox("Email & SMS Alerts");
        emailSmsAlert.setBounds(50, 430, 150, 20);
        add(emailSmsAlert);
        
        chequeBook=new JCheckBox("Cheque Book");
        chequeBook.setBounds(200, 430, 150, 20);
        add(chequeBook);
        
        e_statement=new JCheckBox("E-Statement");
        e_statement.setBounds(350, 430, 150, 20);
        add(e_statement);
        
        confirmCheckBox=new JCheckBox("I hereby declares that the above entered details are correct to the best of knowledge.");
        confirmCheckBox.setFont(new Font("Osward", Font.BOLD, 10));
        confirmCheckBox.setBounds(50, 470, 500, 20);
        add(confirmCheckBox);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(150, 510, 100, 20);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(300, 510, 100, 20);
        add(cancel);
        
        submit.addActionListener(this);
        cancel.addActionListener(this);
        setSize(600,600);
        setVisible(true);
        setLocation(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand()=="Submit"){
            if(confirmCheckBox.isSelected()){
                try{
                    String accountType="";
                    if(savingAcc.isSelected()) accountType="Saving Account";
                    else if(fixeddepoAcc.isSelected()) accountType="Fixed Depoist Account";
                    else if(currAcc.isSelected()) accountType="Current Account";
                    else if(recurrdepoAcc.isSelected()) accountType="Recurring Depoist Account";
                    String serviesrequired="";
                    if(atmCard.isSelected()) serviesrequired+="ATM Card ";
                    else if(internetBanking.isSelected()) serviesrequired+="Internet Banking ";
                    else if(mobileBanking.isSelected()) serviesrequired+="Mobile Banking ";
                    else if(emailSmsAlert.isSelected()) serviesrequired+="Email & SMS Alert ";
                    else if(chequeBook.isSelected()) serviesrequired+="Cheque Book ";
                    else if(e_statement.isSelected()) serviesrequired+="E-Stateement ";
                    
                    if(!accountType.isEmpty()){
                        if(!serviesrequired.isEmpty()){
                            Conn c=new Conn();
                            String query1="insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardno+"', '"+pinno+"', '"+serviesrequired+"')";
                            String query2="insert into accounts values('"+formno+"', '"+cardno+"', '"+pinno+"',0)";
                            c.s.executeUpdate(query1);
                            c.s.executeUpdate(query2);
                            String message="Account Successfully Created!\n"+"Your Card Number: "+cardno+"\nYour PIN: "+pinno;
                            JOptionPane.showMessageDialog(null, message);
                            setVisible(false);
                            new Login().setVisible(true);
                        }else { JOptionPane.showMessageDialog(null, "Select Atleast One Service");}
                    }else { JOptionPane.showMessageDialog(null, "Select Account Type.");}
                }catch(Exception ex) {
                    System.out.println(ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please accept the declaration.");
            }
        }
        

        
        

    }
    public static void main(String[] args) {
        new SignupThree("");
    }

    
}
