package connect;

import java.sql.Connection;
import java.sql.Statement;

public class SqlOperation_Mysql {

	private Connection conn = null;
    private Statement stmt = null;
    
    public void executeUpdateSQL(String sql) throws Exception {
        try {
        	DBConn objConnection = new DBConn();
            Connection conn = objConnection.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    
    public void executeUpdateSQLByRoot(String sql) throws Exception {
        try {
        	DBConn objConnection = new DBConn();
            Connection conn = objConnection.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	closeConnection();
        }
    }
    
    public void Add_Sql(String StrSql) throws Exception{
		SqlOperation sqlopt = new SqlOperation();

		try{
			//System.out.println(StrSql);
    		sqlopt.executeUpdateSQL(StrSql);
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		sqlopt.closeConnection();
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
