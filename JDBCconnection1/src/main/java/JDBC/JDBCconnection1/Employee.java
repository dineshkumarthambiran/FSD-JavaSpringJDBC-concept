package JDBC.JDBCconnection1;

public class Employee {
	
	int eid ,salary ;
	String ename,
	location ;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int eid, String ename,String location,int salary) {
		super();
		this.eid = eid;
		this.salary = salary;
		this.ename = ename;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", salary=" + salary + ", ename=" + ename + ", location=" + location + "]";
	}
	
	
	
	
	

}
