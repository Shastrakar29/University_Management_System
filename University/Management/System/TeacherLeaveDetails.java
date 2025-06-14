package University.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    Choice  choiceEmp;
    JTable table;
    JButton  search , cancel  , print;

    TeacherLeaveDetails(){
        getContentPane().setBackground(new Color(160,160,160));
        JLabel heading  =  new JLabel("Search by Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);

        choiceEmp = new Choice();
        choiceEmp.setBounds(180,20,150,20);
        add(choiceEmp);

        try{
            Con c  =  new Con();
            ResultSet rs  =  c.statement.executeQuery("select * from Teacher");
            while(rs.next()){
                choiceEmp.add(rs.getString("empId"));

            }


        }catch (Exception e){
            e.printStackTrace();

        }

        table =  new JTable();
        try{
            Con c  =  new Con();
            ResultSet  rs=  c.statement.executeQuery("select * from University.Management.System.TeacherLeave");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception s){
            s.printStackTrace();

        }

        JScrollPane js  =  new JScrollPane(table);
        js.setBounds(0,100,900,600);
        add(js);

        search =  new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print =  new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        cancel =  new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);





        setSize(900,700);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            String q  =  " Select * University.Management.System.TeacherLeave from  where empId = '"+choiceEmp.getSelectedItem()+"'";
            try{
                Con c =  new Con();
                ResultSet rs =  c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception er){
                er.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try{
                table.print();

            }catch (Exception er){
                er.printStackTrace();

            }

        }
        else{
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }


}
