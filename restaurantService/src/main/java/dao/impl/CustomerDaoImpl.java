package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.Customer;
import dao.CustomerDao;
import util.DBUtil;

public class CustomerDaoImpl implements CustomerDao {
	private DBUtil db;
	public List findAllCustimerId() {
		this.db = new DBUtil();
		String sql ="select curid from customer";
		try {
			ResultSet rs = this.db.query(sql);
			List list = new ArrayList();
			while(rs.next()) {
				list.add(rs);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			this.db.closed();
		}
	}

	public List<Customer> findAllCustimer() {
		this.db = new DBUtil();
		String sql ="select * from customer";
		try {
			ResultSet rs = this.db.query(sql);
			List<Customer> list = new ArrayList<Customer>();
			while(rs.next()) {
				list.add(new Customer(rs.getInt("curid"), rs.getString("curname"), rs.getString("cursex"), rs.getInt("curphone")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			this.db.closed();
		}
	}

	public boolean insertCustomer(Customer c) {
		this.db = new DBUtil();
		String sql = "insert into customer values(?,?,?,?)";
		try {
			int i = this.db.update(sql, c.getCurid(),c.getCurname(),c.getCursex(),c.getCurphone());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
	}

	public Customer findCustomerById(int id) {
		this.db = new DBUtil();
		String sql ="select * from customer where curid="+id;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new Customer(rs.getInt("curid"), rs.getString("curname"), rs.getString("cursex"), rs.getInt("curphone"));
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

	public boolean modifyCustomerById(Customer c) {
		this.db = new DBUtil();
		String sql ="update Customer set curid=?,curname=?,cursex=?curphome=? where curid ="+c.getCurid();
		try {
			int i = this.db.update(sql, c.getCurid(),c.getCurname(),c.getCursex(),c.getCurphone());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}          
	}

	public boolean removeCustomerById(int id) {
		this.db = new DBUtil();
		String sql = "delete from customer where empid = "+id;
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

}
