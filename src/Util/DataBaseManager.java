package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {

    private Connection conn;
    private String host ;
    private String username ;
    private String password ;

    public DataBaseManager() throws SQLException {
        host = "jdbc:mysql://127.0.0.1:3308/testead";
        username = "root";
        password = "1234";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

    }

    public Connection getConnection() throws SQLException {
        this.conn = DriverManager.getConnection(this.host,this.username,this.password);
        return this.conn;
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}
