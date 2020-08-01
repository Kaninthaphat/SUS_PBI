package connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlSelection_Mysql {

    private Statement stmt = null;
    private Connection conn = null;
    
    public ResultSet getReSultSQL(String sql) throws Exception {
    	DBConn_Mysql objConnection = new DBConn_Mysql();
        Connection conn = objConnection.getConnection();
        conn.setAutoCommit(false);
        stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }
    
    public void closeConnection() throws Exception {
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
        	conn.commit();
            conn.close();
        }
    }
    
}
