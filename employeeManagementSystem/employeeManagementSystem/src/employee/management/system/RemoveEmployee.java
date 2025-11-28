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
    JComboBox<String> selectEmp;
    JButton backBtn, removeBtn;
    JLabel eName, eFName, eEmail, ePhone;

    RemoveEmployee() {
        // Frame setup
        getContentPane().setBackground(DesignSystem.BACKGROUND_COLOR);
        setLayout(null);

        // Header
        JLabel heading = new JLabel("Remove Employee");
        heading.setBounds(250, 20, 500, 50);
        heading.setFont(DesignSystem.HEADER_FONT);
        heading.setForeground(DesignSystem.PRIMARY_COLOR);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);

        // Selection Area
        JLabel label = new JLabel("Select Employee ID");
        label.setBounds(50, 100, 200, 30);
        label.setFont(DesignSystem.SUBHEADER_FONT);
        label.setForeground(DesignSystem.TEXT_COLOR);
        add(label);

        selectEmp = new JComboBox<>();
        selectEmp.setBounds(250, 100, 200, 30);
        selectEmp.setFont(DesignSystem.BODY_FONT);
        selectEmp.setBackground(Color.WHITE);
        add(selectEmp);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                selectEmp.addItem(resultSet.getString("eID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Details Area
        int startY = 160;
        int gapY = 40;

        addLabel("Name:", 50, startY);
        eName = addValueLabel(250, startY);

        addLabel("Father's Name:", 50, startY + gapY);
        eFName = addValueLabel(250, startY + gapY);

        addLabel("Email:", 50, startY + gapY * 2);
        eEmail = addValueLabel(250, startY + gapY * 2);

        addLabel("Phone:", 50, startY + gapY * 3);
        ePhone = addValueLabel(250, startY + gapY * 3);

        // Buttons
        removeBtn = new JButton("REMOVE");
        removeBtn.setBounds(600, 300, 150, 40);
        removeBtn.setBackground(new Color(231, 76, 60)); // Red for remove
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFont(DesignSystem.BUTTON_FONT);
        removeBtn.setFocusPainted(false);
        removeBtn.addActionListener(this);
        add(removeBtn);

        backBtn = new JButton("BACK");
        backBtn.setBounds(600, 360, 150, 40);
        backBtn.setBackground(DesignSystem.BACKGROUND_COLOR);
        backBtn.setForeground(DesignSystem.TEXT_COLOR);
        backBtn.setFont(DesignSystem.BUTTON_FONT);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(this);
        add(backBtn);

        // Initial Data Load
        updateLabels();

        // Event Listener
        selectEmp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateLabels();
            }
        });

        // Decorative Image (Optional, using a colored panel for now)
        JPanel decoration = new JPanel();
        decoration.setBounds(600, 100, 300, 180);
        decoration.setBackground(DesignSystem.PRIMARY_COLOR);
        JLabel iconLabel = new JLabel("DELETE");
        iconLabel.setForeground(new Color(255, 255, 255, 50));
        iconLabel.setFont(new Font("Segoe UI", Font.BOLD, 60));
        decoration.add(iconLabel);
        add(decoration);

        setSize(1000, 500);
        setLocation(250, 100);
        setUndecorated(true);
        setVisible(true);
    }

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 150, 30);
        label.setFont(DesignSystem.SUBHEADER_FONT);
        label.setForeground(DesignSystem.TEXT_COLOR);
        add(label);
    }

    private JLabel addValueLabel(int x, int y) {
        JLabel label = new JLabel();
        label.setBounds(x, y, 300, 30);
        label.setFont(DesignSystem.BODY_FONT);
        label.setForeground(DesignSystem.PRIMARY_COLOR);
        add(label);
        return label;
    }

    private void updateLabels() {
        try {
            conn c = new conn();
            String query = "select * from employee where eID = '" + selectEmp.getSelectedItem() + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                eName.setText(resultSet.getString("ename"));
                eFName.setText(resultSet.getString("fname"));
                eEmail.setText(resultSet.getString("Email"));
                ePhone.setText(resultSet.getString("Phone"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeBtn) {
            try {
                conn c = new conn();
                c.statement.executeUpdate("delete from employee where eID = '" + selectEmp.getSelectedItem() + "'");
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully.");
                setVisible(false);
                new ViewEmployee();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new Main_Class(); // Go back to Dashboard instead of ViewEmployee
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}