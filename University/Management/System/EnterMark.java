package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMark extends JFrame implements ActionListener {
    Choice choiceRollNo;
    JComboBox comboBox;
    JTextField sub1, sub2, sub3, sub4, sub5 , mrk1 ,mrk2 , mrk3 , mrk4 , mrk5;
    JButton submit , close;


    EnterMark(){
        getContentPane().setBackground(new Color(252,245,210));
        ImageIcon i1 = new ImageIcon("C:\\Users\\prasa\\Desktop\\University_Management_System\\src\\Icon\\exam.png");
        Image i2  =  i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3  =  new ImageIcon(i2);
        JLabel img =  new JLabel(i3);
        img.setBounds(500,40,400,300);
        add(img);

        JLabel heading  =  new JLabel("Enter Marks of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        add(heading);

        JLabel rollno  =  new JLabel("Select Roll Number");
        rollno.setBounds(50,70,150,20);
        add(rollno);

        choiceRollNo   =  new Choice();
        choiceRollNo.setBounds(200,70,150,20);
        add(choiceRollNo);


        try{
            Con c  =  new Con();
            ResultSet rs  =  c.statement.executeQuery("select * from Student");
            while(rs.next()){
                choiceRollNo.add(rs.getString("rollno"));

            }

        }catch (Exception e){
            e.printStackTrace();

        }

        JLabel sem  =  new JLabel("Semester");
        sem.setBounds(50,110,150,20);
        add(sem);

        String semester[] = {"1st Semester","2st Semester","3st Semester","4st Semester","5st Semester","6st Semester","7st Semester","8st Semester"};
        comboBox  =  new JComboBox(semester);
        comboBox.setBounds(200,110,150,20);
        comboBox.setBackground(Color.white);
        add(comboBox);

        JLabel entersub =  new JLabel("Enter Subject");
        entersub.setBounds(100,150,200,40);
        add(entersub);

        sub1 =  new JTextField();
        sub1.setBounds(50,200,200,20);
        add(sub1);

        sub2 =  new JTextField();
        sub2.setBounds(50,230,200,20);
        add(sub2);

        sub3 =  new JTextField();
        sub3.setBounds(50,260,200,20);
        add(sub3);

        sub4 =  new JTextField();
        sub4.setBounds(50,290,200,20);
        add(sub4);

        sub5 =  new JTextField();
        sub5.setBounds(50,320,200,20);
        add(sub5);


        mrk1 =  new JTextField();
        mrk1.setBounds(250,200,200,20);
        add(mrk1);

        mrk2 =  new JTextField();
        mrk2.setBounds(250,230,200,20);
        add(mrk2);

        mrk3 =  new JTextField();
        mrk3.setBounds(250,260,200,20);
        add(mrk3);

        mrk4 =  new JTextField();
        mrk4.setBounds(250,290,200,20);
        add(mrk4);

        mrk5 =  new JTextField();
        mrk5.setBounds(250,320,200,20);
        add(mrk5);

        submit =  new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        close =  new JButton("Close");
        close.setBounds(220,350,100,25);
        close.setBackground(Color.BLACK);
        close.setForeground(Color.white);
        close.addActionListener(this);
        add(close);







        JLabel entermarks =  new JLabel("Enter Marks");
        entermarks.setBounds(320,150,200,40);
        add(entermarks);













        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit){
            try{
                Con c  =  new Con();
                String q1  =  "insert into subject values('"+choiceRollNo.getSelectedItem()+"','"+comboBox.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
                String q2  =  "insert into mark values('"+choiceRollNo.getSelectedItem()+"','"+comboBox.getSelectedItem()+"','"+mrk1.getText()+"','"+mrk2.getText()+"','"+mrk3.getText()+"','"+mrk4.getText()+"','"+mrk5.getText()+"')";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
                setVisible(false);

            }catch (Exception er){
                er.printStackTrace();

            }
        }
         

    }
    public static void main(String[] args) {
        new EnterMark();


    }


}
