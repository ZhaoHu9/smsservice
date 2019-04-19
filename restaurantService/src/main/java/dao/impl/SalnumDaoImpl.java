package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.SalnumDao;
import util.DBUtil;

public class SalnumDaoImpl implements SalnumDao {
	private DBUtil db;
	public List findAllNum() {
		this.db = new DBUtil();
		String sql ="select * from salnum order by salnum";
		try {
			ResultSet rs = this.db.query(sql);
			List list = new ArrayList();
			while(rs.next()){
				list.add(rs.getInt("eatid"),rs.getInt("eatnum"));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
