package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateDetails extends JFrame implements ActionListener {
    JTextField eEducation, eFName, eMName, eAddress, ePhone, eEmail, eSalary, eDesignation;
    JLabel eDob, eNID, eName, eID;
    String number;
    JButton submitBtn, backBtn;

    UpdateDetails(String number) {
        this.number = number;

        
        getContentPane().setBackground(DesignSystem.BACKGROUND_COLOR);
        setLayout(null);

        
        JPanel header = new JPanel();
        header.setBackground(DesignSystem.PRIMARY_COLOR);
        header.setBounds(0, 0, 900, 60);
        header.setLayout(null);
        add(header);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 5, 500, 50);
        heading.setFont(DesignSystem.HEADER_FONT);
        heading.setForeground(DesignSystem.WHITE);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(heading);

        
        JLabel exit = new JLabel("X");
        exit.setBounds(870, 10, 20, 30);
        exit.setFont(new Font("Tahoma", Font.BOLD, 20));
        exit.setForeground(DesignSystem.WHITE);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
        header.add(exit);

        
        int startY = 150;
        int gapY = 50;
        int labelX1 = 50, fieldX1 = 200;
        int labelX2 = 450, fieldX2 = 600;

        
        addLabel("Name", labelX1, startY);
        eName = addValueLabel(fieldX1, startY);

        addLabel("Father's Name", labelX2, startY);
        eFName = addTextField(fieldX2, startY);

        
        addLabel("Mother's Name", labelX1, startY + gapY);
        eMName = addTextField(fieldX1, startY + gapY);

        addLabel("Date of Birth", labelX2, startY + gapY);
        eDob = addValueLabel(fieldX2, startY + gapY);

        
        addLabel("Address", labelX1, startY + gapY * 2);
        eAddress = addTextField(fieldX1, startY + gapY * 2);

        addLabel("Salary", labelX2, startY + gapY * 2);
        eSalary = addTextField(fieldX2, startY + gapY * 2);

        
        addLabel("Designation", labelX1, startY + gapY * 3);
        eDesignation = addTextField(fieldX1, startY + gapY * 3);

        addLabel("NID", labelX2, startY + gapY * 3);
        eNID = addValueLabel(fieldX2, startY + gapY * 3);

        
        addLabel("Phone", labelX1, startY + gapY * 4);
        ePhone = addTextField(fieldX1, startY + gapY * 4);

        addLabel("Email", labelX2, startY + gapY * 4);
        eEmail = addTextField(fieldX2, startY + gapY * 4);

        
        addLabel("Education", labelX1, startY + gapY * 5);
        eEducation = addTextField(fieldX1, startY + gapY * 5);

        addLabel("Employee ID", labelX2, startY + gapY * 5);
        eID = addValueLabel(fieldX2, startY + gapY * 5);
        eID.setText(number);
        eID.setForeground(DesignSystem.PRIMARY_COLOR);

        
        try {
            conn c = new conn();
            String query = "select * from employee where eID = '" + number + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                eName.setText(resultSet.getString("ename"));
                eFName.setText(resultSet.getString("fname"));
                eMName.setText(resultSet.getString("mname"));
                eAddress.setText(resultSet.getString("Address"));
                eNID.setText(resultSet.getString("eNid"));
                ePhone.setText(resultSet.getString("Phone"));
                eEmail.setText(resultSet.getString("Email"));
                eSalary.setText(resultSet.getString("Salary"));
                eDesignation.setText(resultSet.getString("Designation"));
                eDob.setText(resultSet.getString("dob"));
                eEducation.setText(resultSet.getString("education"));
                eID.setText(resultSet.getString("eID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        submitBtn = new JButton("UPDATE");
        submitBtn.setBounds(250, 550, 150, 40);
        submitBtn.setBackground(DesignSystem.PRIMARY_COLOR);
        submitBtn.setForeground(DesignSystem.WHITE);
        submitBtn.setFont(DesignSystem.BUTTON_FONT);
        submitBtn.setFocusPainted(false);
        submitBtn.addActionListener(this);
        add(submitBtn);

        backBtn = new JButton("BACK");
        backBtn.setBounds(450, 550, 150, 40);
        backBtn.setBackground(DesignSystem.BACKGROUND_COLOR);
        backBtn.setForeground(DesignSystem.TEXT_COLOR);
        backBtn.setFont(DesignSystem.BUTTON_FONT);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(this);
        add(backBtn);

        setSize(900, 700);
        setLocation(300, 50);
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

    private JTextField addTextField(int x, int y) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, 150, 30);
        tf.setFont(DesignSystem.BODY_FONT);
        add(tf);
        return tf;
    }

    private JLabel addValueLabel(int x, int y) {
        JLabel label = new JLabel();
        label.setBounds(x, y, 150, 30);
        label.setFont(DesignSystem.BODY_FONT);
        label.setForeground(DesignSystem.TEXT_COLOR);
        add(label);
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String fname = eFName.getText();
            String mname = eMName.getText();
            String Address = eAddress.getText();
            String Phone = ePhone.getText();
            String Email = eEmail.getText();
            String Salary = eSalary.getText();
            String Designation = eDesignation.getText();
            String education = eEducation.getText();

            try {
                conn c = new conn();
                String query = "update employee set fname= '" + fname + "',mname = '" + mname + "', Address = '"
                        + Address + "',Phone = '" + Phone + "',Email = '" + Email + "',salary = '" + Salary
                        + "', Designation = '" + Designation + "',education = '" + education + "' where eID = '"
                        + number + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new ViewEmployee();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {
        new UpdateDetails("");
    }
}
