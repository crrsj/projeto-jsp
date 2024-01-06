package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	private static String bancoDados ="jdbc:mysql://localhost:3306/bjdbc?autoReconnect=true";
    private static String user = "root";
    private static String senha ="";
    private static Connection connection = null;   
       
    public SingleConnection() {
    	conectar();
    }
    
    public static Connection getConnection() {
		return connection;
	}
    static{
    	conectar();
    }
    
    private static void conectar() {
    	try {
    		if (connection == null) {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			connection = DriverManager.getConnection(bancoDados,user,senha);
    			connection.setAutoCommit(false);
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	
}
