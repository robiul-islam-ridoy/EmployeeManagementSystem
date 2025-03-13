package employee.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

    JTextField uName;
    JPasswordField uPassword;
    JButton loginBtn, backBtn;

    Login(){
        JLabel userName = new JLabel("User Name: ");
        userName.setBounds(40,20,100,30);
        add(userName);

        uName = new JTextField();
        uName.setBounds(150, 20, 150, 30);
        add(uName);

        JLabel password = new JLabel("Password: ");
        password.setBounds(40,70,100,30);
        add(password);

        uPassword = new JPasswordField();
        uPassword.setBounds(150, 70, 150, 30);
        add(uPassword);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(150, 140, 150, 30);
        loginBtn.setBackground(Color.LIGHT_GRAY);
        loginBtn.setForeground(Color.BLACK);
        loginBtn.addActionListener(this);
        add(loginBtn); 

        backBtn = new JButton("Back");
        backBtn.setBounds(150, 180, 150, 30);
        backBtn.setBackground(Color.LIGHT_GRAY);
        backBtn.setForeground(Color.BLACK);
        backBtn.addActionListener(this);
        add(backBtn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/loginBG.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel loginBG = new JLabel(i3);
        loginBG.setBounds(0, 0, 600,300);
        add(loginBG);


        setSize(600, 300);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginBtn){

            try {
                String username = uName.getText();
                @SuppressWarnings("deprecation")
                String password = uPassword.getText();

                conn connection = new conn();

                String querry = "select * from login where username = '"+username+"' and password = '"+password+"'";

                ResultSet resultSet = connection.statement.executeQuery(querry);

                if (resultSet.next()) {
                    setVisible(false);
                    new Main_Class();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid UserName Or Password.");
                }
                
            } catch (Exception n) {
                n.printStackTrace();
            }

        }else if(e.getSource() == backBtn){
            System.exit(200);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
    
}
