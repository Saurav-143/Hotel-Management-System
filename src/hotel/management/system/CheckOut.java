package hotel.management.system;

import java.awt.print.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CheckOut extends JFrame {

    JButton checkOut, back, check, print, close;
    JTextArea receiptArea;

    CheckOut() {
        setLayout(null);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 850, 550);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);

        receiptArea = new JTextArea();
        receiptArea.setBounds(430, 60, 380, 360);
        receiptArea.setBackground(Color.BLACK);
        receiptArea.setForeground(Color.CYAN);
        receiptArea.setFont(new Font("Monospaced", Font.BOLD, 14));
        receiptArea.setEditable(false);
        receiptArea.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        panel.add(receiptArea);
        receiptArea.setText("\n\n\n\n TAJ HOTEL \n Select Customer  to View Bill");

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100, 20, 100, 30);
        label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel UserId = new JLabel("Customer Id");
        UserId.setBounds(30, 80, 150, 30);
        UserId.setFont(new Font("Tahoma", Font.BOLD, 14));
        UserId.setForeground(Color.WHITE);
        panel.add(UserId);

        Choice Customer = new Choice();
        Customer.setBounds(200, 80, 150, 25);
        panel.add(Customer);

        JLabel roomNum = new JLabel("Room Number");
        roomNum.setBounds(30, 130, 150, 30);
        roomNum.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomNum.setForeground(Color.WHITE);
        panel.add(roomNum);

        JLabel labelRoomnumber = new JLabel();
        labelRoomnumber.setBounds(200, 130, 150, 30);
        labelRoomnumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoomnumber.setForeground(Color.WHITE);
        panel.add(labelRoomnumber);

        JLabel checkintime = new JLabel("Check-In Time");
        checkintime.setBounds(30, 180, 150, 30);
        checkintime.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkintime.setForeground(Color.WHITE);
        panel.add(checkintime);

        JLabel labelcheckintime = new JLabel();
        labelcheckintime.setBounds(200, 180, 200, 30);
        labelcheckintime.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelcheckintime.setForeground(Color.WHITE);
        panel.add(labelcheckintime);

        JLabel checkouttime = new JLabel("Check-Out Time");
        checkouttime.setBounds(30, 230, 150, 30);
        checkouttime.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkouttime.setForeground(Color.WHITE);
        panel.add(checkouttime);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:a");
        String formattedTime = sdf.format(date);

        JLabel labelcheckouttime = new JLabel(formattedTime);
        labelcheckouttime.setBounds(200, 230, 200, 30);
        labelcheckouttime.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelcheckouttime.setForeground(Color.WHITE);
        panel.add(labelcheckouttime);
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.s.executeQuery("select * from customer");
            while (resultSet.next()) {
                Customer.add(resultSet.getString("number"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        checkOut = new JButton(" Check-Out");
        checkOut.setBounds(30, 300, 120, 30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String id = Customer.getSelectedItem();
                    String q1 = "select * from customer where number = '" + id + "'";
                    ResultSet rs = c.s.executeQuery(q1);

                    if (rs.next()) {
                        String name = rs.getString("name");
                        String room = rs.getString("room");
                        String deposit = rs.getString("deposit");
                        String checkinValue = rs.getString("checkintime");

                        SimpleDateFormat sdfOut = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
                        String checkout_time = sdfOut.format(new Date());

                        ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '" + room + "'");
                        if (rs2.next()) {
                            String price = rs2.getString("price");
                            int penalty = 0;
                            long stayHours = 0;

                            try {
                                java.util.Date d1 = null;
                                try {
                                    d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(checkinValue);
                                } catch (Exception e1) {
                                    d1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(checkinValue);
                                }

                                if (d1 != null) {
                                    long diff = System.currentTimeMillis() - d1.getTime();
                                    stayHours = diff / (1000 * 60 * 60);
                                    if (stayHours > 24) {
                                        penalty = (int) (stayHours - 24) * 500;
                                    }
                                }
                            } catch (Exception timeEx) {
                                System.out.println("Calculation Error: " + timeEx);
                            }

                            int totalPayable = Integer.parseInt(price) - Integer.parseInt(deposit) + penalty;
                            String s_final_amount = String.valueOf(totalPayable);

                            JOptionPane.showMessageDialog(null, "Stay Duration: " + stayHours + " Hours\nLate Penalty: Rs." + penalty + "\nTotal Payable: Rs." + totalPayable);

                            String sideBill
                                    = "-----------------------------------------------\n"
                                    + "                 TAJ HOTEL INVOICE             \n"
                                    + "-----------------------------------------------\n"
                                    + "Customer ID : " + id + "\n"
                                    + "Room No     : " + room + "\n"
                                    + "Check-In    : " + checkinValue + "\n"
                                    + "Check-Out   : " + checkout_time + "\n"
                                    + "Stay Hours  : " + stayHours + " Hrs     \n"
                                    + "Penalty     : Rs." + penalty + "\n"
                                    + "-------------------------------------------------\n"
                                    + "FINAL TOTAL : Rs. " + totalPayable + "\n"
                                    + "-------------------------------------------------\n"
                                    + "Status      : CHECKED OUT                \n"
                                    + "--------------------------------------------------";

                            receiptArea.setText(sideBill);

                            c.s.executeUpdate("insert into history values('" + name + "','" + id + "','" + room + "','" + checkinValue + "','" + checkout_time + "','" + s_final_amount + "')");
                            c.s.executeUpdate("delete from customer where number = '" + id + "'");
                            c.s.executeUpdate("update room set availability = 'Available' where roomnumber = '" + room + "'");

                            JOptionPane.showMessageDialog(null, "Check-Out successful !");
                            print.setVisible(true);
                            close.setVisible(true);
                        }
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        check = new JButton("Check");
        check.setBounds(300, 300, 120, 30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try {
                    ResultSet resultSet = c.s.executeQuery("select * from customer where number = '" + Customer.getSelectedItem() + "'");
                    while (resultSet.next()) {
                        String id = Customer.getSelectedItem();
                        String room = resultSet.getString("room");
                        String inTimeRaw = resultSet.getString("checkintime");
                        String deposit = resultSet.getString("deposit");

                        labelRoomnumber.setText(room);

                        try {
                            java.text.SimpleDateFormat inputF = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            java.text.SimpleDateFormat outputF = new java.text.SimpleDateFormat("dd-MM-yyyy hh:mm a");
                            java.util.Date d = inputF.parse(inTimeRaw);
                            labelcheckintime.setText(outputF.format(d));
                        } catch (Exception ex) {
                            labelcheckintime.setText(inTimeRaw);
                        }

                        ResultSet rs2 = c.c.createStatement().executeQuery("select * from room where roomnumber = '" + room + "'");
                        String price = "0";
                        if (rs2.next()) {
                            price = rs2.getString("price");
                        }
                        int pending = Integer.parseInt(price) - Integer.parseInt(deposit);

                        String sideBill
                                = "----------------------------------------------\n"
                                + "                 TAJ HOTEL INVOICE             \n"
                                + "-----------------------------------------------\n"
                                + "Customer ID : " + id + "\n"
                                + "Room No     : " + room + "\n"
                                + "------------------------------------------------\n"
                                + "Room Price  : Rs. " + price + "\n"
                                + "Deposit Paid: Rs. " + deposit + "\n"
                                + "-------------------------------------------------\n"
                                + "Pending Amt : Rs. " + pending + "\n"
                                + "-------------------------------------------------\n"
                                + "Status      : STILL STAYING              \n"
                                + "--------------------------------------------------";

                        receiptArea.setText(sideBill);
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        back = new JButton("Back");
        back.setBounds(170, 300, 120, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        print = new JButton("Print");
        print.setBounds(430, 430, 100, 30);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.setVisible(false);
        panel.add(print);
        print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    receiptArea.print();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        close = new JButton("Close");
        close.setBounds(540, 430, 100, 30);
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);
        close.setVisible(false);
        panel.add(close);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(850, 550);
        setLocation(400, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}