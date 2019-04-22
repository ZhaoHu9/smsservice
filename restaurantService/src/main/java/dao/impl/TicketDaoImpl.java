package dao.impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import admin.Ticket;
import dao.TicketDao;
import util.DBUtil;

public class TicketDaoImpl implements TicketDao {
	private DBUtil db;
	public List<Ticket> printTicket() {
		this.db = new DBUtil();
		String sql = "select * from ticket";
		List<Ticket> list = new ArrayList<Ticket>();
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()) {
				list.add(new Ticket(rs.getInt("ticketid"), rs.getInt("empid"),rs.getDate("ticketdate"), rs.getString("uuid"), rs.getInt("vipid")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public boolean insertTicket(Ticket t) {
		this.db = new DBUtil();
		String sql = "insert into ticket values(seq_tic.nextval,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?)";
		String sql2 = "insert into ticket(ticketid,empid,ticketdate,uuid) values(seq_tic.nextval,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),?)";
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int i;
			if(t.getVipid() != null) {
				String str = t.getUuid().toString().replaceAll("-", "");
				i = this.db.update(sql,t.getEmpid(),sd.format(t.getDate()),str,t.getVipid());
				return i>0;
			}else if (t.getVipid() == null) {
				String str2 = t.getUuid().toString().replaceAll("-", "");
				i = this.db.update(sql2, t.getEmpid(),sd.format(t.getDate()),str2);
				return i>0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			this.db.closed();
		}
		return false;
	}
	public Ticket findTicketById(int id) {
		this.db = new DBUtil();
		String sql = "select * from ticket where ticketid = "+id;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new Ticket(rs.getInt("id"), rs.getInt("empid"),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("date")), rs.getString("uuid"), rs.getInt("vipid"));
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
