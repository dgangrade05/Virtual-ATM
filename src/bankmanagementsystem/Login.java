package bankmanagementsystem;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*; 
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    // GLOBALLY DEFINED BUTTONS FOR ACTIONS
        JButton sign_in,sign_up,clear,exit;
        JTextField card_tf;
        JPasswordField pin_pf;
    
    Login(){
        
        // FRAME TITLE
        setTitle("VIRTUAL ATM SERVICE");
        
        // FRAME LAYOUT
        setLayout(null);
        
        // IMAGE AND ICON
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(20,10,100,100);
        add(l1);
        
        // BANK NAME
        JLabel text_label = new JLabel("RICHIE RICH BANK");
        text_label.setFont(new Font("Arial Black",Font.BOLD,40));
        text_label.setBounds(200,40,500,40);
        add(text_label);
        
        //CREDENTIALS
        JLabel card_num = new JLabel("CARD NUMBER : ");
        card_num.setFont(new Font("Courier New",Font.BOLD,18));
        card_num.setBounds(200,90,500,90);
        add(card_num);
        
        card_tf = new JTextField();
        card_tf.setBounds(350,120,250,30);
        card_tf.setFont(new Font("Courier New",Font.BOLD,18));
        add(card_tf);
        
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Courier New",Font.BOLD,18));
        pin.setBounds(200,150,100,120);
        add(pin);
        
        pin_pf = new JPasswordField();
        pin_pf.setBounds(350,195,250,30);
        add(pin_pf);
        
        // BUTTONS
          sign_in = new JButton("SIGN IN");
        sign_in.setBounds(350,260,100,40);
        sign_in.setBackground(Color.BLACK);
        sign_in.setForeground(Color.WHITE);
        sign_in.setFont(new Font("Courier New",Font.BOLD,15));
        sign_in.addActionListener(this);
        add(sign_in);
        
        sign_up = new JButton("SIGN UP");
        sign_up.setBounds(500,260,100,40);
        sign_up.setBackground(Color.BLACK);
        sign_up.setForeground(Color.WHITE);
        sign_up.setFont(new Font("Courier New",Font.BOLD,15));
        sign_up.addActionListener(this);
        add(sign_up);
        
        clear = new JButton("CLEAR");
        clear.setBounds(350,320,100,40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Courier New",Font.BOLD,15));
        clear.addActionListener(this);
        add(clear);
        
        exit = new JButton("EXIT");
        exit.setBounds(500,320,100,40);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Courier New",Font.BOLD,15));
        exit.addActionListener(this);
        add(exit);
        
        
        // FRAME COLOR
        getContentPane().setBackground(Color.WHITE);
        
        // MAIN FRAME
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
    }
    
    // ACTIONS
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == sign_in){
            Conn conn = new Conn();
            String card_num = card_tf.getText();
            String pin_num = pin_pf.getText();
            String query = "select * from login where card_num = '"+card_num+"' and pin_number = '"+pin_num+"'";
            
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin_num).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null , "INVALID CREDENTILS");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == sign_up){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
        else if(ae.getSource() == clear){
            card_tf.setText("");
            pin_pf.setText("");
        }
        else if(ae.getSource() == exit){
            System.exit(0);
        }
}
    
    public static void main(String...ar){
        new Login();
    }
}
