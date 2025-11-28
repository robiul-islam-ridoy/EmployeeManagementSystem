package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame {

    Main_Class() {
        // Frame setup
        getContentPane().setBackground(DesignSystem.BACKGROUND_COLOR);
        setLayout(null);

        // Header
        JPanel header = new JPanel();
        header.setBackground(DesignSystem.PRIMARY_COLOR);
        header.setBounds(0, 0, 1120, 60);
        header.setLayout(null);
        add(header);

        JLabel title = new JLabel("Employee Management System");
        title.setBounds(20, 10, 400, 40);
        title.setFont(new Font("Raleway", Font.BOLD, 25));
        title.setForeground(DesignSystem.WHITE);
        header.add(title);

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setBackground(DesignSystem.TEXT_COLOR);
        sidebar.setBounds(0, 60, 250, 570);
        sidebar.setLayout(null);
        add(sidebar);

        JLabel welcome = new JLabel("Welcome Admin");
        welcome.setBounds(20, 30, 200, 30);
        welcome.setFont(DesignSystem.SUBHEADER_FONT);
        welcome.setForeground(DesignSystem.WHITE);
        sidebar.add(welcome);

        // Main Content Area - Dashboard Cards
        // Add Employee Card
        createDashboardCard("Add Employee", 300, 100, e -> {
            setVisible(false);
            new AddEmployee();
        });

        // View Employee Card
        createDashboardCard("View Employee", 550, 100, e -> {
            setVisible(false);
            new ViewEmployee();
        });

        // Remove Employee Card
        createDashboardCard("Remove Employee", 800, 100, e -> {
            setVisible(false);
            new RemoveEmployee();
        });

        // Update Details Card (Adding this as it was missing in original but good to
        // have)
        createDashboardCard("Update Details", 300, 250, e -> {
            // Assuming there's a way to select which employee to update,
            // usually UpdateDetails takes an ID or is called from ViewEmployee.
            // For now, let's just link to ViewEmployee as that's the typical flow
            setVisible(false);
            new ViewEmployee();
        });

        setSize(1120, 630);
        setLocation(250, 100);
        setUndecorated(true);
        setVisible(true);
    }

    private void createDashboardCard(String title, int x, int y, ActionListener action) {
        JPanel card = new JPanel();
        card.setBounds(x, y, 200, 120);
        card.setBackground(DesignSystem.WHITE);
        card.setLayout(null);
        // Add subtle border/shadow effect (simulated with border)
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        add(card);

        JLabel cardTitle = new JLabel(title);
        cardTitle.setBounds(10, 20, 180, 30);
        cardTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        cardTitle.setForeground(DesignSystem.TEXT_COLOR);
        cardTitle.setHorizontalAlignment(SwingConstants.CENTER);
        card.add(cardTitle);

        JButton btn = new JButton("Open");
        btn.setBounds(50, 70, 100, 30);
        btn.setBackground(DesignSystem.SECONDARY_COLOR);
        btn.setForeground(DesignSystem.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.addActionListener(action);
        card.add(btn);
    }

    public static void main(String[] args) {
        new Main_Class();
    }
}
