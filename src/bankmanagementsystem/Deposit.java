package bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField depo;
    JButton dep , back , exit;
    String pin_number;
    
    Deposit(String pin_number){
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
        
        // MAIN TEXT
        JLabel main = new JLabel("ENTER THE AMOUNT TO BE DEPOSITED : ");
        main.setFont(new Font("Courier New",Font.BOLD,15));
        main.setForeground(Color.WHITE);
        main.setBounds(170,300,350,30);
        image.add(main);
        
        // DEPOSIT
        depo = new JTextField();
        depo.setFont(new Font("Courier New",Font.BOLD,15));
        depo.setBounds(170,350,300,35);
        image.add(depo);
        
        // BUTTONS
        dep = new JButton("DEPOSIT");
        dep.setBounds(170,450,100,35);
        dep.setBackground(Color.WHITE);
        dep.setForeground(Color.BLACK);
        dep.addActionListener(this);
        dep.setFont(new Font("Courier New",Font.BOLD,15));
        image.add(dep);
        
        back = new JButton("BACK");
        back.setBounds(280,450,100,35);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        back.setFont(new Font("Courier New",Font.BOLD,15));
        image.add(back);
        
        exit = new JButton("EXIT");
        exit.setBounds(390,450,100,35);
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        exit.setFont(new Font("Courier New",Font.BOLD,15));
        image.add(exit);
        
        // MAIN FRAME
        setSize(900,850);
        setUndecorated(true);
        setLocation(330,5);
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
        else if(ae.getSource() == dep){
            String amt_entered = depo.getText();
            Date date = new Date();
            if(amt_entered.equals("")){
                JOptionPane.showMessageDialog(null, "ENTER A VALID AMOUNT!");
            }
            else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into deposit values('"+pin_number+"','"+date+"','Deposit','"+amt_entered+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "₹"+amt_entered+" DEPOSITED SUCCESSFULY");
                    setVisible(false);
                    new Transactions(pin_number).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    
    public static void main(String...ar){
        new Deposit(""); 
    }
}
