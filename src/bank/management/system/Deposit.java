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
import java.util.Date;
import javax.swing.JOptionPane;

public class Deposit extends JFrame implements ActionListener{
    String cardno;
    JTextField amountField;
    JButton depositButton,backButton;
    Deposit(String cardno){
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
        
        JLabel depositLabel=new JLabel("Enter amount to deposit");
        depositLabel.setForeground(Color.WHITE);
        depositLabel.setFont(new Font("Osward",Font.ITALIC,18));
        depositLabel.setBounds(250, 300, 250, 20); 
        mainImage.add(depositLabel);
        
        amountField=new JTextField(350);
        amountField.setBounds(250, 350, 190, 20);
        mainImage.add(amountField);
        
        backButton=new JButton("Back");
        backButton.setBounds(160,420,100,20);
        mainImage.add(backButton);
        
        depositButton=new JButton("Deposit");
        depositButton.setBounds(410, 420, 100, 20);
        mainImage.add(depositButton);
        
        backButton.addActionListener((ActionListener) this);
        depositButton.addActionListener((ActionListener) this);
        
        setUndecorated(true);        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Back"){
            setVisible(false);
            new Transactions(cardno).setVisible(true);
        }
        else if(e.getActionCommand()=="Deposit"){
            Date date=new Date();
            String dateString=date.toString();
            String amount=amountField.getText();
            try{
                Conn c=new Conn();
                String getBalanceQuery="select balance from accounts where cardno="+cardno;
                ResultSet balanceresultset=c.s.executeQuery(getBalanceQuery);
                if(balanceresultset.next()){  
                    String currbalance=balanceresultset.getString(1);
                    int integercurrbalance=Integer.parseInt(currbalance);
                    int integeramountbalance=Integer.parseInt(amount);
                    int updatedbalance=integercurrbalance+integeramountbalance;
                    String updateBalanceQuery="update accounts set balance='"+updatedbalance+"' where cardno='"+cardno+"'";
                    c.s.executeUpdate(updateBalanceQuery);
                    String addTranscationQuery="insert into transactions values('"+cardno+"', '"+dateString+"', 'Deposit','"+amount+"')";
                    c.s.executeUpdate(addTranscationQuery);
                    JOptionPane.showMessageDialog(null, "Amount RS."+amount+" deposited successfully");
                    setVisible(false);
                    new Transactions(cardno).setVisible(true);
                }   
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }

}
