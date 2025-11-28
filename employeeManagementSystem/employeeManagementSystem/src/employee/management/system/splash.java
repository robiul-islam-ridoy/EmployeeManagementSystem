package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame {

    splash() {

        getContentPane().setBackground(DesignSystem.PRIMARY_COLOR);
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 250, 1000, 60);
        heading.setFont(new Font("Raleway", Font.BOLD, 40));
        heading.setForeground(DesignSystem.SECONDARY_COLOR);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);

        JLabel loading = new JLabel("Loading...");
        loading.setBounds(500, 400, 200, 30);
        loading.setFont(DesignSystem.SUBHEADER_FONT);
        loading.setForeground(DesignSystem.WHITE);
        loading.setHorizontalAlignment(SwingConstants.CENTER);
        add(loading);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(285, 450, 600, 10);
        progressBar.setBackground(DesignSystem.PRIMARY_COLOR);
        progressBar.setForeground(DesignSystem.SECONDARY_COLOR);
        progressBar.setBorderPainted(false);
        add(progressBar);

        JLabel developer = new JLabel("Developed By: Robiul Islam Ridoy");
        developer.setBounds(850, 600, 300, 20);
        developer.setFont(new Font("Raleway", Font.PLAIN, 12));
        developer.setForeground(DesignSystem.WHITE);
        developer.setHorizontalAlignment(SwingConstants.RIGHT);
        add(developer);

        setSize(1170, 650);
        setLocation(200, 100);
        setUndecorated(true);
        setVisible(true);

        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(40);
                progressBar.setValue(i);
            }
            setVisible(false);
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new splash();
    }
}
