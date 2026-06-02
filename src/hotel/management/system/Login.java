package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField username;
    JPasswordField password;
    JButton login, cancel;
    
    Login() {
        getContentPane().setBackground(new Color(3, 45, 48));
        
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        user.setForeground(Color.WHITE);
        add(user);
        
        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Tahoma",Font. PLAIN,15));
        username.setBackground(new Color(26, 104, 110));
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        pass.setForeground(Color.WHITE);
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        password.setForeground(Color.WHITE);
        password.setBackground(new Color(26, 104, 110));
        add(password);
        
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setFont(new Font("serif", Font.BOLD, 15));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.gif"));
        Image i2 = i1.getImage().getScaledInstance(255, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(318,-30, 255, 300);
        add(image);
        
        
        setBounds(500, 200, 600, 300);
        setVisible(true);
}
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = password.getText();
            
             try {
                 Conn c = new Conn();
                 
                 String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                 
                 ResultSet rs = c.s.executeQuery(query);
                 
                 if (rs.next()){
                     setVisible(false);
                     new Dashboard();
                 } else {
                     JOptionPane.showMessageDialog(null, "Invalid username or password");
                     
                 }
                 
             }catch (Exception e){
                 e.printStackTrace();
             }
    } else if (ae.getSource() == cancel) {
        setVisible(false);
    }
   }
    public static void main(String[] args){
        new Login();
    }
    }
