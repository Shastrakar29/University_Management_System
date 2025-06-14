package University.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentFeeForm extends JFrame implements ActionListener {
    Choice CrollNumber;
    JLabel totalAmount;
    JComboBox courseBox , departmentBox ,semesterBox;
    JButton update ,pay , back;
    StudentFeeForm(){
        getContentPane().setBackground(new Color(210,252,251));
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("Icon/fee.png"));
        Image i2  =  i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3  =  new ImageIcon(i2);
        JLabel img  =  new JLabel(i3);
        img.setBounds(400,50,500,300);
        add(img);

        JLabel rollNumber  =  new JLabel("Select Roll Number");
        rollNumber.setBounds(40,60,150,20);
        rollNumber.setFont(new Font("Tahoma",Font.BOLD,12));
        add(rollNumber);

        CrollNumber =  new Choice();
        CrollNumber.setBounds(200,60,150,20);
        add(CrollNumber);

        try{
            Con c=  new Con();
            ResultSet rs =  c.statement.executeQuery("select * from Student");
            while(rs.next()){
                CrollNumber.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }
        JLabel  name  =  new JLabel("Name");
        name.setBounds(40,100,150,20);
        add(name);

        JLabel textname  =  new JLabel();
        textname.setBounds(200,100,150,20);
        add(textname);

        JLabel  fname  =  new JLabel("Father Name");
        fname.setBounds(40,140,150,20);
        add(fname);

        JLabel ftextname  =  new JLabel();
        ftextname.setBounds(200,140,150,20);
        add(ftextname);

        try{
            Con c=  new Con();
            String q =  "select  * from Student where rollno = '"+CrollNumber.getSelectedItem()+"'";
            ResultSet rs =   c.statement.executeQuery(q);
            while(rs.next()){
                textname.setText(rs.getString("name"));
                ftextname.setText(rs.getString("fname"));

            }

        }catch (Exception e){
            e.printStackTrace();

        }


        CrollNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Con c=  new Con();
                    String q =  "select  * from Student where rollno = '"+CrollNumber.getSelectedItem()+"'";
                    ResultSet rs =   c.statement.executeQuery(q);
                    while(rs.next()){
                        textname.setText(rs.getString("name"));
                        ftextname.setText(rs.getString("fname"));

                    }

                }catch (Exception E){
                    E.printStackTrace();

                }

            }
        });

        JLabel Qualification =  new JLabel("Course");
        Qualification.setBounds(40,180,150,20);
//        Qualification.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Qualification);

        // course
        String course[] = {"B.Tech","BBA","MBA","MSC","BSC","MCA","MA"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200,180,150,20);
        courseBox.setBackground(Color.white);
        add(courseBox);

        // Branch
        JLabel Department =  new JLabel("Branch");
        Department.setBounds(40,220,150,20);
//        Department.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Department);

        String dept[] = {"CSE","ETC","ME","EE"};
        departmentBox = new JComboBox(dept);
        departmentBox.setBounds(200,220,150,20);
        departmentBox.setBackground(Color.white);
        add(departmentBox);

        JLabel textsem =  new JLabel("Semester");
        textsem.setBounds(40,240,150,20);
        add(textsem);

        String semester [] =  {"Semester 1","semester2","semester3 ","semester4","semester5","semester6","semester7 ","semester8"};
         semesterBox =  new JComboBox(semester);
         semesterBox.setBounds(200,240,150,20);
         add(semesterBox);

         JLabel total =  new JLabel("Total Payable");
         total.setBounds(40,300,150,20);
         add(total);

        totalAmount =  new JLabel();
        totalAmount.setBounds(200,300,150,20);
        add(totalAmount);

        update =  new JButton("Update");
        update.setBounds(30,380,100,25);
        update.addActionListener(this);
        add(update);

        pay =  new JButton("Pay");
        pay.setBounds(150,380,100,25);
        pay.addActionListener(this);
        add(pay);

        back =  new JButton("Pay");
        back.setBounds(270,380,100,25);
        back.addActionListener(this);
        add(back);
















        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update){
            String course  = (String) courseBox.getSelectedItem();
            String semester  =  (String) semesterBox.getSelectedItem();

            try {
                Con c = new Con();
                ResultSet rs = c.statement.executeQuery("select * from fee where course = '" + course + "'");
                while(rs.next()){
                    totalAmount.setText(rs.getString(semester));
                }
            }
            catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        else if (e.getSource() == pay){
            String rollno  = CrollNumber.getSelectedItem();
            String course  = (String) courseBox.getSelectedItem();
            String semester  =  (String ) semesterBox.getSelectedItem();
            String branch  = (String) departmentBox.getSelectedItem();
            String total  =  totalAmount.getText();

            try{
                Con c  =  new Con();
                String q=   "Insert into feecollege values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"fee submitted Successfully");


            }catch (Exception es){

                es.printStackTrace();
            }
        }
        else{
            setVisible(false);


        }

    }
    public static void main(String[] args) {
        new StudentFeeForm();


    }



}
