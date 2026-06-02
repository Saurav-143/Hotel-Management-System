package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class HotelManagementSystem extends JFrame {
    HotelManagementSystem(){
        setUndecorated(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,width,height);
        add(label);

        setLayout(null);
        setLocation(0,0);
        setSize(width,height);
        setVisible(true);

        try {
            Thread.sleep(5000);
            new Login();
            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}




