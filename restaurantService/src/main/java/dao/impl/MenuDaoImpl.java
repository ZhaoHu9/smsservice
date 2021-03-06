package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import admin.Menus;
import dao.MenuDao;
import util.DBUtil;

public class MenuDaoImpl implements MenuDao {
	private DBUtil db;
	public boolean insertMenu(Menus m) {
		this.db = new DBUtil();
		String sql = "insert into menu values(seq_menu.nextval,?,?,?,?)";
		String sql2 = "insert into price values(seq_menu.currval,?)";
		try {
			int i = this.db.update(sql,m.getEatname(),m.getTypeid(),m.getEatlevel(),m.getEatstock());
			int i2 = this.db.update(sql2,m.getEatprice());
			return i>0 & i2>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
	}

	public boolean removeMenu(int id) {
		this.db = new DBUtil();
		String sql = "update menu set eatlevel = 0 where eatid = "+id;
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

	public boolean modifyMenu(Menus m) {
		this.db = new DBUtil();
		String sql = "update menu set eatname =?,typeid =?,eatlevel =?,eatstock =? where eatid =?";
		try {
			int i = this.db.update(sql, m.getEatname(),m.getTypeid(),m.getEatlevel(),m.getEatstock(),m.getEatid());
			return i>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
	}

	public List<Menus> findAllMenu() {
		this.db = new DBUtil();
		String sql = "select * from menu m,price p where m.eatid = p.eatid(+)";
		try {
			ResultSet rs = this.db.query(sql);
			List<Menus> list = new ArrayList<Menus>();
			while(rs.next()) {
				list.add(new Menus(rs.getInt("eatid"), rs.getString("eatname"), rs.getInt("typeid"), rs.getInt("eatlevel"), rs.getInt("eatstock"), rs.getDouble("eatprice")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Menus findMenuById(int id) {
		this.db = new DBUtil();
		String sql = "select * from menu m,price p where (m.eatid = ?) and m.eatid = p.eatid(+)";
		try {
			ResultSet rs = this.db.query(sql,id);
			if (rs.next()) {
				return new Menus(rs.getInt("eatid"), rs.getString("eatname"), rs.getInt("typeid"), rs.getInt("eatlevel"), rs.getInt("eatstock"), rs.getDouble("eatprice"));
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

	public List<Menus> findAllMuBuTp(int id) {
		this.db = new DBUtil();
		String sql = "select * from menu m,price p where (m.typeid = ?) and m.eatid = p.eatid(+)";
		try {
			ResultSet rs = this.db.query(sql ,id);
			List<Menus> list = new ArrayList<Menus>();
			while(rs.next()) {
				list.add(new Menus(rs.getInt("eatid"), rs.getString("eatname"), rs.getInt("typeid"), rs.getInt("eatlevel"), rs.getInt("eatstock"), rs.getDouble("eatprice")));
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
