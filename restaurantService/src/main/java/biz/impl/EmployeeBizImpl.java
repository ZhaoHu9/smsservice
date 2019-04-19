package biz.impl;

import java.util.List;

import admin.Employee;
import biz.EmployeeBiz;
import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;

public class EmployeeBizImpl implements EmployeeBiz {
	private EmployeeDao employeeDao;
	
	/**
	 * @param employeeDao
	 */
	public EmployeeBizImpl() {
		super();
		this.employeeDao = new EmployeeDaoImpl();
	}

	public Employee login(int id, String password) {

		return this.employeeDao.login(id, password);
	}

	public String addEmployee(Employee e) {

		return this.employeeDao.insertEmployee(e)?"添加成功":"添加失败";
	}

	public String deleteEmployee(int id) {

		return this.employeeDao.removeEmployee(id)?"删除成功":"删除失败";
	}

	public String updateEmployee(Employee e) {

		return this.employeeDao.modifyEmployee(e)?"修改成功":"修改失败";
	}

	public Employee selectEmployeeById(int id) {

		return this.employeeDao.findEmployeeById(id);
	}

	public List<Employee> selectAllEmployee() {

		return this.employeeDao.findAllEmployee();
	}

}
