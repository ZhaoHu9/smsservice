package biz;

import java.util.List;

import admin.Vip;

public interface VipBiz {
	//录入vip信息
	public String addVip(Vip v);
	//删除vip信息
	public String deleteVipById(int id);
	//根据id查询vip信息
	public Vip selectVipById(int id);
	//修改vip信息
	public String updateVipById(Vip v);
	//查询vip信息 所有
	public List<Vip> selectAllVip();
}
