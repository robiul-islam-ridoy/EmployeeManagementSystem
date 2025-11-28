package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField eName, eFName, eMName, eAddress, eNID, ePhone, eEmail, eSalary, eDesignation;
    JSpinner eDob; // Changed from JDateChooser to JSpinner
    JComboBox<String> eEducation;
    Random random = new Random();
    int randomNumber = random.nextInt(999999);
    JButton submitBtn, backBtn;

    AddEmployee() {
        // Frame setup
        getContentPane().setBackground(DesignSystem.BACKGROUND_COLOR);
        setLayout(null);

        // Header
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(DesignSystem.HEADER_FONT);
        heading.setForeground(DesignSystem.PRIMARY_COLOR);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);

        // Form Container
        int startY = 150;
        int gapY = 50;
        int labelX1 = 50, fieldX1 = 200;
        int labelX2 = 450, fieldX2 = 600;

        // Row 1
        addLabel("Name", labelX1, startY);
        eName = addTextField(fieldX1, startY);

        addLabel("Father's Name", labelX2, startY);
        eFName = addTextField(fieldX2, startY);

        // Row 2
        addLabel("Mother's Name", labelX1, startY + gapY);
        eMName = addTextField(fieldX1, startY + gapY);

        addLabel("Date of Birth", labelX2, startY + gapY);
        eDob = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(eDob, "yyyy-MM-dd");
        eDob.setEditor(editor);
        eDob.setBounds(fieldX2, startY + gapY, 150, 30);
        eDob.setFont(DesignSystem.BODY_FONT);
        add(eDob);

        // Row 3
        addLabel("Address", labelX1, startY + gapY * 2);
        eAddress = addTextField(fieldX1, startY + gapY * 2);

        addLabel("Salary", labelX2, startY + gapY * 2);
        eSalary = addTextField(fieldX2, startY + gapY * 2);

        // Row 4
        addLabel("Designation", labelX1, startY + gapY * 3);
        eDesignation = addTextField(fieldX1, startY + gapY * 3);

        addLabel("NID", labelX2, startY + gapY * 3);
        eNID = addTextField(fieldX2, startY + gapY * 3);

        // Row 5
        addLabel("Phone", labelX1, startY + gapY * 4);
        ePhone = addTextField(fieldX1, startY + gapY * 4);

        addLabel("Email", labelX2, startY + gapY * 4);
        eEmail = addTextField(fieldX2, startY + gapY * 4);

        // Row 6
        addLabel("Education", labelX1, startY + gapY * 5);
        String[] eduItems = { "BSc", "BBA", "MSc", "MBA", "PhD", "Diploma" };
        eEducation = new JComboBox<>(eduItems);
        eEducation.setBounds(fieldX1, startY + gapY * 5, 150, 30);
        eEducation.setBackground(Color.WHITE);
        eEducation.setFont(DesignSystem.BODY_FONT);
        add(eEducation);

        addLabel("Employee ID", labelX2, startY + gapY * 5);
        JLabel eID = new JLabel("" + randomNumber);
        eID.setBounds(fieldX2, startY + gapY * 5, 150, 30);
        eID.setFont(DesignSystem.BODY_FONT);
        eID.setForeground(DesignSystem.PRIMARY_COLOR);
        add(eID);

        // Buttons
        submitBtn = new JButton("SUBMIT");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String ename = eName.getText();
            String fname = eFName.getText();
            String mname = eMName.getText();
            String address = eAddress.getText();
            String nid = eNID.getText();
            String phone = ePhone.getText();
            String email = eEmail.getText();
            String salary = eSalary.getText();
            String designation = eDesignation.getText();
            String empId = "" + randomNumber;

            // Format Date
            java.util.Date date = (java.util.Date) eDob.getValue();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String dob = sdf.format(date);

            String education = (String) eEducation.getSelectedItem();

            try {
                conn c = new conn();
                String query = "insert into employee values('" + ename + "', '" + fname + "', '" + mname + "', '"
                        + address + "', '" + nid + "', '" + phone + "', '" + email + "', '" + salary + "', '"
                        + designation + "', '" + dob + "', '" + education + "', '" + empId + "')";

                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Details Added Successfully");
                setVisible(false);
                new Main_Class();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new Main_Class();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
