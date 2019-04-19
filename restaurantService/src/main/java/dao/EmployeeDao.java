package dao;

import java.util.List;

import admin.Employee;

public interface EmployeeDao {
	//登录
	public Employee login(int id,String password);
	//录入员工信息
	public boolean insertEmployee(Employee e);
	//删除员工信息
	public boolean removeEmployee(int id);
	//修改员工信息
	public boolean modifyEmployee(Employee e);
	//查询员工信息根基id
	public Employee findEmployeeById(int id);
	//查询所有员工信息
	public List<Employee> findAllEmployee();
}
