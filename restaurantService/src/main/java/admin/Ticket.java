package admin;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Ticket implements Serializable{
	//订单编号
	private int id;
	private int empid;
	private Date date;
	//打印编号
	private UUID uuid;
	private int vipid;
	
	/**
	 * 
	 */
	public Ticket() {
		super();
	}



	/**
	 * @param id
	 * @param empid
	 * @param date
	 * @param uuid
	 */
	public Ticket( int empid, Date date, UUID uuid) {
		super();
		this.empid = empid;
		this.date = date;
		this.uuid = uuid;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getEmpid() {
		return empid;
	}



	public void setEmpid(int empid) {
		this.empid = empid;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public UUID getUuid() {
		return uuid;
	}



	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}



	public int getVipid() {
		return vipid;
	}



	public void setVipid(int vipid) {
		this.vipid = vipid;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.uuid+"\t"+this.empid+"\t"+this.date;
	}
}
