package View.FormStock;

import Model.Stock.Stock;
import Controller.StockController;
import View.FormStock.Component.ButtonEditorActive;
import View.FormStock.Component.ButtonEditorBack;
import View.FormStock.Component.ButtonRendererActive;
import View.FormStock.Component.ButtonRendererBack;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class FormStock {
    private final FormStockDesigner formStockDesigner;
    private final ButtonEditorActive buttonEditorActive;
    private final ButtonEditorBack buttonEditorBack;
    public FormStock() throws SQLException {
        this.buttonEditorActive = new ButtonEditorActive(new JCheckBox());
        this.buttonEditorBack = new ButtonEditorBack(new JCheckBox());
        this.formStockDesigner = new FormStockDesigner();
        new StockController(this);
        resetAllInputField();
    }

    public ArrayList<Object> getSearchCondition() {
        int searchSelectedIndex = formStockDesigner.getSearchPanel().getComboSearchBy().getSelectedIndex();
        int filterSelectedIndex = formStockDesigner.getSearchPanel().getComboFilter().getSelectedIndex();
        String searchValue = null;
        if (!formStockDesigner.getSearchPanel().getTxtSearch().getText().isEmpty()) {
            searchValue = formStockDesigner.getSearchPanel().getTxtSearch().getText().trim();
        }
        ArrayList<Object> list = new ArrayList<>();
        list.add(searchSelectedIndex);
        list.add(filterSelectedIndex);
        list.add(searchValue);
        return list;
    }

    public boolean validateInputField() {
        boolean validation = true;
        //item code
        if (formStockDesigner.getTextFieldPanel().getTxtItemCode().getText().isEmpty()) {
            formStockDesigner.getTextFieldPanel().getTxtItemCode().setBorder(new LineBorder(Color.RED));
            validation = false ;
        }
        else {
            formStockDesigner.getTextFieldPanel().getTxtItemCode().setBorder(new LineBorder(Color.BLACK));
        }
        //item name
        if (formStockDesigner.getTextFieldPanel().getTxtItemName().getText().isEmpty()) {
            formStockDesigner.getTextFieldPanel().getTxtItemName().setBorder(new LineBorder(Color.RED));
            validation = false ;
        }
        else {
            formStockDesigner.getTextFieldPanel().getTxtItemName().setBorder(new LineBorder(Color.BLACK));
        }
        //unit
        if (Objects.equals(formStockDesigner.getTextFieldPanel().getComboUnit().getSelectedItem(), "Select")) {
            formStockDesigner.getTextFieldPanel().getComboUnit().setBorder(new LineBorder(Color.RED));
            validation = false ;
        }
        else {
            formStockDesigner.getTextFieldPanel().getComboUnit().setBorder(new LineBorder(Color.CYAN));
        }
        //quantity
        if (formStockDesigner.getTextFieldPanel().getTxtQuantity().getText().isEmpty()) {
            formStockDesigner.getTextFieldPanel().getTxtQuantity().setBorder(new LineBorder(Color.RED));
            validation = false ;
        }
        else {
            try {
                Float.parseFloat(formStockDesigner.getTextFieldPanel().getTxtQuantity().getText());
                formStockDesigner.getTextFieldPanel().getTxtQuantity().setBorder(new LineBorder(Color.BLACK));
            }
            catch (Exception ex){
                formStockDesigner.getTextFieldPanel().getTxtQuantity().setBorder(new LineBorder(Color.RED));
                validation = false;
            }
        }
        //cost price
        if (formStockDesigner.getTextFieldPanel().getTxtCostPrice().getText().isEmpty()) {

            formStockDesigner.getTextFieldPanel().getTxtCostPrice().setBorder(new LineBorder(Color.RED));
            validation = false ;
        }
        else {
            try {
                Float.parseFloat(formStockDesigner.getTextFieldPanel().getTxtCostPrice().getText());
                formStockDesigner.getTextFieldPanel().getTxtCostPrice().setBorder(new LineBorder(Color.BLACK));
            }
            catch (Exception ex){
                formStockDesigner.getTextFieldPanel().getTxtCostPrice().setBorder(new LineBorder(Color.RED));
                validation = false;
            }
        }
        //sell price
        if (formStockDesigner.getTextFieldPanel().getTxtSellPrice().getText().isEmpty()) {
            formStockDesigner.getTextFieldPanel().getTxtSellPrice().setBorder(new LineBorder(Color.RED));
            validation = false ;
        }
        else {
            try {
                Float.parseFloat(formStockDesigner.getTextFieldPanel().getTxtSellPrice().getText());
                formStockDesigner.getTextFieldPanel().getTxtSellPrice().setBorder(new LineBorder(Color.BLACK));
            }
            catch (Exception ex){
                formStockDesigner.getTextFieldPanel().getTxtSellPrice().setBorder(new LineBorder(Color.RED));
                validation = false;
            }
        }
        //out
        if (formStockDesigner.getTextFieldPanel().getTxtStockOutLimit().getText().isEmpty()) {
            formStockDesigner.getTextFieldPanel().getTxtStockOutLimit().setBorder(new LineBorder(Color.RED));
            validation = false ;
        }
        else {
            try {
                Float.parseFloat(formStockDesigner.getTextFieldPanel().getTxtStockOutLimit().getText());
                formStockDesigner.getTextFieldPanel().getTxtStockOutLimit().setBorder(new LineBorder(Color.BLACK));
            }
            catch (Exception ex){
                formStockDesigner.getTextFieldPanel().getTxtStockOutLimit().setBorder(new LineBorder(Color.RED));
                validation = false;
            }
        }
        //category
        if (Objects.equals(formStockDesigner.getTextFieldPanel().getComboCategory().getSelectedItem(), "Select")) {
            formStockDesigner.getTextFieldPanel().getComboCategory().setBorder(new LineBorder(Color.RED));
            validation = false ;
        }
        else {
            formStockDesigner.getTextFieldPanel().getComboCategory().setBorder(new LineBorder(Color.CYAN));
        }
        //return
        if (formStockDesigner.getTextFieldPanel().getTxtReturnCount().getText().isEmpty()) {
            formStockDesigner.getTextFieldPanel().getTxtReturnCount().setBorder(new LineBorder(Color.RED));
            validation = false ;
        }
        else {
            try {
                Float.parseFloat(formStockDesigner.getTextFieldPanel().getTxtReturnCount().getText());
                formStockDesigner.getTextFieldPanel().getTxtReturnCount().setBorder(new LineBorder(Color.BLACK));
            }
            catch (Exception ex){
                formStockDesigner.getTextFieldPanel().getTxtReturnCount().setBorder(new LineBorder(Color.RED));
                validation = false;
            }
        }

        //supplier ID
        if (formStockDesigner.getTextFieldPanel().getTxtSupplierID().getText().isEmpty()) {
            formStockDesigner.getTextFieldPanel().getTxtSupplierID().setBorder(new LineBorder(Color.RED));
            validation = false ;
        }
        else {
            try {
                Integer.parseInt(formStockDesigner.getTextFieldPanel().getTxtSupplierID().getText());
                formStockDesigner.getTextFieldPanel().getTxtSupplierID().setBorder(new LineBorder(Color.BLACK));
            }
            catch (Exception ex) {
                formStockDesigner.getTextFieldPanel().getTxtSupplierID().setBorder(new LineBorder(Color.RED));
                validation = false ;
            }
        }
        return validation;
    }

    public void resetAllInputField() {
        formStockDesigner.getTextFieldPanel().getTxtItemCode().setBorder(new LineBorder(Color.BLACK));
        formStockDesigner.getTextFieldPanel().getTxtItemName().setBorder(new LineBorder(Color.BLACK));
        formStockDesigner.getTextFieldPanel().getComboUnit().setBorder(new LineBorder(Color.CYAN));
        formStockDesigner.getTextFieldPanel().getTxtQuantity().setBorder(new LineBorder(Color.BLACK));
        formStockDesigner.getTextFieldPanel().getTxtCostPrice().setBorder(new LineBorder(Color.BLACK));
        formStockDesigner.getTextFieldPanel().getTxtSellPrice().setBorder(new LineBorder(Color.BLACK));
        formStockDesigner.getTextFieldPanel().getTxtStockOutLimit().setBorder(new LineBorder(Color.BLACK));
        formStockDesigner.getTextFieldPanel().getComboCategory().setBorder(new LineBorder(Color.CYAN));
        formStockDesigner.getTextFieldPanel().getTxtReturnCount().setBorder(new LineBorder(Color.BLACK));
        formStockDesigner.getTextFieldPanel().getTxtSupplierID().setBorder(new LineBorder(Color.BLACK));

        formStockDesigner.getTextFieldPanel().getTxtItemCode().setText("");
        formStockDesigner.getTextFieldPanel().getTxtItemName().setText("");
        formStockDesigner.getTextFieldPanel().getComboUnit().setSelectedItem("Select");
        formStockDesigner.getTextFieldPanel().getTxtQuantity().setText("");
        formStockDesigner.getTextFieldPanel().getTxtCostPrice().setText("");
        formStockDesigner.getTextFieldPanel().getTxtSellPrice().setText("");
        formStockDesigner.getTextFieldPanel().getTxtStockOutLimit().setText("");
        formStockDesigner.getTextFieldPanel().getComboCategory().setSelectedItem("Select");
        formStockDesigner.getTextFieldPanel().getTxtReturnCount().setText("");
        formStockDesigner.getTextFieldPanel().getTxtSupplierID().setText("");
    }

    public JButton getBtnSearch() {
        return formStockDesigner.getSearchPanel().getBtnSearch();
    }

    public JButton getBtnAdd() {
        return formStockDesigner.getInputControllerPanel().getBtnAdd();
    }

    public JButton getBtnUpdate() {
        return formStockDesigner.getInputControllerPanel().getBtnUpdate();
    }

    public JButton getBtnClear() {
        return formStockDesigner.getInputControllerPanel().getBtnClear();
    }

    public JButton getBtnEdit() {
        return this.buttonEditorActive.getBtnEdit();
    }

    public JButton getBtnOut() {
        return buttonEditorActive.getBtnOut();
    }

    public JButton getBtnBack() {
        return buttonEditorBack.getBtnBack();
    }

    public JButton getBtnSupplierDetails() {
        return formStockDesigner.getTextFieldPanel().getBtnSDetails();
    }

    public JButton getBtnOpenSupplier() {
        return formStockDesigner.getBtnSupplier();
    }

    public JTextField getTxtSID() {
        return formStockDesigner.getTextFieldPanel().getTxtSupplierID();
    }

    public JTable getTblStock() {
        return formStockDesigner.getStockTable().getTblStock();
    }

    public void setTableModel(DefaultTableModel table) {
        table.addColumn("Action");
        formStockDesigner.getStockTable().getTblStock().setModel(table);
    }

    public int[] getSelectedRow() {
        int[] arr = new int[2];
        int row = formStockDesigner.getStockTable().getTblStock().getSelectedRow();
        int stockID = Integer.parseInt(formStockDesigner.getStockTable().getTblStock().getValueAt(row,0).toString());
        arr[0] = row;
        arr[1] = stockID;
        return arr;
    }

    public void removeRow(int row) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) formStockDesigner.getStockTable().getTblStock().getModel();
            tableModel.removeRow(row);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    public Stock getInputStock() {
        Stock stock = new Stock();
        stock.setItemCode(formStockDesigner.getTextFieldPanel().getTxtItemCode().getText());
        stock.setItemName(formStockDesigner.getTextFieldPanel().getTxtItemName().getText());
        stock.setUnit(Objects.requireNonNull(formStockDesigner.getTextFieldPanel().getComboUnit().getSelectedItem()).toString());
        stock.setQuantity(Float.parseFloat(formStockDesigner.getTextFieldPanel().getTxtQuantity().getText()));
        stock.setSellPrice(Float.parseFloat(formStockDesigner.getTextFieldPanel().getTxtSellPrice().getText()));
        stock.setCostPrice(Float.parseFloat(formStockDesigner.getTextFieldPanel().getTxtCostPrice().getText()));
        stock.setOutOfStockLimit(Integer.parseInt(formStockDesigner.getTextFieldPanel().getTxtStockOutLimit().getText()));
        stock.setCategory(Objects.requireNonNull(formStockDesigner.getTextFieldPanel().getComboCategory().getSelectedItem()).toString());
        stock.setReturnCount(Float.parseFloat(formStockDesigner.getTextFieldPanel().getTxtReturnCount().getText()));
        stock.setSupplierID(Integer.parseInt(formStockDesigner.getTextFieldPanel().getTxtSupplierID().getText()));
        return stock;
    }

    public void setInputStock(Stock stock) {
        formStockDesigner.getTextFieldPanel().getTxtItemCode().setText(stock.getItemCode());
        formStockDesigner.getTextFieldPanel().getTxtItemName().setText(stock.getItemName());
        formStockDesigner.getTextFieldPanel().getComboUnit().setSelectedItem(stock.getUnit());
        formStockDesigner.getTextFieldPanel().getTxtQuantity().setText(String.valueOf(stock.getQuantity()));
        formStockDesigner.getTextFieldPanel().getTxtCostPrice().setText(String.valueOf(stock.getCostPrice()));
        formStockDesigner.getTextFieldPanel().getTxtSellPrice().setText(String.valueOf(stock.getSellPrice()));
        formStockDesigner.getTextFieldPanel().getTxtStockOutLimit().setText(String.valueOf(stock.getOutOfStockLimit()));
        formStockDesigner.getTextFieldPanel().getComboCategory().setSelectedItem(String.valueOf(stock.getCategory()));
        formStockDesigner.getTextFieldPanel().getTxtReturnCount().setText(String.valueOf(stock.getReturnCount()));
        formStockDesigner.getTextFieldPanel().getTxtSupplierID().setText(String.valueOf(stock.getSupplierID()));
    }

    public void setUpdatedRow(int row,Stock stock) {
        formStockDesigner.getStockTable().getTblStock().setValueAt(stock.getItemCode(),row,1);
        formStockDesigner.getStockTable().getTblStock().setValueAt(stock.getItemName(),row,2);
        formStockDesigner.getStockTable().getTblStock().setValueAt(stock.getUnit(),row,3);
        formStockDesigner.getStockTable().getTblStock().setValueAt(stock.getQuantity(),row,4);
        formStockDesigner.getStockTable().getTblStock().setValueAt(stock.getCostPrice(),row,5);
        formStockDesigner.getStockTable().getTblStock().setValueAt(stock.getSellPrice(),row,6);
        formStockDesigner.getStockTable().getTblStock().setValueAt(stock.getOutOfStockLimit(),row,7);
        formStockDesigner.getStockTable().getTblStock().setValueAt(stock.getCategory(),row,8);
        formStockDesigner.getStockTable().getTblStock().setValueAt(stock.getReturnCount(),row,9);
    }

    public void setActiveRenderer() {
        formStockDesigner.getStockTable().getTblStock().getColumn("Action").setCellRenderer(new ButtonRendererActive());
        formStockDesigner.getStockTable().getTblStock().getColumn("Action").setCellEditor(this.buttonEditorActive);
        formStockDesigner.getStockTable().getTblStock().getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    public void setBackRenderer() {
        formStockDesigner.getStockTable().getTblStock().getColumn("Action").setCellRenderer(new ButtonRendererBack());
        formStockDesigner.getStockTable().getTblStock().getColumn("Action").setCellEditor(this.buttonEditorBack);
        formStockDesigner.getStockTable().getTblStock().getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    public int messageBox(String message,String title) {
        return JOptionPane.showConfirmDialog(null,message,title,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    }
    public void messageBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public FormStockDesigner getFormStockDesigner() {
        return formStockDesigner;
    }
}
