package admin;

import java.io.Serializable;

public class Customer implements Serializable{
	private int curid;
	private String curname;
	private String cursex;
	private int curphone;
	
	/**
	 * 
	 */
	public Customer() {
		super();
	}
	/**
	 * @param curid
	 * @param curname
	 * @param cuesex
	 * @param curphone
	 */
	public Customer(int curid, String curname, String cursex, int curphone) {
		super();
		this.curid = curid;
		this.curname = curname;
		this.cursex = cursex;
		this.curphone = curphone;
	}
	public int getCurid() {
		return curid;
	}
	public void setCurid(int curid) {
		this.curid = curid;
	}
	public String getCurname() {
		return curname;
	}
	public void setCurname(String curname) {
		this.curname = curname;
	}
	public String getCursex() {
		return cursex;
	}
	public void setCursex(String cursex) {
		this.cursex = cursex;
	}
	public int getCurphone() {
		return curphone;
	}
	public void setCurphone(int curphone) {
		this.curphone = curphone;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.curid+"\t"+this.curname+"\t"+this.cursex+"\t"+this.curphone;
	}
}
