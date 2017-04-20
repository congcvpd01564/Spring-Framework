package edu.poly.controller;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.bean.User;

@Controller
@RequestMapping(value="account")
@Transactional
public class AccountController {
	@Autowired
	SessionFactory factory;
	
	//hien thi list account.
	@ModelAttribute("accounts")
	public List<User> getUsers(){
		Session session = factory.getCurrentSession();
		String hql="FROM User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		return list;
	}
	
	//hien thi form nhap du lieu
	@RequestMapping()
	public String account(ModelMap model){
		model.addAttribute("account", new User());
		return "account";
	}
	//tham chieu toi button Insert.
	@RequestMapping(params="btnInsert")
	public String insert(ModelMap model, @ModelAttribute("account") User user){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(user);
			transaction.commit();
			model.addAttribute("message", "Insert successfully");
			
		}catch(Exception ex){
			model.addAttribute("message", "Insert failed");
			transaction.rollback();
		}
		session.close();
		model.addAttribute("account", new User());
		model.addAttribute("accounts", getUsers());
		
		return "account";
	}
	
	//tham chieu toi button update.
	@RequestMapping(params="btnUpdate")
	public String update(ModelMap model, @ModelAttribute("account") User user){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.update(user);
			transaction.commit();
			model.addAttribute("message", "Update successfully");
			
		}catch(Exception ex){
			model.addAttribute("message","Update failed");
			transaction.rollback();
		}
		session.close();
		
		model.addAttribute("accounts", getUsers());
		return "account";
	}
	
	//tham chieu toi button Delete.
	@RequestMapping(params = "btnDelete")
	public String delete(ModelMap model, User user){
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.delete(user);
			transaction.commit();
			model.addAttribute("message", "Delete successfully");
			
		}catch(Exception ex){
			model.addAttribute("message", "Delete failed");
			transaction.rollback();
		}
		session.close();
		
		model.addAttribute("account", new User());
		model.addAttribute("accounts", getUsers());
		return "account";
	}
	
	//linkEdit.
	@RequestMapping(params="linkEdit")
	public String edit(ModelMap model, @RequestParam("username") String username){
		Session session = factory.getCurrentSession();
		User account = (User) session.get(User.class, username);
		
		model.addAttribute("editMode", true);
		model.addAttribute("account", account);
		return "account";
	}
	
}
