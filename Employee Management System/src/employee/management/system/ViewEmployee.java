package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{
    
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    
    JTable table;
    Choice cemployeeId;
    JButton search, print, back,Exit;
    
    ViewEmployee() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/view.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenSize.width,screenSize.height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,screenSize.width,screenSize.height);
        add(image);
        
        JLabel heading = new JLabel("View Employee Detail");
        heading.setBounds(400, 10, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 40));
        image.add(heading);
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 70, 150, 20);
        image.add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 70, 150, 20);
        image.add(cemployeeId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()) {
                cemployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 150, screenSize.width, 600);
        image.add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 120, 80, 20);
        search.addActionListener(this);
        image.add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 120, 80, 20);
        print.addActionListener(this);
        image.add(print);
        
        back = new JButton("Back");
        back.setBounds(220, 120, 80, 20);
        back.addActionListener(this);
        image.add(back);
        
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
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
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

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
