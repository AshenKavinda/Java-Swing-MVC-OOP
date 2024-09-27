package View.FormSalesReport;

import Controller.SalesReportController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormSalesReport {

    private final FormSalesReportDesigner formSalesReportDesigner;

    public FormSalesReport() throws SQLException {
        this.formSalesReportDesigner = new FormSalesReportDesigner();
        new SalesReportController(this);
    }

    public boolean isValidate() {
        boolean isValid = true;
        if (getStartDate() == null) {
            formSalesReportDesigner.getPanelTopBar().getDatePickerStart().setBorder(new LineBorder(Color.red));
            isValid = false;
        }
        else {
            formSalesReportDesigner.getPanelTopBar().getDatePickerStart().setBorder(new LineBorder(Color.black));
        }
        return isValid;
    }

    public JButton getBtnGo() {
        return formSalesReportDesigner.getPanelTopBar().getBtnGo();
    }

    public JButton getBtnPrint() {
        return formSalesReportDesigner.getPanelTopBar().getBtnPrint();
    }

    public JLabel getLblCostValue() {
        return formSalesReportDesigner.getPanelSummery().getLblCostValue();
    }

    public JLabel getLblIncomeValue() {
        return formSalesReportDesigner.getPanelSummery().getLblIncomeValue();
    }

    public JLabel getLblProfitValue() {
        return formSalesReportDesigner.getPanelSummery().getLblProfitValue();
    }

    public JTable getTable() {
        return formSalesReportDesigner.getPanelTable().getTable();
    }

    public String getStartDate() {
        Date selectedDate = (Date) formSalesReportDesigner.getPanelTopBar().getDatePickerStart().getModel().getValue();
        if (selectedDate != null) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormatter.format(selectedDate.getTime());
        }
        return null;
    }

    public String getEndDate() {
        Date selectedDate = (Date) formSalesReportDesigner.getPanelTopBar().getDatePickerEnd().getModel().getValue();
        if (selectedDate != null) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormatter.format(selectedDate.getTime());
        }
        return null;
    }

    public void messageBox(String message) {
         JOptionPane.showMessageDialog(null,message);
    }
}
