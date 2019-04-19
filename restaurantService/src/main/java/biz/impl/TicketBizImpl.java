package biz.impl;

import admin.Ticket;
import biz.TicketBiz;
import dao.TicketDao;
import dao.impl.TicketDaoImpl;

public class TicketBizImpl implements TicketBiz {
	private TicketDao ticketDao;
	
	/**
	 * 
	 */
	public TicketBizImpl() {
		super();
		this.ticketDao = new TicketDaoImpl();
	}

	public void printTicket(int id) {
		this.ticketDao.printTicket(id);
	}

	public String addTicket(Ticket t) {

		return this.ticketDao.insertTicket(t)?"添加成功":"添加失败";
	}


	public int findTicketid() {

		return this.ticketDao.selectTicketid();
	}

}
