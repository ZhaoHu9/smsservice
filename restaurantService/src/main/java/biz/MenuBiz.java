package biz;

import java.util.List;

import admin.Menus;

public interface MenuBiz {
	//录入菜品，价格，类型
	public String addMenu(Menus m);
	//删除菜品
	public String deleteMenu(int id);
	//修改菜品，价格，类型
	public String upadteMenu(Menus m);
	//查询所有菜品 list
	public List<Menus> selectAllMenu();
	//根据id查询 
	public Menus selectMenuById(int id);
	//根据菜品种类id返回菜单
	public List<Menus> selectAllMuByTp(int id);
}
