package dao;

import java.util.List;

import admin.Customer;

public interface CustomerDao {
	//查询所有客户id 返回list
	public List findAllCustimerId();
	//查询所有客户  list
	public List<Customer> findAllCustimer();
	//录入客户信息
	public boolean insertCustomer(Customer c);
	//查找顾客通过id
	public Customer findCustomerById(int id);
	//删除客户信息 通过id
	public boolean removeCustomerById(int id);
	//修改客户信息
	public boolean modifyCustomerById(Customer c);
}
