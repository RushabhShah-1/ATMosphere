package bank.management.system;

import Conn.Conn;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class PINChange extends JFrame implements ActionListener{
    String cardno;
    JTextField currPinTextField,newPinTextField;
    JButton confirm,back;
    PINChange(String cardno) {
        this.cardno=cardno;
        setLayout(null);
        setSize(900,900);
        setLocation(300, 0);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel mainImage=new JLabel(i3);
        mainImage.setBounds(0,0, 900, 900);
        add(mainImage);
        
        JLabel currpinLabel=new JLabel("Enter Current PIN");
        currpinLabel.setForeground(Color.WHITE);
        currpinLabel.setFont(new Font("Osward",Font.ITALIC,18));
        currpinLabel.setBounds(160, 300, 150, 20); 
        mainImage.add(currpinLabel);
        
        currPinTextField=new JTextField(20);
        currPinTextField.setForeground(Color.WHITE);
        currPinTextField.setBackground(Color.BLACK);        
        currPinTextField.setFont(new Font("Osward",Font.ITALIC,18));
        currPinTextField.setBounds(330, 300, 50, 20);
        mainImage.add(currPinTextField);
        
        JLabel newpinLabel=new JLabel("Enter New PIN");
        newpinLabel.setForeground(Color.WHITE);
        newpinLabel.setFont(new Font("Osward",Font.ITALIC,18));
        newpinLabel.setBounds(160, 330, 150, 20); 
        mainImage.add(newpinLabel);
        
        newPinTextField=new JTextField(20);
        newPinTextField.setForeground(Color.WHITE);
        newPinTextField.setBackground(Color.BLACK);        
        newPinTextField.setFont(new Font("Osward",Font.ITALIC,18));
        newPinTextField.setBounds(330, 330, 50, 20);
        mainImage.add(newPinTextField);
        
        back=new JButton("Back");
        back.setBounds(160, 420, 150, 25);
        back.setActionCommand("Back");
        mainImage.add(back);
        
        confirm=new JButton("Confirm");
        confirm.setBounds(370, 420, 150, 25);
        mainImage.add(confirm);
        
        back.addActionListener(this);
        confirm.addActionListener(this);
        
        setUndecorated(true);        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Back"){
            setVisible(false);
            new Transactions(cardno).setVisible(true);
        }
        else if(e.getActionCommand()=="Confirm"){
               Conn c=new Conn();
           try{
               String enteredCurrPin=currPinTextField.getText();
               String enteredNewPin=newPinTextField.getText();
               String usercurrPin="";
               System.out.println("Enter in try catch");
               String getPinQuery="select pin from accounts where cardno='"+cardno+"'";
               ResultSet pinResultSet=c.s.executeQuery(getPinQuery);
               if(pinResultSet.next()){
                   usercurrPin=pinResultSet.getString(1);
               }
               if(enteredCurrPin.equals(usercurrPin)){
                   String updatePinQuery="UPDATE accounts set pin='"+enteredNewPin+"' where cardno='"+cardno+"'";
                   c.s.executeUpdate(updatePinQuery);
                   JOptionPane.showMessageDialog(null, "PIN changed successfully");
                   setVisible(false);
                   new Login().setVisible(true);
               }
               else{
                   JOptionPane.showMessageDialog(null, "Current PIN is different.Try again later...");
                   setVisible(false);
                   new Login().setVisible(true);
               }
           }catch(Exception ex){
               System.out.println(ex);
           }
        }
    }
    
    public static void main(String[] args) {
        new PINChange("");
    }

    
}
