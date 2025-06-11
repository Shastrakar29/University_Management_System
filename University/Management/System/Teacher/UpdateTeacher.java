package University.Management.System.Teacher;

import University.Management.System.Con;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateTeacher extends JFrame implements ActionListener {
    JTextField addresstext , phoneText , emailText , adharText , textcourse , textbranch;
    JLabel empText;
    Choice cEmpID;
    JButton submit , cancel;



    UpdateTeacher(){
        getContentPane().setBackground(new Color(239,210,252));
        JLabel heading  =  new JLabel("Update Teacher Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel  empId =  new JLabel("select Employee Id");
        empId.setBounds(50,100,200,20);
        empId.setFont(new Font("serif",Font.PLAIN,20));
        add(empId);

        cEmpID =  new Choice();
        cEmpID.setBounds(250,100,200,20);
        add(cEmpID)
;
        try{
            Con c =  new Con();
            ResultSet rs  =  c.statement.executeQuery("select * from teacher");
            while(rs.next()){
                cEmpID.add(rs.getString("empId"));
            }

        }catch (Exception e){
            e.printStackTrace();

        }


        // Name
        JLabel name  =  new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        JLabel textName =   new JLabel();
        textName.setBounds(200,150,160,30);
        add(textName);

        JLabel fatherName =  new JLabel("Father Name");
        fatherName.setBounds(400,150,120,30);
        fatherName.setFont(new Font("serif",Font.BOLD,20));
        add(fatherName);

       JLabel fname =   new JLabel();
        fname.setBounds(600,150,200,30);
        add(fname);

        JLabel EmpIDD =  new JLabel("Employee ID");
        EmpIDD.setBounds(50,200,200,30);
        EmpIDD.setFont(new Font("serif",Font.BOLD,20));
        add(EmpIDD);

         JLabel empText  = new JLabel();
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);

        JLabel Dob =  new JLabel("Date OF Birth");
        Dob.setBounds(400,200,200,30);
        Dob.setFont(new Font("serif",Font.BOLD,20));
        add(Dob);

        JLabel  dobd =  new JLabel();
        dobd.setBounds(600,200,150,30);
        add(dobd);



        JLabel Address =  new JLabel("Address");
        Address.setBounds(50,250,200,30);
        Address.setFont(new Font("serif",Font.BOLD,20));
        add(Address);

        addresstext = new JTextField();
        addresstext.setBounds(200,250,150,30);
        addresstext.setFont(new Font("serif",Font.BOLD,20));
        add(addresstext);

        JLabel Phone =  new JLabel("Phone");
        Phone.setBounds(400,250,200,30);
        Phone.setFont(new Font("serif",Font.BOLD,20));
        add(Phone);

        phoneText = new JTextField();
        phoneText.setBounds(600,250,150,30);
        phoneText.setFont(new Font("serif",Font.BOLD,20));
        add(phoneText);

        JLabel email =  new JLabel("Email");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        emailText = new JTextField();
        emailText.setBounds(200,300,150,30);
        emailText.setFont(new Font("serif",Font.BOLD,20));
        add(emailText);

        JLabel M10 =  new JLabel("Class x (%)");
        M10.setBounds(400,300,200,30);
        M10.setFont(new Font("serif",Font.BOLD,20));
        add(M10);

       JLabel markText = new JLabel();
        markText.setBounds(600,300,150,30);
        markText.setFont(new Font("serif",Font.BOLD,20));
        add(markText);

        JLabel M12 =  new JLabel("Class xii (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);

        JLabel  text12 = new JLabel();
        text12.setBounds(200,350,150,30);
        text12.setFont(new Font("serif",Font.BOLD,20));
        add(text12);

        JLabel Addhar =  new JLabel("Aadhaar Number");
        Addhar.setBounds(400,350,200,30);
        Addhar.setFont(new Font("serif",Font.BOLD,20));
        add(Addhar);

        adharText = new JTextField();
        adharText.setBounds(600,350,200,30);
        adharText.setFont(new Font("serif",Font.BOLD,20));
        add(adharText);

        JLabel Qualification =  new JLabel("Qualification");
        Qualification.setBounds(50,400,150,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        textcourse  =  new JTextField();
        textcourse.setBounds(200,400,150,30);
        add(textcourse);




        JLabel Department =  new JLabel("Department");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        textbranch  =  new JTextField();
        textbranch.setBounds(600,400,150,30);
        add(textbranch);


        try{
            Con c  =  new Con();
            String query  =  "select * from "

        }catch (Exception E){
            E.printStackTrace();
        }




        submit  =  new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        submit.setForeground(Color.white);
        add(submit);

        cancel  =  new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);



        setSize(900,700);
        setLocation(350,700);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        new UpdateTeacher();

    }


}
