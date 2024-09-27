package Model.SalesReport;

import Util.DataBaseManager;
import Util.TableUtil;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SalesReportDAO {

    private final DataBaseManager dataBaseManager;
    private PreparedStatement ps;

    public SalesReportDAO() throws SQLException {
        dataBaseManager = new DataBaseManager();
    }

    public SalesReport DisplayDailySalesReport(String date) throws SQLException {
        try {
            SalesReport salesReport = new SalesReport();
            salesReport.setDate(date);
            double TotalIncome = 0 ;
            double TotalCost = 0;
            double TotalProfit = 0;
            String cmd = "select st.stockID, st.itemName, st.costPrice,st.sellPrice, sum(bist.quantity) as quantity from stock st " +
                    "inner join billstock bist on st.stockID = bist.sID " +
                    "inner join bill bi on bist.bID = bi.bID " +
                    "where date(bi.`date`) = ? " +
                    "group by st.stockID " +
                    "order by sum(bist.quantity) DESC";
            this.ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setString(1,date);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel tableModel = getTableModel();

            while (rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(rs.getInt(1)));
                row.add(rs.getString(2));
                float costPrice = rs.getFloat(3);
                row.add(String.valueOf(costPrice));
                float sellPrice = rs.getFloat(4);
                row.add(String.valueOf(sellPrice));
                float quantity = rs.getFloat(5);
                row.add(String.valueOf(quantity));
                double totalCost = Math.round(costPrice * quantity*10.0)/10.0 ;
                double totalSell = Math.round(sellPrice * quantity*10.0)/10.0 ;
                double profit = Math.round((totalSell-totalCost) * 10.0) / 10.0 ;
                row.add(String.valueOf(totalCost));
                row.add(String.valueOf(totalSell));
                row.add(String.valueOf(profit));
                tableModel.addRow(row);
                TotalCost += totalCost;
                TotalIncome += totalSell;
                TotalProfit += profit;
            }
            if (tableModel.getRowCount() > 0) {
                salesReport.setTableModel(tableModel);
                salesReport.setCost(Math.round((TotalCost) * 10.0) / 10.0);
                salesReport.setIncome(Math.round((TotalIncome) * 10.0) / 10.0);
                salesReport.setProfit(Math.round((TotalProfit) * 10.0) / 10.0);
                return salesReport;
            }
            else {
                return null;
            }

        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public SalesReport DisplayDailySalesReport(String startDate,String endDate) throws SQLException {
        try {
            SalesReport salesReport = new SalesReport();
            salesReport.setDate(startDate+" -> "+endDate);
            double TotalIncome = 0 ;
            double TotalCost = 0;
            double TotalProfit = 0;
            String cmd = "select st.stockID, st.itemName, st.costPrice,st.sellPrice, sum(bist.quantity) as quantity from stock st " +
                    "inner join billstock bist on st.stockID = bist.sID " +
                    "inner join bill bi on bist.bID = bi.bID " +
                    "where date(bi.`date`) between ? and ? " +
                    "group by st.stockID " +
                    "order by sum(bist.quantity) DESC";
            this.ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setString(1,startDate);
            ps.setString(2,endDate);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel tableModel = getTableModel();
            while (rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(rs.getInt(1)));
                row.add(rs.getString(2));
                float costPrice = rs.getFloat(3);
                row.add(String.valueOf(costPrice));
                float sellPrice = rs.getFloat(4);
                row.add(String.valueOf(sellPrice));
                float quantity = rs.getFloat(5);
                row.add(String.valueOf(quantity));
                double totalCost = Math.round(costPrice * quantity*10.0)/10.0 ;
                double totalSell = Math.round(sellPrice * quantity*10.0)/10.0 ;
                double profit = Math.round((totalSell-totalCost) * 10.0) / 10.0 ;
                row.add(String.valueOf(totalCost));
                row.add(String.valueOf(totalSell));
                row.add(String.valueOf(profit));
                tableModel.addRow(row);
                TotalCost += totalCost;
                TotalIncome += totalSell;
                TotalProfit += profit;
            }
            if (tableModel.getRowCount() > 0) {
                salesReport.setTableModel(tableModel);
                salesReport.setCost(TotalCost);
                salesReport.setIncome(TotalIncome);
                salesReport.setProfit(TotalProfit);
                return salesReport;
            }
            else {
                return null;
            }

        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public DefaultTableModel getTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Stock");
        tableModel.addColumn("Item Name");
        tableModel.addColumn("Cost Price");
        tableModel.addColumn("Sell Price");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Total cost");
        tableModel.addColumn("Total sell");
        tableModel.addColumn("Profit");
        return tableModel;
    }
}
