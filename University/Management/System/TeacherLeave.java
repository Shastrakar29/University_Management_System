package University.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {
    Choice choice, choTime;
    JDateChooser selDate;
    JButton  submit , cancel;

    TeacherLeave(){

        getContentPane().setBackground(new Color(255,153,204));
        JLabel heading   =  new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD , 20));
        add(heading);

        JLabel empId  =  new JLabel("Search by Employee ID");
        empId.setBounds(60,100,200,20);
        empId.setFont(new Font("Tahoma",Font.PLAIN , 18));
        add(empId);

        choice = new Choice();
        choice.setBounds(60,130,200,20);
        add(choice);

        try{
            Con c=  new Con();
            ResultSet rs =  c.statement.executeQuery("Select * from Teacher");
            while(rs.next()){
                choice.add(rs.getString("empId"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel ldate  =  new JLabel("Date");
        ldate.setBounds(60,180,200,20);
        ldate.setFont(new Font("Tahoma", Font.PLAIN , 18));
        add(ldate);


        selDate =   new JDateChooser();
        selDate.setBounds(60,210,200,25);
        add(selDate);

        JLabel time  =  new JLabel("Time Duration");
        time.setBounds(60,260,200,20);
        time.setFont(new Font("Tahoma", Font.PLAIN , 18));
        add(time);

        choTime  =  new Choice();
        choTime.setBounds(60,290,200,20);
        choTime.add("Full Day");
        choTime.add("Half Day");
        add(choTime);

        submit =  new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel =  new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setSize(500,550);
        setLayout(null);
        setLocation(550,100);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == submit){
                String empId=  choice.getSelectedItem();
                String date =((JTextField) selDate.getDateEditor().getUiComponent()).getText() ;
                String time  =  choTime.getSelectedItem();

                String q =  "Insert into University.Management.System.TeacherLeave values ('"+empId+"','"+date+"','"+time+"')";

                try{
                    Con c =  new Con();
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Leave Confirmed");
                    setVisible(false);


                }catch (Exception er){
                    er.printStackTrace();
                }
            }
            else{
                setVisible(false);

            }
    }
    public static void main(String[] args) {
        new TeacherLeave();


    }


}
