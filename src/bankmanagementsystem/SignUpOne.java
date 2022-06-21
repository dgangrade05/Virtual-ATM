package bankmanagementsystem;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;


public class SignUpOne extends JFrame implements ActionListener{
    
    JTextField first_name_tf , last_name_tf , father_tf , email_tf , add_tf , city_tf , state_tf , pc_tf , dob_tf;
    JRadioButton male , female , other;
    JCheckBox yes , no;
    JButton next , clear , exit;
    long random;
    
    SignUpOne(){
        // LAYOUT
        setLayout(null);
        
        // RANDOM CLASS
        Random ran = new Random();
        random = Math.abs(ran.nextLong()%9000L)+1000L;
        
        // FORM
        JLabel form_num = new JLabel("APPLICATION FORM NUMBER "+random);
        form_num.setFont(new Font("Courier New",Font.BOLD,25));
        form_num.setBounds(200,5,500,30);
        add(form_num);
        
        // DETAILS
        JLabel personalDetails = new JLabel("PAGE 1 : PERSONAL DETAILS ");
        personalDetails.setFont(new Font("Courier New",Font.BOLD,15));
        personalDetails.setBounds(280,50,500,30);
        add(personalDetails);
        
        // NAME
        JLabel fisrt_name = new JLabel("FIRST NAME : ");
        fisrt_name.setFont(new Font("Courier New",Font.BOLD,15));
        fisrt_name.setBounds(80,120,250,30);
        add(fisrt_name);
        
        first_name_tf = new JTextField();
        first_name_tf.setFont(new Font("Courier New",Font.BOLD,15));
        first_name_tf.setBounds(200,120,150,30);
        add(first_name_tf);
        
        JLabel last_name = new JLabel("LAST NAME :");
        last_name.setFont(new Font("Courier New",Font.BOLD,15));
        last_name.setBounds(390,120,250,30);
        add(last_name);
        
        
        last_name_tf = new JTextField();
        last_name_tf.setFont(new Font("Courier New",Font.BOLD,15));
        last_name_tf.setBounds(510,120,150,30);
        add(last_name_tf);
        
        
        //FATHER'S NAME
        JLabel father_name = new JLabel("FATHER'S NAME : ");
        father_name.setFont(new Font("Courier New",Font.BOLD,15));
        father_name.setBounds(55,170,250,30);
        add(father_name);
        
        father_tf = new JTextField();
        father_tf.setFont(new Font("Courier New",Font.BOLD,15));
        father_tf.setBounds(200,170,460,30);
        add(father_tf);
        
        // DOB
        JLabel dob = new JLabel("DATE OF BIRTH : ");
        dob.setFont(new Font("Courier New",Font.BOLD,15));
        dob.setBounds(55,220,150,30);
        add(dob);
        
        dob_tf = new JTextField();
        dob_tf.setFont(new Font("Courier New",Font.BOLD,15));
        dob_tf.setBounds(200,220,150,30);
        add(dob_tf);
        
        // GENDER
        JLabel gender = new JLabel("GENDER : ");
        gender.setFont(new Font("Courier New",Font.BOLD,15));
        gender.setBounds(55,270,150,30);
        add(gender);
        
        male = new JRadioButton(" MALE");
        male.setBackground(Color.WHITE);
        male.setBounds(200,270,100,30);
        add(male);
        
        female = new JRadioButton(" FEMALE");
        female.setBackground(Color.WHITE);
        female.setBounds(350,270,100,30);
        add(female);
        
        other = new JRadioButton(" OTHER");
        other.setBackground(Color.WHITE);
        other.setBounds(500,270,100,30);
        add(other);
        
        ButtonGroup gen_gr = new ButtonGroup();
        gen_gr.add(male);
        gen_gr.add(female);
        gen_gr.add(other);
        
        //EMAIL
        JLabel email = new JLabel("EMAIL : ");
        email.setFont(new Font("Courier New",Font.BOLD,15));
        email.setBounds(55,320,150,30);
        add(email);
        
        email_tf = new JTextField();
        email_tf.setFont(new Font("Courier New",Font.BOLD,15));
        email_tf.setBounds(200,320,460,30);
        add(email_tf);
        
        
        //MARITIAL STATUS 
        JLabel ms = new JLabel("MARITIAL STATUS : ");
        ms.setFont(new Font("Courier New",Font.BOLD,15));
        ms.setBounds(55,370,200,30);
        add(ms);
        
        yes = new JCheckBox(" YES");
        yes.setBackground(Color.WHITE);
        yes.setBounds(220,370,100,30);
        add(yes);
        
        no = new JCheckBox(" NO");
        no.setBackground(Color.WHITE);
        no.setBounds(370,370,100,30);
        add(no);
        
        ButtonGroup msgr = new ButtonGroup();
        msgr.add(yes);
        msgr.add(no);
        
        //ADDRESS
        JLabel addr = new JLabel("ADDRESS : ");
        addr.setFont(new Font("Courier New",Font.BOLD,15));
        addr.setBounds(55,420,100,30);
        add(addr);
        
        add_tf = new JTextField();
        add_tf.setFont(new Font("Courier New",Font.BOLD,15));
        add_tf.setBounds(200,420,460,30);
        add(add_tf);
        
        //CITY
        JLabel city = new JLabel("CITY : ");
        city.setFont(new Font("Courier New",Font.BOLD,15));
        city.setBounds(55,470,80,30);
        add(city);
        
        city_tf = new JTextField();
        city_tf.setFont(new Font("Courier New",Font.BOLD,15));
        city_tf.setBounds(200,470,200,30);
        add(city_tf);
        
        //STATE
        JLabel state = new JLabel("STATE : ");
        state.setFont(new Font("Courier New",Font.BOLD,15));
        state.setBounds(55,520,100,30);
        add(state);
        
        state_tf = new JTextField();
        state_tf.setFont(new Font("Courier New",Font.BOLD,15));
        state_tf.setBounds(200,520,200,30);
        add(state_tf);
        
        //PIN CODE
        JLabel pc = new JLabel("PIN CODE : ");
        pc.setFont(new Font("Courier New",Font.BOLD,15));
        pc.setBounds(55,570,100,30);
        add(pc);
        
        pc_tf = new JTextField();
        pc_tf.setFont(new Font("Courier New",Font.BOLD,15));
        pc_tf.setBounds(200,570,200,30);
        add(pc_tf);
        
        // BUTTONS
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Courier New",Font.BOLD,15));
        next.setBounds(200,620,100,40);
        next.addActionListener(this);
        add(next);
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Courier New",Font.BOLD,15));
        clear.setBounds(400,620,100,40);
        clear.addActionListener(this);
        add(clear);
        
        exit = new JButton("EXIT");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Courier New",Font.BOLD,15));
        exit.setBounds(600,620,100,40);
        exit.addActionListener(this);
        add(exit);
        
        // MAIN FRAME
        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        setLocation(400,10);
        setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            first_name_tf.setText(""); 
            last_name_tf.setText("");
            father_tf.setText("");
            email_tf.setText("");
            add_tf.setText("");
            city_tf.setText("");
            state_tf.setText("");
            pc_tf.setText("");
            dob_tf.setText(""); 
        }
        else if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource() == next){
            
            //GETTING DATA FROM THE FORM FIELDS
            
            String form_num = "" + random;
            String first_name = first_name_tf.getText();
            String last_name = last_name_tf.getText();
            String father_name = father_tf.getText();
            String dob = dob_tf.getText();
            String gender = null;
            if(male.isSelected()){
                gender = "MALE";
            }
            else if(female.isSelected()){
                gender = "FEMALE";
            }
            else if(other.isSelected()){
                gender = "OTHER";
            }
            String email = email_tf.getText();
            String ms = null;
            if(yes.isSelected()){
                ms = "YES";
            }
            else if(no.isSelected()){
                ms = "NO";
            }
            String addr = add_tf.getText();
            String city = city_tf.getText();
            String state = state_tf.getText();
            String pc = pc_tf.getText();
            
            //VALIDATION & DATABASE CONNECTION
            try{
                Conn c = new Conn();
                String query = "insert into signup values('"+form_num+"','"+first_name+"','"+last_name+"','"+father_name+"'"
                        + ",'"+dob+"','"+gender+"','"+email+"','"+ms+"','"+addr+"','"+city+"','"+state+"','"+pc+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpTwo(form_num).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String...ar){
        new SignUpOne();
    }
}
