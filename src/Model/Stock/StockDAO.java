package Model.Stock;

import Util.DataBaseManager;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class StockDAO {

    private final DataBaseManager dataBaseManager ;
    private PreparedStatement ps;
    public StockDAO() throws SQLException {
        this.dataBaseManager = new DataBaseManager();
    }

    public boolean add(Stock stock) throws SQLException {
        try {
            String cmd = "INSERT INTO stock(itemCode,itemName,unit,quantity,costPrice,sellPrice,ool,category,sID) VALUES(?,?,?,?,?,?,?,?,?)";
            this.ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setString(1,stock.getItemCode());
            ps.setString(2,stock.getItemName());
            ps.setString(3,stock.getUnit());
            ps.setFloat(4,stock.getQuantity());
            ps.setFloat(5,stock.getCostPrice());
            ps.setFloat(6,stock.getSellPrice());
            ps.setInt(7,stock.getOutOfStockLimit());
            ps.setString(8, stock.getCategory());
            ps.setInt(9,stock.getSupplierID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public boolean update(Stock stock) throws SQLException {
        try {
            Stock currentStock = searchByStockID(stock.getStockID());
            if (currentStock.getReturnCount() != stock.getReturnCount()) {
                if (stock.getReturnCount() > currentStock.getReturnCount()) {
                    float difference = stock.getReturnCount() - currentStock.getReturnCount();
                    stock.setQuantity(stock.getQuantity()-difference);
                }
                else {
                    float difference = currentStock.getReturnCount() - stock.getReturnCount();
                    stock.setQuantity(stock.getQuantity()+difference);
                }
            }
            String cmd = "UPDATE stock SET "+
                    "itemCode = ?,"+
                    "itemName = ?,"+
                    "unit = ?,"+
                    "quantity = ?,"+
                    "costPrice = ?,"+
                    "sellPrice = ?,"+
                    "ool = ?,"+
                    "category = ? ,"+
                    "returnCount = ? ,"+
                    "sID = ? "+
                    "WHERE stockID = ? " ;
            this.ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setString(1,stock.getItemCode());
            ps.setString(2,stock.getItemName());
            ps.setString(3,stock.getUnit());
            ps.setFloat(4,stock.getQuantity());
            ps.setFloat(5,stock.getCostPrice());
            ps.setFloat(6,stock.getSellPrice());
            ps.setInt(7,stock.getOutOfStockLimit());
            ps.setString(8, stock.getCategory());
            ps.setFloat(9,stock.getReturnCount());
            ps.setInt(10,stock.getSupplierID());
            ps.setInt(11, stock.getStockID());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new SQLException(e);
        }
        finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public boolean delete(int stockID) throws SQLException {
        try {
            String cmd = "Delete from stock where stockID = ?";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setInt(1,stockID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public boolean updateQuantityByStockID(int stockID,float quantity) throws SQLException {
        try {
            Stock stock = searchByStockID(stockID);
            stock.setQuantity(stock.getQuantity()-quantity);
            return update(stock);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Stock searchByStockID(int stockID) throws SQLException {
        Statement statement;
        try {
            Stock stock = new Stock();
            String cmd = "select * from stock where stockID = "+stockID ;
            statement = dataBaseManager.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(cmd);
            while (rs.next()) {
                stock.setStockID(rs.getInt(1));
                stock.setItemCode(rs.getString(2));
                stock.setItemName(rs.getString(3));
                stock.setUnit(rs.getString(4));
                stock.setQuantity(rs.getFloat(5));
                stock.setCostPrice(rs.getFloat(6));
                stock.setSellPrice(rs.getFloat(7));
                stock.setOutOfStockLimit(rs.getInt(8));
                stock.setCategory(rs.getString(9));
                stock.setReturnCount(rs.getFloat(10));
                stock.setSupplierID(rs.getInt(11));
                stock.setStockStatus(rs.getInt(12));
            }
            return stock;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public ArrayList<Stock> searchByItemCode(String itemCode) throws SQLException {
        try {
            ArrayList<Stock> availableStockList = new ArrayList<>();
            String cmd = "select * from stock where itemCode = ? and stockStatus = 1 and quantity > 0 ";
            PreparedStatement ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setString(1,itemCode);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Stock stock = new Stock();
                stock.setStockID(resultSet.getInt(1));
                stock.setItemCode(resultSet.getString(2));
                stock.setItemName(resultSet.getString(3));
                stock.setUnit(resultSet.getString(4));
                stock.setQuantity(resultSet.getFloat(5));
                stock.setCostPrice(resultSet.getFloat(6));
                stock.setSellPrice(resultSet.getFloat(7));
                stock.setOutOfStockLimit(resultSet.getInt(8));
                stock.setCategory(resultSet.getString(9));
                stock.setReturnCount(resultSet.getFloat(10));
                stock.setSupplierID(resultSet.getInt(11));
                stock.setStockStatus(resultSet.getInt(12));
                availableStockList.add(stock);
            }
            return availableStockList;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public boolean setOutOFStock(int stockID,int status) throws SQLException {
        try {
            String cmd = "UPDATE stock SET stockStatus = ? where stockID = ?";
            this.ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setInt(1,status);
            ps.setInt(2,stockID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        finally {
            this.ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public DefaultTableModel displayAll(int filter) throws SQLException {
        Statement statement = null;
        try {
            DefaultTableModel tableModel = getTableModel();

            String cmdActive = "Select * from stock where quantity > 0 and stockStatus = 1 order by stockID DESC";
            String cmdDisable = "Select * from stock where stockStatus = 0 order by stockID DESC";
            String cmdHasReturn = "Select * from stock where stockStatus = 1 and returnCount > 0 order by stockID DESC";
            String cmdLowStock = "select * from stock where quantity < ool and stockStatus = 1 order by stockID DESC";
            statement = dataBaseManager.getConnection().createStatement();
            ResultSet rs = switch (filter) {
                case 1 -> statement.executeQuery(cmdActive);
                case 2 -> statement.executeQuery(cmdDisable);
                case 3 -> statement.executeQuery(cmdHasReturn);
                case 4 -> statement.executeQuery(cmdLowStock);
                default -> null;
            };
            assert rs != null;
            return fillDataToModel(rs,tableModel);
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            assert statement != null;
            statement.close();
            dataBaseManager.closeConnection();
        }
    }

    public DefaultTableModel displayByName(int filter,String name) throws SQLException {
        Statement statement = null;
        try {
            DefaultTableModel tableModel = getTableModel();

            String cmdActive = "Select * from stock where quantity > 0 and stockStatus = 1 and itemName like('%"+name+"%') order by stockID DESC";
            String cmdDisable = "Select * from stock where stockStatus = 0 and itemName like('%"+name+"%') order by stockID DESC";
            String cmdHasReturn = "Select * from stock where stockStatus = 1 and returnCount > 0 and itemName like('%"+name+"%') order by stockID DESC";
            String cmdLowStock = "select * from stock where quantity < ool and stockStatus = 1 and like('%"+name+"%') order by stockID DESC";
            statement = dataBaseManager.getConnection().createStatement();
            ResultSet rs = switch (filter) {
                case 1 -> statement.executeQuery(cmdActive);
                case 2 -> statement.executeQuery(cmdDisable);
                case 3 -> statement.executeQuery(cmdHasReturn);
                case 4 -> statement.executeQuery(cmdLowStock);
                default -> null;
            };
            assert rs != null;
            return fillDataToModel(rs,tableModel);
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            assert statement != null;
            statement.close();
            dataBaseManager.closeConnection();
        }
    }

    public DefaultTableModel displayByCode(int filter,String code) throws SQLException {
        Statement statement = null;
        try {
            DefaultTableModel tableModel = getTableModel();

            String cmdActive = "Select * from stock where quantity > 0 and stockStatus = 1 and itemCode like('%"+code+"%') order by stockID DESC";
            String cmdDisable = "Select * from stock where stockStatus = 0 and itemCode like('%"+code+"%') order by stockID DESC";
            String cmdHasReturn = "Select * from stock where stockStatus = 1 and returnCount > 0 and itemCode like('%"+code+"%') order by stockID DESC";
            String cmdLowStock = "select * from stock where quantity < ool and stockStatus = 1 and itemCode like('%"+code+"%') order by stockID DESC";
            statement = dataBaseManager.getConnection().createStatement();
            ResultSet rs = switch (filter) {
                case 1 -> statement.executeQuery(cmdActive);
                case 2 -> statement.executeQuery(cmdDisable);
                case 3 -> statement.executeQuery(cmdHasReturn);
                case 4 -> statement.executeQuery(cmdLowStock);
                default -> null;
            };
            assert rs != null;
            return fillDataToModel(rs,tableModel);
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            assert statement != null;
            statement.close();
            dataBaseManager.closeConnection();
        }
    }

    private DefaultTableModel fillDataToModel(ResultSet rs,DefaultTableModel tableModel) throws SQLException {
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs.getInt(1));
            row.add(rs.getString(2));
            row.add(rs.getString(3));
            row.add(rs.getString(4));
            row.add(rs.getFloat(5));
            row.add(rs.getFloat(6));
            row.add(rs.getFloat(7));
            row.add(rs.getInt(8));
            row.add(rs.getString(9));
            row.add(rs.getFloat(10));
            tableModel.addRow(row);
        }
        return tableModel;
    }

    private DefaultTableModel getTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
        Vector<Object> headerList = new Vector<>();
        headerList.add("Stock ID");
        headerList.add("Item Code");
        headerList.add("Item Name");
        headerList.add("Unit");
        headerList.add("Quantity");
        headerList.add("Cost Price");
        headerList.add("Sell Price");
        headerList.add("Out Limit");
        headerList.add("Category");
        headerList.add("Return");
        tableModel.setColumnIdentifiers(headerList);
        return tableModel;
    }


}
