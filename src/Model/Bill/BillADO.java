package Model.Bill;

import Model.Stock.StockDAO;
import Util.DataBaseManager;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class BillADO {

    private final DataBaseManager dataBaseManager;
    private final StockDAO stockDAO;
    private PreparedStatement ps;

    public BillADO() throws SQLException {
        this.dataBaseManager = new DataBaseManager();
        stockDAO = new StockDAO();
    }

    public Bill add(Bill bill) throws Exception {
        String cmd = "INSERT INTO bill(total,uID,date) VALUES(?,?,NOW())";
        String cmd2 = "Insert into billstock values(?,?,?)";
        PreparedStatement ps = null;
        try {
            bill.setDateTime(LocalDateTime.now());
            ps = dataBaseManager.getConnection().prepareStatement(cmd, Statement.RETURN_GENERATED_KEYS);
            ps.setFloat(1, bill.getTotal());
            ps.setInt(2, bill.getCashierID());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                 if (generatedKeys.next()) {
                     bill.setBillID(generatedKeys.getInt(1));
                     ps = dataBaseManager.getConnection().prepareStatement(cmd2);
                     boolean isAllSuccess = true;
                     for(BillItem item : bill.getItemList()) {
                        ps.setInt(1,bill.getBillID());
                        ps.setInt(2,item.getStockID());
                        ps.setFloat(3,item.getQuantity());
                        int rowsCount = ps.executeUpdate();
                        if (rowsCount < 1) {
                            isAllSuccess = false;
                        }else {
                            boolean re = stockDAO.updateQuantityByStockID(item.getStockID(), item.getQuantity());
                            if (!re){
                                isAllSuccess = false;
                            }
                        }
                     }
                     if (!isAllSuccess){
                         throw new RuntimeException("Some record unsuccessful");
                     }
                 }
            }
            return bill;
        } catch (SQLException e) {
            throw new Exception(e);
        }
        finally {
            assert ps != null;
            ps.close();
            dataBaseManager.closeConnection();
        }
    }
}
