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

		return this.salnumDao.findAllNum();
	}

	public String addSal(Salnum s) {

		return this.salnumDao.insertSal(s)?"添加成功":"添加失败";
	}

	public Salnum selectSal(int id) {

		return this.salnumDao.findSal(id);
	}

	public String updateSal(Salnum s) {

		return this.salnumDao.modifySal(s)?"修改成功":"修改失败";
	}

}
