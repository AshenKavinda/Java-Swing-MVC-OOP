package View.FormSupplier.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SupplierTextFieldPanel extends JPanel {

    private final JTextField txtName;
    private final JTextField txtNIC;
    private final JTextField txtPhone1;
    private final JTextField txtPhone2;
    private final JTextField txtEmail;
    private final JComboBox<String> comboIsActive;

    public SupplierTextFieldPanel() {
        JLabel lblName = new JLabel("Name");
        JLabel lblNIC = new JLabel("NIC");
        JLabel lblPhone1 = new JLabel("Phone 1");
        JLabel lblPhone2 = new JLabel("Phone 2");
        JLabel lblEmail = new JLabel("Email");
        JLabel lblIsActive = new JLabel("Is Active");

        this.txtName = new JTextField();
        this.txtNIC = new JTextField();
        this.txtPhone1 = new JTextField();
        this.txtPhone2 = new JTextField();
        this.txtEmail = new JTextField();
        this.comboIsActive = new JComboBox<>();
        ComboBoxModel<String> isActiveList = new DefaultComboBoxModel<>(new String[]{"False", "True"});
        comboIsActive.setModel(isActiveList);
        comboIsActive.setSelectedIndex(1);

        this.setBorder(new EmptyBorder(10, 20, 10, 20));
        this.setLayout(new GridLayout(18, 1));

        this.add(lblName);
        this.add(txtName);
        this.add(lblNIC);
        this.add(txtNIC);
        this.add(lblPhone1);
        this.add(txtPhone1);
        this.add(lblPhone2);
        this.add(txtPhone2);
        this.add(lblEmail);
        this.add(txtEmail);
        this.add(lblIsActive);
        this.add(comboIsActive);
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtNIC() {
        return txtNIC;
    }

    public JTextField getTxtPhone1() {
        return txtPhone1;
    }

    public JTextField getTxtPhone2() {
        return txtPhone2;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JComboBox<String> getComboIsActive() {
        return comboIsActive;
    }
}
