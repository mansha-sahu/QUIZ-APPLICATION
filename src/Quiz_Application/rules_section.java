package Quiz_Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rules_section extends JFrame implements ActionListener {
    JButton start,back;
    String name;
    rules_section(String name){

        this.name=name;
        JLabel heading=new JLabel("Welcome "+ name +" to QUIZ Challenge");
        heading.setBounds(150,100,700,30);
        heading.setFont(new Font("Vainer hand ITC",Font.BOLD,28));
        heading.setForeground(new Color(22,99,54));
        add(heading);

        JLabel rules=new JLabel("Rules");
        rules.setBounds(200,150,700,350);
        rules.setFont(new Font("Tahoma",Font.BOLD,16));
        rules.setForeground(new Color(22,99,54));
        rules.setText(
                "<html>"+ "Think fast. Answer smart. Beat the clock."+"<br><br>"+
                        "1.The game consists of 10 questions "+"<br><br>"+
                        "2.Each question must be answered within 15s"+"<br><br>"+
                        "3.Each correct answer will give you 10 points"+"<br><br>"+
                        "4.No Cheating"+"<br><br>"+
                        "5.One Player at a Time"+"<br><br>"+
                        "6.Best of Luck!"+
                        "<html>");
        add(rules);

        back=new JButton("Back");
        back.setBounds(300,500,100,30);
        back.setBackground(new Color(22,99,54));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        start=new JButton("Start");
        start.setBounds(500,500,100,30);
        start.setBackground(new Color(22,99,54));
        start.setForeground(Color.white);
        start.addActionListener(this);
        add(start);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/background.jpg"));
        Image i=i1.getImage().getScaledInstance(800,650,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i);
        JLabel image=new JLabel(i2);
        image.setBounds(0,0,800,650);
        add(image);

        setSize(800,650);
        setLocation(350,100);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==start){
            setVisible(false);
            new quiz_game(name);
        }
        else{
            setVisible(false);
            new Login();
        }


    }

    public static void main(String[] args) {
        new rules_section("User");
    }
}
