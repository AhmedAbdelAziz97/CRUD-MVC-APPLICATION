package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmpDB {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/employeedb?user=root&password=");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(Emp e) {
		int status = 0;
		try {
			Connection con = EmpDB.getConnection();
			PreparedStatement ps = ((java.sql.Connection) con).prepareStatement("insert into employeeinfo(name,email,password,salary) values (?,?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getSalary());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Emp e) {
		int status = 0;
		try {
			Connection con = EmpDB.getConnection();
			PreparedStatement ps = con.prepareStatement("update employeeinfo set name=?,email=?,password=?, salary=? where id=?");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPassword());
			ps.setString(5, e.getSalary());
			

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = EmpDB.getConnection();
			System.out.println("delete id : " + id);
			PreparedStatement ps = ((java.sql.Connection) con).prepareStatement("delete from employeeinfo where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			System.out.println("delete status : " + status);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Emp getEmployeeById(int id) {
		Emp e = new Emp();

		try {
			Connection con = EmpDB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employeeinfo where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPassword(rs.getString(4));
				e.setSalary(rs.getString(5));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<Emp> getAllEmployees() {
		List<Emp> list = new ArrayList<Emp>();

		try {
			Connection con = EmpDB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employeeinfo");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPassword(rs.getString(4));
				e.setSalary(rs.getString(5));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
