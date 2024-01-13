package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    
    JButton Exit;
    JMenuBar mb;    
    JMenu Profile,Manage,Attendance,Leave,Salary,Remove;    
    JMenuItem Complete_Profile,View_Profile,Update_Details,Take_Attendance,View_Attendance,Apply_Leave,View_Leaves,Add_Salary,Generate_Salary_Slip,Remove_Employee;
    
    Home() {
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/img25.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, screenSize.width, screenSize.height);
        add(image);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(640, 20, 700, 60);
        heading.setFont(new Font("Raleway", Font.BOLD, 40));
        image.add(heading);

        mb=new JMenuBar();
        add(mb);
        
        Profile=new JMenu("Profile");
        mb.add(Profile);
        
        Manage=new JMenu("Manage");
        mb.add(Manage);
        
        Attendance=new JMenu("Attendance");
        mb.add(Attendance);
        
        Leave=new JMenu("Leave");
        mb.add(Leave);
        
        Salary=new JMenu("Salary");
        mb.add(Salary);
        
        Remove=new JMenu("Remove");
        mb.add(Remove);

        Complete_Profile=new JMenuItem("Complete Profile");
        Complete_Profile.addActionListener(this); 
        Profile.add(Complete_Profile);
        
        View_Profile=new JMenuItem("View Profile");
        View_Profile.addActionListener(this); 
        Profile.add(View_Profile);
        
        Update_Details=new JMenuItem("Update Details");
        Update_Details.addActionListener(this); 
        Manage.add(Update_Details);
        
        Take_Attendance=new JMenuItem("Take Attendance");
        Take_Attendance.addActionListener(this); 
        Attendance.add(Take_Attendance);
        
        View_Attendance=new JMenuItem("View Attendance");
        View_Attendance.addActionListener(this); 
        Attendance.add(View_Attendance);
        
        Apply_Leave=new JMenuItem("Apply Leave");
        Apply_Leave.addActionListener(this); 
        Leave.add(Apply_Leave);
        
        View_Leaves=new JMenuItem("View Leaves");
        View_Leaves.addActionListener(this); 
        Leave.add(View_Leaves);
        
        Add_Salary=new JMenuItem("Add Salary");
        Add_Salary.addActionListener(this); 
        Salary.add(Add_Salary);
        
        Generate_Salary_Slip=new JMenuItem("Generate Salary Slip");
        Generate_Salary_Slip.addActionListener(this); 
        Salary.add(Generate_Salary_Slip);
        
        Remove_Employee=new JMenuItem("Remove Employee");
        Remove_Employee.addActionListener(this); 
        Remove.add(Remove_Employee);
        
        Exit = new JButton("Exit");
        Exit.setBounds(1180, 0, 100, 50);
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(Color.WHITE);
        Exit.addActionListener(this);
        image.add(Exit);

        setJMenuBar(mb);
        setLayout(null);   
        setSize(screenSize.width, screenSize.height);
        setLocation(0, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Complete_Profile) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == View_Profile) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == Update_Details) {
            setVisible(false);
            new UpdateDetails1();
        } else if (ae.getSource() == Take_Attendance) {
            setVisible(false);
            new TakeAttendance();
        } else if (ae.getSource() == View_Attendance) {
            setVisible(false);
            new ViewAttendance();
        } else if (ae.getSource() == Apply_Leave) {
            setVisible(false);
            new ApplyLeave();
        } else if (ae.getSource() == View_Leaves) {
            setVisible(false);
            new ViewLeaves();
        } else if (ae.getSource() == Add_Salary) {
            setVisible(false);
            new AddSalary();
        } else if (ae.getSource() == Generate_Salary_Slip) {
            setVisible(false);
            new GenerateSalarySlip();
        } else if (ae.getSource() == Remove_Employee) {
            setVisible(false);
            new RemoveEmployee();
        } else if (ae.getSource() == Exit){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Home();
    }

}
