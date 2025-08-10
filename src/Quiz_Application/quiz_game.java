package Quiz_Application;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class quiz_game extends JFrame implements ActionListener{

    JLabel qno,ques;
    String[][] question=new String[10][5];
    String[][] answer=new String[10][2];
    String[][] userAnswer=new String[10][1];
    JRadioButton A,B,C,D;
    ButtonGroup group;
    JButton next ,submit ,help;

    public static int timer=15;
    public static int ans_given=0;
    public static int count=0;
    public static int score=0;
    String name;


    quiz_game(String name){

        this.name=name;
        setBounds(100,100,1440,850);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/backimage.jpg"));
        JLabel img=new JLabel(i1);
        img.setBounds(0,0,1250,392);
        add(img);

        qno=new JLabel();
        qno.setBounds(100,350,50,30);
        qno.setFont(new Font("Thoma", Font.PLAIN,24));
        add(qno);

        ques=new JLabel();
        ques.setBounds(150,350,900,30);
        ques.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(ques);

        //questions and answer.........
        question[0][0]="Which method is the entry point of any Java program?";
        question[0][1]="main()";
        question[0][2]="run()";
        question[0][3]="start()";
        question[0][4]="init()";

        question[1][0]="Number of primitive Datatype in java are?";
        question[1][1]="6";
        question[1][2]="7";
        question[1][3]="8";
        question[1][4]="9";

        question[2][0]="Which keyword is used to inherit a class in Java?";
        question[2][1]="implements";
        question[2][2]="import";
        question[2][3]="extends";
        question[2][4]="inherits";

        question[3][0]="Which of the following is not a Java primitive type?";
        question[3][1]="int";
        question[3][2]="float";
        question[3][3]="boolean";
        question[3][4]="String";

        question[4][0]="Which of the following is a valid declaration of a Java main method?";
        question[4][1]="public void main(String[] args)";
        question[4][2]="public static void main(String[] args)";
        question[4][3]="private static void main(String[] args)";
        question[4][4]="public static int main(String[] args)";

        question[5][0]="Which keyword is used to stop the execution of a loop?";
        question[5][1]="stop";
        question[5][2]="return";
        question[5][3]="break";
        question[5][4]="exit";

        question[6][0]="What is method overloading in Java?";
        question[6][1]="Two classes with the same method name";
        question[6][2]="One class with same method name but different parameters";
        question[6][3]="Multiple main methods";
        question[6][4]="None of the above";

        question[7][0]="What does the final keyword mean when applied to a variable?";
        question[7][1]="The value can be changed";
        question[7][2]="The value cannot be changed after initialization";
        question[7][3]="The variable is garbage collected";
        question[7][4]="It's an abstract variable";

        question[8][0]="Which of these is a checked exception?";
        question[8][1]="NullPointerException";
        question[8][2]="ArithmeticException";
        question[8][3]="IOException";
        question[8][4]="ArrayIndexOutOfBoundsException";

        question[9][0]="What does the static keyword mean in Java?";
        question[9][1]="Method belongs to the object";
        question[9][2]="Method cannot be overridden";
        question[9][3]="Method or variable belongs to the class, not instances";
        question[9][4]=" Method is final";

        answer[0][1]="main()";
        answer[1][1]="8";
        answer[2][1]="extends";
        answer[3][1]="String";
        answer[4][1]="public static void main(String[] args)";
        answer[5][1]="break";
        answer[6][1]="One class with same method name but different parameters";
        answer[7][1]="The value cannot be changed after initialization";
        answer[8][1]="IOException";
        answer[9][1]="Method or variable belongs to the class, not instances";

        //button option
        A=new JRadioButton();
        A.setBounds(170,450,700,30);
        A.setBackground(Color.white);
        A.setFont(new Font("Dialog",Font.PLAIN,20));
        add(A);

        B=new JRadioButton();
        B.setBounds(170,490,700,30);
        B.setBackground(Color.white);
        B.setFont(new Font("Dialog",Font.PLAIN,20));
        add(B);

        C=new JRadioButton();
        C.setBounds(170,530,700,30);
        C.setBackground(Color.white);
        C.setFont(new Font("Dialog",Font.PLAIN,20));
        add(C);

        D=new JRadioButton();
        D.setBounds(170,570,700,30);
        D.setBackground(Color.white);
        D.setFont(new Font("Dialog",Font.PLAIN,20));
        add(D);

        //group button to select one option
        group=new ButtonGroup();
        group.add(A);
        group.add(B);
        group.add(C);
        group.add(D);

        next=new JButton("Next");
        next.setBounds(700,620,150,30);
        next.setBackground(new Color(22,99,54));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        submit=new JButton("Submit");
        submit.setBounds(1060,620,150,30);
        submit.setBackground(new Color(255,215,0));
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        help=new JButton("Help");
        help.setBounds(880,620,150,30);
        help.setBackground(new Color(22,99,54));
        help.setForeground(Color.white);
        help.addActionListener(this);
        add(help);

        start(count);





        setSize(1250,700);
        setLocation(100,80);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            repaint();
            A.setEnabled(true);
            B.setEnabled(true);
            C.setEnabled(true);
            D.setEnabled(true);
            ans_given=1;
            if(group.getSelection()==null){
                userAnswer[count][0]="";
            }
            else{
                userAnswer[count][0]=group.getSelection().getActionCommand();
            }
            if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }else if(e.getSource()==help){
            if(count==2|| count==4|| count==6|| count==8|| count==9){
                B.setEnabled(false);
                C.setEnabled(false);}
            else{
                A.setEnabled(false);
                D.setEnabled(false);
            }
            help.setEnabled(false);
        }else if(e.getSource()==submit){
            ans_given=-1;
            if(group.getSelection()==null){
                userAnswer[count][0]="";
            }else{
                userAnswer[count][0]=group.getSelection().getActionCommand();
            }
            for(int i=0;i<userAnswer.length;i++){
                if(userAnswer[i][0].equals(answer[i][1])){
                    score+=10;
                }
                else{
                    score+=0;
                }
            }
            setVisible(false);
            new Score(name,score);
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        String time="time left-"+timer +"seconds";
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma",Font.BOLD,25));
        if(timer>0){
            g.drawString(time,950,400);
        }else{
            g.drawString("times up!!",950,400);
        }
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception E){
            E.printStackTrace();
        }
        if(ans_given==1){
            ans_given=0;
            timer=15;
        }
        else if(timer<0){
            timer=15;
            A.setEnabled(true);
            B.setEnabled(true);
            C.setEnabled(true);
            D.setEnabled(true);

            if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9){
                if(group.getSelection()==null){
                    userAnswer[count][0]="";
                }else{
                    userAnswer[count][0]=group.getSelection().getActionCommand();
                }
                for(int i=0;i<userAnswer.length;i++){
                    if(userAnswer[i][0].equals(answer[i][1])){
                        score+=10;
                    }
                    else{
                        score+=0;
                    }
                }
                setVisible(false);
                new Score(name,score);
            }else{
                if(group.getSelection()==null){
                    userAnswer[count][0]="";
                }else{
                    userAnswer[count][0]=group.getSelection().getActionCommand();
                }count++;
                start(count);

            }
        }
    }
    public void start(int count){
        qno.setText(" "+(count+1)+".");
        ques.setText(question[count][0]);
        A.setText(question[count][1]);
        A.setActionCommand(question[count][1]);

        B.setText(question[count][2]);
        B.setActionCommand(question[count][2]);

        C.setText(question[count][3]);
        C.setActionCommand(question[count][3]);

        D.setText(question[count][4]);
        D.setActionCommand(question[count][4]);

        group.clearSelection();
    }
    public static void main(String[] args) {
        new quiz_game("User");
    }
}
