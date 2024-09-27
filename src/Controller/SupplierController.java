package Controller;

import Model.Supplier.Supplier;
import Model.Supplier.SupplierDAO;
import Model.User.User;
import Model.User.UserDAO;
import View.FormSupplier.FormSupplier;
import View.FormUser.FormUser;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class SupplierController implements ActionListener {
    private final FormSupplier view;
    private final SupplierDAO model;
    private int selectedRowToEdit;

    public SupplierController(FormSupplier view) throws Exception {
        this.selectedRowToEdit = -1;
        this.view = view;
        this.model = new SupplierDAO();
        view.setTable(model.displayAll());

        view.getBtnSearch().addActionListener(this);
        view.getBtnAdd().addActionListener(this);
        view.getBtnUpdate().addActionListener(this);
        view.getBtnEdit().addActionListener(this);
        view.getBtnDelete().addActionListener(this);
        view.getBtnClear().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("search")) {
            int searchType = view.getComboSearchBy().getSelectedIndex();
            switch (searchType) {
                case 0:
                    try {
                        DefaultTableModel tableModel = model.displayAll();
                        view.setTable(tableModel);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 1:
                    try {
                        DefaultTableModel tableModel = model.displayAllByName(view.getTxtSearchBy().getText());
                        view.setTable(tableModel);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 2:
                    try {
                        DefaultTableModel tableModel = model.displayAllByNIC(view.getTxtSearchBy().getText());
                        view.setTable(tableModel);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
            }
        }

        if (cmd.equals("add")) {
            if (view.isValid()) {
                Supplier supplier = view.getInputData();
                try {
                    boolean rs = model.add(supplier);
                    if (rs) {
                        view.messageBox("Successful");
                        DefaultTableModel tableModel = model.displayAll();
                        view.setTable(tableModel);
                        view.clearInput();
                    }
                    else {
                        view.messageBox("**Unsuccessful**");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        if (cmd.equals("update")) {
            if (view.isValid()) {
                Supplier supplier = view.getInputData();
                if (selectedRowToEdit!=-1) {
                    int uID = Integer.parseInt(view.getTable().getValueAt(selectedRowToEdit,0).toString());
                    supplier.setSupplierID(uID);
                    int con = view.messageBox("Update confirm?(Record: "+uID+" )","Confirm");
                    if (con == 0) {
                        try {
                            boolean rs = model.update(supplier);
                            if (rs) {
                                view.messageBox("Update Successful");
                                view.updateTableRow(selectedRowToEdit,supplier);
                                view.clearInput();
                            } else {
                                view.messageBox("**Update Unsuccessful**");
                            }
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        }

        if (cmd.equals("delete")) {
            int sID = (int) view.getTable().getValueAt(view.getTable().getSelectedRow(),0);
            int re = view.messageBox("Are you want delete "+sID,"Confirm?");
            if (re == 0) {
                try {
                    boolean cmdRe = model.delete(sID);
                    if (cmdRe) {
                        view.messageBox("Delete Successful");
                        DefaultTableModel tableModel = (DefaultTableModel) view.getTable().getModel();
                        tableModel.removeRow(view.getTable().getSelectedRow());
                    }
                    else {
                        view.messageBox("**Delete Unsuccessful**");
                    }
                } catch (Exception ex) {
                    boolean disabled;
                    try {
                        disabled = model.disable(sID);
                    } catch (SQLException exc) {
                        throw new RuntimeException(exc);
                    }
                    if (disabled) {
                        view.messageBox("Disabled Successful");
                        DefaultTableModel tableModel;
                        try {
                            tableModel = model.displayAll();
                        } catch (Exception exc) {
                            throw new RuntimeException(exc);
                        }
                        view.setTable(tableModel);
                    }
                    else {
                        view.messageBox("**Delete Unsuccessful**");
                    }
                }
            }
        }

        if (cmd.equals("clear")) {
            view.clearInput();
        }

        if (cmd.equals("edit")) {
            this.selectedRowToEdit = view.setSelectedRowToInputField();
        }
    }
}

