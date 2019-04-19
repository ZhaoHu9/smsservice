package biz.impl;

import java.util.List;

import admin.Type;
import biz.TypeBiz;
import dao.TypeDao;
import dao.impl.TypeDaoImpl;

public class TypeBizImpl implements TypeBiz {
	private TypeDao typeDao;
	
	/**
	 * @param typeDao
	 */
	public TypeBizImpl() {
		super();
		this.typeDao = new TypeDaoImpl();
	}

	public List<Type> selectAllType() {

		return this.typeDao.findAllType();
	}

	public Type selectTypeById(int id) {

		return this.typeDao.findTypeById(id);
	}

	public String addType(Type t) {

		return this.typeDao.insertType(t)?"添加成功":"添加失败";
	}

	public String deleteTypeById(int id) {

		return this.typeDao.removeTypeById(id)?"删除成功":"删除失败";
	}

	public String updateTypeById(Type t) {

		return this.typeDao.modifyTypeById(t)?"修改成功":"修改失败";
	}

}
