
package connect;

import java.sql.Connection;
import java.sql.Statement;

public class SqlOperation_19 {

    DBConn_19 objConnection = new DBConn_19();
    Connection conn = objConnection.getConnection();
    Statement stmt = null;

    public void executeUpdateSQL(String sql) throws Exception {
        try {
            conn = objConnection.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void closeConnection() throws Exception {
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
