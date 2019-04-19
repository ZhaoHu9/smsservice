package biz;

import java.util.List;

import admin.Salnum;

public interface SalnumBiz {
	//查询菜品月销量 降序 list
	public List<Salnum> selectAllNum();
	//增加销量
	public String addSal(Salnum s);
	//查询销量是否存在
	public boolean selectSal(int id);
	//更改销量
	public String updateSal(Salnum s);
}
