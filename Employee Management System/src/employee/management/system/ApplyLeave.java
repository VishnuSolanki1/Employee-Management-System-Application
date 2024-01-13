package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class ApplyLeave extends JFrame implements ActionListener {
    
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    
    Choice cEmpId;
    JDateChooser dcdos,dcdoe;
    JLabel lblname,lblphone,lblemail;
    JComboBox<String> cbReason;
    JButton Submit, back,Exit;
    
    ApplyLeave(){
    
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/img20.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenSize.width,screenSize.height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,screenSize.width,screenSize.height);
        add(image);
        
        JLabel heading = new JLabel("Apply Leave");
        heading.setBounds(500, 10, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 40));
        image.add(heading);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 100, 100, 30);
        image.add(labelempId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(200, 100, 100, 30);
        image.add(cEmpId);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 100, 30);
        image.add(labelname);
        
        lblname = new JLabel();
        lblname.setBounds(200, 150, 100, 30);
        image.add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 200, 100, 30);
        image.add(labelphone);
        
        lblphone = new JLabel();
        lblphone.setBounds(200, 200, 100, 30);
        image.add(lblphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 250, 100, 30);
        image.add(labelemail);
        
        lblemail = new JLabel();
        lblemail.setBounds(200, 250, 100, 30);
        image.add(lblemail);
        
        JLabel lblStartingDate = new JLabel("Starting Date");
        lblStartingDate.setBounds(50, 300, 100, 30);
        image.add(lblStartingDate);
        
        dcdos = new JDateChooser();
        dcdos.setBounds(200, 300, 100, 30);
        image.add(dcdos);
        
        JLabel lblEndingDate = new JLabel("Ending Date");
        lblEndingDate.setBounds(50, 350, 100, 30);
        image.add(lblEndingDate);
        
        dcdoe = new JDateChooser();
        dcdoe.setBounds(200, 350, 100, 30);
        image.add(dcdoe);
        
        JLabel lblReason = new JLabel("Reason");
        lblReason.setBounds(50, 400, 100, 30);
        image.add(lblReason);
        
        String Reason[] = {"Employee Health Issue", "Family Member Health Issue", "Function/Celebration","Party","Personel Things","Tour/Travelling","Family Member Death Problem","Mariage Invitation","Own Mariage","Other"};
        cbReason = new JComboBox<String>(Reason);
        cbReason.setBackground(Color.WHITE);
        cbReason.setBounds(200, 400, 200, 30);
        image.add(cbReason);
        
        Submit = new JButton("Submit");
        Submit.setBounds(50, 500, 100, 30);
        Submit.addActionListener(this);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        image.add(Submit);
        
        back = new JButton("Back");
        back.setBounds(200, 500, 100, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        image.add(back);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        Exit = new JButton("Exit");
        Exit.setBounds(1180, 0, 100, 50);
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(Color.WHITE);
        Exit.addActionListener(this);
        image.add(Exit);
        
        setSize(screenSize.width, screenSize.height);
        setLocation(0, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       if (ae.getSource() == Submit) {
            String EmpId = cEmpId.getSelectedItem();
            String Name = lblname.getText();
            String Phone = lblphone.getText();
            String Email = lblemail.getText();
            String StartingDate = ((JTextField) dcdos.getDateEditor().getUiComponent()).getText();
            String EndingDate = ((JTextField) dcdoe.getDateEditor().getUiComponent()).getText();
            String Reason = (String) cbReason.getSelectedItem();
            
            try {
                Conn conn = new Conn();
                String query = "insert into Leaves values('"+EmpId+"', '"+Name+"', '"+Phone+"', '"+Email+"', '"+StartingDate+"', '"+EndingDate+"', '"+Reason+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Details added successfully");
                setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Exit){
            System.exit(0);
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new ApplyLeave();
    }
    
}
