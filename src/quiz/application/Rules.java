package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " for the ml quiz");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("mongolian baiti", Font.BOLD, 28));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. Each student is given ten questions" + "<br><br>" +
                "2. Time limit of 15 sec for each question is provided" + "<br><br>" +
                "3. Try to attempt all the questions" + "<br><br>" +
                "4. A 50-50 lifeline is given to use for one time only" + "<br><br>" +
                "5. Dont try to copy" +  "<br><br>" +
                "6. Its just a type of skill test so dont get tensed" + "<br><br>" +
                "7. At last you have submit option to submit your test" + "<br><br>" +
                "8. You can also view your quiz score at the end of the test "+"<br><br>" +
            "<html>"
        );
        add(rules);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(800, 600);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
