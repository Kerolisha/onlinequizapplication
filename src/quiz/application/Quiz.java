package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(0 ,0 , 1400, 750);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ml2.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Which type of ml alg is trained on labeled data.?";
        questions[0][1] = "Unsupervised Learning";
        questions[0][2] = "Supervised Learning";
        questions[0][3] = "Semi-supervised Learning";
        questions[0][4] = "reinforcement Learning";

        questions[1][0] = "Which of these products use ml?";
        questions[1][1] = "Google Maps";
        questions[1][2] = "tiktok";
        questions[1][3] = "Netflix";
        questions[1][4] = "All of the above";

        questions[2][0] = "How does ml relate to AI?";
        questions[2][1] = "AI is a subfield of ml";
        questions[2][2] = "ml and AI are synonyms";
        questions[2][3] = "ml is a subfield of AI";
        questions[2][4] = "ml and AI are two completely different fields";

        questions[3][0] = "Which ml alg is inspired by the behaviour of neurons in the human brain?";
        questions[3][1] = "Decision Trees";
        questions[3][2] = "K-nearest Neighbors";
        questions[3][3] = "Support vector machines";
        questions[3][4] = "Artificial Neural Networks";

        questions[4][0] = "In unsupervised learning the primary task is?";
        questions[4][1] = "predict the output value based on input data";
        questions[4][2] = "discover patterns and structures";
        questions[4][3] = "learning from expert demonstrations";
        questions[4][4] = "None of the above";

        questions[5][0] = "What is process of preparing raw data by cleaning and transforming?";
        questions[5][1] = "Data preprocessing";
        questions[5][2] = "Data engineering";
        questions[5][3] = "Data wrangling";
        questions[5][4] = "Data augmentation";

        questions[6][0] = "Which technique is used for handling missing data?";
        questions[6][1] = "Feature scaling";
        questions[6][2] = "Data noralization";
        questions[6][3] = "Data imputation";
        questions[6][4] = "Feature engineering";

        questions[7][0] = "Which of the following ml alg is based on the idea of bagging?";
        questions[7][1] = "Decision tree";
        questions[7][2] = "Random forest";
        questions[7][3] = "Classification";
        questions[7][4] = "Regression";

        questions[8][0] = "Full form of PAC?";
        questions[8][1] = "Probably Approx Cost";
        questions[8][2] = "Probably Approximate Correct";
        questions[8][3] = "Probability Approx Communication";
        questions[8][4] = "Probably Approximate Computation";

        questions[9][0] = "Identify the kind of ml used for facial idendification?";
        questions[9][1] = "Prediction";
        questions[9][2] = "Recognition patterns";
        questions[9][3] = "Recognizing anomalies";
        questions[9][4] = "Generating patterns";

        answers[0][1] = "Supervised Learning";
        answers[1][1] = "All of the above";
        answers[2][1] = "ml is a subfield of AI";
        answers[3][1] = "Artificial Neural Networks";
        answers[4][1] = "discover patterns and structures";
        answers[5][1] = "Data preprocesssing";
        answers[6][1] = "Data imputation";
        answers[7][1] = "Random forest";
        answers[8][1] = "Probably Approximate Correct";
        answers[9][1] = "Recognition patterns";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 400, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 500, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 600, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
       
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) { 
            g.drawString(time, 450, 450);
        } else {
            g.drawString("Times up!!", 450, 450);
        }

        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
         
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}