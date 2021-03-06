package dao;

import java.util.List;

import admin.Menus;
import admin.Salnum;

public interface SalnumDao {
	//查询菜品月销量 降序 list
	public List<Salnum> findAllNum();
	//增加销量
	public boolean insertSal(Salnum s);
	//查找id 和销量
	public Salnum findSal(int id);
	//修改销量
	public boolean modifySal(Salnum s);
}
