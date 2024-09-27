package Controller;

import Model.Stock.Stock;
import Model.Stock.StockDAO;
import Model.Supplier.SupplierDAO;
import View.FormStock.FormStock;
import View.FormSupplier.FormSupplier;
import View.FormSupplier.FormSupplierDetails;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockController implements ActionListener {

    private final FormStock view;
    private final StockDAO model;
    private final SupplierDAO model_supplier;

    private int selectedRowToEdit = -1;

    public StockController(FormStock view) throws SQLException {
        this.view = view;
        model = new StockDAO();
        model_supplier = new SupplierDAO();

        view.setTableModel(model.displayAll(1));
        view.setActiveRenderer();

        this.view.getBtnSearch().addActionListener(this);
        this.view.getBtnEdit().addActionListener(this);
        this.view.getBtnUpdate().addActionListener(this);
        this.view.getBtnAdd().addActionListener(this);
        this.view.getBtnClear().addActionListener(this);
        this.view.getBtnOut().addActionListener(this);
        this.view.getBtnBack().addActionListener(this);
        this.view.getBtnSupplierDetails().addActionListener(this);
        this.view.getBtnOpenSupplier().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("search")) {
            ArrayList<Object> list = view.getSearchCondition();
            int searchBy = (int)list.getFirst();
            int filter = (int)list.get(1);
            String key = (String)list.get(2);

            if (searchBy == 0) {
                switch (filter) {
                    case 0 :
                        try {
                            DefaultTableModel tableModel = model.displayAll(1);
                            view.setTableModel(tableModel);
                            view.setActiveRenderer();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 1 :
                        try {
                            DefaultTableModel tableModel = model.displayAll(2);
                            view.setTableModel(tableModel);
                            view.setBackRenderer();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 2:
                        try {
                            DefaultTableModel tableModel = model.displayAll(3);
                            view.setTableModel(tableModel);
                            view.setActiveRenderer();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 3:
                        try {
                            DefaultTableModel tableModel = model.displayAll(4);
                            view.setTableModel(tableModel);
                            view.setActiveRenderer();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                }
            }
            if (searchBy == 1) {
                switch (filter) {
                    case 0 :
                        try {
                            DefaultTableModel tableModel = model.displayByName(1,key);
                            view.setTableModel(tableModel);
                            view.setActiveRenderer();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 1 :
                        try {
                            DefaultTableModel tableModel = model.displayByName(2,key);
                            view.setTableModel(tableModel);
                            view.setBackRenderer();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 2:
                        try {
                            DefaultTableModel tableModel = model.displayByName(3,key);
                            view.setTableModel(tableModel);
                            view.setActiveRenderer();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 3:
                        try {
                            DefaultTableModel tableModel = model.displayByName(4,key);
                            view.setTableModel(tableModel);
                            view.setActiveRenderer();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                }
            }
            if (searchBy == 2) {
                switch (filter) {
                    case 0 :
                        try {
                            DefaultTableModel tableModel = model.displayByCode(1,key);
                            view.setTableModel(tableModel);
                            view.setActiveRenderer();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 1 :
                        try {
                            DefaultTableModel tableModel = model.displayByCode(2,key);
                            view.setTableModel(tableModel);
                            view.setBackRenderer();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 2:
                        try {
                            DefaultTableModel tableModel = model.displayByCode(3,key);
                            view.setTableModel(tableModel);
                            view.setActiveRenderer();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case 3:
                        try {
                            DefaultTableModel tableModel = model.displayByCode(4,key);
                            view.setTableModel(tableModel);
                            view.setActiveRenderer();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                }
            }

        }

        if (cmd.equals("rowEdit")) {
            this.selectedRowToEdit = view.getTblStock().getSelectedRow();
            int stockId = Integer.parseInt(view.getTblStock().getValueAt(selectedRowToEdit,0).toString());
            try {
                Stock stock = model.searchByStockID(stockId);
                view.setInputStock(stock);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (cmd.equals("update")) {
            boolean isValidated = view.validateInputField();
            if (isValidated){
                Stock stock = view.getInputStock();
                stock.setStockID((Integer) view.getTblStock().getValueAt(selectedRowToEdit,0));
                String message = "Do you want to edit Stoke = "+stock.getStockID();
                int result = view.messageBox(message,"EDIT");
                if (result == 0) {
                    try {
                        boolean re = model.update(stock);
                        if (re) {
                            view.messageBox("Update Successful!");
                            view.setUpdatedRow(selectedRowToEdit,stock);
                        }
                        else {
                            view.messageBox("**Unsuccessful**");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

        }

        if (cmd.equals("add")) {
            boolean isValidated = view.validateInputField();
            if (isValidated) {
                Stock stock = view.getInputStock();
                String message = "Confirm record";
                int ans = view.messageBox(message,"Add Record");
                if (ans == 0) {
                    try {
                        if (model_supplier.searchBySID(stock.getSupplierID())!= null) {
                            boolean result = model.add(stock);
                            if (result) {
                                view.messageBox("Successful");
                                DefaultTableModel tableModel = model.displayAll(1);
                                view.setTableModel(tableModel);
                                view.setActiveRenderer();
                            }else {
                                view.messageBox("**Unsuccessful**");
                            }
                        }
                        else {
                            view.messageBox("Supplier ID Not Valid!");
                        }

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        }

        if (cmd.equals("clear")) {
            view.resetAllInputField();
        }

        if (cmd.equals("rowOut")) {
            int stockID = (int) view.getTblStock().getValueAt(view.getTblStock().getSelectedRow(),0);
            try {
                int re = view.messageBox("Do yo want to delete?(Stock "+stockID+" )","Confirm");
                if (re == 0) {
                    boolean delete = model.delete(stockID);
                    if (delete) {
                        view.messageBox("Delete successful");
                        view.removeRow(view.getTblStock().getSelectedRow());
                    }
                    else {
                        view.messageBox("**Unsuccessful**");
                    }
                }
            } catch (SQLException ex) {
                boolean res ;
                try {
                    res = model.setOutOFStock(stockID,0);
                } catch (SQLException exc) {
                    throw new RuntimeException(exc);
                }
                if (res) {
                    view.messageBox("Stock out successful");
                    view.removeRow(view.getTblStock().getSelectedRow());
                }else {
                    view.messageBox("**Unsuccessful**");
                }
            }
        }

        if (cmd.equals("back")) {
            int[] row = view.getSelectedRow();
            try {
                boolean res = model.setOutOFStock(row[1],1);
                if (res) {
                    view.messageBox("Successful");
                    view.removeRow(row[0]);
                }else {
                    view.messageBox("**Unsuccessful**");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (cmd.equals("supplierDetails")) {
            if (!view.getTxtSID().getText().isEmpty()) {
                try {
                    new FormSupplierDetails(Integer.parseInt(view.getTxtSID().getText()));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else {
                view.messageBox("Supplier ID is Empty");
            }
        }

        if (cmd.equals("supplier")) {
            view.getFormStockDesigner().dispose();
            try {
                new FormSupplier();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
