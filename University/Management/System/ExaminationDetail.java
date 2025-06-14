package University.Management.System;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ExaminationDetail  extends JFrame implements ActionListener {
    JTextField search;
    JButton result , back;
    JTable table;


    ExaminationDetail(){
        getContentPane().setBackground(new Color(241,252,210));
        JLabel heading  =  new JLabel("Check Result");
        heading.setBounds(350,15,400,50);
        heading.setFont(new Font("Tahoma", Font.BOLD,24));
        add(heading);

        search =  new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("Tahoma", Font.BOLD,18));
        add(search);

        result  =  new JButton("Result");
        result.setBounds(300,90,120,30);
        result.setBackground(Color.black);
        result.setForeground(Color.white);
        result.addActionListener(this);
        add(result);

        back  =  new JButton("Back");
        back.setBounds(300,90,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        table  =  new JTable();
        JScrollPane  sc  =  new JScrollPane(table);
        sc.setBounds(0,130,1000,310);
        add(sc);

        try{
            Con c =  new Con();
            ResultSet rs  =  c.statement.executeQuery("Select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));


        }catch (Exception e){
            e.printStackTrace();

        }
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row  = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());

            }
        });

        setSize(1000,475);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==result){
            setVisible(false);
            new marks(search.getText());
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ExaminationDetail();

    }


}
