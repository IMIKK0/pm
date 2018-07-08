package com.pm.action;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Id;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pm.bean.Emp;
import com.pm.service.IEmpService;
import com.pm.service.ServiceUtil;
import com.pm.util.ImgCodeUtil;
import com.pm.util.PageUtiles;

@Controller
public class EmpAction extends ActionSupport {
	@Resource
	private IEmpService empService;
	private PageUtiles page;
	private Emp emp;
	private List<Emp> listEmp;
	private String num;	
	private String yzm;
	private String msg;
	private String data;
	private ByteArrayInputStream inputStream; //验证码
	

	public String login(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		emp = empService.login(emp.getUsername(),emp.getPassword());	
		/*int ff = emp.getJurisdiction();*/
		session.setAttribute("ff", emp.getJurisdiction());
		session.setAttribute("id", emp.getE_id());
		if (emp!=null) {			
			//将emp 存入session中
			return "loginsuccess";
		}else{
			msg = "用户名或密码错误";
		}
		return "loginerror";//登陆失败
	}
	public String yzm(){
		
		 ImgCodeUtil rdnu = ImgCodeUtil.Instance();  
	        this.setInputStream(rdnu.getImage()); // 取得带有随机字符串的图片  
	        HttpSession session = ServletActionContext.getRequest().getSession();  	       
	        // 取得随机字符串放入HttpSession  
	        session.setAttribute("imgCode", rdnu.getString());  
	        //设置当前session的有效时间为10*60秒  
	        session.setMaxInactiveInterval(600); 	 
	        return SUCCESS;  
	}
	//用户跳转添加页面
	public String add(){
		return "add";
	}
	
	public String addEmp(){
		System.out.println("********************8");
		HttpSession session=ServletActionContext.getRequest().getSession();	
		int i = (int) session.getAttribute("ff");
		int a = emp.getJurisdiction();
		/*if (i==1 || i==0 && a!=1&&a!=0) {
			System.out.println("我进来了");
			empService.save(emp);
			return "Empsuccess";
		}*/
		if ((i==0 && a!=0) || (i==1 && a!=0 && a!=1) ) {
			System.out.println("我进来了");
			empService.save(emp);
			return "Empsuccess";
		}
		System.out.println("你没有该权限");
		return "Jurisdiction";		
	}
	public String deleteEmp(){
		HttpSession session=ServletActionContext.getRequest().getSession();	
		int i = (int) session.getAttribute("ff");
		int a = emp.getJurisdiction();
		int b = emp.getJurisdiction();
		System.out.println(a+"***********"+b);
		if (i==1 || i==0 || a!=0 || b!=1) {
		empService.delete(emp);
		return "deletesuccess";
		}		
		return "Jurisdiction";	
	}
	public String findEmpByid(){	
		emp=empService.getById(emp.getE_id());		
		return "findEmpByid";
	}
	/**
	 * 查看个人任务
	 * @return
	 */
	public String findGeRen(){	
		HttpSession session=ServletActionContext.getRequest().getSession();	
		int i = (int) session.getAttribute("id");
		emp=empService.getById(i);
		System.out.println(emp.getE_mail());
		System.out.println(i);
		return "findGeRen";
	}
	public String updateEmp(){
		HttpSession session=ServletActionContext.getRequest().getSession();	
		int i = (int) session.getAttribute("ff");
		int a = emp.getJurisdiction();
		int b = emp.getJurisdiction();
		if (i==1 || i==0 || a!=0 || b!=1) {
			empService.update(emp);
			return "updatesuccess";
		}
		System.out.println("操作失败");
		return "Jurisdiction";
	}
	public String findEmp(){
		int pageNum = 1;
		if(num!=null){
			pageNum = Integer.parseInt(num);
		}
		//总条数
		int totalRecordsNumber = empService.totalCount();
		page= new PageUtiles(pageNum, totalRecordsNumber); 
		listEmp = empService.findAll(page.getStartIndex(), page.getPageSize());		
		return "findEmp";
	}
	public String searchEmp(){
		listEmp = empService.searchEmp(emp);		
		return "searchEmp";
	}
	public PageUtiles getPage() {
		return page;
	}
	public void setPage(PageUtiles page) {
		this.page = page;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public List<Emp> getListEmp() {
		return listEmp;
	}
	public void setListEmp(List<Emp> listEmp) {
		this.listEmp = listEmp;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getYzm() {
		return yzm;
	}
	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	

}
