package View.FormCashier.component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelUserDetails extends JPanel {

    private final JLabel lblUserIDValue;
    private final JLabel lblUserNameValue;
    public PanelUserDetails() {

        JPanel panel = new JPanel(new GridLayout(4,1));
        //panel.setBorder(new EmptyBorder(10,10,10,10));

        Font font1 = new Font("Arial",Font.BOLD,16);
        Font font2 = new Font("Arial",Font.BOLD,15);

        JLabel lblUserID = new JLabel("User ID :");
        lblUserIDValue = new JLabel(":..");
        lblUserID.setFont(font1);
        lblUserIDValue.setFont(font2);

        JLabel lblUserName = new JLabel("User Name :");
        lblUserNameValue = new JLabel(":..");
        lblUserName.setFont(font1);
        lblUserNameValue.setFont(font2);

        panel.add(lblUserID);
        panel.add(lblUserIDValue);
        panel.add(lblUserName);
        panel.add(lblUserNameValue);

        this.add(panel,BorderLayout.CENTER);

        this.setVisible(true);

    }

    public JLabel getLblUserIDValue() {
        return lblUserIDValue;
    }

    public JLabel getLblUserNameValue() {
        return lblUserNameValue;
    }
}
