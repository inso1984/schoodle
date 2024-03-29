package ch.schoodle.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class DBConnector {

	
	
	private static final String PASSWORD = "root";
	private static final String DBUSER = "root";
	private static final String MYSLDB = "jdbc:mysql://localhost:3306/schoodle?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";

	protected Connection connect() throws ClassNotFoundException{
        Connection conn = null;
        try {
        	Class.forName(COM_MYSQL_JDBC_DRIVER);
            conn = DriverManager.getConnection (MYSLDB, DBUSER, PASSWORD);
        } catch (SQLException e) {
			System.out.println("DB error");
			e.printStackTrace();
        }
        return conn;
    }
	
	protected Date toJavaDate(java.sql.Date sqlDate) {
		return sqlDate != null ? new Date(sqlDate.getTime()) : null;
	}

	protected boolean toBoolean(int val) {
		return val==1;
	}
}
