package University.Management.System.Teacher;

import University.Management.System.Con;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddFaculty extends JFrame  implements ActionListener {
    JTextField textName , fname ,addresstext , phoneText , emailText , markText , text12 , adharText , Qualificationtext;
    Random ran  =  new Random();
    JLabel empText;
    JComboBox courseBox , departmentBox;
    JDateChooser cdob;
    JButton submit , cancel;

    Long  f4  =  Math.abs((ran.nextLong() % 9000L) + 1000L);
    AddFaculty(){

        // for background Color used getContentPane()
        getContentPane().setBackground(new Color(166,164,252));
        JLabel heading  =  new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);


        // Name
        JLabel name  =  new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textName =   new JTextField();
        textName.setBounds(200,150,160,30);
        add(textName);

        JLabel fatherName =  new JLabel("Father Name");
        fatherName.setBounds(400,150,120,30);
        fatherName.setFont(new Font("serif",Font.BOLD,20));
        add(fatherName);

        fname =   new JTextField();
        fname.setBounds(600,150,200,30);
        add(fname);

        JLabel empId =  new JLabel("Employee ID");
        empId.setBounds(50,200,200,30);
        empId.setFont(new Font("serif",Font.BOLD,20));
        add(empId);

        empText  = new JLabel("PS"+f4);
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);

        JLabel Dob =  new JLabel("Date OF Birth");
        Dob.setBounds(400,200,200,30);
        Dob.setFont(new Font("serif",Font.BOLD,20));
        add(Dob);
       cdob =  new JDateChooser();
      cdob.setBounds(600,200,150,30);
        add(cdob);

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

        markText = new JTextField();
        markText.setBounds(600,300,150,30);
        markText.setFont(new Font("serif",Font.BOLD,20));
        add(markText);

        JLabel M12 =  new JLabel("Class xii (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);

        text12 = new JTextField();
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
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        String course[] = {"B.Tech","BBA","MBA","MSC","BSC","MCA","MA"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200,400,150,30);
        courseBox.setBackground(Color.white);
        add(courseBox);

        JLabel Department =  new JLabel("Department");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        String dept[] = {"CSE","ETC","ME","EE"};
        departmentBox = new JComboBox(dept);
        departmentBox.setBounds(600,400,150,30);
        departmentBox.setBackground(Color.white);
        add(departmentBox);

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
        if(e.getSource()== submit ){
            String name =  textName.getText();
            String fathername  =  fname.getText();
            String  empid =  empText.getText();
            String   dob =  ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = addresstext.getText();
            String phone =  phoneText.getText();
            String email =  emailText.getText();
            String x  =  markText.getText();
            String xii =  text12.getText();
            String adhar =  adharText.getText();
            String course  =  (String) courseBox.getSelectedItem();
            String department =(String)  departmentBox.getSelectedItem();
            try{

                String query =  "INSERT INTO Teacher Values('"+name+"','"+fathername+"','"+empid+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+adhar+"','"+course+"','"+department+"')";
               Con c = new Con();
               c.statement.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Detailed Inserted");
               setVisible(false);
            }catch (Exception S){
                S.printStackTrace();
            }
        }else{
            setVisible(false);
        }


    }

    public static void main(String[] args) {
        new AddFaculty();
    }


}
