package biz;

import java.util.List;

import admin.Menu;

public interface MenuBiz {
	//录入菜品，价格，类型
	public String addMenu(Menu m);
	//删除菜品
	public String deleteMenu(int id);
	//修改菜品，价格，类型
	public String upadteMenu(int id);
	//查询所有菜品 list
	public List<Menu> selectAllMenu();
	//根据id查询 
	public Menu selectMenuById(int id);
}
