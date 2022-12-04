package JDBC.JDBCconnection1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

	public class JdbcInsert {
	
		
		Connection con ;
		Statement statement;
		
		public void establishConnection() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/natwest","root","Mysql");
			System.out.println("database connected");
			statement = con.createStatement();
			System.out.println("statement initiated");
			
			}
		
//		public void InsertRecord(int eid,String ename ,String location,int salary) {
//			
//			try {
//				statement.execute("insert into Employee2 values"+"(eid,ename,location,salary)");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
		public void InsertRecord(Employee employee) {
//			
			try {
				statement.execute("insert into Employee2 values"+"('"+ employee.getEid()+"','"+employee.getEname()+"','"+employee.getLocation()+"','"+employee.getSalary()+"')");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public List<Employee> getAllRecords() throws Exception{
					List<Employee> emplist = new LinkedList<>();
			ResultSet rs = statement.executeQuery("select * from Employee2");

			while(rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print(rs.getString(2));
				System.out.print(rs.getString(3));
				System.out.println(rs.getInt(4));
				emplist.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			
			return emplist;
		

		}
		
		public Employee getARecord(int eid) throws SQLException {
			ResultSet rs = statement.executeQuery("Select * from Employee2 where eid = "+eid+"");
			rs.next();
			return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		}
		
		public Employee UpdateARecord(Employee employee) throws SQLException {
			statement.execute("Update Employee2 set ename='"+employee.getEname()+"',location='"+employee.getLocation()+"',salary='"+employee.getSalary()+"' where eid = '"+employee.getEid()+"'");
			return employee;
		}
		
		public Employee deleteARecord(int eid) throws SQLException {
			Employee employee = getARecord(eid);
			statement.execute("delete from Employee2 where eid='"+eid+"' ");
			
			return employee;
			
		}
		
		
	public static void main(String[] args) {
		
			Scanner s = new Scanner(System.in);
				
			JdbcInsert rec1 = new JdbcInsert();
			
			try {
				rec1.establishConnection();
//				System.out.println("enter record to inserted");
//				int id = s.nextInt();
//				String name = s.nextLine();
//				String location = s.nextLine();
//				int salary = s.nextInt();
//				
				
//				Employee employee = new Employee();
//				employee.setEid(3);
//				employee.setEname("raja");
//				employee.setLocation("trichy");
//				employee.setSalary(250000);
//				
//				rec1.InsertRecord(employee);
//				rec1.getAllRecords();
				
				
//				Employee found =rec1.getARecord(2);
//				System.out.println(found);
				
				Employee employeelatest = new Employee(1,"dina","Chennai",45000);
				Employee updaterec = rec1.UpdateARecord(employeelatest);
				System.out.println(updaterec);
				
//				Employee deleteemp = rec1.deleteARecord(3);
//				System.out.println(deleteemp +"has been deleted");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
