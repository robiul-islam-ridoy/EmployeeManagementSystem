package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice selectEmp;
    JButton backBtn, removeBtn;

    RemoveEmployee(){
        JLabel label = new JLabel("Select Employee ID");
        label.setBounds(50, 50, 200, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(label);

        selectEmp = new Choice();
        selectEmp.setBounds(250, 50, 100, 30);
        add(selectEmp);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                selectEmp.add(resultSet.getString("eID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        JLabel eName = new JLabel();
        eName.setBounds(200, 150, 150, 30);
        eName.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(eName);

        JLabel fname = new JLabel("Fathers Name:");
        fname.setBounds(50, 200, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        JLabel eFName = new JLabel();
        eFName.setBounds(200, 200, 150, 30);
        eFName.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(eFName);

        JLabel email = new JLabel("Email :");
        email.setBounds(400, 200, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        JLabel eEmail = new JLabel();
        eEmail.setBounds(550, 200, 250, 30);
        eEmail.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(eEmail);

        JLabel phone = new JLabel("Phone:");
        phone.setBounds(50, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        JLabel ePhone = new JLabel();
        ePhone.setBounds(200, 250, 150, 30);
        ePhone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(ePhone);

        removeBtn = new JButton("Remove");
        removeBtn.setBounds(300, 300, 150, 30);
        removeBtn.setForeground(Color.black);
        removeBtn.setBackground(Color.LIGHT_GRAY);
        removeBtn.addActionListener(this);
        add(removeBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(50, 300, 150, 30);
        backBtn.setForeground(Color.black);
        backBtn.setBackground(Color.LIGHT_GRAY);
        backBtn.addActionListener(this);
        add(backBtn);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where eID = '"+selectEmp.getSelectedItem()+"'");
            while (resultSet.next()){
                eName.setText(resultSet.getString("ename"));
                eFName.setText(resultSet.getString("fname"));
                eEmail.setText(resultSet.getString("Email"));
                ePhone.setText(resultSet.getString("Phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        selectEmp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where eID = '"+selectEmp.getSelectedItem()+"'");
                    while (resultSet.next()){
                        eName.setText(resultSet.getString("ename"));
                        eFName.setText(resultSet.getString("fname"));
                        eEmail.setText(resultSet.getString("Email"));
                        ePhone.setText(resultSet.getString("Phone"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setSize(1000, 400);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == removeBtn){
            try{
                conn c = new conn();
                c.statement.executeUpdate("delete from employee where eID = '"+selectEmp.getSelectedItem()+"'");
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully.");
                setVisible(false);
                new ViewEmployee();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}