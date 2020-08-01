package connect;
import java.sql.Connection;

public class DBConn_Mysql {
    private Connection conn = null;
    public static java.sql.Connection Connection = null;  
    
    public java.sql.Connection getConnection() {
        try {
        
            String ServerName = "192.168.2.18";
            String Port = "3306";
            String Username = "root";
        	String Password = "1234";
            String DatabaseName = "meetingroom";
            
            String fixtime = "?zeroDateTimeBehavior=convertToNull";
            String fixlng = "&useUnicode=true&characterEncoding=UTF-8";
            String Drivers = "jdbc:mysql://";
            String Host = Drivers + ServerName + ":" + Port + "/" + DatabaseName+fixtime+fixlng;
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = java.sql.DriverManager.getConnection(Host, Username, Password);
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return conn;
    }
}
