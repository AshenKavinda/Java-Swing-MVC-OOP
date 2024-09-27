package Controller;

import Model.SalesReport.SalesReport;
import Model.SalesReport.SalesReportDAO;
import View.FormSalesReport.FormSalesReport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;

public class SalesReportController implements ActionListener {

    private final FormSalesReport view;
    private final SalesReportDAO model;
    private SalesReport currentObject;

    public SalesReportController(FormSalesReport view) throws SQLException {
        this.view = view;
        this.model = new SalesReportDAO();

        currentObject = null;

        this.view.getBtnGo().addActionListener(this);
        this.view.getBtnPrint().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("go")) {
            if (view.isValidate()) {
                String startDate = view.getStartDate();
                String endDate = view.getEndDate();
                try {
                    if (startDate != null && endDate != null) {
                        SalesReport salesReport = model.DisplayDailySalesReport(startDate,endDate);
                        if (salesReport != null) {
                            setView(salesReport);
                        }
                        else {
                            view.messageBox("Record not found!");
                        }
                    }else {
                        SalesReport salesReport = model.DisplayDailySalesReport(startDate);
                        if (salesReport != null) {
                            setView(salesReport);
                        }
                        else {
                            view.messageBox("Record not found!");
                        }
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }

        if (cmd.equals("print")) {
            if (currentObject != null) {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(this.currentObject);
                boolean doPrint = job.printDialog();
                if (doPrint) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
            else {
                view.messageBox("Nothing to Print");
            }
        }
    }

    public void setView(SalesReport salesReport) {
        view.getTable().setModel(salesReport.getTableModel());
        view.getLblCostValue().setText(String.valueOf(salesReport.getCost()));
        view.getLblIncomeValue().setText(String.valueOf(salesReport.getIncome()));
        view.getLblProfitValue().setText(String.valueOf(salesReport.getProfit()));
        currentObject = salesReport;
    }
}
