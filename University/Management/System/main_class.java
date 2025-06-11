package University.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class main_class extends JFrame implements ActionListener {
    //Creating the Menu bar
    main_class(){
        ImageIcon i1 = new ImageIcon("C:\\Users\\prasa\\Desktop\\University_Management_System\\src\\Icon\\third.jpg");
        Image i2  =  i1.getImage().getScaledInstance(1900,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img =  new JLabel(i3);
        add(img);

        JMenuBar mb =  new JMenuBar();


      //1   New Information
        JMenu newInfo =  new JMenu("New Information");
        newInfo.setForeground(Color.black);
         mb.add(newInfo);

         // Creating the Items
        JMenuItem  facultyInfo =  new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        newInfo.add(facultyInfo);

        JMenuItem  StudentInfo =  new JMenuItem("New Student Information");
        StudentInfo.setBackground(Color.WHITE);
        newInfo.add(StudentInfo);

        // 2 Details

        JMenu details =  new JMenu("Details");
        details.setForeground(Color.black);
        mb.add(details);

        // Creating the Items
        JMenuItem  facultyDetails =  new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        details.add(facultyDetails);

        JMenuItem  StudentDetails =  new JMenuItem("View Student Details");
        StudentDetails.setBackground(Color.WHITE);
        details.add(StudentDetails);


        //3 Leave

        JMenu leave =  new JMenu("Leaves");
        leave.setForeground(Color.black);
        mb.add(leave);

        // Creating the Items
        JMenuItem  facultyLeave =  new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        leave.add(facultyLeave);

        JMenuItem StudentLeave=  new JMenuItem(" Student Leave");
        StudentLeave.setBackground(Color.WHITE);
        leave.add(StudentLeave);

        //4 Leave Details
        JMenu leaveDetails =  new JMenu("Leaves Details ");
        leaveDetails.setForeground(Color.black);
        mb.add(leaveDetails);

        // Creating the Items
        JMenuItem  facultyLeaveDetails =  new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem StudentLeaveDetails=  new JMenuItem(" Student Leave Details");
        StudentLeaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(StudentLeaveDetails);

        // 5  Exam

        JMenu exam =  new JMenu("Examination ");
        exam.setForeground(Color.black);
        mb.add(exam);

        // Creating the Items
        JMenuItem  ExaminationDetails =  new JMenuItem("Examination Results");
        ExaminationDetails.setBackground(Color.WHITE);
        exam.add(ExaminationDetails);

        JMenuItem EnterMarks =  new JMenuItem(" Enter Marks");
        EnterMarks.setBackground(Color.WHITE);
        exam.add(EnterMarks);

        //6 update Info

        JMenu updateInfo =  new JMenu("Update Details ");
        updateInfo.setForeground(Color.black);
        mb.add(updateInfo);

        // Creating the Items
        JMenuItem  updateFacultyInfo =  new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setBackground(Color.WHITE);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo =  new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.WHITE);
        updateInfo.add(updateStudentInfo);

        // 7 fees

        JMenu fees =  new JMenu("Fees Details ");
        fees.setForeground(Color.black);
        mb.add(fees);

        // Creating the Items
        JMenuItem  feeStructure =  new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        fees.add(feeStructure);

        JMenuItem  FeesForm=  new JMenuItem(" Student Fee Form");
        FeesForm.setBackground(Color.WHITE);
        fees.add(FeesForm);

        // Utility

        JMenu utility =  new JMenu("Utility ");
        utility.setForeground(Color.black);
        mb.add(utility);

        // Creating the Items
        JMenuItem calculator  =  new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem  notepad =  new JMenuItem("NotePad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        // About

        JMenu about =  new JMenu("About ");
        about.setForeground(Color.black);
        mb.add(about);

        // Creating the Items
        JMenuItem About1  =  new JMenuItem("About");
        About1.setBackground(Color.WHITE);
        about.add(About1);

        // Exits

        JMenu exit =  new JMenu("Exit ");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        // Creating the Items
        JMenuItem exit1  =  new JMenuItem("Exit");
        exit1.setBackground(Color.WHITE);
        exit1.addActionListener(this);
        exit.add(exit1);

        setJMenuBar(mb);
        setSize(1900,1020);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm =  e.getActionCommand();
        if(sm.equals("Exit")){
            System.exit(15);
            
        } else if (sm.equals("Calculator")) {
            try{
                Runtime.getRuntime().exec("calc.exe");

            }catch (Exception E){
                E.printStackTrace();

            }
            
        }
        else if (sm.equals("NotePad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");

            } catch (Exception E) {
                E.printStackTrace();

            }
        }


    }

    public static void main(String[] args) {
        new main_class();


    }
}
