package dao;

import java.util.Map;

public interface CurtDao {
	//订单行信息增加
	public boolean insertCurt(Map<Integer, Integer> m);
	//订单行删除信息 根据id
	public boolean removeCurt(int id);
	//订单行删除全部信息
	public boolean removeAllCurt();
	//订单行查询全部信息
	public Map<Integer, Integer> findAllCurt(int id);
	//根据id更改物品数量
	public boolean modifyCurt(int id);
}
