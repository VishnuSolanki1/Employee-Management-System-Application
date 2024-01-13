package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddSalary extends JFrame implements ActionListener {
    
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    
    Choice cEmpId;
    JLabel lblname,lblphone,lblemail;
    JComboBox<String> cbMonth, cbYear;
    JButton Submit, back,Exit;
    JTextField tfHRA,tfDA,tfMID,tfPF,tfBasicSalary;
    
    AddSalary(){
    
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
        
        JLabel heading = new JLabel("Add Salary Details");
        heading.setBounds(400, 10, 500, 50);
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
        
        JLabel labelHRA = new JLabel("HRA");
        labelHRA.setBounds(50, 300, 100, 30);
        image.add(labelHRA);
        
        tfHRA = new JTextField();
        tfHRA.setBounds(200, 300, 100, 30);
        image.add(tfHRA);
        
        JLabel labelDA = new JLabel("DA");
        labelDA.setBounds(50, 350, 100, 30);
        image.add(labelDA);
        
        tfDA = new JTextField();
        tfDA.setBounds(200, 350, 100, 30);
        image.add(tfDA);
        
        JLabel labelMID = new JLabel("MID");
        labelMID.setBounds(50, 400, 100, 30);
        image.add(labelMID);
        
        tfMID = new JTextField();
        tfMID.setBounds(200, 400, 100, 30);
        image.add(tfMID);
        
        JLabel labelPF = new JLabel("PF");
        labelPF.setBounds(50, 450, 100, 30);
        image.add(labelPF);
        
        tfPF = new JTextField();
        tfPF.setBounds(200, 450, 100, 30);
        image.add(tfPF);
        
        JLabel labelBasicSalary = new JLabel("Basic Salary");
        labelBasicSalary.setBounds(50, 500, 100, 30);
        image.add(labelBasicSalary);
        
        tfBasicSalary = new JTextField();
        tfBasicSalary.setBounds(200, 500, 100, 30);
        image.add(tfBasicSalary);
        
        JLabel lblMonth = new JLabel("Select Month");
        lblMonth.setBounds(50, 550, 100, 30);
        image.add(lblMonth);
        
        String SMonth[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        cbMonth = new JComboBox<String>(SMonth);
        cbMonth.setBackground(Color.WHITE);
        cbMonth.setBounds(200, 550, 100, 30);
        image.add(cbMonth);
        
        JLabel lblYear = new JLabel("Select Year");
        lblYear.setBounds(50, 600, 100, 30);
        image.add(lblYear);
        
        String SYear[] = {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"};
        cbYear = new JComboBox<String>(SYear);
        cbYear.setBackground(Color.WHITE);
        cbYear.setBounds(200, 600, 100, 30);
        image.add(cbYear);
       
        Submit = new JButton("Submit");
        Submit.setBounds(350, 550, 100, 30);
        Submit.addActionListener(this);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        image.add(Submit);
        
        back = new JButton("Back");
        back.setBounds(350, 600, 100, 30);
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
            String HRA = tfHRA.getText();
            String DA = tfDA.getText();
            String MID = tfMID.getText();
            String PF = tfPF.getText();
            String BasicSalary = tfBasicSalary.getText();
            String Month = (String) cbMonth.getSelectedItem();
            String Year = (String) cbYear.getSelectedItem();
            
            try {
                Conn conn = new Conn();
                String query = "insert into Salary values('"+EmpId+"', '"+Name+"', '"+Phone+"', '"+Email+"', '"+HRA+"', '"+DA+"', '"+MID+"', '"+PF+"', '"+BasicSalary+"', '"+Month+"', '"+Year+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Salary Details added successfully");
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
        new AddSalary();
    }
    
}
