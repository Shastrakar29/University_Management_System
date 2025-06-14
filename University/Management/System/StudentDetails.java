package University.Management.System;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentDetails  extends JFrame implements ActionListener {

    Choice choice;
    JTable table;
    JButton  search , print, update , add , cancel;



    StudentDetails(){
        getContentPane().setBackground(new Color(210,252,218));

        JLabel heading  =  new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        choice  = new Choice();
        choice.setBounds(180,20,150,20);
        add(choice);

        try{
            Con c =  new Con();
            ResultSet rs =  c.statement.executeQuery("select * from Student");
            while(rs.next()){
                choice.add(rs.getString("rollno"));
            }


        }catch (Exception E){
            E.printStackTrace();


        }
        table =  new JTable();
        try{
            Con c =  new Con();
            ResultSet rs =  c.statement.executeQuery("select * from Student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){
                choice.add(rs.getString("rollno"));
            }
        }catch (Exception E){
            E.printStackTrace();

        }

        JScrollPane  js  =  new JScrollPane(table);
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

        update =  new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);


        add =  new JButton("Add");
        add.setBounds(320,70,80,20);
        add.addActionListener(this);
        add(add);

        cancel =  new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            String q  =  " Select * from Student where rollno = '"+choice.getSelectedItem()+"'";
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
            
        } else if (e.getSource() == add) {
            setVisible(false);
            new AddStudent();

        } else if (e.getSource() == update) {


        }
        else{
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new StudentDetails();

    }


}
