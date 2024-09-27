package Model.SalesReport;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class SalesReport implements Printable {
    private String date;
    private DefaultTableModel tableModel;
    private double cost;
    private double income;
    private double profit;

    public SalesReport() {
        tableModel = null;
        this.cost = 0;
        this.income = 0;
        this.profit = 0;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        Font font = new Font("Arial", Font.PLAIN, 10);
        g2d.setFont(font);

        int y = 20;
        g2d.drawString("Sales Report for: " + getDate(), 30, y);

        y += 30;
        int columnCount = tableModel.getColumnCount();
        int rowCount = tableModel.getRowCount();

        // Draw table header
        int x = 30;
        for (int i = 0; i < columnCount; i++) {
            g2d.drawString(tableModel.getColumnName(i), x, y);
            if (i == 0) {
                x+=60;
            } else if (i == 1) {
                x+= 120;
            } else if (i == 2 || i == 3 || i == 4) {
                x+= 60;
            } else {
                x += 70;
            }
        }

        y += 20;

        // Draw table rows
        for (int row = 0; row < rowCount; row++) {
            x = 30;
            for (int col = 0; col < columnCount; col++) {
                g2d.drawString(tableModel.getValueAt(row, col).toString(), x, y);
                if (col == 0) {
                    x+=60;
                } else if (col == 1) {
                    x+= 120;
                } else if (col == 2 || col == 3 || col == 4) {
                    x+= 60;
                } else {
                    x += 70;
                }
            }
            y += 20;
        }

        // Draw summary
        y += 40;
        g2d.drawString("Total Cost: " + getCost(), 30, y);
        y += 20;
        g2d.drawString("Total Income: " + getIncome(), 30, y);
        y += 20;
        g2d.drawString("Total Profit: " + getProfit(), 30, y);

        return PAGE_EXISTS;
    }
}
