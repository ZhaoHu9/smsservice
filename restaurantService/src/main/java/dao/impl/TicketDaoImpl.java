package dao.impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;
import admin.Ticket;
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
	public boolean insertTicket(Ticket t) {
		this.db = new DBUtil();
		String sql = "insert into ticket valuse(?,?,?,?,?)";
		try {
			java.sql.Date s = new java.sql.Date(t.getDate().getTime());
			int i = this.db.update(sql, t.getId(),t.getEmpid(),s,t.getUuid(),t.getVipid());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
	}
	public Ticket findTicketById(int id) {
		this.db = new DBUtil();
		String sql = "select * from ticket where ticketid = "+id;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new Ticket(rs.getInt("id"), rs.getInt("empid"),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("date")), UUID.fromString(rs.getString("uuid")), rs.getInt("vipid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.db.closed();
		}
		return null;
	}
	public int selectTicketid() {
		// TODO Auto-generated method stub
		return 0;
	}

}
