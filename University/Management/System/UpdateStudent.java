package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {
    JTextField addresstext , phoneText , emailText , adharText , textcourse , textbranch;
    JLabel empText;
    Choice cEmpID;
    JButton submit , cancel;


    UpdateStudent(){
        getContentPane().setBackground(new Color(153,153,255));
        JLabel heading  =  new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);

        JLabel  empId =  new JLabel("Select Roll Number");
        empId.setBounds(50,100,200,20);
        empId.setFont(new Font("serif",Font.PLAIN,20));
        add(empId);

        cEmpID =  new Choice();
        cEmpID.setBounds(250,100,200,20);
        add(cEmpID)
        ;
        try{
            Con c =  new Con();
            ResultSet rs  =  c.statement.executeQuery("select * from Student");
            while(rs.next()){
                cEmpID.add(rs.getString("rollno"));
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

        JLabel EmpIDD =  new JLabel("Roll Number");
        EmpIDD.setBounds(50,200,200,30);
        EmpIDD.setFont(new Font("serif",Font.BOLD,20));
        add(EmpIDD);

        empText  = new JLabel();
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

        JLabel Qualification =  new JLabel("Course");
        Qualification.setBounds(50,400,150,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        textcourse  =  new JTextField();
        textcourse.setBounds(200,400,150,30);
        add(textcourse);

        JLabel Department =  new JLabel("Branch");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        textbranch  =  new JTextField();
        textbranch.setBounds(600,400,150,30);
        add(textbranch);


        try{
            Con c  =  new Con();
            String query  =  "select * from Student where rollno = '"+cEmpID.getSelectedItem()+"'";
            ResultSet rs  =  c.statement.executeQuery(query);
            while(rs.next()){
                textName.setText(rs.getString("name"));
                fname.setText(rs.getString("fname"));
                dobd.setText(rs.getString("dob"));
                addresstext.setText(rs.getString("address"));
                phoneText.setText(rs.getString("phone"));
                emailText.setText(rs.getString("email"));
                markText.setText(rs.getString("class_x"));
                text12.setText(rs.getString("class_xii"));
                adharText.setText(rs.getString("aadhar"));
                empText.setText(rs.getString("rollno"));
                textcourse.setText(rs.getString("course"));
                textbranch.setText(rs.getString("branch"));


            }
        }catch (Exception E){
            E.printStackTrace();
        }

        cEmpID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Con c  =  new Con();
                    String query  =  "select * from Student where rollno = '"+cEmpID.getSelectedItem()+"'";
                    ResultSet rs  =  c.statement.executeQuery(query);
                    while(rs.next()) {
                        textName.setText(rs.getString("name"));
                        fname.setText(rs.getString("fname"));
                        dobd.setText(rs.getString("dob"));
                        addresstext.setText(rs.getString("address"));
                        phoneText.setText(rs.getString("phone"));
                        emailText.setText(rs.getString("email"));
                        markText.setText(rs.getString("class_x"));
                        text12.setText(rs.getString("class_xii"));
                        adharText.setText(rs.getString("aadhar"));
                        empText.setText(rs.getString("rollno"));
                        textcourse.setText(rs.getString("course"));
                        textbranch.setText(rs.getString("branch"));
                    }
                }catch (Exception E){
                    E.printStackTrace();

                }
            }
        });

        submit  =  new JButton("Update");
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
        if(e.getSource() == submit){
            String empid =  empText.getText();
            String address =  addresstext.getText();
            String phone  =  phoneText.getText();
            String email =  emailText.getText();
            String course  =  textcourse.getText();
            String branch =  textbranch.getText();

            try{
                String Q  =  "update student set address = '"+address+"',phone = '"+phone+"', email = '"+email+"', course = '"+course+"',branch ='"+branch+"' where rollno ='"+empid+"'";
                Con c  =  new Con();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Detailed Updated");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();

            }
        }
        else{
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new UpdateStudent();


    }


}
