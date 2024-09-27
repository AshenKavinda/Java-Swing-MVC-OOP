package View.FormUser;

import Model.User.User;
import Controller.UserController;
import View.FormUser.Component.ButtonEditorActive;
import View.FormUser.Component.ButtonRendererActive;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Objects;

public class FormUser {
    private final FormUserDesigner formUserDesigner;
    private final ButtonEditorActive tableEditor;
    public FormUser() throws Exception {
        formUserDesigner = new FormUserDesigner();
        tableEditor = new ButtonEditorActive(new JCheckBox());
        clearInput();
        new UserController(this);
    }

    public JButton getBtnAdd() {
        return formUserDesigner.getInputControllerPanel().getBtnAdd();
    }

    public JButton getBtnUpdate() {
        return formUserDesigner.getInputControllerPanel().getBtnUpdate();
    }

    public JButton getBtnClear() {
        return formUserDesigner.getInputControllerPanel().getBtnClear();
    }

    public JButton getBtnSearch() {
        return formUserDesigner.getSearchPanel().getBtnSearch();
    }

    public JButton getBtnEdit() {
        return tableEditor.getBtnEdit();
    }

    public JButton getBtnDelete() {
        return tableEditor.getBtnDelete();
    }

    public JTextField getTxtSearchBy() {
        return formUserDesigner.getSearchPanel().getTxtSearch();
    }

    public JComboBox<String> getComboSearchBy() {
        return formUserDesigner.getSearchPanel().getComboSearchBy();
    }

    public JTable getTblUser() {
        return formUserDesigner.getUserTable().getTblUser();
    }

    public void setTblUser(DefaultTableModel tableModel) {
        formUserDesigner.getUserTable().getTblUser().setModel(tableModel);
        tableModel.addColumn("Action");
        formUserDesigner.getUserTable().getTblUser().getColumn("Action").setCellRenderer(new ButtonRendererActive());
        formUserDesigner.getUserTable().getTblUser().getColumn("Action").setCellEditor(this.tableEditor);
    }

    public int setSelectedRowToInputField() {
        int row = formUserDesigner.getUserTable().getTblUser().getSelectedRow();
        formUserDesigner.getTextFieldPanel().getTxtName().setText(formUserDesigner.getUserTable().getTblUser().getValueAt(row,1).toString());
        formUserDesigner.getTextFieldPanel().getTxtNIC().setText(formUserDesigner.getUserTable().getTblUser().getValueAt(row,2).toString());
        formUserDesigner.getTextFieldPanel().getComboType().setSelectedItem(formUserDesigner.getUserTable().getTblUser().getValueAt(row,3));
        formUserDesigner.getTextFieldPanel().getTxtPassword().setText(formUserDesigner.getUserTable().getTblUser().getValueAt(row,4).toString());
        formUserDesigner.getTextFieldPanel().getComboIsActive().setSelectedIndex((int) formUserDesigner.getUserTable().getTblUser().getValueAt(row,5));
        return row;
    }

    public User getInputData() {
        User user = new User();
        user.setName(formUserDesigner.getTextFieldPanel().getTxtName().getText());
        user.setNic(formUserDesigner.getTextFieldPanel().getTxtNIC().getText());
        user.setType(String.valueOf(formUserDesigner.getTextFieldPanel().getComboType().getSelectedItem()));
        user.setPassword(formUserDesigner.getTextFieldPanel().getTxtPassword().getText());
        user.setIsActive(formUserDesigner.getTextFieldPanel().getComboIsActive().getSelectedIndex());
        return user;
    }

    public void updateTableRow(int row,User user) {
        formUserDesigner.getUserTable().getTblUser().setValueAt(user.getuID(),row,0);
        formUserDesigner.getUserTable().getTblUser().setValueAt(user.getName(),row,1);
        formUserDesigner.getUserTable().getTblUser().setValueAt(user.getNic(),row,2);
        formUserDesigner.getUserTable().getTblUser().setValueAt(user.getType(),row,3);
        formUserDesigner.getUserTable().getTblUser().setValueAt(user.getPassword(),row,4);
        formUserDesigner.getUserTable().getTblUser().setValueAt(user.getIsActive(),row,5);
    }

    public boolean isValid() {
        boolean isValid = true;
        if (formUserDesigner.getTextFieldPanel().getTxtName().getText().isEmpty()) {
            formUserDesigner.getTextFieldPanel().getTxtName().setBorder(new LineBorder(Color.red));
            isValid = false;
        }else {
            formUserDesigner.getTextFieldPanel().getTxtName().setBorder(new LineBorder(Color.black));
        }

        if (formUserDesigner.getTextFieldPanel().getTxtNIC().getText().isEmpty()) {
            formUserDesigner.getTextFieldPanel().getTxtNIC().setBorder(new LineBorder(Color.red));
            isValid = false;
        }else {
            formUserDesigner.getTextFieldPanel().getTxtNIC().setBorder(new LineBorder(Color.black));
        }

        if (Objects.equals(formUserDesigner.getTextFieldPanel().getComboType().getSelectedItem(), "Select")) {
            formUserDesigner.getTextFieldPanel().getComboType().setBorder(new LineBorder(Color.red));
            isValid = false;
        }else {
            formUserDesigner.getTextFieldPanel().getComboType().setBorder(new LineBorder(Color.cyan));
        }

        if (formUserDesigner.getTextFieldPanel().getTxtPassword().getText().isEmpty()) {
            formUserDesigner.getTextFieldPanel().getTxtPassword().setBorder(new LineBorder(Color.red));
            isValid = false;
        }else {
            formUserDesigner.getTextFieldPanel().getTxtPassword().setBorder(new LineBorder(Color.black));
        }
        return isValid;
    }

    public void clearInput(){

        formUserDesigner.getTextFieldPanel().getTxtName().setBorder(new LineBorder(Color.black));
        formUserDesigner.getTextFieldPanel().getTxtNIC().setBorder(new LineBorder(Color.black));
        formUserDesigner.getTextFieldPanel().getComboType().setBorder(new LineBorder(Color.cyan));
        formUserDesigner.getTextFieldPanel().getTxtPassword().setBorder(new LineBorder(Color.black));

        formUserDesigner.getTextFieldPanel().getTxtName().setText("");
        formUserDesigner.getTextFieldPanel().getTxtNIC().setText("");
        formUserDesigner.getTextFieldPanel().getComboType().setSelectedItem("Select");
        formUserDesigner.getTextFieldPanel().getTxtPassword().setText("");
        formUserDesigner.getTextFieldPanel().getComboIsActive().setSelectedIndex(1);
    }

    public int messageBox(String message,String title) {
        return JOptionPane.showConfirmDialog(null,message,title,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    }
    public void messageBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
