package employee.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class ViewEmployee extends JFrame implements ActionListener {

    Choice searchOptions;
    JTable table;
    JButton searchBtn, printBtn, updateBtn, backBtn;

    public ViewEmployee() {

        getContentPane().setBackground(DesignSystem.BACKGROUND_COLOR);
        setLayout(null);

        JPanel header = new JPanel();
        header.setBackground(DesignSystem.PRIMARY_COLOR);
        header.setBounds(0, 0, 915, 60);
        header.setLayout(null);
        add(header);

        JLabel heading = new JLabel("View Employee Details");
        heading.setBounds(20, 15, 300, 30);
        heading.setFont(DesignSystem.HEADER_FONT);
        heading.setForeground(DesignSystem.WHITE);
        header.add(heading);

        JLabel exit = new JLabel("X");
        exit.setBounds(885, 10, 20, 30);
        exit.setFont(new Font("Tahoma", Font.BOLD, 20));
        exit.setForeground(DesignSystem.WHITE);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
        header.add(exit);

        JLabel searchLabel = new JLabel("Search by Employee ID:");
        searchLabel.setBounds(20, 70, 180, 20);
        searchLabel.setFont(DesignSystem.BODY_FONT);
        add(searchLabel);

        searchOptions = new Choice();
        searchOptions.setBounds(220, 70, 150, 20);
        searchOptions.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(searchOptions);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                searchOptions.add(resultSet.getString("eID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        searchBtn = createButton("Search", 20, 110);
        printBtn = createButton("Print", 140, 110);
        updateBtn = createButton("Update", 260, 110);
        backBtn = createButton("Back", 380, 110);

        
        table = new JTable();
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(DesignSystem.PRIMARY_COLOR);
        table.getTableHeader().setForeground(Color.WHITE);
        table.setSelectionBackground(DesignSystem.SECONDARY_COLOR);
        table.setSelectionForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 160, 900, 540);
        add(scrollPane);

        loadData("select * from employee");

        setSize(915, 740);
        setLocation(300, 100);
        setUndecorated(true);
        setVisible(true);
    }

    private JButton createButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 100, 30);
        btn.setBackground(DesignSystem.PRIMARY_COLOR);
        btn.setForeground(Color.WHITE);
        btn.setFont(DesignSystem.BUTTON_FONT);
        btn.setFocusPainted(false);
        btn.addActionListener(this);
        add(btn);
        return btn;
    }

    private void loadData(String query) {
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery(query);
            table.setModel(buildTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchBtn) {
            String query = "select * from employee where eID = '" + searchOptions.getSelectedItem() + "'";
            loadData(query);
        } else if (e.getSource() == printBtn) {
            try {
                table.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == updateBtn) {
            setVisible(false);
            new UpdateDetails(searchOptions.getSelectedItem());
        } else {
            setVisible(false);
            new Main_Class();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}