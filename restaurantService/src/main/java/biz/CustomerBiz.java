package biz;

import java.util.List;

import admin.Customer;

public interface CustomerBiz {
	//查询所有客户id 返回list
	public List<Customer> selectAllCustimerId();
	//查询所有客户  list
	public List<Customer> selectAllCustimer();
	//录入客户信息
	public String addCustomer(Customer c);
	//删除客户信息 通过id
	public String selectCustomerById(int id);
	//修改客户信息
	public String updateCustomerById(int id);
}
