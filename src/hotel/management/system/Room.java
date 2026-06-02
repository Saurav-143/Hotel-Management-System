package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Room extends JFrame {
    
    JTable table;
    JButton back;
    
    Room(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        panel.add(image);
        
        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);
        
        try{
            Conn c = new Conn();
            String RoomInfo = "select * from room";
            ResultSet rs = c.s.executeQuery(RoomInfo);
            table.setModel(DbUtils.resultSetToTableModel(rs));
                    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        panel.add(back);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });
        
        JLabel room = new JLabel("Room No.");
        room.setBounds(12,15,80,19);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);
        
        JLabel availability = new JLabel("Availability");
        availability.setBounds(119,15,80,19);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(availability);
        
        JLabel clean = new JLabel("Clean Status");
        clean.setBounds(216,15,150,19);
        clean.setForeground(Color.WHITE);
        clean.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(clean);
        
        JLabel price = new JLabel("Price");
        price.setBounds(330,15,80,19);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);
        
        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(417,15,80,19);
        bed.setForeground(Color.WHITE);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(bed);
        
        setUndecorated(true);
        setLayout(null);
        setLocation(450,100);
        setSize(900,600);
        setVisible(true);
        
    }
    public static void main(String[] args){
    new Room();
    }
    
}
