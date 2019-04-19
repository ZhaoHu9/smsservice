package dao;

import java.util.List;

import admin.Vip;

public interface VipDao {
	//录入vip信息
	public boolean insertVip(Vip v);
	//删除vip信息
	public boolean removeVipById(int id);
	//根据id查询vip信息
	public Vip findVipById(int id);
	//修改vip信息
	public boolean modifyVipById(Vip v);
	//查询vip信息 所有
	public List<Vip> findAllVip();
}
