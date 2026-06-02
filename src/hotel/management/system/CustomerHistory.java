package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class CustomerHistory extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
    CustomerHistory(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);
        
        JLabel heading = new JLabel("CUSTOMER TRANSACTION HISTORY");
        heading.setBounds(250,10,500,30);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40,50,100,20);
        name.setForeground(Color.WHITE);
        panel.add(name);
        
        JLabel id = new JLabel("ID");
        id.setBounds(180,50,100,20);
        id.setForeground(Color.WHITE);
        panel.add(id);
        
        JLabel room = new JLabel("Room");
        room.setBounds(330,50,100,20);
        room.setForeground(Color.WHITE);
        panel.add(room);
        
        JLabel checkin = new JLabel("Check-In");
        checkin.setBounds(480,50,100,20);
        checkin.setForeground(Color.WHITE);
        panel.add(checkin);
        
        JLabel checkout = new JLabel("Check-Out");
        checkout.setBounds(630,50,100,20);
        checkout.setForeground(Color.WHITE);
        panel.add(checkout);
        
        JLabel amt = new JLabel("Amount");
        amt.setBounds(780,50,100,20);
        amt.setForeground(Color.WHITE);
        panel.add(amt);
        
        table = new JTable();
        table.setBounds(10,80,880,400);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from history");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        back = new JButton("Back");
        back.setBounds(380,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);
        
        setUndecorated(true);
        setLayout(null);
        setSize(900,600);
        setLocation(400,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== back){
            setVisible(false);
        }
    }
     public static void main(String[] args){
            new CustomerHistory();
        }
}
