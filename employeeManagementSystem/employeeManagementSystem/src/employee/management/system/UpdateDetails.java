package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateDetails extends JFrame implements ActionListener {
    JTextField eEducation, eFName, eMName, eAddress, eNID, ePhone, eEmail, eSalary, eDesignation;
    JLabel eDob;
    String number;
//    JDateChooser eDob;
    JButton submitBtn, backBtn;
    UpdateDetails(String number){
        this.number = number;

        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        JLabel eName = new JLabel();
        eName.setBounds(200, 150, 150, 30);
        eName.setBackground(new Color(177, 252, 197));
        add(eName);

        JLabel fname = new JLabel("Fathers Name:");
        fname.setBounds(50, 200, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        eFName = new JTextField();
        eFName.setBounds(200, 200, 150, 30);
        eFName.setBackground(new Color(177, 252, 197));
        add(eFName);

        JLabel mName = new JLabel("Mothers Name:");
        mName.setBounds(400, 200, 150, 30);
        mName.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(mName);

        eMName = new JTextField();
        eMName.setBounds(550, 200, 150, 30);
        eMName.setBackground(new Color(177, 252, 197));
        add(eMName);

        JLabel address = new JLabel("Address:");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        eAddress = new JTextField();
        eAddress.setBounds(200, 250, 150, 30);
        eAddress.setBackground(new Color(177, 252, 197));
        add(eAddress);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(400, 250, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        eDob = new JLabel();
        eDob.setBounds(550, 250, 150, 30);
        eDob.setBackground(new Color(177, 252, 197));
        add(eDob);

        JLabel nid = new JLabel("NID:");
        nid.setBounds(50, 300, 150, 30);
        nid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(nid);

        JLabel eNID = new JLabel();
        eNID.setBounds(200, 300, 150, 30);
        eNID.setBackground(new Color(177, 252, 197));
        add(eNID);

        JLabel designation = new JLabel("Designation:");
        designation.setBounds(400, 300, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        eDesignation = new JTextField();
        eDesignation.setBounds(550, 300, 150, 30);
        eDesignation.setBackground(new Color(177, 252, 197));
        add(eDesignation);

        JLabel phone = new JLabel("Phone Number:");
        phone.setBounds(50, 350, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        ePhone = new JTextField();
        ePhone.setBounds(200, 350, 150, 30);
        ePhone.setBackground(new Color(177, 252, 197));
        add(ePhone);

        JLabel email = new JLabel("Email:");
        email.setBounds(400, 350, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        eEmail = new JTextField();
        eEmail.setBounds(550, 350, 150, 30);
        eEmail.setBackground(new Color(177, 252, 197));
        add(eEmail);

        JLabel highestEducation = new JLabel("Highest Education:");
        highestEducation.setBounds(50, 400, 150, 30);
        highestEducation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(highestEducation);


        eEducation = new JTextField();
        eEducation.setBounds(200, 400, 150, 30);
        eEducation.setBackground(new Color(177, 252, 197));
        add(eEducation);

        JLabel salary = new JLabel("Salary:");

        salary.setBounds(400, 400, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        eSalary = new JTextField();
        eSalary.setBounds(550, 400, 150, 30);
        eSalary.setBackground(new Color(177, 252, 197));
        add(eSalary);

        JLabel eId = new JLabel("Employee Id:");
        eId.setBounds(50, 450, 150, 30);
        eId.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(eId);

        JLabel eID = new JLabel(number);
        eID.setBounds(200, 450, 150, 30);
        eID.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        eID.setForeground(Color.red);
        add(eID);

        try {
            conn c = new conn();
            String query = "select * from employee where eID = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
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

        submitBtn = new JButton("Update");
        submitBtn.setBounds(450, 500, 150, 30);
        submitBtn.setForeground(Color.black);
        submitBtn.setBackground(Color.LIGHT_GRAY);
        submitBtn.addActionListener(this);
        add(submitBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 500, 150, 30);
        backBtn.setForeground(Color.black);
        backBtn.setBackground(Color.LIGHT_GRAY);
        backBtn.addActionListener(this);
        add(backBtn);

        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn){
            String fname = eFName.getText();
            String mname =eMName.getText();
            //eName, eFName, eMName, eAddress, eNID, ePhone, eEmail, eSalary, eDesignation
            String Address =eAddress.getText();
            String Phone =ePhone.getText();
            String Email =eEmail.getText();
            String Salary =eSalary.getText();
            String Designation =eDesignation.getText();
            String education = eEducation.getText();

            try{
                conn c = new conn();
                String query = "update employee set fname= '"+fname+"',mname = '"+mname+"', Address = '"+Address+"',Phone = '"+Phone+"',Email = '"+Email+"',salary = '"+Salary+"', Designation = '"+Designation+"',education = '"+education+"' where eID = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Information Updated");
                setVisible(false);
                new ViewEmployee();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else {
            setVisible(false);
            new ViewEmployee();
        }


    }
    //    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == submitBtn){
//            String ename = "";
//            String fname = eFName.getText();
//            String mname =eMName.getText();
//            //eName, eFName, eMName, eAddress, eNID, ePhone, eEmail, eSalary, eDesignation
//            String Address =eAddress.getText();
//            String eNid =eNID.getText();
//            String Phone =ePhone.getText();
//            String Email =eEmail.getText();
//            String Salary =eSalary.getText();
//            String Designation =eDesignation.getText();
//            String eID = "";
//            eDob
//            eEducation
//            String dob = ((JTextField) eDob.getDateEditor().getUiComponent()).getText();
//            String education = (String) eEducation.getSelectedItem();
//
//            try{
//                conn c = new conn();
//                String querry = "insert into employee values('"+ename+"', '"+fname+"', '"+mname+"', '"+Address+"', '"+eNid+"', '"+Phone+"', '"+Email+"', '"+Salary+"', '"+Designation+"', '"+dob+"', '"+education+"', '"+eID+"')";
//
//                c.statement.executeUpdate(querry);
//
//                JOptionPane.showMessageDialog(null, "Information Added Successfully");
//                setVisible(false);
//                new Main_Class();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//    }

    public static void main(String[] args) {
        new UpdateDetails("");
    }
}
