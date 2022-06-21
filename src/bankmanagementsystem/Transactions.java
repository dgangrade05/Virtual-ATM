 package bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit , withdrawal , fcash , mstat , pchange , balenq , exit;
    String pin_number;
        Transactions(String pin_number){
            this.pin_number = pin_number;
            // LAYOUT
            setLayout(null);
            
            // IMAGE
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);
            
            // LABELS 
            JLabel main_text = new JLabel(" RICHIE RICH BANK ");
            main_text.setFont(new Font("Arial Black",Font.BOLD,18));
            main_text.setForeground(Color.WHITE);
            main_text.setBounds(230,280,300,30);
            image.add(main_text);
            
            JLabel select = new JLabel("PLEASE SELECT : ");
            select.setFont(new Font("Courier New",Font.BOLD,15));
            select.setBounds(275,320,300,30);
            select.setForeground(Color.WHITE);
            image.add(select);
            
            // BUTTONS 
            deposit = new JButton("DEPOSIT");
            deposit.setFont(new Font("Courier New",Font.BOLD,15));
            deposit.setBounds(160,418,160,30);
            deposit.addActionListener(this);
            image.add(deposit);
            
            withdrawal = new JButton("WITHDRAWL");
            withdrawal.setFont(new Font("Courier New",Font.BOLD,15));
            withdrawal.setBounds(350,418,160,30);
            withdrawal.addActionListener(this);
            image.add(withdrawal);
            
            fcash = new JButton("FAST CASH");
            fcash.setFont(new Font("Courier New",Font.BOLD,15));
            fcash.setBounds(160,450,160,30);
            fcash.addActionListener(this);
            image.add(fcash);
            
            mstat = new JButton("MINI STATEMENT");
            mstat.setFont(new Font("Courier New",Font.BOLD,15));
            mstat.setBounds(350,450,160,30);
            mstat.addActionListener(this);
            image.add(mstat);
            
            pchange = new JButton("PIN CHANGE");
            pchange.setFont(new Font("Courier New",Font.BOLD,15));
            pchange.setBounds(160,482,160,30);
            pchange.addActionListener(this);
            image.add(pchange);
            
            balenq = new JButton("BALANCE");
            balenq.setFont(new Font("Courier New",Font.BOLD,15));
            balenq.setBounds(350,482,160,30);
            balenq.addActionListener(this);
            image.add(balenq);
            
            exit = new JButton("EXIT");
            exit.setFont(new Font("Courier New",Font.BOLD,15));
            exit.setBounds(160,514,350,30);
            exit.setBackground(Color.RED);
            exit.setForeground(Color.WHITE);
            exit.addActionListener(this);
            image.add(exit);
        
            //MAIN FRAME
            setSize(900,850);
            setLocation(330,5);
            setUndecorated(true);
            setVisible(true);
        }
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() ==  exit){
                System.exit(0);
            }
            else if(ae.getSource() == deposit){
                setVisible(false);
                new Deposit(pin_number).setVisible(true);
            }
            else if(ae.getSource() == withdrawal){
                setVisible(false);
                new Withdrawal(pin_number).setVisible(true);
            }
            else if(ae.getSource() == fcash){
                setVisible(false);
                new FastCash(pin_number).setVisible(true);
            }
            else if(ae.getSource() == pchange){
                setVisible(false);
                new PinChange(pin_number).setVisible(true);
            }
            else if(ae.getSource() == balenq){
                setVisible(false);
                new BalanceEnquiry(pin_number).setVisible(true);
            }
            else if(ae.getSource() ==  mstat){
                setVisible(false);
                new MiniStatement(pin_number).setVisible(true);
            }
        }
    
        public static void main(String...ar){
            new Transactions("");
        }   
    
}
