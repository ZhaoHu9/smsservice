package biz;

import java.util.List;

import admin.Salnum;

public interface SalnumBiz {
	//查询菜品月销量 降序 list
	public List<Salnum> selectAllNum();
}
