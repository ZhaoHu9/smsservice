package biz;

import admin.Ticket;

public interface TicketBiz {
	//打印小票抬头
	public void printTicket(int id);
	//录入小票抬头
	public String addTicket(Ticket t);
	//查找最大id+1
	public int findTicketid();
}
