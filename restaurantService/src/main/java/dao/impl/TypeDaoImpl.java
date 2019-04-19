package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import admin.Type;
import dao.TypeDao;
import util.DBUtil;

public class TypeDaoImpl implements TypeDao {
	private DBUtil db;
	public List<Type> findAllType() {
		this.db = new DBUtil();
		String sql = "select * from eattype";
		try {
			ResultSet rs = this.db.query(sql);
			List<Type> list = new ArrayList<Type>();
			while(rs.next()) {
				list.add(new Type(rs.getInt("typeid"), rs.getString("typename")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Type findTypeById(int id) {
		this.db = new DBUtil();
		String sql = "select * from eattype where id = "+id;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new Type(rs.getInt("typeid"), rs.getString("typename"));
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

	public boolean insertType(Type t) {
		this.db = new DBUtil();
		String sql = "insert into eattype values(?,?)";
		try {
			int i = this.db.update(sql, t.getTypename(),t.getTypeid());
			return i>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
	}

	public boolean removeTypeById(int id) {
		this.db = new DBUtil();
		String sql = "delete from eattype where typeid = "+id;
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

	public boolean modifyTypeById(Type t) {
		this.db = new DBUtil();
		String sql = "update eattype set typeid =?,typename =? where eatid ="+t.getTypeid();
		try {
			int i = this.db.update(sql, t.getTypeid(),t.getTypename());
			return i>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
	}

}
