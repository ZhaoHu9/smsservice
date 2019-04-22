package test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.Test;

import admin.Curt;
import admin.Customer;
import admin.Employee;
import admin.Menus;
import admin.Salnum;
import admin.Ticket;
import admin.Type;
import admin.Vip;
import dao.CurtDao;
import dao.CustomerDao;
import dao.EmployeeDao;
import dao.MenuDao;
import dao.SalnumDao;
import dao.TicketDao;
import dao.TypeDao;
import dao.VipDao;
import dao.impl.CurtDaoImpl;
import dao.impl.CustomerDaoImpl;
import dao.impl.EmployeeDaoImpl;
import dao.impl.MenuDaoImpl;
import dao.impl.SalnumDaoImpl;
import dao.impl.TicketDaoImpl;
import dao.impl.TypeDaoImpl;
import dao.impl.VipDaoImpl;

public class Mytest {
	@Test
	public void addemployee() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee e = new Employee(10002, "张三", "男", 123456, 1, "123456");
 		boolean b = employeeDao.insertEmployee(e);
 		System.err.println(b);
	}
	@Test
	public void addCustomer() {
		CustomerDao customerDao = new CustomerDaoImpl();
		Customer c = new Customer(1000, "赵1", "男", 199999);
		boolean b = customerDao.insertCustomer(c);
		System.out.println(b);
	}
	@Test
	public void addTicket() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TicketDao ticketDao = new TicketDaoImpl();
		try {
			Date d = sd.parse(sd.format(new Date()));
			Ticket t = new Ticket(10001,d,UUID.randomUUID(),132);
			boolean b = ticketDao.insertTicket(t);
			System.err.println(sd.format(t.getDate()));
			System.out.println(b);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void addVip() {
		Vip vip = new Vip(132, 111, 1, 1, 0.95, 500);
		VipDao vipDao = new VipDaoImpl();
		System.out.println(vipDao.insertVip(vip));
	}
	@Test
	public void addType() {
		Type t = new Type(4, "酒水");
		TypeDao typeDao = new TypeDaoImpl();
		System.err.println(typeDao.insertType(t));
	}
	@Test
	public void addMenu() {
		Menus menus = new Menus("果粒橙", 4, 1, 100, 5);
		MenuDao menuDao = new MenuDaoImpl();
		System.out.println(menuDao.insertMenu(menus));
	}
	@Test
	public void addSal() {
		Salnum salnum = new Salnum(4, 20);
		SalnumDao salnumDao = new SalnumDaoImpl();
		System.out.println(salnumDao.insertSal(salnum));
	}
	@Test
	public void selectSal() {
		SalnumDao salnumDao = new SalnumDaoImpl();
		List list = salnumDao.findAllNum();
		for (Object object : list) {
			System.out.println(object);
		}
	}
	@Test
	public void showUuid() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TicketDao ticketDao = new TicketDaoImpl();
		try {
			Date d = sd.parse(sd.format(new Date()));
			Ticket t = new Ticket(1001, 10001 ,d,UUID.randomUUID(),131);
			System.out.println(sd.format(t.getDate()));
			String id = t.getUuid().toString().replaceAll("-", "");
			System.out.println(id);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void addCurt() {
		CurtDao curtDao = new CurtDaoImpl();
		Map map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		System.out.println(curtDao.insertCurt(map));
	}
}
