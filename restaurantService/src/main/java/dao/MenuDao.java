package dao;

import java.util.List;

import admin.Menus;

public interface MenuDao {
	//录入菜品，价格，类型
	public boolean insertMenu(Menus m);
	//删除菜品
	public boolean removeMenu(int id);
	//修改菜品，价格，类型
	public boolean modifyMenu(Menus m);
	//查询所有菜品 list
	public List<Menus> findAllMenu();
	//根据id查询 
	public Menus findMenuById(int id);
}
