package JDBC.JDBCconnection1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PreparedStatementDemo {
	
	Connection con ;
	Statement statement;
	
	public void establishConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/natwest","root","Mysql");
		System.out.println("database connected");
//		statement = con.createStatement();
//		System.out.println("statement initiated");
		
		}
	

}
