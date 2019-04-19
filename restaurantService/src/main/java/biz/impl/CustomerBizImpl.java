package biz.impl;

import java.util.List;

import admin.Customer;
import biz.CustomerBiz;
import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;

public class CustomerBizImpl implements CustomerBiz {
	private CustomerDao customerDao;
	
	/**
	 * 
	 */
	public CustomerBizImpl() {
		super();
		this.customerDao = new CustomerDaoImpl();
	}

	public List<Customer> selectAllCustimerId() {
	
		return customerDao.findAllCustimerId();
	}

	public List<Customer> selectAllCustimer() {
	
		return customerDao.findAllCustimer();
	}

	public String addCustomer(Customer c) {
	
		return this.customerDao.insertCustomer(c)?"添加成功":"添加失败";
	}

	public String updateCustomerById(Customer c) {
		
		return this.customerDao.modifyCustomerById(c)?"修改成功":"修改失败";
	}

	public Customer selectCustomerById(int id) {
		
		return this.customerDao.findCustomerById(id);
	}

	public String deleteCustomerById(int id) {
		
		return this.customerDao.removeCustomerById(id)?"删除成功":"删除失败";
	}
}
