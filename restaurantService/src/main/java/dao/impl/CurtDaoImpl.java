package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import dao.CurtDao;
import util.DBUtil;

public class CurtDaoImpl implements CurtDao {
	private DBUtil db;
	
	public boolean insertCurt( Map<Integer, Integer> m) {
		this.db = new DBUtil();
		String sql = "insert into curt values((select max(ticketid) from ticket),?,?)";
		Set<Integer> key = m.keySet();
		for (Integer i : key) {
			int i3 = m.get(i);
			try {
				int i2 = this.db.update(sql,i,i3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally {
				this.db.closed();
			}
		}
		return true;
	}

	public boolean removeCurt(int id) {
		this.db = new DBUtil();
		String sql = "delete from curt where eatid = "+id;
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

	public boolean removeAllCurt() {
		// TODO Auto-generated method stub
		return false;
	}

	public Map<Integer, Integer> findAllCurt(int id) {
		this.db = new DBUtil();
		String sql ="select * from curt where ticketid = "+id;
		try {
			ResultSet rs = this.db.query(sql);
			Map<Integer, Integer> map = new HashMap<Integer, Integer>() ;
			while(rs.next()) {
				map.put(rs.getInt("eatid"), rs.getInt("eatnum"));
			}
			return map;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean modifyCurt(int id) {
		this.db = new DBUtil();
		String sql = "update curt where eatid = "+id;
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
