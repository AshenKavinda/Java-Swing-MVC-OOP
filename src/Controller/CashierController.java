package Controller;

import Model.Bill.Bill;
import Model.Bill.BillADO;
import Model.Bill.BillItem;
import Model.Stock.Stock;
import Model.Stock.StockDAO;
import Model.User.User;
import Model.User.UserDAO;
import View.FormCashier.FormCashier;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

public class CashierController implements KeyListener {

    private final FormCashier view;
    private final StockDAO model_Stock;
    private final BillADO model_Bill;
    private final UserDAO model_User;
    private final ArrayList<Bill> billCollection;
    private Stock currentStock;
    private Bill currentBill;

    public CashierController(FormCashier formCashier) throws SQLException {
        billCollection = new ArrayList<>();
        currentStock = null;
        currentBill = null;
        view = formCashier;
        model_Bill = new BillADO();
        model_Stock = new StockDAO();
        model_User = new UserDAO();
        setBillInformation();
        setUserDetails();
        DefaultTableModel model = getTableModel();
        view.updateTable(model);


        view.getTxtQuantity().addKeyListener(this);
        view.getTxtItemCode().addKeyListener(this);
        view.getTable().addKeyListener(this);
        view.getTxtCash().addKeyListener(this);
    }

    private void setUserDetails() throws SQLException {
        int cashierID = view.getCashierID();
        User user = model_User.searchByUID(cashierID);
        view.getLblCashierIDValue().setText(": "+cashierID);
        view.getLblCashierNameValue().setText(": "+user.getName());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            boolean isValid = view.validateInputField();
            if (isValid) {
                //set current bill
                if (currentBill == null) {
                    view.resetDescriptionPanelCashier();
                    Bill bill = new Bill();
                    billCollection.add(bill);
                    int index = billCollection.indexOf(bill);
                    setCurrentBill(index);
                }
                //add item to current bill
                BillItem billItem = new BillItem();
                ArrayList<Stock> availableList;
                try {
                    availableList = model_Stock.searchByItemCode(view.getTxtItemCode().getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (availableList.size()>1) {//has many items
                    DefaultComboBoxModel<String> priceList = new DefaultComboBoxModel<>();
                    priceList.addElement("Select");
                    for(Stock stock :availableList) {
                        priceList.addElement(Float.toString(stock.getSellPrice()));
                    }
                    JComboBox<String> comboBox = new JComboBox<>(priceList); comboBox.setSelectedIndex(1);
                    JOptionPane.showMessageDialog(null, comboBox, "Select Price", JOptionPane.QUESTION_MESSAGE);
                    if (!Objects.equals(comboBox.getSelectedItem(), "Select")) {
                        for (Stock stock : availableList) {
                            if (Objects.equals(comboBox.getSelectedItem(), Float.toString(stock.getSellPrice()))) {
                                this.currentStock = stock;
                            }
                        }
                    }
                }
                else if (availableList.size() == 1) {
                    currentStock = availableList.getFirst();
                }
                else {
                    view.messageBox("Item Code not valid");
                    view.resetInputField();
                }

                if (currentStock != null && currentBill != null) {
                    billItem.setStockID(currentStock.getStockID());
                    billItem.setItemCode(currentStock.getItemCode());
                    billItem.setItemName(currentStock.getItemName());
                    billItem.setUnit(currentStock.getUnit());
                    billItem.setSellPrice(currentStock.getSellPrice());
                    billItem.setQuantity(Float.parseFloat(view.getTxtQuantity().getText()));
                    currentBill.addItem(billItem);
                    currentStock = null;
                    //currentBill.display();
                    setBillInformation();
                    view.resetInputField();
                }
            }
        }

        if (key == KeyEvent.VK_DELETE) {
            if (currentBill != null) {
                int index = view.getTable().getSelectedRow();
                if (index >= 0) {
                    currentBill.deleteItem(index);
                    setBillInformation();
                }
            }
        }

        if (key == KeyEvent.VK_F1) {
            view.getTxtItemCode().grabFocus();
        }

        if (key == KeyEvent.VK_F2) {
            if (currentBill != null) {
                view.getTable().grabFocus();
            }
        }

        if (key == KeyEvent.VK_F4) {
            if (currentBill != null) {
                String message = "Do you want new bill";
                int re = view.messageBox(message,"New Bill");
                if (re == 0) {
                    view.resetDescriptionPanelCashier();
                    Bill bill = new Bill();
                    billCollection.add(bill);
                    int index = billCollection.indexOf(bill);
                    setCurrentBill(index);
                    setBillInformation();
                }
            }
        }

        if (key == KeyEvent.VK_F6) {
            if (currentBill != null) {
                if (billCollection.indexOf(currentBill)<billCollection.size()-1) {
                    view.resetDescriptionPanelCashier();
                    view.getTxtItemCode().grabFocus();
                    setCurrentBill(billCollection.indexOf(currentBill)+1);
                    currentBill.setCash(-1);
                }
            }else {
                if (!billCollection.isEmpty()) {
                    view.resetDescriptionPanelCashier();
                    view.getTxtItemCode().grabFocus();
                    currentBill = billCollection.getLast();
                    setBillInformation();
                }
            }
        }

        if (key == KeyEvent.VK_F5) {
            if (currentBill != null) {
                if (billCollection.indexOf(currentBill) > 0) {
                    view.resetDescriptionPanelCashier();
                    view.getTxtItemCode().grabFocus();
                    setCurrentBill(billCollection.indexOf(currentBill)-1);
                    currentBill.setCash(-1);
                }
            }else {
                if (!billCollection.isEmpty()) {
                    view.resetDescriptionPanelCashier();
                    view.getTxtItemCode().grabFocus();
                    currentBill = billCollection.getFirst();
                    setBillInformation();
                }
            }
        }

        if (key == KeyEvent.VK_F12) {
            if (currentBill != null) {
                if (currentBill.getCash()>=currentBill.getTotal()) {
                    int rs = view.messageBox("Confirm Bill?","Confirm");
                    if (rs == 0) {
                        try {
                            currentBill.setCashierID(view.getCashierID());
                            Bill bill = model_Bill.add(currentBill);
                            if (bill.getBillID()>0) {
                                System.out.println("True");
                                billCollection.remove(currentBill);
                                currentBill = null;
                                DefaultTableModel model = getTableModel();
                                view.updateTable(model);
                                view.getTxtItemCode().grabFocus();
                                view.resetDescriptionPanelCashier();
                                bill.printTxt();
                            }
                            bill.display();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                }
                else {
                    if (view.getTxtCash().getText().isEmpty()) {
                        view.getTxtCash().setBorder(new LineBorder(Color.CYAN));
                        view.getTxtCash().setText("");
                        view.getTxtCash().grabFocus();
                    }
                    else {
                        float cash = Float.parseFloat(view.getTxtCash().getText());
                        float balance = cash-currentBill.getTotal();
                        view.getTxtCash().setText("");
                        if (balance >=0) {
                            currentBill.setCash(cash);
                            view.setLblBalance(balance);
                            view.getTxtCash().setBorder(new LineBorder(Color.black));
                        }
                        else {
                            view.getTxtCash().setBorder(new LineBorder(Color.red));
                        }

                    }
                }

            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setCurrentBill(int index) {
        currentBill = billCollection.get(index);
        setBillInformation();
    }

    public void setBillInformation() {
        if (currentBill != null) {
            DefaultTableModel tableModel = getTableModel();
            int rowNo = 1;
            for(BillItem item : currentBill.getItemList()) {
                Vector<Object> row = new Vector<>();
                row.add(rowNo);
                row.add(item.getStockID());
                row.add(item.getItemName());
                row.add(item.getQuantity()+" "+item.getUnit());
                row.add(item.getSellPrice());
                row.add(item.getSellPrice()*item.getQuantity());
                tableModel.addRow(row);
                rowNo++;
            }
            view.updateTable(tableModel);
            view.setTotalBill(currentBill.getTotal());
        }
    }

    public DefaultTableModel getTableModel() {
        Vector<Object> header = new Vector<>();
        header.add("Item no");
        header.add("Stock Code");
        header.add("Item Name");
        header.add("Quantity");
        header.add("Unit price(Rs)");
        header.add("Total(Rs)");
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(header);
        return tableModel;
    }
}
