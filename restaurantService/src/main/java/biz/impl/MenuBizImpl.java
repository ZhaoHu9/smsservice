package biz.impl;

import java.util.List;

import admin.Menus;
import biz.MenuBiz;
import dao.MenuDao;
import dao.impl.MenuDaoImpl;

public class MenuBizImpl implements MenuBiz {
	private MenuDao menuDao;
	
	/**
	 * @param menuDao
	 */
	public MenuBizImpl() {
		super();
		this.menuDao = new MenuDaoImpl();
	}

	public String addMenu(Menus m) {

		return this.menuDao.insertMenu(m)?"添加成功":"添加失败";
	}

	public String deleteMenu(int id) {

		return this.menuDao.removeMenu(id)?"删除成功":"删除失败";
	}

	public String upadteMenu(Menus m) {

		return this.menuDao.modifyMenu(m)?"修改成功":"修改失败";
	}

	public List<Menus> selectAllMenu() {

		return this.menuDao.findAllMenu();
	}

	public Menus selectMenuById(int id) {

		return this.menuDao.findMenuById(id);
	}

	public List<Menus> selectAllMuByTp(int id) {

		return this.menuDao.findAllMuBuTp(id);
	}

}
