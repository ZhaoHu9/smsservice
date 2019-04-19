package biz.impl;

import java.util.List;

import admin.Salnum;
import biz.SalnumBiz;
import dao.SalnumDao;
import dao.impl.SalnumDaoImpl;

public class SalnumBizImpl implements SalnumBiz {
	private SalnumDao salnumDao;
	
	/**
	 * @param salnumDao
	 */
	public SalnumBizImpl() {
		super();
		this.salnumDao = new SalnumDaoImpl();
	}

	public List<Salnum> selectAllNum() {
		// TODO Auto-generated method stub
		return this.salnumDao.findAllNum();
	}

	public String addSal(Salnum s) {
		// TODO Auto-generated method stub
		return this.salnumDao.insertSal(s)?"添加成功":"添加失败";
	}

	public boolean selectSal(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public String updateSal(Salnum s) {
		// TODO Auto-generated method stub
		return null;
	}

}
