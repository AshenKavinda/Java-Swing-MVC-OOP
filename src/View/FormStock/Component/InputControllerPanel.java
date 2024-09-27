package View.FormStock.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InputControllerPanel extends JPanel {

    private final JButton btnClear;
    private final JButton btnAdd;
    private final JButton btnUpdate;
    public InputControllerPanel() {

        Font font = new Font("Arial",Font.BOLD,15);

        btnAdd = new JButton("Add");
        btnAdd.setActionCommand("add");
        btnAdd.setFocusPainted(false);

        btnClear = new JButton("Clear");
        btnClear.setActionCommand("clear");
        btnClear.setFocusPainted(false);

        btnUpdate = new JButton("Update");
        btnUpdate.setActionCommand("update");
        btnUpdate.setFocusPainted(false);


        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(null);
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,5,2));
        rightPanel.setBackground(null);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        setLayout(gbl);

        gbc.gridx = 0;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        leftPanel.add(btnClear);
        this.add(leftPanel,gbc);

        gbc.gridx = 1;
        rightPanel.add(btnUpdate);
        rightPanel.add(btnAdd);
        this.add(rightPanel,gbc);



        this.setBorder(new EmptyBorder(10,10,10,10));
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }
}
