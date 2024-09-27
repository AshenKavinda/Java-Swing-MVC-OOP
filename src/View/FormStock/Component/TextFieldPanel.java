package View.FormStock.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TextFieldPanel extends JPanel {

    private final JTextField txtItemCode;
    private final JTextField txtItemName;
    private final JComboBox<String> comboUnit;
    private final JTextField txtQuantity;
    private final JTextField txtCostPrice;
    private final JTextField txtSellPrice;
    private final JTextField txtStockOutLimit;
    private final JComboBox<String> comboCategory;
    private final JTextField txtReturnCount;
    private final JTextField txtSupplierID;
    private final JButton btnSDetails;

    public TextFieldPanel() {
        String[] categories = new String[]{
                "Select",
                "Beverages", "Fruits", "Meat", "Cleaning", "Dairy",
                "Baking", "Condiments", "Frozen", "Vegetables",
                "Groceries", "Grains", "Snacks", "Spices", "Bakery"
        };
        String[] units = new String[]{
                "Select",
                "Bottle", "Kg", "Dozen", "Jar", "Tub", "Pack",
                "Piece", "Liter", "Loaf", "Cup", "Can"
        };

        JLabel lblItemCode = new JLabel("Item Code");
        JLabel lblItemName = new JLabel("Item Name");
        JLabel lblUnit = new JLabel("Unit");
        JLabel lblQuantity = new JLabel("Quantity");
        JLabel lblCostPrice = new JLabel("Cost Price");
        JLabel lblSellPrice = new JLabel("Sell Price");
        JLabel lblStockOutLimit = new JLabel("Stock Out Limit");
        JLabel lblCategory = new JLabel("Category");
        JLabel lblReturnCount = new JLabel("Return Count");
        JLabel lblSupplier = new JLabel("Supplier");

        this.txtItemCode = new JTextField();
        this.txtItemName = new JTextField();
        this.comboUnit = new JComboBox<>(units);
        this.txtQuantity = new JTextField();
        this.txtCostPrice = new JTextField();
        this.txtSellPrice = new JTextField();
        this.txtStockOutLimit = new JTextField();
        this.comboCategory = new JComboBox<>(categories);
        this.txtReturnCount = new JTextField();
        this.txtSupplierID = new JTextField();

        this.btnSDetails = new JButton("Details");
        btnSDetails.setActionCommand("supplierDetails");
        btnSDetails.setFocusPainted(false);

        //style
        setBorder(new EmptyBorder(10,20,10,20));

        //
        setLayout(new GridLayout(20,1));
        add(lblItemCode);
        add(txtItemCode);
        add(lblItemName);
        add(txtItemName);
        add(lblUnit);
        add(comboUnit);
        add(lblQuantity);
        add(txtQuantity);
        add(lblCostPrice);
        add(txtCostPrice);
        add(lblSellPrice);
        add(txtSellPrice);
        add(lblStockOutLimit);
        add(txtStockOutLimit);
        add(lblCategory);
        add(comboCategory);
        add(lblReturnCount);
        add(txtReturnCount);
        add(lblSupplier);
        JPanel sPanel = new JPanel(new BorderLayout());
        sPanel.add(txtSupplierID,BorderLayout.CENTER);
        sPanel.add(btnSDetails,BorderLayout.EAST);
        add(sPanel);


    }

    public JTextField getTxtItemCode() {
        return txtItemCode;
    }

    public JTextField getTxtItemName() {
        return txtItemName;
    }

    public JComboBox<String> getComboUnit() {
        return comboUnit;
    }

    public JTextField getTxtQuantity() {
        return txtQuantity;
    }

    public JTextField getTxtCostPrice() {
        return txtCostPrice;
    }

    public JTextField getTxtSellPrice() {
        return txtSellPrice;
    }

    public JTextField getTxtStockOutLimit() {
        return txtStockOutLimit;
    }

    public JComboBox<String> getComboCategory() {
        return comboCategory;
    }

    public JTextField getTxtReturnCount() {
        return txtReturnCount;
    }

    public JTextField getTxtSupplierID() {
        return txtSupplierID;
    }

    public JButton getBtnSDetails() {
        return btnSDetails;
    }
}
