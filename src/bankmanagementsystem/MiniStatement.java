package bankmanagementsystem;

import java.awt.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniStatement extends JFrame implements ActionListener {
    
    String pin_number;
    JButton exit;
    
    MiniStatement(String pin_number){
        this.pin_number = pin_number;
        // LAYOUT
        setLayout(null);
        
        // LABELS
        JLabel main_text = new JLabel(" RICHIE RICH BANK ");
        main_text.setFont(new Font("Arial Black",Font.BOLD,20));
        main_text.setBounds(165,5,300,30);
        add(main_text);
        
        JLabel card = new JLabel();
        card.setBounds(50,50,500,30);
        card.setFont(new Font("Courier New",Font.BOLD,15));
        add(card);
        
        JLabel mini = new JLabel();
        mini.setBounds(50,100,500,30);
        mini.setFont(new Font("Courier New",Font.BOLD,15));
        add(mini);
        
        exit = new JButton("EXIT");
        exit.setFont(new Font("Courier New",Font.BOLD,15));
        exit.setBounds(50,450,100,30);
        exit.setBackground(Color.RED);
        exit.addActionListener(this);
        exit.setForeground(Color.WHITE);
        add(exit);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin_number = '"+pin_number+"' ");
            while(rs.next()){
                card.setText("CARD NUMBER : "+ rs.getString("card_num").substring(0,4) +"XXXX-XXXX"+ rs.getString("card_num").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from deposit where pin = '"+pin_number+"' ");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;"+ "&nbsp;"+ "&nbsp;"+ "&nbsp;" + rs.getString("type")+ "&nbsp;"+ "&nbsp;"+ "&nbsp;"+ "&nbsp;" + rs.getString("amount")+"<br><br><html>");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        // MAIN FRAME
        setTitle("STATEMENT");
        setSize(600,600);
        setLocation(50,50);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
    }
    
    public static void main(String...ar){
        new MiniStatement("");
    }
}
