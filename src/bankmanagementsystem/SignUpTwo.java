package bankmanagementsystem;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;



public class SignUpTwo extends JFrame implements ActionListener{
    
    JComboBox rel_box , cat_box , income_box , edu_box , occ_box;
    JButton next , clear , exit;
    JTextField pan_tf , aadh_tf;
    JRadioButton yes , no;
    String form_num;
    
    SignUpTwo(String form_num){
        this.form_num = form_num;
        
        // LAYOUT
        setLayout(null);
        
        // TITLE
        setTitle("NEW ACCOUNT OPENING");
        
        // DETAILS
        JLabel personalDetails = new JLabel("PAGE 2 : ADDITIONAL DETAILS ");
        personalDetails.setFont(new Font("Courier New",Font.BOLD,15));
        personalDetails.setBounds(280,10,500,30);
        add(personalDetails);
        
        // RELIGION
        
        JLabel rel = new JLabel("RELIGION : ");
        rel.setFont(new Font("Courier New",Font.BOLD,15));
        rel.setBounds(80,120,100,30);
        add(rel);
        
        String valRel[] = {"HINDU","MUSLIM","CHRISTIAN","SIKH","JAIN"};
        
        rel_box = new JComboBox(valRel);
        rel_box.setFont(new Font("Courier New",Font.BOLD,15));
        rel_box.setBounds(250,120,250,30);
        rel_box.setBackground(Color.WHITE);
        add(rel_box);
        
        // CATEGORY
        
        JLabel cat = new JLabel("CATEGORY :");
        cat.setFont(new Font("Courier New",Font.BOLD,15));
        cat.setBounds(80,170,100,30);
        add(cat);
        
        String catVal[] = {"GENERAL","SC","ST","OBC"};
        
        cat_box = new JComboBox(catVal);
        cat_box.setFont(new Font("Courier New",Font.BOLD,15));
        cat_box.setBounds(250,170,250,30);
        cat_box.setBackground(Color.WHITE);
        add(cat_box);
        
        // INCOME 
        
        JLabel income = new JLabel("INCOME   : ");
        income.setFont(new Font("Courier New",Font.BOLD,15));
        income.setBounds(80,220,150,30);
        add(income);
        
        String incVal[] = {"> 1,00,000","< 2,00,000","< 5,00,000","< 10,00,000","< 50,00,000"};
        
        income_box = new JComboBox(incVal);
        income_box.setFont(new Font("Courier New",Font.BOLD,15));
        income_box.setBounds(250,220,250,30);
        income_box.setBackground(Color.WHITE);
        add(income_box);
        
        // EDUCATION
        
        JLabel edu = new JLabel("EDUCATION : ");
        edu.setFont(new Font("Courier New",Font.BOLD,15));
        edu.setBounds(70,270,150,30);
        add(edu);
        
        String eduVal[] = {"UNEDUCATED","SECONDARY","STUDENT","UNDER GRADUATE","POST GRADUATE"};
        
        edu_box = new JComboBox(eduVal);
        edu_box.setFont(new Font("Courier New",Font.BOLD,15));
        edu_box.setBounds(250,270,250,30);
        edu_box.setBackground(Color.WHITE);
        add(edu_box);
        
        // OCCUPATION
        
        JLabel occu = new JLabel("OCCUPATION : ");
        occu.setFont(new Font("Courier New",Font.BOLD,15));
        occu.setBounds(60,320,150,30);
        add(occu);
        
        String occVal[] = {"UNEMPLOYED","BUSINESS","SERVICE","JOB"};
        
        occ_box = new JComboBox(occVal);
        occ_box.setFont(new Font("Courier New",Font.BOLD,15));
        occ_box.setBounds(250,320,250,30);
        occ_box.setBackground(Color.WHITE);
        add(occ_box);
        
        // PAN
        
        JLabel pan = new JLabel("PAN NUMBER : ");
        pan.setFont(new Font("Courier New",Font.BOLD,15));
        pan.setBounds(60,370,150,30);
        add(pan);
        
        pan_tf = new JTextField();
        pan_tf.setFont(new Font("Courier New",Font.BOLD,15));
        pan_tf.setBounds(250,370,250,30);
        add(pan_tf);
        
        // AADHAR
        
        JLabel aadh = new JLabel("AADHAR NUMBER : ");
        aadh.setFont(new Font("Courier New",Font.BOLD,15));
        aadh.setBounds(35,420,150,30);
        add(aadh);
        
        aadh_tf = new JTextField();
        aadh_tf.setFont(new Font("Courier New",Font.BOLD,15));
        aadh_tf.setBounds(250,420,250,30);
        add(aadh_tf);
        
        // SENIOR CITIZEN
        JLabel sencit = new JLabel("SENIOR CITIZEN : ");
        sencit.setFont(new Font("Courier New",Font.BOLD,15));
        sencit.setBounds(30,470,150,30);
        add(sencit);
        
        yes = new JRadioButton("YES");
        yes.setFont(new Font("Courier New",Font.BOLD,15));
        yes.setBounds(250,470,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no = new JRadioButton("NO");
        no.setFont(new Font("Courier New",Font.BOLD,15));
        no.setBounds(400,470,100,30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup msgr1 = new ButtonGroup();
        msgr1.add(yes);
        msgr1.add(no);
        
        //EXISTING ACCOUNT
        JLabel exiacc = new JLabel("EXISTING ACCOUNT : ");
        exiacc.setFont(new Font("Courier New",Font.BOLD,15));
        exiacc.setBounds(30,520,200,30);
        add(exiacc);
        
        yes = new JRadioButton("YES");
        yes.setFont(new Font("Courier New",Font.BOLD,15));
        yes.setBounds(250,520,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);
                
        no = new JRadioButton("NO");
        no.setFont(new Font("Courier New",Font.BOLD,15));
        no.setBounds(400,520,100,30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup msgr2 = new ButtonGroup();
        msgr2.add(yes);
        msgr2.add(no);
        
        // BUTTONS
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Courier New",Font.BOLD,15));
        next.setBounds(200,620,100,40);
        next.addActionListener(this);
        add(next);
        
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
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource() == next){
           String rel = (String) rel_box.getSelectedItem();
           String cat = (String) cat_box.getSelectedItem();
           String income = (String) income_box.getSelectedItem();
           String edu = (String) edu_box.getSelectedItem();
           String occu = (String) occ_box.getSelectedItem();
           String pan = pan_tf.getText();
           String aadh = aadh_tf.getText();
           String sencit = null;
           if(yes.isSelected()){
               sencit = "YES";
           }
           else if(no.isSelected()){
               sencit = "NO";
           }
           String exiacc = null;
           if(yes.isSelected()){
               exiacc = "YES";
           }
           else if(no.isSelected()){
               exiacc = "NO"; 
           }
           
           //VALIDATION & DATABASE CONNECTION
            try{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+form_num+"','"+rel+"','"+cat+"','"+income+"'"
                        + ",'"+edu+"','"+occu+"','"+pan+"','"+aadh+"','"+sencit+"','"+exiacc+"')";
                c.s.executeUpdate(query);
                
                
                // SIGNUP 3
                setVisible(false);
                new SignUpThree(form_num).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String...ar){
        new SignUpTwo("");
    }
}
