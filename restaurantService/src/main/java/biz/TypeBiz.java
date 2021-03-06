package biz;

import java.util.List;

import admin.Type;

public interface TypeBiz {
	//查询所有菜品类别 id 名称
	public List<Type> selectAllType();
	//根据id查找具体菜类别
	public Type selectTypeById(int id);
	//添加
	public String addType(Type t);
	//修改
	public String updateTypeById(Type t);
	//删除
	public String deleteTypeById(int id);
	
}
