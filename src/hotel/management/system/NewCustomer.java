package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {

    JComboBox comboBox;
    JTextField textFieldNumber, TextName, TextCountry, TextDeposit;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;

    JButton add, back;

    NewCustomer() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(550, 150, 200, 200);
        panel.add(imglabel);

        JLabel labelName = new JLabel("NEW CUSTOMER FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setForeground(Color.WHITE);
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelID);

        comboBox = new JComboBox(new String[]{"Passport", "Aadhaar Card", "Voter Id", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelNumber);
        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textFieldNumber);

        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(35, 151, 200, 14);
        labelname.setForeground(Color.WHITE);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelname);
        TextName = new JTextField();
        TextName.setBounds(271, 151, 150, 20);
        panel.add(TextName);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setForeground(Color.WHITE);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(3, 45, 48));
        r1.setBounds(271, 191, 80, 12);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(3, 45, 48));
        r2.setBounds(350, 191, 80, 12);
        panel.add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel labelCountry = new JLabel("Country :");
        labelCountry.setBounds(35, 231, 200, 14);
        labelCountry.setForeground(Color.WHITE);
        labelCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelCountry);
        TextCountry = new JTextField();
        TextCountry.setBounds(271, 231, 150, 20);
        panel.add(TextCountry);

        JLabel labelRoom = new JLabel("Allocated Room Number :");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setForeground(Color.WHITE);
        labelRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelRoom);

        c1 = new Choice();
        try {

            Conn c = new Conn();
            ResultSet resultSet = c.s.executeQuery("select * from room where availability = 'Available'");
            while (resultSet.next()) {
                c1.add(resultSet.getString("roomnumber"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(271, 274, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3, 45, 48));
        panel.add(c1);

        JLabel labelCIS = new JLabel("Checked-In :");
        labelCIS.setBounds(35, 316, 200, 14);
        labelCIS.setForeground(Color.WHITE);
        labelCIS.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelCIS);

        Date date1 = new Date();

        date = new JLabel("" + date1);
        date.setBounds(271, 316, 200, 14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(date);

        JLabel labelDeposit = new JLabel("Deposit :");
        labelDeposit.setBounds(35, 359, 200, 14);
        labelDeposit.setForeground(Color.WHITE);
        labelDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelDeposit);
        TextDeposit = new JTextField();
        TextDeposit.setBounds(271, 359, 150, 20);
        panel.add(TextDeposit);

        add = new JButton("ADD");
        add.setBounds(100, 430, 120, 30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260, 430, 120, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setLocation(500, 150);
        setSize(850, 550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String id_number = textFieldNumber.getText();
            String type = (String) comboBox.getSelectedItem();

            if (textFieldNumber.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error : ID Number is required in Field!");
                return;
            }

            if (TextName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error : Customer Name cannot be empty!");
                return;
            }

            if (TextDeposit.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error : Please enter the initial deposit amount!");
                return;
            }

            if (type.equals("Aadhaar Card")) {

                if (id_number.length() != 12) {

                    JOptionPane.showMessageDialog(null, "Error: Aadhaar number must be 12 digits!!");
                    return;
                }
                for (int i = 0; i < 12; i++) {
                    if (!Character.isDigit(id_number.charAt(i))) {
                        JOptionPane.showMessageDialog(null, "Error: Invalid input");
                        return;
                    }
                }
            } else if (type.equals("Passport")) {
                if (id_number.length() != 8) {
                    JOptionPane.showMessageDialog(null, "Error: Passport must be 8 digits!!");
                    return;
                }
                if (!Character.isLetter(id_number.charAt(0))) {
                    JOptionPane.showMessageDialog(null, "Invalid Format");
                    return;
                }
                for (int i = 1; i < 8; i++) {
                    if (!Character.isDigit(id_number.charAt(i))) {
                        JOptionPane.showMessageDialog(null, "Inavlid Format");
                        return;
                    }
                }
            } else if (type.equals("Voter Id")) {
                if (id_number.length() != 10) {
                    JOptionPane.showMessageDialog(null, "Error: Voter ID must be 10 digits!!");
                    return;
                }
                for (int i = 0; i < 3; i++) {
                    if (!Character.isLetter(id_number.charAt(i))) {
                        JOptionPane.showMessageDialog(null, "Invalid Format");
                        return;
                    }
                }
                for (int i = 3; i < 10; i++) {
                    if (!Character.isDigit(id_number.charAt(i))) {
                        JOptionPane.showMessageDialog(null, "Inavlid Format");
                        return;
                    }
                }
            } else if (type.equals("Driving License")) {
                if (id_number.length() != 15) {
                    JOptionPane.showMessageDialog(null, "Error: Driving License  must be 15 digits!!");
                    return;
                }
                if (!Character.isLetter(id_number.charAt(1))) {
                    JOptionPane.showMessageDialog(null, "Invalid Format");
                    return;
                }
            }
            String s6 = c1.getSelectedItem();
            try {
                Conn c = new Conn();

                String query = "select * from room where roomnumber = '" + s6 + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    if (rs.getString("availability").equalsIgnoreCase("Occupied")) {
                        JOptionPane.showMessageDialog(null, "Room Occupied! Please Search For Another");
                        return;
                    }
                }
                String radioBtn = null;
                if (r1.isSelected()) {
                    radioBtn = "Male";
                } else if (r2.isSelected()) {
                    radioBtn = "Female";
                }
                if (radioBtn == null) {
                    JOptionPane.showMessageDialog(null, "Error:Please Select Gender!");
                    return;
                }

                String s1 = (String) comboBox.getSelectedItem();
                String s2 = textFieldNumber.getText();
                String s3 = TextName.getText();
                String s4 = radioBtn;
                String s5 = TextCountry.getText();
                String s7 = date.getText();
                String s8 = TextDeposit.getText();

                try {
                    Conn c1 = new Conn();
                    String qp = "select price from room where roomnumber = '" + s6 + "'";
                    ResultSet rsPrice = c.s.executeQuery(qp);

                    if (rsPrice.next()) {
                        int roomPrice = Integer.parseInt(rsPrice.getString("price"));
                        int depositAmount = Integer.parseInt(s8);

                        if (depositAmount > roomPrice) {
                            JOptionPane.showMessageDialog(null, "Error: Deposit cannot be more than Room Price (" + roomPrice + ")!");
                            return;
                        }
                    }
                } catch (Exception ae) {
                    ae.printStackTrace();
                }

                String q = "insert into customer values('" + s1 + "', '" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s5 + "', '" + s6 + "', '" + s7 + "', '" + s8 + "')";
                c.s.executeUpdate(q);
                String q1 = "update room set availability = 'Occupied' where roomnumber = '" + s6 + "'";
                c.s.executeUpdate(q1);

                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
                new Reception().setVisible(true);

            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Reception().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
