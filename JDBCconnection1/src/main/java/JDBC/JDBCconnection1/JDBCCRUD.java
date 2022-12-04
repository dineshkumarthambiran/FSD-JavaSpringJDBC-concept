package JDBC.JDBCconnection1;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;



	public class JDBCCRUD
	{
		
		Connection con;
		Statement statement;
		String url = "jdbc:mysql://localhost:3306/natwest";
		String dbuser = "root";
		String dbpass = "Mysql";
		
		public void Connection() throws Exception{
			
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("driver loaded success");
			
			con= DriverManager.getConnection(url,dbuser,dbpass);
			
			System.out.println("db connected");
			
			statement = con.createStatement();
			
			System.out.println("statement executed");
					
			
		}
		
		
		public void insertEmployee(Employee employee) throws Exception
		{
			statement.execute("insert into Employee2 values"+
		"('"+ employee.getEid()+"','" + employee.getEname()+"','"+ employee.getLocation()+"','" + employee.getSalary()+"')");
	
		}
//		
//		public List<Employee> getallRecords() throws Exception{
//			
//		List<Employee> employeelist= new LinkedList<>();
//		ResultSet res = statement.executeQuery("select * from Employee2 ");
//		
//		while(employeelist)
//		{
//		
//		}}
		
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			JDBCCRUD jdbccrud = new JDBCCRUD();
				
			Employee employee =  new Employee();
			
			employee.setEid(1);
			employee.setEname("dinesh");
			employee.setLocation("chennai");
			employee.setSalary(10000);
			
			try {
				jdbccrud.Connection();
				jdbccrud.insertEmployee(employee);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
					
			
	
		}
	
	}
