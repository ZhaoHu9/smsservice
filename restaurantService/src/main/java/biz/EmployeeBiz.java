package biz;

import java.util.List;

import admin.Employee;

public interface EmployeeBiz {
	//登录
	public Employee login(int id,String password);
	//录入员工信息
	public String addEmployee(Employee e);
	//删除员工信息
	public String deleteEmployee(int id);
	//修改员工信息
	public String updateEmployee(Employee e);
	//查询员工信息根基id
	public Employee selectEmployeeById(int id);
	//查询所有员工信息
	public List<Employee> selectAllEmployee();
}
