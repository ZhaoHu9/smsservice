package dao;

import java.util.List;

import admin.Menus;
import admin.Salnum;

public interface SalnumDao {
	//查询菜品月销量 降序 list
	public List<Salnum> findAllNum();
}
