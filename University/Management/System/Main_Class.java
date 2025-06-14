package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {
    Main_Class() {
        ImageIcon i1 = new ImageIcon("C:\\Users\\prasa\\Desktop\\University_Management_System\\src\\Icon\\third.jpg");
        Image i2 = i1.getImage().getScaledInstance(1900, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();


        //1   New Information
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.black);
        mb.add(newInfo);

        // Creating the Items
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem StudentInfo = new JMenuItem("New Student Information");
        StudentInfo.setBackground(Color.WHITE);
        StudentInfo.addActionListener(this);
        newInfo.add(StudentInfo);

        // 2 Details

        JMenu details = new JMenu(" View Details");
        details.setForeground(Color.black);
        details.addActionListener(this);
        mb.add(details);

        // Creating the Items
        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem StudentDetails = new JMenuItem("View Student Details");
        StudentDetails.setBackground(Color.WHITE);
        StudentDetails.addActionListener(this);
        details.add(StudentDetails);


        //3 Leave

        JMenu leave = new JMenu("Leaves");
        leave.setForeground(Color.black);
        leave.addActionListener(this);
        mb.add(leave);

        // Creating the Items
        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem StudentLeave = new JMenuItem(" Student Leave");
        StudentLeave.setBackground(Color.WHITE);
        StudentLeave.addActionListener(this);
        leave.add(StudentLeave);

        //4 Leave Details
        JMenu leaveDetails = new JMenu("Leaves Details ");
        leaveDetails.setForeground(Color.black);
        leaveDetails.addActionListener(this);
        mb.add(leaveDetails);

        // Creating the Items
        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem StudentLeaveDetails = new JMenuItem(" Student Leave Details");
        StudentLeaveDetails.setBackground(Color.WHITE);
        StudentLeaveDetails.addActionListener(this);
        leaveDetails.add(StudentLeaveDetails);

        // 5  Exam

        JMenu exam = new JMenu("Examination ");
        exam.setForeground(Color.black);
        exam.addActionListener(this);
        mb.add(exam);

        // Creating the Items
        JMenuItem ExaminationDetails = new JMenuItem("Examination Results");
        ExaminationDetails.setBackground(Color.WHITE);
        ExaminationDetails.addActionListener(this);
        exam.add(ExaminationDetails);

        JMenuItem EnterMarks = new JMenuItem(" Enter Marks");
        EnterMarks.setBackground(Color.WHITE);
        EnterMarks.addActionListener(this);
        exam.add(EnterMarks);

        //6 update Info

        JMenu updateInfo = new JMenu("Update Details ");
        updateInfo.setForeground(Color.black);
        updateInfo.addActionListener(this);
        mb.add(updateInfo);

        // Creating the Items
        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setBackground(Color.WHITE);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.WHITE);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        // 7 fees

        JMenu fees = new JMenu("Fees Details ");
        fees.setForeground(Color.black);
        fees.addActionListener(this);
        mb.add(fees);

        // Creating the Items
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fees.add(feeStructure);

        JMenuItem FeesForm = new JMenuItem(" Student Fee Form");
        FeesForm.setBackground(Color.WHITE);
        FeesForm.addActionListener(this);
        fees.add(FeesForm);

        // Utility

        JMenu utility = new JMenu("Utility ");
        utility.setForeground(Color.black);
        utility.addActionListener(this);
        mb.add(utility);

        // Creating the Items
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem notepad = new JMenuItem("NotePad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        // About

        JMenu about = new JMenu("About ");
        about.setForeground(Color.black);
        about.addActionListener(this);
        mb.add(about);

        // Creating the Items
        JMenuItem About1 = new JMenuItem("About");
        About1.setBackground(Color.WHITE);
        About1.addActionListener(this);
        about.add(About1);

        // Exits

        JMenu exit = new JMenu("Exit ");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        // Creating the Items
        JMenuItem exit1 = new JMenuItem("Exit");
        exit1.setBackground(Color.WHITE);
        exit1.addActionListener(this);
        exit.add(exit1);

        setJMenuBar(mb);
        setSize(1900, 1020);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if (sm.equals("Exit")) {
            System.exit(15);

        } else if (sm.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");

            } catch (Exception E) {
                E.printStackTrace();

            }

        } else if (sm.equals("NotePad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");

            } catch (Exception E) {
                E.printStackTrace();

            }
        } else if (sm.equals("New Faculty Information")) {
            new AddFaculty();


        } else if (sm.equals("New Student Information")) {
            new AddStudent();

        } else if (sm.equals("View Faculty Details")) {
            new TeacherDetail1();


        } else if (sm.equals("View Student Details")) {
            new StudentDetails();

        } else if (sm.equals("Faculty Leave")) {
            new TeacherLeave();

        } else if (sm.equals(" Student Leave")) {
            new StudentLeave();

        } else if (sm.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();


        } else if (sm.equals(" Student Leave Details")) {
            new StudentLeaveDetail();


        } else if (sm.equals("Update Faculty Details")) {
            new UpdateTeacher();


        } else if (sm.equals("Update Student Details")) {
            new UpdateStudent();

        } else if (sm.equals(" Enter Marks")) {
            new EnterMark();

        } else if (sm.equals("Examination Results")) {
            new ExaminationDetail();

        } else if (sm.equals("Fee Structure")) {
            new FeesStructure();


        } else if (sm.equals(" Student Fee Form")) {
            new StudentFeeForm();


        } else if (sm.equals("About")) {
            new About();

        }


    }

    public static void main(String[] args) {
        new Main_Class();
    }
}



