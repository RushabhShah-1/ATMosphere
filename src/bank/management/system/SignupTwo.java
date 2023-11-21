package bank.management.system;

import Conn.Conn;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener{
    String formno;
    JComboBox<String> religionComboBox,categoryComboBox,incomeComboBox,educationComboBox,occupationComboBox;
    JTextField panField,aadharField;
    JRadioButton yseniorcitizenRadioButton, nseniorcitizenRadioButton, yexistingcustomerRadioButton, nexistingcustomerRadioButton;
    JButton nextButton;
    SignupTwo(String formno) {
        this.formno=formno;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2"+"(Form No: "+formno+")");
       
        JLabel addtionalDetailsLabel=new JLabel("Page 2: Additional Details");
        addtionalDetailsLabel.setFont(new Font("Osward", Font.BOLD,20));
        addtionalDetailsLabel.setBounds(175, 60, 250, 25);
        add(addtionalDetailsLabel);
        
        JLabel religionLabel=new JLabel("Religion:");
        religionLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        religionLabel.setBounds(50, 100, 175, 22);
        add(religionLabel);
        
        String religions[]={"Jain","Hindu","Sikh","Muslim","Christian"};
        religionComboBox=new JComboBox<>(religions);
        religionComboBox.setSelectedIndex(-1);
        religionComboBox.setBounds(230, 100, 275, 20);
        add(religionComboBox);
        
        JLabel categoryLabel=new JLabel("Category:");
        categoryLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        categoryLabel.setBounds(50, 130, 175, 20);
        add(categoryLabel);
        
        String categories[]={"General","ST","SC","OBC","Minority"};
        categoryComboBox=new JComboBox<>(categories);
        categoryComboBox.setSelectedIndex(-1);
        categoryComboBox.setBounds(230, 130, 275, 20);
        add(categoryComboBox);
        
        JLabel incomeLabel=new JLabel("Income:");
        incomeLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        incomeLabel.setBounds(50, 160, 175, 20);
        add(incomeLabel);
        
        String incomes[]={"Null","Upto 2 lakhs","Upto 5 lakhs","Upto 10 lakhs"};
        incomeComboBox=new JComboBox<>(incomes);
        incomeComboBox.setSelectedIndex(-1);
        incomeComboBox.setBounds(230, 160, 275, 20);
        add(incomeComboBox);

        JLabel educationalLabel=new JLabel("Educational");
        educationalLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        educationalLabel.setBounds(50, 190, 175, 20);
        add(educationalLabel);
        
        String educations[]={"Non-Graduate","Graduate","Post Graduate","Others"};
        educationComboBox=new JComboBox<>(educations);
        educationComboBox.setSelectedIndex(-1);
        educationComboBox.setBounds(230, 200, 275, 20);
        add(educationComboBox);
        
        JLabel qualificationLabel=new JLabel("Qualification:");
        qualificationLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        qualificationLabel.setBounds(50, 210, 175, 20);
        add(qualificationLabel);
        
        JLabel occupationLabel=new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        occupationLabel.setBounds(50, 240, 175, 20);
        add(occupationLabel);
        
        String occupations[]={"Salaried","Self-Employed","Buisness","Student","Others"};
        occupationComboBox=new JComboBox<>(occupations);
        occupationComboBox.setSelectedIndex(-1);
        occupationComboBox.setBounds(230, 240, 275, 20);
        add(occupationComboBox);
        
        JLabel panLabel=new JLabel("PAN Number:");
        panLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        panLabel.setBounds(50, 270, 175, 20);
        add(panLabel);
        
        panField=new JTextField();
        panField.setBounds(230, 270, 275, 20);
        add(panField);
        
        JLabel aadharLabel=new JLabel("Aadhar Number:");
        aadharLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        aadharLabel.setBounds(50, 300, 175, 20);
        add(aadharLabel);
        
        aadharField=new JTextField();
        aadharField.setBounds(230, 300, 275, 20);
        add(aadharField);
        
        JLabel seniorcitizenLabel=new JLabel("Senior Citizen:");
        seniorcitizenLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        seniorcitizenLabel.setBounds(50, 330, 175, 20);
        add(seniorcitizenLabel);
        
        yseniorcitizenRadioButton=new JRadioButton("Yes");
        yseniorcitizenRadioButton.setBounds(230, 330, 48, 20);
        nseniorcitizenRadioButton=new JRadioButton("No");
        nseniorcitizenRadioButton.setBounds(300, 330, 45, 20);
        ButtonGroup seniorcitizenGroup=new ButtonGroup();
        seniorcitizenGroup.add(yseniorcitizenRadioButton);
        seniorcitizenGroup.add(nseniorcitizenRadioButton);
        add(yseniorcitizenRadioButton);
        add(nseniorcitizenRadioButton);
        
        JLabel existingaccountLabel=new JLabel("Existing Account:");
        existingaccountLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        existingaccountLabel.setBounds(50, 360, 175, 22);
        add(existingaccountLabel);
        
        yexistingcustomerRadioButton=new JRadioButton("Yes");
        yexistingcustomerRadioButton.setBounds(230, 360, 48, 20);
        nexistingcustomerRadioButton=new JRadioButton("No");
        nexistingcustomerRadioButton.setBounds(300, 360, 45, 20);
        ButtonGroup existingaccountGroup=new ButtonGroup();
        existingaccountGroup.add(yexistingcustomerRadioButton);
        existingaccountGroup.add(nexistingcustomerRadioButton);
        add(yexistingcustomerRadioButton);
        add(nexistingcustomerRadioButton);
        
        nextButton=new JButton("Next");
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(400, 390, 100, 20);
        add(nextButton);
        
        nextButton.addActionListener((ActionListener) this);
        
        setSize(600,600);
        setVisible(true);
        setLocation(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String religion=religionComboBox.getSelectedItem().toString();
        String category=categoryComboBox.getSelectedItem().toString();
        String income=incomeComboBox.getSelectedItem().toString();
        String education=educationComboBox.getSelectedItem().toString();
        String occupation=occupationComboBox.getSelectedItem().toString();
        String panno=panField.getText();
        String aadharno=aadharField.getText();
        
        String isSeniorCitizen=null;
        if(yseniorcitizenRadioButton.isSelected()) isSeniorCitizen="Yes";
        else if(nseniorcitizenRadioButton.isSelected()) isSeniorCitizen="No";
        String hasExistingAccount=null;
        if(yexistingcustomerRadioButton.isSelected()) hasExistingAccount="Yes";
        else if(nexistingcustomerRadioButton.isSelected()) hasExistingAccount="No";
        if(!religion.equals("") && !category.equals("") && !income.equals("") && !education.equals("") && !occupation.equals("") && 
                !panno.equals("") && !aadharno.equals("") && !isSeniorCitizen.equals(null) && !hasExistingAccount.equals(null)){
            try{
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"','"+panno+"','"+aadharno+"','"+isSeniorCitizen+"','"+hasExistingAccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
            catch(Exception ex){
                System.out.println(ex);            
            }
        }else{
            JOptionPane.showMessageDialog(null, "Enter all details properly.");
        } 
    }
    public static void main(String args[]){
        new SignupTwo("");
    }
    
}
