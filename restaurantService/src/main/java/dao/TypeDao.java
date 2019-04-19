package dao;

import java.util.List;

import admin.Type;

public interface TypeDao {
	//查询所有菜品类别 id 名称
	public List<Type> findAllType();
	//根据id查找具体菜类别
	public Type findTypeById(int id);
	
	public boolean insertType(Type t);
	
	public boolean modifyTypeById(Type t);
	
	public boolean removeTypeById(int id);
}
