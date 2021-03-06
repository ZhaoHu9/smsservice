package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.Salnum;
import dao.SalnumDao;
import util.DBUtil;

public class SalnumDaoImpl implements SalnumDao {
	private DBUtil db;
	public List findAllNum() {
		this.db = new DBUtil();
		String sql ="select m.eatname,s.salnum from salnum s,menu m where m.eatid = s.eatid order by s.salnum desc";
		try {
			ResultSet rs = this.db.query(sql);
			List list = new ArrayList();
			while(rs.next()){
				list.add(rs.getString("eatname")+"\t"+rs.getInt("salnum"));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public boolean insertSal(Salnum s) {
		this.db = new DBUtil();
		String sql = "insert into salnum values(?,?)";
		try {
			int i = this.db.update(sql, s.getEatid(),s.getSalnum());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
	}
	public Salnum findSal(int id) {
		this.db = new DBUtil();
		String sql ="select * from salnum where eatid="+id;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new Salnum(rs.getInt("eatid"), rs.getInt("salnum"));
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
	public boolean modifySal(Salnum s) {
		this.db = new DBUtil();
		String sql ="update salnum set salnum =? where eatid =?";
		try {
			int i = this.db.update(sql, s.getSalnum(),s.getEatid());
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
