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
import edu.poly.bean.Depart;

@Controller
@RequestMapping(value="depart")
@Transactional
public class DepartController {
	
	@Autowired
	SessionFactory factory;
	
	
	//hien thi danh sach
	@ModelAttribute("departs")
	public List<Depart> getDeparts(){
		Session session = factory.getCurrentSession();
		String hql = "FROM Depart";
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
		return list;
	}
	
	//hien thi form cho phep nhap.
	@RequestMapping()
	public String depart(ModelMap model){
		model.addAttribute("depart", new Depart());
		return "depart";
	}
	
	//tham chieu toi button Insert.
	@RequestMapping(params="btnInsert")
	public String insert(ModelMap model, @ModelAttribute("depart") Depart depart){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(depart);
			transaction.commit();
			model.addAttribute("message", "Insert successfully");
			
		}catch(Exception ex){
			model.addAttribute("message", "Insert failed");
			transaction.rollback();
		}
		session.close();

		model.addAttribute("depart", new Depart());
		model.addAttribute("departs", getDeparts());
		
		return "depart";
	}
	
	//tham chieu toi button Upadte.
	@RequestMapping(params="btnUpdate")
	public String update(ModelMap model, @ModelAttribute("depart") Depart depart){
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try{
			session.update(depart);
			transaction.commit();
			model.addAttribute("message", "Update successfully");
			
		}catch(Exception ex){
			model.addAttribute("message", "Update failed");
			transaction.rollback();
		}
		session.close();
		
		model.addAttribute("departs", getDeparts());
		return "depart";
	}
	
	//tham chieu toi button Delete.
	@RequestMapping(params = "btnDelete")
	public String delete(ModelMap model, Depart depart){
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.delete(depart);
			transaction.commit();
			model.addAttribute("message", "Delete successfully");
			
		}catch(Exception e){
			model.addAttribute("message", "Delete failed");
			transaction.rollback();
		}
		session.close();
		
		model.addAttribute("depart", new Depart());
		model.addAttribute("departs", getDeparts());
		
		return "depart";
	}
	
	//linkEdit
	@RequestMapping(params ="linkEdit")
	public String edit(ModelMap model, @RequestParam("id") String id){
		Session session = factory.getCurrentSession();
		Depart depart = (Depart) session.get(Depart.class, id);
		model.addAttribute("editMode", true);
		model.addAttribute("depart", depart);
		return "depart";
	}
	
	

}
