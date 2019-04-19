package biz.impl;

import java.util.List;

import admin.Vip;
import biz.VipBiz;
import dao.VipDao;
import dao.impl.VipDaoImpl;

public class VipBizImpl implements VipBiz{
	private VipDao vipDao;
	
	/**
	 * @param vipDao
	 */
	public VipBizImpl() {
		super();
		this.vipDao = new VipDaoImpl();
	}

	public String addVip(Vip v) {

		return this.vipDao.insertVip(v)?"添加成功":"添加失败";
	}

	public String deleteVipById(int id) {

		return this.vipDao.removeVipById(id)?"删除成功":"删除失败";
	}

	public Vip selectVipById(int id) {

		return this.vipDao.findVipById(id);
	}

	public String updateVipById(Vip v) {

		return this.vipDao.modifyVipById(v)?"修改成功":"修改失败";
	}

	public List<Vip> selectAllVip() {
		
		return this.vipDao.findAllVip();
	}

}
