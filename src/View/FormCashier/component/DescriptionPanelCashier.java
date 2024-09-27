package View.FormCashier.component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Collections;

public class DescriptionPanelCashier extends JPanel {
    public JLabel lblTotalValue;
    public JLabel lblBalanceAmount;
    public JTextField txtCash;
    public DescriptionPanelCashier() {

        setLayout(new GridLayout(12,1));
        setBorder(new EmptyBorder(30,10,10,10));

        JLabel lblTotal = new JLabel("Total :");
        lblTotal.setFont(new Font("Arial",Font.BOLD,25));

        lblTotalValue = new JLabel("......");
        lblTotalValue.setFont(new Font("Arial",Font.BOLD,23));

        JLabel lblCash = new JLabel("Cash : ");
        lblCash.setFont(new Font("Arial",Font.BOLD,22));

        txtCash = new JTextField();
        txtCash.setFont(new Font("Arial",Font.BOLD,20));
        txtCash.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.emptySet());
        txtCash.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, Collections.emptySet());

        lblBalanceAmount = new JLabel("Balance : .......");
        lblBalanceAmount.setFont(new Font("Arial",Font.BOLD,20));

        add(lblTotal);
        add(lblTotalValue);
        add(lblCash);
        add(txtCash);
        add(lblBalanceAmount);

    }
}
