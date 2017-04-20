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
import edu.poly.bean.Staff;

@Controller
@RequestMapping(value="staff")
@Transactional
public class StaffController {
	
	@Autowired
	SessionFactory factory;
	
	
	@ModelAttribute("staffs")
	public List<Staff> getStaffs(){
		Session session = factory.getCurrentSession();
		String hql ="FROM Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list;
	}
	
	//hien thi khoa ngoai DepartId
		@ModelAttribute("departs")
		public List<Depart> getDeparts(){
			Session session = factory.getCurrentSession();
			String hql = "FROM Depart";
			Query query = session.createQuery(hql);
			List<Depart> list = query.list();
			return list;
		}
	
	@RequestMapping()
	public String staff(ModelMap model){
		model.addAttribute("staff", new Staff());
		return "staff";
	}
	
	@RequestMapping(params="btnInsert")
	public String insert(ModelMap model, @ModelAttribute("staff") Staff staff){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(staff);
			transaction.commit();
			model.addAttribute("message", "Insert successfully");
			
		}catch(Exception e){
			model.addAttribute("message", "Insert failed");
			transaction.rollback();
		}
		session.close();
		
		model.addAttribute("staff", new Staff());
		model.addAttribute("staffs", getStaffs());
		
		return "staff";
		
	}
	@RequestMapping(params="btnUpdate")
	public String update(ModelMap model, @ModelAttribute("staff") Staff staff){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try{
			session.update(staff);
			transaction.commit();
			model.addAttribute("message", "Update Successfully");
			
		}catch(Exception e){
			model.addAttribute("message", "Update failed");
			transaction.rollback();
		}
		session.close();
		
		model.addAttribute("staffs", getStaffs());
		return "staff";
	}
	
	@RequestMapping(params ="btnDelete")
	public String delete(ModelMap model, Staff staff){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.delete(staff);
			transaction.commit();
			model.addAttribute("message", "Delete successfully");
		}catch(Exception e){
			model.addAttribute("message", "Delete failed");
			transaction.rollback();
		}
		session.close();
		
		model.addAttribute("staff", new Staff());
		model.addAttribute("staffs", getStaffs());
		return "staff";
	}
	
	@RequestMapping(params="linkEdit")
	public String edit(ModelMap model, @RequestParam("id") String id){
		Session session = factory.getCurrentSession();
		Staff staff = (Staff) session.get(Staff.class, id);
		
		model.addAttribute("editMode", true);
		model.addAttribute("staff", staff);
		return "staff";
	}
	
	
}
