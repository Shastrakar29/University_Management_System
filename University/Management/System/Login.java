package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textName;
    JPasswordField passwordField;
    JButton login, Back;

    Login() {

        // JLabel --> It is used for text frame pr visible
        JLabel label = new JLabel("Username");
        label.setBounds(40, 20, 100, 20);
        add(label);

        textName = new JTextField();
        textName.setBounds(150, 20, 150, 20);
        add(textName);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 20);
        add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 20);
        add(passwordField);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        Back = new JButton("Back");
        Back.setBounds(180, 140, 120, 30);
        Back.setBackground(Color.black);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon("C:\\Users\\prasa\\Desktop\\University_Management_System\\src\\Icon\\second.png");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 20, 200, 200);
        add(img);

        ImageIcon i11 = new ImageIcon("C:\\Users\\prasa\\Desktop\\University_Management_System\\src\\Icon\\loginback.png");
        Image i22 = i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel img1 = new JLabel(i33);
        img1.setBounds(0, 0, 200, 200);
        add(img1);


        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
        setLayout(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String username = textName.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username or Password cannot be empty");
                return;
            }

            String query = "SELECT * FROM Login WHERE username=? AND password=?";
            try {
                Con c = new Con();
                PreparedStatement pstmt = c.connection.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet res = pstmt.executeQuery();

                if (res.next()) {
                    setVisible(false);
                    new main_class();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

                // Cleanup
                res.close();
                pstmt.close();
                c.connection.close();
            } catch (Exception er) {
                er.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}


