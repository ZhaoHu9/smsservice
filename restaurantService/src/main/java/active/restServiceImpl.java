package active;

import java.util.List;
import java.util.Map;

import admin.Customer;
import admin.Employee;
import admin.Menu;
import admin.Salnum;
import admin.Type;
import admin.Vip;
import biz.CurtBiz;
import biz.CustomerBiz;
import biz.EmployeeBiz;
import biz.MenuBiz;
import biz.SalnumBiz;
import biz.TicketBiz;
import biz.TypeBiz;
import biz.VipBiz;
import biz.impl.CurtBizImpl;
import biz.impl.CustomerBizImpl;
import biz.impl.EmployeeBizImpl;
import biz.impl.MenuBizImpl;
import biz.impl.SalnumBizImpl;
import biz.impl.TicketBizImpl;
import biz.impl.TypeBizImpl;
import biz.impl.VipBizImpl;

public class restServiceImpl implements restService{
	private CurtBiz curtBiz;
	private CustomerBiz customerBiz;
	private EmployeeBiz employeeBiz;
	private MenuBiz menuBiz;
	private SalnumBiz salnumBiz;
	private TicketBiz ticketBiz;
	private TypeBiz typeBiz;
	private VipBiz vipBiz;
	
	
	/**
	 * 
	 */
	public restServiceImpl() {
		this.curtBiz = new CurtBizImpl();
		this.customerBiz = new CustomerBizImpl();
		this.employeeBiz = new EmployeeBizImpl();
		this.menuBiz = new MenuBizImpl();
		this.salnumBiz = new SalnumBizImpl();
		this.ticketBiz = new TicketBizImpl();
		this.typeBiz = new TypeBizImpl();
		this.vipBiz = new VipBizImpl();
	}

	public Employee login(int id, String password) {
		
		return this.employeeBiz.login(id, password);
	}

	public String addCurt(int id, Map<Integer, Integer> m) {
		
		return this.curtBiz.addCurt(id, m);
	}

	public String deleteCurt(int id) {
		
		return this.curtBiz.deleteCurt(id);
	}

	public String deleteAllCurt() {
		
		return this.curtBiz.deleteAllCurt();
	}

	public Map<Integer, Integer> selectAllCurt() {
		
		return this.curtBiz.selectAllCurt();
	}

	public String updateCurt(int id) {
		
		return this.curtBiz.updateCurt(id);
	}

	public String addEmployee(Employee e) {
		
		return this.employeeBiz.addEmployee(e);
	}

	public String deleteEmployee(int id) {
		
		return this.employeeBiz.deleteEmployee(id);
	}

	public String updateEmployee(Employee e) {
		
		return this.employeeBiz.updateEmployee(e);
	}

	public Employee selectEmployeeById(int id) {
		
		return this.employeeBiz.selectEmployeeById(id);
	}

	public List<Employee> selectAllEmployee() {
		
		return this.employeeBiz.selectAllEmployee();
	}

	public List<Customer> selectAllCustimerId() {
		
		return this.customerBiz.selectAllCustimerId();
	}

	public List<Customer> selectAllCustimer() {
		
		return this.customerBiz.selectAllCustimer();
	}

	public String addCustomer(Customer c) {
		
		return this.customerBiz.addCustomer(c);
	}

	public String selectCustomerById(int id) {
		
		return this.customerBiz.selectCustomerById(id);
	}

	public String updateCustomerById(int id) {
		
		return this.customerBiz.updateCustomerById(id);
	}

	public String addVip(Vip v) {
		
		return this.vipBiz.addVip(v);
	}

	public String deleteVipById(int id) {
		
		return this.vipBiz.deleteVipById(id);
	}

	public Vip selectVipById(int id) {
		
		return this.vipBiz.selectVipById(id);
	}

	public String updateVipById(int id) {
		
		return this.vipBiz.updateVipById(id);
	}

	public Vip selectAllVip() {
		
		return this.vipBiz.selectAllVip();
	}

	public String addMenu(Menu m) {
		
		return this.menuBiz.addMenu(m);
	}

	public String deleteMenu(int id) {
		
		return this.menuBiz.deleteMenu(id);
	}

	public String upadteMenu(int id) {
		
		return this.menuBiz.upadteMenu(id);
	}

	public List<Menu> selectAllMenu() {
		
		return this.menuBiz.selectAllMenu();
	}

	public Menu selectMenuById(int id) {
		
		return this.menuBiz.selectMenuById(id);
	}

	public List<Salnum> selectAllNum() {
		
		return this.salnumBiz.selectAllNum();
	}

	public void printTicket(int id) {
		this.ticketBiz.printTicket(id);
		
	}

	public List<Type> selectAllType() {
		
		return this.typeBiz.selectAllType();
	}

	public Type selectTypeById(int id) {
		
		return this.typeBiz.selectTypeById(id);
	}
	
}
