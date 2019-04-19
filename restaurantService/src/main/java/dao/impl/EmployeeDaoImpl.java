package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.Employee;
import dao.EmployeeDao;
import util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	private DBUtil db;
	public Employee login(int id, String password) {
		this.db = new DBUtil();
		String sql = "select * from employee where id = ? and password = ?";
		try {
			ResultSet rs = this.db.query(sql, id,password);
			if(rs.next()) {
				return new Employee(rs.getInt("empid"), rs.getString("empname"), rs.getString("empsex"), rs.getInt("empphone"), rs.getInt("emplevel"), rs.getString("emppassword"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			this.db.closed();
		}
		return null;
	}

	public boolean insertEmployee(Employee e) {
		this.db = new DBUtil();
		String sql = "insert into employee values(序列,?,?,?,?,?)";
		try {
			int i = this.db.update(sql, e.getEmpname(),e.getEmpsex(),e.getEmpphone(),e.getEmplevel(),e.getEmppassword());
			return i>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
	}

	public boolean removeEmployee(int id) {
		this.db = new DBUtil();
		String sql = "delete from employee where empid = "+id;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
	}

	public boolean modifyEmployee(Employee e) {
		this.db = new DBUtil();
		String sql = "update employee set empid =?,empname =?,empsex =?,empphone =?,emplevel =?,emppassword =?";
		try {
			int i = this.db.update(sql, e.getEmpid(),e.getEmpname(),e.getEmpsex(),e.getEmpphone(),e.getEmplevel(),e.getEmppassword());
			return i>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
	}

	public Employee findEmployeeById(int id) {
		this.db = new DBUtil();
		String sql = "select * from employee where id = "+id;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new Employee(rs.getInt("empid"), rs.getString("empname"), rs.getString("empsex"), rs.getInt("empphone"), rs.getInt("emplevel"), rs.getString("emppassword"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			this.db.closed();
		}
		return null;
	}

	public List<Employee> findAllEmployee() {
		this.db = new DBUtil();
		String sql = "select * from employee";
		try {
			ResultSet rs = this.db.query(sql);
			List<Employee> list = new ArrayList<Employee>();
			while(rs.next()) {
				list.add(new Employee(rs.getInt("empid"), rs.getString("empname"), rs.getString("empsex"), rs.getInt("empphone"), rs.getInt("emplevel"), rs.getString("emppassword")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
