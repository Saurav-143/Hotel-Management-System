package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280, 5, 1238, 820);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 270, 820);
        panel1.setBackground(new Color(3, 45, 48));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.gif"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300, 20, 800, 800);
        panel.add(image);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.gif"));
        Image i22 = i11.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image1 = new JLabel(i33);
        image1.setBounds(5, 530, 250, 250);
        panel1.add(image1);

        JButton btnNewCustomerForm = new JButton("New Customer Form");
        btnNewCustomerForm.setBounds(30, 30, 200, 30);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.WHITE);
        panel1.add(btnNewCustomerForm);
        btnNewCustomerForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new NewCustomer();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton btnRoom = new JButton("Room");
        btnRoom.setBounds(30, 70, 200, 30);
        btnRoom.setBackground(Color.BLACK);
        btnRoom.setForeground(Color.WHITE);
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Room();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton btnDepartment = new JButton("Department");
        btnDepartment.setBounds(30, 110, 200, 30);
        btnDepartment.setBackground(Color.BLACK);
        btnDepartment.setForeground(Color.WHITE);
        panel1.add(btnDepartment);
        btnDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Department();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton btnAEI = new JButton("Employee Info");
        btnAEI.setBounds(30, 150, 200, 30);
        btnAEI.setBackground(Color.BLACK);
        btnAEI.setForeground(Color.WHITE);
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Employee();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton btnCustomerInfo = new JButton("Customer Info");
        btnCustomerInfo.setBounds(30, 190, 200, 30);
        btnCustomerInfo.setBackground(Color.BLACK);
        btnCustomerInfo.setForeground(Color.WHITE);
        panel1.add(btnCustomerInfo);
        btnCustomerInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CustomerInfo();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton btnManagerInfo = new JButton("Manager Info");
        btnManagerInfo.setBounds(30, 230, 200, 30);
        btnManagerInfo.setBackground(Color.BLACK);
        btnManagerInfo.setForeground(Color.WHITE);
        panel1.add(btnManagerInfo);
        btnManagerInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ManagerInfo();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton btnCO = new JButton("Check Out");
        btnCO.setBounds(30, 270, 200, 30);
        btnCO.setBackground(Color.BLACK);
        btnCO.setForeground(Color.WHITE);
        panel1.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CheckOut();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton btnUC = new JButton("Update Check-In Details");
        btnUC.setBounds(30, 310, 200, 30);
        btnUC.setBackground(Color.BLACK);
        btnUC.setForeground(Color.WHITE);
        panel1.add(btnUC);
        btnUC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateCheck();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton btnURS = new JButton("Update Room Status");
        btnURS.setBounds(30, 350, 200, 30);
        btnURS.setBackground(Color.BLACK);
        btnURS.setForeground(Color.WHITE);
        panel1.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateRoom();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton btnPUS = new JButton("Pick up Service");
        btnPUS.setBounds(30, 390, 200, 30);
        btnPUS.setBackground(Color.BLACK);
        btnPUS.setForeground(Color.WHITE);
        panel1.add(btnPUS);
        btnPUS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new PickUp();

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton btnSR = new JButton("Search Room");
        btnSR.setBounds(30, 430, 200, 30);
        btnSR.setBackground(Color.BLACK);
        btnSR.setForeground(Color.WHITE);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new SearchRoom();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton logout = new JButton("Logout");
        logout.setBounds(30, 470, 95, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        panel1.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.exit(500);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(140, 470, 95, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel1.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    new Dashboard();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1950, 1090);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
