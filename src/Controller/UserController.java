package Controller;

import Model.User.User;
import Model.User.UserDAO;
import View.FormUser.FormUser;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class UserController implements ActionListener {
    private final FormUser view;
    private final UserDAO model;
    private int selectedRowToEdit;

    public UserController(FormUser view) throws Exception {
        this.selectedRowToEdit = -1;
        this.view = view;
        this.model = new UserDAO();
        view.setTblUser(model.displayAll());

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
                        view.setTblUser(tableModel);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 1:
                    try {
                        DefaultTableModel tableModel = model.displayAllByName(view.getTxtSearchBy().getText());
                        view.setTblUser(tableModel);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case 2:
                    try {
                        DefaultTableModel tableModel = model.displayAllByNIC(view.getTxtSearchBy().getText());
                        view.setTblUser(tableModel);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
            }
        }

        if (cmd.equals("add")) {
            if (view.isValid()) {
                User user = view.getInputData();
                try {
                    boolean rs = model.add(user);
                    if (rs) {
                        view.messageBox("Successful");
                        DefaultTableModel tableModel = model.displayAll();
                        view.setTblUser(tableModel);
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
                User user = view.getInputData();
                if (selectedRowToEdit!=-1) {
                    int uID = Integer.parseInt(view.getTblUser().getValueAt(selectedRowToEdit,0).toString());
                    user.setuID(uID);
                    int con = view.messageBox("Update confirm?(Record: "+uID+" )","Confirm");
                    if (con == 0) {
                        try {
                            boolean rs = model.update(user);
                            if (rs) {
                                view.messageBox("Update Successful");
                                view.updateTableRow(selectedRowToEdit,user);
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
            int uID = (int) view.getTblUser().getValueAt(view.getTblUser().getSelectedRow(),0);
            int re = view.messageBox("Are you want delete "+uID,"Confirm?");
            if (re == 0) {
                try {
                    boolean cmdRe = model.delete(uID);
                    if (cmdRe) {
                        view.messageBox("Delete Successful");
                        DefaultTableModel tableModel = (DefaultTableModel) view.getTblUser().getModel();
                        tableModel.removeRow(view.getTblUser().getSelectedRow());
                    }
                    else {
                        view.messageBox("**Delete Unsuccessful**");
                    }
                } catch (Exception ex) {
                    boolean disabled;
                    try {
                        disabled = model.disable(uID);
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
                        view.setTblUser(tableModel);
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
