package bank.management.system;

import Conn.Conn;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;

public class MiniStatement extends JFrame{
    String cardno;
    JLabel printtextLabel;
    String currBalance;
    public MiniStatement(String cardno){
        this.cardno=cardno;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(500, 500);
        setLocation(100, 20);
        setTitle("Mini Statement");
        
        JLabel bankLabel=new JLabel("RS Bank");
        bankLabel.setFont(new Font("Raleway",Font.BOLD,30));
        bankLabel.setBounds(190, 20, 150, 30);
        add(bankLabel);
        
        String partialCard=cardno.substring(0, 4)+"-XXXX-XXXX-"+cardno.substring(12);
        JLabel cardnoLabel=new JLabel("Card Number: "+partialCard);
        cardnoLabel.setFont(new Font("Osward",Font.PLAIN,15));
        cardnoLabel.setBounds(20, 80, 300, 15);
        add(cardnoLabel);
        
        JLabel lastTranscation=new JLabel("Last 5 Transactions");
        lastTranscation.setFont(new Font("Osward",Font.PLAIN,15));
        lastTranscation.setBounds(20, 115, 150, 15);
        add(lastTranscation);

        
        printtextLabel=new JLabel();
        printtextLabel.setBounds(20, 140, 480, 200);
        printtextLabel.setFont(new Font("Osward",Font.PLAIN,13));
        try{
            int i=0;
            Conn c=new Conn();
            String query="select date,type,amount from transactions where cardno=('"+cardno+"')";
            ResultSet getTransaction=c.s.executeQuery(query);
            while(getTransaction.next()){
                if(i<5){
                    i++;
                    printtextLabel.setText(printtextLabel.getText()+"<html>"+getTransaction.getString(1)+"&nbsp;&nbsp;&nbsp;"+getTransaction.getString(2)+"&nbsp;&nbsp;&nbsp;"+getTransaction.getString(3)+"<br><br>");
                }else break;
            }
            String query2="select balance from accounts where cardno='"+cardno+"'";
            ResultSet getBalance=c.s.executeQuery(query2);
            if(getBalance.next()) currBalance=getBalance.getString(1);
        }catch(Exception ex){
            System.out.println(ex);;
        }
        add(printtextLabel);
        
        JLabel currbalanceLabel=new JLabel("Your Account Balance is "+currBalance);
        currbalanceLabel.setBounds(20, 405, 200, 15);
        add(currbalanceLabel);
        
        setVisible(true); 
        setUndecorated(true);
    }
    
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
