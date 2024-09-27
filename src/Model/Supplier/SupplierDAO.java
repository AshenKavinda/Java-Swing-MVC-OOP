package Model.Supplier;

import Util.DataBaseManager;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class SupplierDAO {
    private final DataBaseManager dataBaseManager;
    private PreparedStatement ps;

    public SupplierDAO() throws SQLException {
        dataBaseManager = new DataBaseManager();
    }

    public boolean add(Supplier supplier) throws SQLException {
        try {
            String cmd = "Insert into supplier(name, nic, phone1, phone2, email) values(?,?,?,?,?)";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getNic());
            ps.setString(3, supplier.getPhone1());
            ps.setString(4, supplier.getPhone2());
            ps.setString(5, supplier.getEmail());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public boolean update(Supplier supplier) throws Exception {
        try {
            String cmd = "update supplier set name = ?, nic = ?, phone1 = ?, phone2 = ?, email = ?, isActive = ? where sID = ?";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getNic());
            ps.setString(3, supplier.getPhone1());
            ps.setString(4, supplier.getPhone2());
            ps.setString(5, supplier.getEmail());
            ps.setInt(6, supplier.getIsActive());
            ps.setInt(7, supplier.getSupplierID());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public boolean delete(int sID) throws Exception {
        try {
            String cmd = "Delete from supplier where sID = ?";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setInt(1, sID);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public Supplier searchBySID(int sID) throws SQLException {
        Statement statement;
        try {
            Supplier supplier = new Supplier();
            String cmd = "select * from supplier where sID = " + sID;
            statement = dataBaseManager.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(cmd);
            while (rs.next()) {
                supplier.setSupplierID(rs.getInt(1));
                supplier.setName(rs.getString(2));
                supplier.setNic(rs.getString(3));
                supplier.setPhone1(rs.getString(4));
                supplier.setPhone2(rs.getString(5));
                supplier.setEmail(rs.getString(6));
                supplier.setIsActive(rs.getInt(7));
            }
            if (supplier.getSupplierID() != -1) {
                return supplier;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public boolean disable(int sID) throws SQLException {
        try {
            String cmd = "update supplier set isActive = 0 where sID = ?";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setInt(1, sID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public DefaultTableModel displayAll() throws Exception {
        try {
            String cmd = "select * from supplier order by sID DESC";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            DefaultTableModel tableModel = getTableModel();
            ResultSet rs = ps.executeQuery();
            return fillDataToModel(rs, tableModel);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public DefaultTableModel displayAllByName(String name) throws Exception {
        try {
            String cmd = "select * from supplier where name like('%"+name+"%') order by sID DESC";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            DefaultTableModel tableModel = getTableModel();
            ResultSet rs = ps.executeQuery();
            return fillDataToModel(rs, tableModel);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public DefaultTableModel displayAllByNIC(String nic) throws Exception {
        try {
            String cmd = "select * from supplier where nic like('%"+nic+"%') order by sID DESC";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            DefaultTableModel tableModel = getTableModel();
            ResultSet rs = ps.executeQuery();
            return fillDataToModel(rs, tableModel);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    private DefaultTableModel fillDataToModel(ResultSet rs, DefaultTableModel tableModel) throws SQLException {
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs.getInt(1));
            row.add(rs.getString(2));
            row.add(rs.getString(3));
            row.add(rs.getString(4));
            row.add(rs.getString(5));
            row.add(rs.getString(6));
            row.add(rs.getInt(7));
            tableModel.addRow(row);
        }
        return tableModel;
    }

    private DefaultTableModel getTableModel() {
        Vector<String> headerList = new Vector<>();
        headerList.add("Supplier ID");
        headerList.add("Name");
        headerList.add("NIC");
        headerList.add("Phone 1");
        headerList.add("Phone 2");
        headerList.add("Email");
        headerList.add("Is active");
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headerList);
        return tableModel;
    }
}
