package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ViewEmployee extends JFrame implements ActionListener {
    Choice searchOptions;
    JTable table;
    JButton searchBtn, printBtn, updateBtn, backBtn;
    public ViewEmployee(){
        getContentPane().setBackground(new Color(255, 121, 121));

        JLabel searchText = new JLabel("Search By Employee ID: ");
        searchText.setBounds(20, 20, 150, 40);
        add(searchText);

        searchOptions = new Choice();
        searchOptions.setBounds(180, 20, 150, 40);
        add(searchOptions);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                searchOptions.add(resultSet.getString("eID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table = new JTable();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900, 600);
        add(scrollPane);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(20, 70, 80,20);
        searchBtn.setForeground(Color.black);
        searchBtn.setBackground(Color.LIGHT_GRAY);
        searchBtn.addActionListener(this);
        add(searchBtn);

        printBtn = new JButton("Print");
        printBtn.setBounds(120, 70, 80,20);
        printBtn.setForeground(Color.black);
        printBtn.setBackground(Color.LIGHT_GRAY);
        printBtn.addActionListener(this);
        add(printBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(220, 70, 80,20);
        updateBtn.setForeground(Color.black);
        updateBtn.setBackground(Color.LIGHT_GRAY);
        updateBtn.addActionListener(this);
        add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(320, 70, 80,20);
        backBtn.setForeground(Color.black);
        backBtn.setBackground(Color.LIGHT_GRAY);
        backBtn.addActionListener(this);
        add(backBtn);

        setSize(900, 700);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchBtn){
            String querry = "select * from employee where eID = '"+searchOptions.getSelectedItem()+"'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(querry);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == printBtn) {
            try {
                table.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == updateBtn) {
            setVisible(false);
            new UpdateDetails(searchOptions.getSelectedItem());

        }else {
            setVisible(false);
            new Main_Class();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}