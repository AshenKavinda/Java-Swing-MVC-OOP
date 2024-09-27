package View.FormSupplier;

import Controller.SupplierController;
import Controller.UserController;
import Model.Supplier.Supplier;
import Model.User.User;
import View.FormSupplier.Component.ButtonEditorActive;
import View.FormSupplier.Component.ButtonRendererActive;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormSupplier {
    private final FormSupplierDesigner formSupplierDesigner;
    private final ButtonEditorActive tableEditor;
    public FormSupplier() throws Exception {
        formSupplierDesigner = new FormSupplierDesigner();
        tableEditor = new ButtonEditorActive(new JCheckBox());
        clearInput();
        new SupplierController(this);
    }

    public JButton getBtnAdd() {
        return formSupplierDesigner.getInputControllerPanel().getBtnAdd();
    }

    public JButton getBtnUpdate() {
        return formSupplierDesigner.getInputControllerPanel().getBtnUpdate();
    }

    public JButton getBtnClear() {
        return formSupplierDesigner.getInputControllerPanel().getBtnClear();
    }

    public JButton getBtnSearch() {
        return formSupplierDesigner.getSearchPanel().getBtnSearch();
    }

    public JButton getBtnEdit() {
        return tableEditor.getBtnEdit();
    }

    public JButton getBtnDelete() {
        return tableEditor.getBtnDelete();
    }

    public JTextField getTxtSearchBy() {
        return formSupplierDesigner.getSearchPanel().getTxtSearch();
    }

    public JComboBox<String> getComboSearchBy() {
        return formSupplierDesigner.getSearchPanel().getComboSearchBy();
    }

    public JTable getTable() {
        return formSupplierDesigner.getSupplierTable().getTable();
    }

    public void setTable(DefaultTableModel tableModel) {
        formSupplierDesigner.getSupplierTable().getTable().setModel(tableModel);
        tableModel.addColumn("Action");
        formSupplierDesigner.getSupplierTable().getTable().getColumn("Action").setCellRenderer(new ButtonRendererActive());
        formSupplierDesigner.getSupplierTable().getTable().getColumn("Action").setCellEditor(this.tableEditor);
    }

    public int setSelectedRowToInputField() {
        int row = formSupplierDesigner.getSupplierTable().getTable().getSelectedRow();
        formSupplierDesigner.getTextFieldPanel().getTxtName().setText(formSupplierDesigner.getSupplierTable().getTable().getValueAt(row,1).toString());
        formSupplierDesigner.getTextFieldPanel().getTxtNIC().setText(formSupplierDesigner.getSupplierTable().getTable().getValueAt(row,2).toString());
        formSupplierDesigner.getTextFieldPanel().getTxtPhone1().setText(formSupplierDesigner.getSupplierTable().getTable().getValueAt(row,3).toString());
        formSupplierDesigner.getTextFieldPanel().getTxtPhone2().setText(formSupplierDesigner.getSupplierTable().getTable().getValueAt(row,4).toString());
        formSupplierDesigner.getTextFieldPanel().getTxtEmail().setText(formSupplierDesigner.getSupplierTable().getTable().getValueAt(row,5).toString());
        formSupplierDesigner.getTextFieldPanel().getComboIsActive().setSelectedIndex((int) formSupplierDesigner.getSupplierTable().getTable().getValueAt(row,6));
        return row;
    }

    public Supplier getInputData() {
        Supplier supplier = new Supplier();
        supplier.setName(formSupplierDesigner.getTextFieldPanel().getTxtName().getText());
        supplier.setNic(formSupplierDesigner.getTextFieldPanel().getTxtNIC().getText());
        supplier.setPhone1(formSupplierDesigner.getTextFieldPanel().getTxtPhone1().getText());
        supplier.setPhone2(formSupplierDesigner.getTextFieldPanel().getTxtPhone2().getText());
        supplier.setEmail(formSupplierDesigner.getTextFieldPanel().getTxtEmail().getText());
        supplier.setIsActive(formSupplierDesigner.getTextFieldPanel().getComboIsActive().getSelectedIndex());
        return supplier;
    }

    public void updateTableRow(int row,Supplier supplier) {
        formSupplierDesigner.getSupplierTable().getTable().setValueAt(supplier.getSupplierID(),row,0);
        formSupplierDesigner.getSupplierTable().getTable().setValueAt(supplier.getName(),row,1);
        formSupplierDesigner.getSupplierTable().getTable().setValueAt(supplier.getNic(),row,2);
        formSupplierDesigner.getSupplierTable().getTable().setValueAt(supplier.getPhone1(),row,3);
        formSupplierDesigner.getSupplierTable().getTable().setValueAt(supplier.getPhone2(),row,4);
        formSupplierDesigner.getSupplierTable().getTable().setValueAt(supplier.getEmail(),row,5);
        formSupplierDesigner.getSupplierTable().getTable().setValueAt(supplier.getIsActive(),row,6);
    }

    public boolean isValid() {
        boolean isValid = true;
        if (formSupplierDesigner.getTextFieldPanel().getTxtName().getText().isEmpty()) {
            formSupplierDesigner.getTextFieldPanel().getTxtName().setBorder(new LineBorder(Color.red));
            isValid = false;
        }else {
            formSupplierDesigner.getTextFieldPanel().getTxtName().setBorder(new LineBorder(Color.black));
        }

        if (formSupplierDesigner.getTextFieldPanel().getTxtNIC().getText().isEmpty()) {
            formSupplierDesigner.getTextFieldPanel().getTxtNIC().setBorder(new LineBorder(Color.red));
            isValid = false;
        }else {
            formSupplierDesigner.getTextFieldPanel().getTxtNIC().setBorder(new LineBorder(Color.black));
        }

        if (formSupplierDesigner.getTextFieldPanel().getTxtPhone1().getText().isEmpty()) {
            formSupplierDesigner.getTextFieldPanel().getTxtPhone1().setBorder(new LineBorder(Color.red));
            isValid = false;
        }else {
            Pattern pattern = Pattern.compile("^[0-9]*$");
            Matcher matcher = pattern.matcher(formSupplierDesigner.getTextFieldPanel().getTxtPhone1().getText());
            if (matcher.matches()) {
                formSupplierDesigner.getTextFieldPanel().getTxtPhone1().setBorder(new LineBorder(Color.black));
            }
            else {
                formSupplierDesigner.getTextFieldPanel().getTxtPhone1().setBorder(new LineBorder(Color.black));
            }
        }

        if (formSupplierDesigner.getTextFieldPanel().getTxtPhone2().getText().isEmpty()) {
            formSupplierDesigner.getTextFieldPanel().getTxtPhone2().setBorder(new LineBorder(Color.red));
            isValid = false;
        }else {
            Pattern pattern = Pattern.compile("^[0-9]*$");
            Matcher matcher = pattern.matcher(formSupplierDesigner.getTextFieldPanel().getTxtPhone2().getText());
            if (matcher.matches()) {
                formSupplierDesigner.getTextFieldPanel().getTxtPhone2().setBorder(new LineBorder(Color.black));
            }
            else {
                formSupplierDesigner.getTextFieldPanel().getTxtPhone2().setBorder(new LineBorder(Color.black));
            }
        }

        return isValid;
    }

    public void clearInput(){
        formSupplierDesigner.getTextFieldPanel().getTxtName().setBorder(new LineBorder(Color.black));
        formSupplierDesigner.getTextFieldPanel().getTxtNIC().setBorder(new LineBorder(Color.black));
        formSupplierDesigner.getTextFieldPanel().getTxtPhone1().setBorder(new LineBorder(Color.black));
        formSupplierDesigner.getTextFieldPanel().getTxtPhone2().setBorder(new LineBorder(Color.black));
        formSupplierDesigner.getTextFieldPanel().getTxtEmail().setBorder(new LineBorder(Color.black));

        formSupplierDesigner.getTextFieldPanel().getTxtName().setText("");
        formSupplierDesigner.getTextFieldPanel().getTxtNIC().setText("");
        formSupplierDesigner.getTextFieldPanel().getTxtPhone1().setText("");
        formSupplierDesigner.getTextFieldPanel().getTxtPhone2().setText("");
        formSupplierDesigner.getTextFieldPanel().getTxtEmail().setText("");
        formSupplierDesigner.getTextFieldPanel().getComboIsActive().setSelectedIndex(1);
    }

    public int messageBox(String message,String title) {
        return JOptionPane.showConfirmDialog(null,message,title,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    }
    public void messageBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
