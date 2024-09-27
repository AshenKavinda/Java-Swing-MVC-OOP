package View.FormUser.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InputControllerPanel extends JPanel {

    public JButton btnClear;
    public JButton btnAdd;
    public JButton btnUpdate;
    public InputControllerPanel() {
        btnAdd = new JButton("Add");
        btnAdd.setActionCommand("add");
        btnClear = new JButton("Clear");
        btnClear.setActionCommand("clear");
        btnUpdate = new JButton("Update");
        btnUpdate.setActionCommand("update");

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,5,2));

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
        this.setVisible(true);
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
