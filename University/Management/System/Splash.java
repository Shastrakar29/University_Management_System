package University.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{

    Thread t;    // Initialization  of thread t
    Splash(){    // Creating the Constructor

        ImageIcon i1 = new ImageIcon("C:\\Users\\prasa\\Desktop\\University_Management_System\\src\\Icon\\first.png");
        Image i2 =  i1.getImage().getScaledInstance(1000,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img =  new JLabel(i3);
        add(img);


        t =  new Thread(this);
        t.start();
        setVisible(true);

        // Set Parameter for Animation
        int x= 1;
        for (int i = 2; i <=600 ; i+=4,x+=1) {
            setLocation(600-((i + x)/2), 350 -(i/2));
            setSize(i + 3*x,i + x/2);

            try{
                Thread.sleep(10
                );

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
    @Override
    public void run() {
        try{
            Thread.sleep(7000);   // for sec second
            setVisible(false);
            new Login();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Splash();
    }

}
