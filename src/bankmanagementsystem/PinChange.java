package bankmanagementsystem;

import java.awt.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField new_pin , confirm_pin;
    JButton change , cancel , exit;
    String pin_number;
    
    PinChange(String pin_number){
        this.pin_number = pin_number;
        //LAYOUT
        setLayout(null);
        
        // IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        // LABELS AND TEXTFIELDS
        JLabel main_text = new JLabel(" RICHIE RICH BANK ");
        main_text.setFont(new Font("Arial Black",Font.BOLD,20));
        main_text.setForeground(Color.WHITE);
        main_text.setBounds(230,280,300,30);
        image.add(main_text);
            
        JLabel select = new JLabel("PIN CHANGE");
        select.setFont(new Font("Courier New",Font.BOLD,15));
        select.setBounds(295,320,300,30);
        select.setForeground(Color.WHITE);
        image.add(select);
        
        JLabel newpin = new JLabel("NEW PIN :");
        newpin.setFont(new Font("Arial Black",Font.BOLD,15));
        newpin.setForeground(Color.WHITE);
        newpin.setBounds(160,410,160,30);
        image.add(newpin);
        
        JLabel conpin = new JLabel("CONFIRM PIN :");
        conpin.setFont(new Font("Arial Black",Font.BOLD,15));
        conpin.setForeground(Color.WHITE);
        conpin.setBounds(160,460,160,30);
        image.add(conpin);
        
        new_pin = new JPasswordField();
        new_pin.setBounds(300,410,150,30);
        new_pin.setFont(new Font("Courier New",Font.BOLD,15));
        image.add(new_pin);
        
        confirm_pin = new JPasswordField();
        confirm_pin.setBounds(300,460,150,30);
        confirm_pin.setFont(new Font("Courier New",Font.BOLD,15));
        image.add(confirm_pin);
        
        // BUTTONS
        change = new JButton("CHANGE");
        change.setFont(new Font("Courier New",Font.BOLD,15));
        change.setBounds(160,510,100,30);
        change.addActionListener(this);
        image.add(change);
        
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Courier New",Font.BOLD,15));
        cancel.setBounds(280,510,100,30);
        cancel.addActionListener(this);
        image.add(cancel);
        
        exit = new JButton("EXIT");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        exit.setFont(new Font("Courier New",Font.BOLD,15));
        exit.setBounds(400,510,100,30);
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
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Transactions(pin_number).setVisible(true);
        }
        else if(ae.getSource() == change){
            try{
                String npin = new_pin.getText();
                String cpin = confirm_pin.getText();
                
                if(!npin.equals(cpin)){
                    JOptionPane.showMessageDialog(null, "PINS DO NOT MATCH");
                }
                
                Conn conn = new Conn();
                String query1 = "update deposit set pin = '"+cpin+"' where pin = '"+pin_number+"'";
                String query2 = "update login set pin_number = '"+cpin+"' where pin_number = '"+pin_number+"'";
                String query3 = "update signupthree set pin_num = '"+cpin+"' where pin_num = '"+pin_number+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN CHANGED");
                setVisible(false);
                new Transactions(cpin).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String...ar){
        new PinChange("");
    }
}
