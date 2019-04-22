package biz;

import java.util.Map;

public interface CurtBiz {
	//订单行信息增加
	public String addCurt(Map<Integer, Integer> m);
	//订单行删除信息 根据id
	public String deleteCurt(int id);
	//订单行删除全部信息
	public String deleteAllCurt();
	//订单行查询全部信息
	public Map<Integer, Integer> selectAllCurt();
	//根据id更改物品数量
	public String updateCurt(int id);
}
