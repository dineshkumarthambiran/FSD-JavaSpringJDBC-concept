package JDBC.JDBCconnection1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchInput {


	Connection con ;
	Statement statement;
	
	public void establishConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/natwest","root","Mysql");
		System.out.println("database connected");
	}
	
	public void insertManyRecord() throws SQLException {
		statement = con.createStatement();
		statement.addBatch("Insert into Employee2 values ('1','Dinesh','chennai','20000'),('2','dina','Delhi','30000')");
		statement.addBatch("delete from Employee2 where eid = '2'");
		statement.executeBatch();
		
	}
	
	public static void main(String[] args) {
		
		JdbcBatchInput batch = new JdbcBatchInput();
		try {
			batch.establishConnection();
			batch.insertManyRecord();
			
			System.out.println("batch execution done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
