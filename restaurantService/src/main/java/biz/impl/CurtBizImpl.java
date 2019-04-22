package biz.impl;

import java.util.Map;

import biz.CurtBiz;
import dao.CurtDao;
import dao.impl.CurtDaoImpl;

public class CurtBizImpl implements CurtBiz {
	private CurtDao curtDao;
	
	/**
	 * @param curtDao
	 */
	public CurtBizImpl() {
		super();
		this.curtDao = new CurtDaoImpl();
	}

	public String addCurt(Map<Integer, Integer> m) {
		
		return this.curtDao.insertCurt( m)?"添加成功":"添加失败";
	}

	public String deleteCurt(int id) {
		
		return this.curtDao.removeCurt(id)?"删除成功":"删除失败";
	}

	public String deleteAllCurt() {
		
		return this.curtDao.removeAllCurt()?"删除成功":"删除失败";
	}

	public Map<Integer, Integer> selectAllCurt() {
		
		return this.curtDao.findAllCurt();
	}

	public String updateCurt(int id) {
		
		return this.curtDao.modifyCurt(id)?"修改成功":"修改失败";
	}

}
