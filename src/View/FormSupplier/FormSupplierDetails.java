package View.FormSupplier;

import Model.Supplier.Supplier;
import Model.Supplier.SupplierDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class FormSupplierDetails extends JFrame {

    public FormSupplierDetails(int supplierID) throws SQLException {
        setTitle("Supplier Details");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        SupplierDAO supplierDAO = new SupplierDAO();
        Supplier supplier = supplierDAO.searchBySID(supplierID);

        if (supplier != null) {
            JPanel panel = new JPanel(new GridLayout(6, 2));
            panel.setBorder(new EmptyBorder(20,20,20,20));

            panel.add(new JLabel("Name:"));
            JLabel lblName = new JLabel(supplier.getName());
            panel.add(lblName);

            panel.add(new JLabel("NIC:"));
            JLabel lblNic = new JLabel(supplier.getNic());
            panel.add(lblNic);

            panel.add(new JLabel("Phone 1:"));
            JLabel lblPhone1 = new JLabel(supplier.getPhone1());
            panel.add(lblPhone1);

            panel.add(new JLabel("Phone 2:"));
            JLabel lblPhone2 = new JLabel(supplier.getPhone2());
            panel.add(lblPhone2);

            panel.add(new JLabel("Email:"));
            JLabel lblEmail = new JLabel(supplier.getEmail());
            panel.add(lblEmail);

            panel.add(new JLabel("Is Active:"));
            JLabel lblIsActive = new JLabel(supplier.getIsActive() == 1 ? "Active" : "Inactive");
            panel.add(lblIsActive);

            add(panel,BorderLayout.CENTER);
            this.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Supplier not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

