package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame{
    Main_Class(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg = new JLabel(i3);
        bg.setBounds(0,0,1120, 630);
        add(bg);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340, 155, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        heading.setForeground(Color.GRAY);
        bg.add(heading);

        JButton addBtn = new JButton("Add Employee");
        addBtn.setBounds(430, 300, 150, 40);
        addBtn.setForeground(Color.BLACK);
        addBtn.setBackground(Color.LIGHT_GRAY);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddEmployee();
            }
        });
        bg.add(addBtn);

        JButton viewBtn = new JButton("View Employee");
        viewBtn.setBounds(430, 360, 150, 40);
        viewBtn.setForeground(Color.black);
        viewBtn.setBackground(Color.LIGHT_GRAY);
        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ViewEmployee();
            }
        });
        bg.add(viewBtn);

        JButton removeBtn = new JButton("Remove Employee");
        removeBtn.setBounds(430, 420, 150, 40);
        removeBtn.setForeground(Color.black);
        removeBtn.setBackground(Color.LIGHT_GRAY);
        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoveEmployee();
            }
        });
        bg.add(removeBtn);

        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Main_Class();
    }
}
