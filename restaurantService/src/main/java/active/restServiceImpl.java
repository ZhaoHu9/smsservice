package active;

import java.util.List;
import java.util.Map;

import admin.Customer;
import admin.Employee;
import admin.Menus;
import admin.Salnum;
import admin.Ticket;
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
	private Object customerBiztBiz;


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

	public String addCurt( Map<Integer, Integer> m) {

		return this.curtBiz.addCurt( m);
	}

	public String deleteCurt(int id) {

		return this.curtBiz.deleteCurt(id);
	}

	public String deleteAllCurt() {

		return this.curtBiz.deleteAllCurt();
	}

	public Map<Integer, Integer> selectAllCurt(int id) {

		return this.curtBiz.selectAllCurt(id);
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

	public Customer selectCustomerById(int id) {

		return this.customerBiz.selectCustomerById(id);
	}

	public String updateCustomerById(Customer c) {

		return this.customerBiz.updateCustomerById(c);
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

	public String updateVipById(Vip v) {

		return this.vipBiz.updateVipById(v);
	}

	public List<Vip> selectAllVip() {

		return this.vipBiz.selectAllVip();
	}

	public String addMenu(Menus m) {

		return this.menuBiz.addMenu(m);
	}

	public String deleteMenu(int id) {

		return this.menuBiz.deleteMenu(id);
	}

	public String upadteMenu(Menus m) {

		return this.menuBiz.upadteMenu(m);
	}

	public List<Menus> selectAllMenu() {

		return this.menuBiz.selectAllMenu();
	}

	public Menus selectMenuById(int id) {

		return this.menuBiz.selectMenuById(id);
	}

	public List<Salnum> selectAllNum() {

		return this.salnumBiz.selectAllNum();
	}

	public List<Ticket> printTicket() {
		return this.ticketBiz.printTicket();

	}

	public List<Type> selectAllType() {

		return this.typeBiz.selectAllType();
	}

	public Type selectTypeById(int id) {

		return this.typeBiz.selectTypeById(id);
	}

	public List<Menus> selectAllMuByTp(int id) {

		return this.menuBiz.selectAllMuByTp(id);
	}


	public String deleteCustomer(int id) {

		return this.customerBiz.deleteCustomerById(id);
	}

	public String addTicket(Ticket t) {

		return this.ticketBiz.addTicket(t);
	}


	public String addSal(Salnum s) {

		return this.salnumBiz.addSal(s);
	}

	public int finTicketid() {

		return this.ticketBiz.findTicketid();
	}

	public String updateSal(Salnum s) {

		return this.salnumBiz.updateSal(s);
	}

	public Salnum selectSal(int id) {

		return this.salnumBiz.selectSal(id);
	}

	public String addType(Type t) {

		return this.typeBiz.addType(t);
	}

	public String updateTypeById(Type t) {

		return this.typeBiz.updateTypeById(t);
	}

	public String deleteTypeById(int id) {

		return this.typeBiz.deleteTypeById(id);
	}

}
