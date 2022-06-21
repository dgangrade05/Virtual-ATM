package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdrawal extends JFrame implements ActionListener {
    
    JTextField wdraw;
    JButton withd , back , exit;
    String pin_number;
    
    Withdrawal(String pin_number){
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
        JLabel main = new JLabel("ENTER THE AMOUNT TO BE WITHDRAWN : ");
        main.setFont(new Font("Courier New",Font.BOLD,15));
        main.setForeground(Color.WHITE);
        main.setBounds(170,300,350,30);
        image.add(main);
        
        // WITHDRAW
        wdraw = new JTextField();
        wdraw.setFont(new Font("Courier New",Font.BOLD,15));
        wdraw.setBounds(170,350,300,35);
        image.add(wdraw);
        
        // BUTTONS
        withd = new JButton("WITHDRAW");
        withd.setBounds(170,450,120,35);
        withd.setBackground(Color.WHITE);
        withd.setForeground(Color.BLACK);
        withd.addActionListener(this);
        withd.setFont(new Font("Courier New",Font.BOLD,15));
        image.add(withd);
        
        back = new JButton("BACK");
        back.setBounds(300,450,100,35);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        back.setFont(new Font("Courier New",Font.BOLD,15));
        image.add(back);
        
        exit = new JButton("EXIT");
        exit.setBounds(410,450,100,35);
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        exit.setFont(new Font("Courier New",Font.BOLD,15));
        image.add(exit);

        
        // MAIN FRAME
        setSize(900,850);
//        setUndecorated(true);
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
        else if(ae.getSource() == withd){
            String amt_entered = wdraw.getText();
            Date date = new Date();
            if(amt_entered.equals("")){
                JOptionPane.showMessageDialog(null, "ENTER A VALID AMOUNT!");
            }
            else{
                try{
                Conn conn = new Conn();
                String query = "insert into withdraw values('"+pin_number+"','"+date+"','Withdraw','"+amt_entered+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "₹"+amt_entered+" WITHDRAWN SUCCESSFULY");
                setVisible(false);
                new Transactions(pin_number).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    
    public static void main(String...ar){
        new Withdrawal("");
    }
}
