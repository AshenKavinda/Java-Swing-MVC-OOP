package View.FormUser.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TextFieldPanel extends JPanel {

    private final JTextField txtName;
    private final JTextField txtNIC;
    private final JComboBox<String> comboType;
    private final JTextField txtPassword;
    private final JComboBox<String> comboIsActive;

    public TextFieldPanel() {
        JLabel lblName = new JLabel("Name");
        JLabel lblNIC = new JLabel("NIC");
        JLabel lblType = new JLabel("Type");
        JLabel lblPassword = new JLabel("password");
        JLabel lblIsActive = new JLabel("Is Active");

        this.txtName = new JTextField();
        this.txtNIC = new JTextField();
        this.comboType = new JComboBox<>();
        ComboBoxModel<String> list = new DefaultComboBoxModel<>(new String[]{"Select","TopBord","Cashier","Inventory"});
        comboType.setModel(list);
        this.txtPassword = new JTextField();
        this.comboIsActive = new JComboBox<>();
        ComboBoxModel<String> isActiveList = new DefaultComboBoxModel<>(new String[]{"False","True"});
        comboIsActive.setModel(isActiveList);
        comboIsActive.setSelectedIndex(1);

        this.setBorder(new EmptyBorder(10,20,10,20));
        this.setLayout(new GridLayout(18,1));

        this.add(lblName);
        this.add(txtName);
        this.add(lblNIC);
        this.add(txtNIC);
        this.add(lblType);
        this.add(comboType);
        this.add(lblPassword);
        this.add(txtPassword);
        this.add(lblIsActive);
        this.add(comboIsActive);
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtNIC() {
        return txtNIC;
    }

    public JComboBox<String> getComboType() {
        return comboType;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public JComboBox<String> getComboIsActive() {
        return comboIsActive;
    }
}
