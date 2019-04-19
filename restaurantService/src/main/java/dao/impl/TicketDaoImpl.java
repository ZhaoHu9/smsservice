package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.TicketDao;
import util.DBUtil;

public class TicketDaoImpl implements TicketDao {
	private DBUtil db;
	public void printTicket(int id) {
		this.db = new DBUtil();
		String sql = "select * from ticket where ticketid ="+id;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()) {
				System.out.println(rs.getInt("ticketid")+"\t"+rs.getInt("empid")+"\t"+rs.getDate("date")+"\t"+rs.getString("uuid")+"\t"+rs.getInt("vipid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.db.closed();
		}
	}

}
