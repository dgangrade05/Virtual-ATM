package bankmanagementsystem;

import java.awt.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back , exit;
    String pin_number;
    
    BalanceEnquiry(String pin_number){
        
        this.pin_number= pin_number;
        
        //LAYOUT
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
        main_text.setFont(new Font("Arial Black",Font.BOLD,20));
        main_text.setForeground(Color.WHITE);
        main_text.setBounds(230,280,300,30);
        image.add(main_text);
        
        JLabel balenq = new JLabel("AVAILABLE BALANCE");
        balenq.setFont(new Font("Courier New",Font.BOLD,15));
        balenq.setBounds(270,330,300,30);
        balenq.setForeground(Color.WHITE);
        image.add(balenq);
        
        // BUTTONS
        exit = new JButton("EXIT");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        exit.setFont(new Font("Courier New",Font.BOLD,15));
        exit.setBounds(400,510,100,30);
        image.add(exit);
        
        back = new JButton("BACK");
        back.setFont(new Font("Courier New",Font.BOLD,15));
        back.setBounds(280,510,100,30);
        back.addActionListener(this);
        image.add(back);
        
        // BALANCE DISPLAY
        Conn conn = new Conn();
        int balance = 0;
        try{
            ResultSet rs = conn.s.executeQuery("select * from deposit where pin = '"+pin_number+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance = balance + Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance = balance - Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        // DISPLAY LABEL
        JLabel avail_bal = new JLabel("₹ "+balance);
        avail_bal.setFont(new Font("Courier New",Font.BOLD,18));
        avail_bal.setForeground(Color.WHITE);
        avail_bal.setBounds(230,380,100,30);
        image.add(avail_bal);
        
        //MAIN FRAME
        setSize(900,850);
        setLocation(330,5);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pin_number).setVisible(true);
        }
    }
    
    public static void main(String...ar){
        new BalanceEnquiry("");
    }
}
