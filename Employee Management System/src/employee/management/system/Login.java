package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener{
    
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    JTextField tfusername;
    JPasswordField pfpassword;
    JButton login,Exit;
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenSize.width,screenSize.height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,screenSize.width,screenSize.height);
        add(image);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 140, 100, 30);
        lblusername.setForeground(Color.white);
        image.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(210, 140, 150, 30);
        image.add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 190, 100, 30);
        lblpassword.setForeground(Color.white);
        image.add(lblpassword);
        
        pfpassword = new JPasswordField();
        pfpassword.setBounds(210, 190, 150, 30);
        image.add(pfpassword);
        
        login = new JButton("LOGIN");
        login.setBounds(210, 260, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        image.add(login);

        JLabel heading = new JLabel("LOGIN PAGE");
        heading.setBounds(20,-300,screenSize.width,screenSize.height);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.white);
        image.add(heading);
        
        Exit = new JButton("Exit");
        Exit.setBounds(1180, 0, 100, 50);
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(Color.WHITE);
        Exit.addActionListener(this);
        image.add(Exit);
        
        setSize(screenSize.width,screenSize.height);
        setLocation(0,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login){ 
            try {
            String username = tfusername.getText();
            char[] passwordChars = pfpassword.getPassword();
            String password = new String(passwordChars);

            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login successfully");
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
         else if (ae.getSource() == Exit){
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
