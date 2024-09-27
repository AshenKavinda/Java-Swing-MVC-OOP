package View.FormCashier;

import Controller.CashierController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class FormCashier {
    private final FormCashierDesigner formCashierDesigner;
    private final int cashierID;
    public FormCashier(int cashierID) throws SQLException {
        this.cashierID = cashierID;
        formCashierDesigner = new FormCashierDesigner();
        formCashierDesigner.initializeComponent();
        new CashierController(this);
        resetInputField();
    }

    public int getCashierID() {
        return cashierID;
    }

    public JLabel getLblCashierIDValue() {
        return formCashierDesigner.getPanelUserDetails().getLblUserIDValue();
    }

    public JLabel getLblCashierNameValue() {
        return formCashierDesigner.getPanelUserDetails().getLblUserNameValue();
    }

    public boolean validateInputField() {
        boolean isValid = true;
        if (getTxtItemCode().getText().isEmpty()){
            getTxtItemCode().setBorder(new LineBorder(Color.red));
            isValid = false;
        }
        else {
            getTxtItemCode().setBorder(new LineBorder(Color.black));
        }
        if (getTxtQuantity().getText().isEmpty()) {
            getTxtQuantity().setBorder(new LineBorder(Color.RED));
            isValid = false;
        }
        else {
            try {
                Float.parseFloat(getTxtQuantity().getText());
                getTxtQuantity().setBorder(new LineBorder(Color.black));
            }catch (Exception ex) {
                getTxtQuantity().setBorder(new LineBorder(Color.red));
                isValid = false;
            }
        }
        return isValid;
    }

    public void resetInputField() {
        getTxtQuantity().setBorder(new LineBorder(Color.black));
        getTxtItemCode().setBorder(new LineBorder(Color.black));
        getTxtQuantity().setText("");
        getTxtItemCode().setText("");
        getTxtItemCode().grabFocus();
    }

    public void resetDescriptionPanelCashier() {
        formCashierDesigner.getDescriptionPanelCashier().txtCash.setText("");
        formCashierDesigner.getDescriptionPanelCashier().txtCash.setBorder(new LineBorder(Color.black));
        formCashierDesigner.getDescriptionPanelCashier().lblBalanceAmount.setText("Balance: .......");
        formCashierDesigner.getDescriptionPanelCashier().lblTotalValue.setText("......");
    }

    public JTextField getTxtQuantity() {
        return formCashierDesigner.getInputPanel().txtQuantity;
    }

    public JTextField getTxtItemCode() {
        return formCashierDesigner.getInputPanel().txtItemCode;
    }

    public JTable getTable() {
        return formCashierDesigner.getTablePanelCashier().table;
    }

    public JTextField getTxtCash() {
        return formCashierDesigner.getDescriptionPanelCashier().txtCash;
    }

    public void setLblBalance(float balance) {
        formCashierDesigner.getDescriptionPanelCashier().lblBalanceAmount.setText("Balance : "+ Math.round(balance * 100.0) / 100.0);
    }

    public void updateTable(DefaultTableModel model) {
        formCashierDesigner.getTablePanelCashier().table.setModel(model);
    }

    public void setTotalBill(float total) {
        formCashierDesigner.getDescriptionPanelCashier().lblTotalValue.setText(Float.toString(total));
    }

    public int messageBox(String message,String title) {
        return JOptionPane.showConfirmDialog(null,message,title,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    }
    public void messageBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
