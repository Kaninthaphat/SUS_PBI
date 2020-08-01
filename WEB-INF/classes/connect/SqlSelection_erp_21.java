
package connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlSelection_erp_21 {

    private DBConn_erp_21 objConnection = new DBConn_erp_21();
    private Connection conn = null;
    private Statement stmt = null;

    public ResultSet getReSultSQL(String sql) throws Exception {
        conn = objConnection.getConnection();
        stmt = conn.createStatement();
        return stmt.executeQuery(sql);
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
