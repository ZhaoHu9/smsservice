package biz.impl;

import java.util.List;

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

	public List<Ticket> printTicket() {
		return this.ticketDao.printTicket();
	}

	public String addTicket(Ticket t) {

		return this.ticketDao.insertTicket(t)?"添加成功":"添加失败";
	}


	public int findTicketid() {

		return this.ticketDao.selectTicketid();
	}

}
