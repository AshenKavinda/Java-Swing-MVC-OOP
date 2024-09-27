package View.LogIn;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FormLogInDesigner extends JFrame {

    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnSubmit;
    public FormLogInDesigner() throws HeadlessException {
        super("Log-In");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        JPanel title = new JPanel(new FlowLayout(FlowLayout.CENTER));
        title.setBorder(new EmptyBorder(20,10,0,10));
        JPanel input = new JPanel(new GridLayout(4, 1));
        input.setBorder(new EmptyBorder(10, 30, 10, 30));
        JPanel submit = new JPanel(new FlowLayout());
        submit.setBorder(new EmptyBorder(10,10,10,10));


        JLabel lblTitle = new JLabel("Log-In");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 18));

        this.txtUsername = new JTextField();
        this.txtPassword = new JPasswordField();

        this.btnSubmit = new JButton("Submit");
        this.btnSubmit.setActionCommand("submit");

        submit.add(btnSubmit);

        title.add(lblTitle);

        input.add(lblUsername);
        input.add(txtUsername);
        input.add(lblPassword);
        input.add(txtPassword);

        this.add(title,BorderLayout.NORTH);
        this.add(input,BorderLayout.CENTER);
        this.add(submit,BorderLayout.SOUTH);

        this.setVisible(true);

    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }
}
