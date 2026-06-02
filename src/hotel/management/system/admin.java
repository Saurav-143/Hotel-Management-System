package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener {

    JButton add_Employee, add_Room, add_Drivers, history, logout, back;
    admin(){

        add_Employee = new JButton( "ADD EMPLOYEE");
        add_Employee.setBounds(250,75,200,30);
        add_Employee.setBackground(Color.WHITE);
        add_Employee.setForeground(Color.BLACK);
        add_Employee.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Employee.addActionListener(this);
        add(add_Employee);

        add_Room = new JButton( "ADD ROOM");
        add_Room.setBounds(250,255,200,30);
        add_Room.setBackground(Color.WHITE);
        add_Room.setForeground(Color.BLACK);
        add_Room.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Room.addActionListener(this);
        add(add_Room);

        add_Drivers = new JButton( "ADD DRIVERS");
        add_Drivers.setBounds(250,435,200,30);
        add_Drivers.setBackground(Color.WHITE);
        add_Drivers.setForeground(Color.BLACK);
        add_Drivers.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Drivers.addActionListener(this);
        add(add_Drivers);
        
        history = new JButton("Customer Records");
        history.setBounds(250,615,200,30);
        history.setBackground(Color.WHITE);
        history.setForeground(Color.BLACK);
        history.setFont(new Font("Tahoma",Font.BOLD,15));
        history.addActionListener(this);
        add(history);
        

        logout = new JButton( "Logout");
        logout.setBounds(10,750,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma", Font.BOLD, 15));
        logout.addActionListener(this);
        add(logout);

        back = new JButton( "Back");
        back.setBounds(110,750,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);


        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/employees.png"));
        Image l11 = l1.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(l11);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(70,50,120,120);
        add(label);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/room.png"));
        Image image = imageIcon1.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(70,230,120,120);
        add(label1);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icons/driver.png"));
        Image image1 = imageIcon2.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon12 = new ImageIcon(image1);
        JLabel label2 = new JLabel(imageIcon12);
        label2.setBounds(70,410,120,120);
        add(label2);
        
        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icons/record.jpeg"));
        Image image2 = imageIcon3.getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon13 = new ImageIcon(image2);
        JLabel label3 = new JLabel(imageIcon13);
        label3.setBounds(70,590,120,120);
        add(label3);

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("icons/second.gif"));
        Image image3 = imageIcon4.getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon14 = new ImageIcon(image3);
        JLabel label4 = new JLabel(imageIcon14);
        label4.setBounds(1000,250,400,400);
        add(label4);


        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add_Employee){
           new AddEmployee();
        } else if (e.getSource() == add_Room) {
            new AddRoom();
        } else if (e.getSource() ==  add_Drivers) {
            new AddDriver();
        }else if (e.getSource() == history){
            new CustomerHistory();
        }else if (e.getSource() == logout){
            System.exit(102);
        } else if (e.getSource() == back) {
            new Dashboard();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new admin();
    }
}