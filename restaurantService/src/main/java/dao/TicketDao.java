package dao;

import java.util.List;

import admin.Ticket;

public interface TicketDao {
	//打印小票抬头
	public List<Ticket> printTicket();
	//录入小票抬头
	public boolean insertTicket(Ticket t);
	//根据id查询小票
	public Ticket findTicketById(int id);
	//查询最大id+1
	public int selectTicketid();
}
