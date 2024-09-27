package View.FormCashier.component;

import javax.swing.*;
import java.awt.*;

public class InputPanelCashier extends JPanel {
    public JTextField txtItemCode;
    public JTextField txtQuantity;

    public InputPanelCashier() {
        txtItemCode = new JTextField();
        txtQuantity = new JTextField();
        JLabel lblItemCode = new JLabel("Item Code");
        lblItemCode.setFont(new Font("Arial",Font.BOLD,22));
        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setFont(new Font("Arial",Font.BOLD,22));

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,3,3,3);

        setLayout(gbl);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        add(lblItemCode,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(lblQuantity,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.9;
        gbc.fill = GridBagConstraints.BOTH;
        add(txtItemCode,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(txtQuantity,gbc);

        this.setVisible(true);

    }
}
