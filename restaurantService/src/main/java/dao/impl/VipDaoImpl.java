package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.Vip;
import dao.VipDao;
import util.DBUtil;

public class VipDaoImpl implements VipDao {
	private DBUtil db;
	public boolean insertVip(Vip v) {
		this.db = new DBUtil();
		String sql = "insert into viptable values(序列,?,?,?,?,?)";
		try {
			int i = this.db.update(sql, v.getCurid(),v.getViplevel(),v.getVipstate(),v.getVipdiscount(),v.getVipdalance());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
	}
//冻结
	public boolean removeVipById(int id) {
		this.db = new DBUtil();
		String sql ="update viptable set viplevel = 0";
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

	public Vip findVipById(int id) {
		this.db = new DBUtil();
		String sql="select * from viptable where vipid ="+id;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new Vip(rs.getInt("vipid"), rs.getInt("curid"), rs.getInt("viplevel"), rs.getInt("vipstate"), rs.getInt("vipdiscount"),rs.getDouble("vipdalance"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
//修改
	public boolean modifyVipById(Vip v) {
		this.db = new DBUtil();
		String sql ="update viptable set vipdalance =? where vipid ="+v.getVipid();
		try {
			int i = this.db.update(sql,v.getVipdalance());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
	}

	public List<Vip> findAllVip() {
		this.db = new DBUtil();
		String sql ="select * from viptable";
		try {
			ResultSet rs = this.db.query(sql);
			List<Vip> list = new ArrayList<Vip>();
			while(rs.next()) {
				list.add(new Vip(rs.getInt("vipid"),rs.getInt("curid"), rs.getInt("viplevel"), rs.getInt("vipstate"), rs.getInt("vipdiscount"),rs.getDouble("vipdalance")));
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

}
