package Model.User;

import Util.DataBaseManager;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class UserDAO {
    private final DataBaseManager dataBaseManager;
    private PreparedStatement ps;
    public UserDAO() throws SQLException {
        dataBaseManager = new DataBaseManager();
    }

    public boolean add(User user) throws SQLException {
        try {
            String cmd = "Insert into user(name,nic,type,password) values(?,?,?,?)";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setString(1,user.getName());
            ps.setString(2,user.getNic());
            ps.setString(3,user.getType());
            ps.setString(4,user.getPassword());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new SQLException(e);
        }finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public boolean update(User user) throws Exception {
        try {
            String cmd = "update user set name = ?,nic = ?,type = ?,password = ?,isActive = ? where uID = ?";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setString(1,user.getName());
            ps.setString(2,user.getNic());
            ps.setString(3,user.getType());
            ps.setString(4,user.getPassword());
            ps.setInt(5,user.getIsActive());
            ps.setInt(6,user.getuID());

            return ps.executeUpdate() > 0;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
        finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public boolean delete(int uID) throws Exception {
        try {
            String cmd = "Delete from user where uID = ?";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setInt(1,uID);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            throw new Exception(e);
        }
        finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public User searchByUID(int uID) throws SQLException {
        Statement statement = null;
        try {
            User user = new User();
            String cmd = "select * from user where uID = " + uID;
            statement = dataBaseManager.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(cmd);
            while (rs.next()) {
                user.setuID(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setNic(rs.getString(3));
                user.setType(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setIsActive(rs.getInt(6));
            }
            return user;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        finally {
            assert statement != null;
            statement.close();
            dataBaseManager.closeConnection();
        }
    }

    public boolean disable(int uID) throws SQLException {
        try {
            String cmd = "update user set isActive = 0 where uID = ?";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setInt(1,uID);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public User isVerified(User user) throws SQLException {
        try {
            String type = null;
            String cmd = "Select * from user where nic = ? and password = ? and isActive = 1";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            ps.setString(1, user.getNic());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setuID(rs.getInt(1));
                user.setType(rs.getString(4));
                return user;
            }
            rs.close();
            return null;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public DefaultTableModel displayAll() throws Exception {
        try {
            String cmd = "select * from user order by uID DESC";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            DefaultTableModel tableModel = getTableModel();
            ResultSet rs = ps.executeQuery();
            return fillDataToModel(rs,tableModel);
        } catch (Exception e) {
            throw new Exception(e);
        }finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public DefaultTableModel displayAllByName(String name) throws Exception {
        try {
            String cmd = "select * from user where name like('%"+name+"%') order by uID DESC";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            DefaultTableModel tableModel = getTableModel();
            ResultSet rs = ps.executeQuery();
            return fillDataToModel(rs,tableModel);
        } catch (Exception e) {
            throw new Exception(e);
        }
        finally {
            ps.close();
            dataBaseManager.closeConnection();
        }
    }

    public DefaultTableModel displayAllByNIC(String nic) throws Exception {
        try {
            String cmd = "select * from user where nic like('%"+nic+"%') order by uID DESC";
            ps = dataBaseManager.getConnection().prepareStatement(cmd);
            DefaultTableModel tableModel = getTableModel();
            ResultSet rs = ps.executeQuery();
            return fillDataToModel(rs,tableModel);
        } catch (Exception e) {
            throw new Exception(e);
        }
        finally {
            ps.close();
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
            row.add(rs.getString(5));
            row.add(rs.getInt(6));
            tableModel.addRow(row);
        }
        return tableModel;
    }

    private DefaultTableModel getTableModel() {
        Vector<String> headerList = new Vector<>();
        headerList.add("User ID");
        headerList.add("Name");
        headerList.add("NIC");
        headerList.add("Type");
        headerList.add("Password");
        headerList.add("Is active");
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headerList);
        return tableModel;
    }
}
