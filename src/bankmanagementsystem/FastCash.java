 package bankmanagementsystem;

import java.awt.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FastCash extends JFrame implements ActionListener{
    
    JButton r500 , r1000 , r2000 , r5000 , r10000 , r50000 , exit;
    String pin_number;
        FastCash(String pin_number){
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
            r500 = new JButton("₹ 500");
            r500.setFont(new Font("Courier New",Font.BOLD,15));
            r500.setBounds(160,418,160,30);
            r500.addActionListener(this);
            image.add(r500);
            
            r1000 = new JButton("₹ 1000");
            r1000.setFont(new Font("Courier New",Font.BOLD,15));
            r1000.setBounds(350,418,160,30);
            r1000.addActionListener(this);
            image.add(r1000);
            
            r2000 = new JButton("₹ 2000");
            r2000.setFont(new Font("Courier New",Font.BOLD,15));
            r2000.setBounds(160,450,160,30);
            r2000.addActionListener(this);
            image.add(r2000);
            
            r5000 = new JButton("₹ 5000");
            r5000.setFont(new Font("Courier New",Font.BOLD,15));
            r5000.setBounds(350,450,160,30);
            r5000.addActionListener(this);
            image.add(r5000);
            
            r10000 = new JButton("₹ 10,000");
            r10000.setFont(new Font("Courier New",Font.BOLD,15));
            r10000.setBounds(160,482,160,30);
            r10000.addActionListener(this);
            image.add(r10000);
            
            r50000 = new JButton("₹ 50,000");
            r50000.setFont(new Font("Courier New",Font.BOLD,15));
            r50000.setBounds(350,482,160,30);
            r50000.addActionListener(this);
            image.add(r50000);
            
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
            if(ae.getSource() == exit){
                System.exit(0);
            }
            else{
                String amount = ((JButton)ae.getSource()).getText().substring(2);
                try{
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from deposit where pin = '"+pin_number+"'");
                    int balance = 0;
                    while(rs.next()){
                         if(rs.getString("type").equals("Deposit")){
                             balance = balance + Integer.parseInt(rs.getString("amount"));
                         }
                         else{
                             balance = balance - Integer.parseInt(rs.getString("amount"));
                         }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE!");
                        return;
                    }
                    
                    Date date = new Date();
                    String query = "insert into deposit values('"+pin_number+"','"+date+"','WITHDRAWAL','"+amount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "₹ "+amount+" WITHDRAWN");
                    
                    setVisible(false);
                    new Transactions(pin_number).setVisible(true);
                    
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    
        public static void main(String...ar){
            new FastCash("");
        }   
    
}
