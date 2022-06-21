package bankmanagementsystem;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class SignUpThree extends JFrame implements ActionListener {
    
    JRadioButton saving , current;
    JButton submit , exit;
    JCheckBox atm_card , ibanking , mbanking , alerts , chebooks , estat , decla;
    String form_num;
    
    SignUpThree(String form_num){
        this.form_num = form_num;
        
        // LAYOUT
        setLayout(null);
        
        // TITLE
        setTitle("ACCOUNT DETAILS");
        
        // DETAILS
        JLabel heading = new JLabel("PAGE 3 : LOGIN CREDENTIALS");
        heading.setFont(new Font("Courier New",Font.BOLD,15));
        heading.setBounds(170,10,300,30);
        add(heading);
        
        // ACCOUNT TYPE
        JLabel acctype = new JLabel("ACCOUNT TYPE :");
        acctype.setFont(new Font("Courier New",Font.BOLD,15));
        acctype.setBounds(50,80,150,30);
        add(acctype);
        
        saving = new JRadioButton("SAVING");
        saving.setFont(new Font("Arial Black",Font.BOLD,10));
        saving.setBackground(Color.WHITE);
        saving.setBounds(200,80,100,30);
        add(saving);
        
        current = new JRadioButton("CURRENT");
        current.setFont(new Font("Arial Black",Font.BOLD,10));
        current.setBackground(Color.WHITE);
        current.setBounds(350,80,100,30);
        add(current);
        
        ButtonGroup acc_group = new ButtonGroup();
        acc_group.add(saving);
        acc_group.add(current);
        
        // CARD NUMBER
        JLabel card = new JLabel("CARD NUMBER  : ");
        card.setFont(new Font("Courier New",Font.BOLD,15));
        card.setBounds(50,130,150,30);
        add(card);
        
        JLabel card_num = new JLabel("XXXX-XXXX-XXXX-2582");
        card_num.setFont(new Font("Courier New",Font.BOLD,15));
        card_num.setBounds(200,130,250,30);
        add(card_num);
        
        JLabel card_line = new JLabel("( YOUR 16 DIGIT CARD NUMBER )");
        card_line.setFont(new Font("Arial Black",Font.BOLD,10));
        card_line.setBounds(50,150,250,30);
        add(card_line);
        
        // PIN NUMBER 
        JLabel pin = new JLabel("PIN          : ");
        pin.setFont(new Font("Courier New",Font.BOLD,15));
        pin.setBounds(50,200,150,30);
        add(pin);
        
        JLabel pin_num = new JLabel("XXXX");
        pin_num.setFont(new Font("Courier New",Font.BOLD,15));
        pin_num.setBounds(200,200,100,30);
        add(pin_num);
        
        JLabel pin_line = new JLabel("( YOUR 4 DIGIT PIN NUMBER )");
        pin_line.setFont(new Font("Arial Black",Font.BOLD,10));
        pin_line.setBounds(50,220,200,30);
        add(pin_line);
        
        // SERVICES SECTION
        JLabel serv_req = new JLabel("SERVICES REQUIRED : ");
        serv_req.setFont(new Font("Courier New",Font.BOLD,15));
        serv_req.setBounds(50,270,200,30);
        add(serv_req);
        
        // SERVICES
        atm_card = new JCheckBox(" ATM CARD");
        atm_card.setFont(new Font("Arial Black",Font.BOLD,10));
        atm_card.setBackground(Color.WHITE);
        atm_card.setBounds(50,300,100,30);
        add(atm_card);
        
        ibanking = new JCheckBox(" INTERNET BANKING");
        ibanking.setFont(new Font("Arial Black",Font.BOLD,10));
        ibanking.setBackground(Color.WHITE);
        ibanking.setBounds(200,300,200,30);
        add(ibanking);
        
        mbanking = new JCheckBox(" MOBILE BANKING");
        mbanking.setFont(new Font("Arial Black",Font.BOLD,10));
        mbanking.setBackground(Color.WHITE);
        mbanking.setBounds(50,350,150,30);
        add(mbanking);
        
        alerts = new JCheckBox(" SMS ALERTS");
        alerts.setFont(new Font("Arial Black",Font.BOLD,10));
        alerts.setBackground(Color.WHITE);
        alerts.setBounds(200,350,200,30);
        add(alerts);
        
        chebooks = new JCheckBox(" CHEQUE BOOK");
        chebooks.setFont(new Font("Arial Black",Font.BOLD,10));
        chebooks.setBackground(Color.WHITE);
        chebooks.setBounds(50,400,150,30);
        add(chebooks);
        
        estat = new JCheckBox(" E-STATEMENTS");
        estat.setFont(new Font("Arial Black",Font.BOLD,10));
        estat.setBackground(Color.WHITE);
        estat.setBounds(200,400,200,30);
        add(estat);
        
        decla = new JCheckBox(" I DO HEREBY DECLARE THAT ALL THE ABOVE MENTIONED DETAILS ARE CORRECT.");
        decla.setFont(new Font("Arial Black",Font.BOLD,10));
        decla.setBackground(Color.WHITE);
        decla.setBounds(50,480,600,30);
        add(decla);
        
        // BUTTONS
         submit = new JButton("SUBMIT");
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);
         submit.setFont(new Font("Courier New",Font.BOLD,15));
         submit.setBounds(50,550,100,40);
         submit.addActionListener(this);
         add(submit);
         
         exit = new JButton("EXIT");
         exit.setBackground(Color.BLACK);
         exit.setForeground(Color.WHITE);
         exit.setFont(new Font("Courier New",Font.BOLD,15));
         exit.addActionListener(this);
         exit.setBounds(200,550,100,40);
         add(exit);
        
        // MAIN FRAME
        setSize(700,700);
        setLocation(450,100);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String acctype = null;
            if(saving.isSelected()){
                acctype = "SAVING";
            }
            else if(current.isSelected()){
                acctype = "CURRENT";
            }
            
            Random random = new Random();
            String card_num = "" + Math.abs((random.nextLong() % 90000000L) + 7959205000000000L);
            String pin_num = "" + Math.abs((random.nextLong() % 9000L) + 1000L );
            
            String facility = "";
            if(atm_card.isSelected()){
                facility = facility + " ATM CARD";
            }
            else if(ibanking.isSelected()){
                facility =  facility + " INTERNET BANKING";
            }
            else if(mbanking.isSelected()){
                facility =  facility + " MOBILE BANKING";
            }
            else if(alerts.isSelected()){
                facility =  facility + " SMS ALERTS";
            }
            else if(chebooks.isSelected()){
                facility =  facility + " CHEQUE BOOKS";
            }
            else if(estat.isSelected()){
                facility =  facility + " E-STATEMENTS";
            }
            
            try{
                Conn conn = new Conn();
                String query1 = "insert into signupthree values('"+form_num+"','"+acctype+"','"+card_num+"','"+pin_num+"','"+facility+"')";
                String query2 = "insert into login values('"+form_num+"','"+card_num+"','"+pin_num+"')";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null , "CARD NUMBER : " + card_num + "\n" + "\n" + "PIN NUMBER : " + pin_num);
                
                setVisible(false);
                new Deposit(pin_num).setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource() == exit){
            System.exit(0);
        }
    }
    
    public static void main(String...ar){
        new SignUpThree("");
    }
}
