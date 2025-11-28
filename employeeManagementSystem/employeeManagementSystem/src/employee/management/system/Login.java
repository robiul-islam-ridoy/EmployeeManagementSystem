package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JTextField uName;
    JPasswordField uPassword;
    JButton loginBtn, backBtn;

    Login() {
        
        getContentPane().setBackground(DesignSystem.WHITE);
        setLayout(null);

        
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(DesignSystem.PRIMARY_COLOR);
        leftPanel.setBounds(0, 0, 250, 400);
        leftPanel.setLayout(null);
        add(leftPanel);

        JLabel logoLabel = new JLabel("EMS");
        logoLabel.setBounds(25, 100, 200, 50);
        logoLabel.setFont(new Font("Raleway", Font.BOLD, 40));
        logoLabel.setForeground(DesignSystem.SECONDARY_COLOR);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(logoLabel);

        JLabel subtitleLabel = new JLabel("Employee Management");
        subtitleLabel.setBounds(25, 150, 200, 30);
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(200, 200, 200));
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(subtitleLabel);

        
        JLabel heading = new JLabel("Login");
        heading.setBounds(350, 30, 200, 40);
        heading.setFont(DesignSystem.HEADER_FONT);
        heading.setForeground(DesignSystem.PRIMARY_COLOR);
        add(heading);

        
        JLabel exit = new JLabel("X");
        exit.setBounds(570, 10, 20, 30);
        exit.setFont(new Font("Tahoma", Font.BOLD, 20));
        exit.setForeground(DesignSystem.PRIMARY_COLOR);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
        add(exit);

        JLabel userName = new JLabel("Username");
        userName.setBounds(300, 90, 100, 20);
        userName.setFont(DesignSystem.BODY_FONT);
        add(userName);

        uName = new JTextField();
        uName.setBounds(300, 120, 250, 30);
        uName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(uName);

        JLabel password = new JLabel("Password");
        password.setBounds(300, 170, 100, 20);
        password.setFont(DesignSystem.BODY_FONT);
        add(password);

        uPassword = new JPasswordField();
        uPassword.setBounds(300, 200, 250, 30);
        uPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(uPassword);

        loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(300, 260, 110, 35);
        loginBtn.setBackground(DesignSystem.PRIMARY_COLOR);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(DesignSystem.BUTTON_FONT);
        loginBtn.setFocusPainted(false);
        loginBtn.addActionListener(this);
        add(loginBtn);

        backBtn = new JButton("BACK");
        backBtn.setBounds(440, 260, 110, 35);
        backBtn.setBackground(DesignSystem.BACKGROUND_COLOR);
        backBtn.setForeground(DesignSystem.TEXT_COLOR);
        backBtn.setFont(DesignSystem.BUTTON_FONT);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(this);
        add(backBtn);

        setSize(600, 400);
        setLocation(450, 200);
        setUndecorated(true); 
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            try {
                String username = uName.getText();
                @SuppressWarnings("deprecation")
                String password = uPassword.getText();

                conn connection = new conn();
                String query = "select * from login where username = '" + username + "' and password = '" + password
                        + "'";

                ResultSet resultSet = connection.statement.executeQuery(query);

                if (resultSet.next()) {
                    setVisible(false);
                    new Main_Class();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

            } catch (Exception n) {
                n.printStackTrace();
            }

        } else if (e.getSource() == backBtn) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
