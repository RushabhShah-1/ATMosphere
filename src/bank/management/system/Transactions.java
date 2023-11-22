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
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Transactions extends JFrame implements ActionListener{
    String cardno;
    JButton deposit,cashWithdrwal,fastCash,miniStatement,pinChange,balanceEnquiry,exitButtton;
    Transactions(String cardno){
        this.cardno=cardno;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel mainImage=new JLabel(i3);
        
        JLabel selectTranscation=new JLabel("Please select your Transaction");
        selectTranscation.setForeground(Color.WHITE);
        selectTranscation.setFont(new Font("Osward",Font.ITALIC,18));
        selectTranscation.setBounds(210, 300, 350, 20); 
        mainImage.add(selectTranscation);
        mainImage.setBounds(0,0, 900, 900);
        add(mainImage);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(170, 420, 100, 25);
        deposit.setFont(new Font("Osward",Font.BOLD,10));
        mainImage.add(deposit);
        
        cashWithdrwal=new JButton("Cash Withdrawal");
        cashWithdrwal.setBounds(370, 420, 150, 25);
        cashWithdrwal.setFont(new Font("Osward",Font.BOLD,10));        
        mainImage.add(cashWithdrwal);
        
        fastCash=new JButton("Fast Cash");
        fastCash.setBounds(170, 455, 100, 25);
        fastCash.setFont(new Font("Osward",Font.BOLD,10));
        mainImage.add(fastCash);
        
        miniStatement=new JButton("Mini Statement");
        miniStatement.setBounds(370, 455, 150, 25);
        miniStatement.setFont(new Font("Osward",Font.BOLD,10));
        mainImage.add(miniStatement);
        
        pinChange=new JButton("PIN Change");
        pinChange.setBounds(170, 490, 100, 25);
        pinChange.setFont(new Font("Osward",Font.BOLD,10));
        mainImage.add(pinChange);
        
        balanceEnquiry=new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(370, 490, 150, 25);
        balanceEnquiry.setFont(new Font("Osward",Font.BOLD,10));
        mainImage.add(balanceEnquiry);
        
        exitButtton=new JButton("EXIT");
        exitButtton.setBounds(270, 525, 100, 25);
        exitButtton.setFont(new Font("Osward",Font.BOLD,10));
        mainImage.add(exitButtton);
        
        deposit.addActionListener(this);
        cashWithdrwal.addActionListener(this);
        fastCash.addActionListener(this);
        miniStatement.addActionListener(this);
        pinChange.addActionListener(this);
        balanceEnquiry.addActionListener(this);
        exitButtton.addActionListener(this);
        

        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand()=="EXIT") System.exit(0);
        else if(ae.getActionCommand()=="Deposit"){
            setVisible(false);
            new Deposit(cardno).setVisible(true);
        }
        else if(ae.getActionCommand()=="Cash Withdrawal"){
            setVisible(false);
            new CashWithdrawal(cardno).setVisible(true);
        }
        else if(ae.getActionCommand()=="PIN Change"){
            setVisible(false);
            new PINChange(cardno).setVisible(true);
        }
        else if(ae.getActionCommand()=="Balance Enquiry"){
            try{
               Conn c=new Conn();
               String query="select balance from accounts where cardno='"+cardno+"'";
               ResultSet balanceResultSet=c.s.executeQuery(query);
               if(balanceResultSet.next()){
                   JOptionPane.showMessageDialog(null, "Your Current Balance is "+balanceResultSet.getString(1));
               }
            }catch(Exception ex){
                System.out.println("ex");;
            }
        }
        else if(ae.getActionCommand()=="Mini Statement"){
            new MiniStatement(cardno).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transactions("");
    }

    
}
