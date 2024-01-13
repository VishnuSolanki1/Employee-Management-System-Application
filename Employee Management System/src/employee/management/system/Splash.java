package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    
    JButton clickhere,Exit;

    Splash() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenSize.width,screenSize.height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,screenSize.width,screenSize.height);
        add(image);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(120,-300,screenSize.width,screenSize.height);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.black);
        image.add(heading);
        
        clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(575, 500, 200, 50);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        Exit = new JButton("Exit");
        Exit.setBounds(1180, 0, 100, 50);
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(Color.WHITE);
        Exit.addActionListener(this);
        image.add(Exit);
        
        setSize(screenSize.width,screenSize.height);
        setLocation(0,100);
        setVisible(true);
        
        while(true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                
            }
            
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                
            }
        }
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clickhere) {
            setVisible(false);
            new Login();
        } else if (ae.getSource() == Exit){
            System.exit(0);
        }
    }
    
    public static void main(String args[]) {
        new Splash();
    }
}
