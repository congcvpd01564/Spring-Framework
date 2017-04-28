package edu.poly.controller;

import java.util.Date;
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

import edu.poly.bean.Record;
import edu.poly.bean.Staff;

@Controller
@RequestMapping(value="record")
@Transactional
public class RecordController {
	
	@Autowired
	SessionFactory factory;
	
	@ModelAttribute("records")
	public List<Record> getRecords(){
		Session session = factory.getCurrentSession();
		String hql = "FROM Record";
		Query query = session.createQuery(hql);
		List<Record> list = query.list();
		return list;
	}
	//hien thi khoa ngoai StaffId
	@ModelAttribute("staffs")
	public List<Staff> getStaffs(){
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list;
	}
	
	@RequestMapping()
	public String record(ModelMap model){
		model.addAttribute("record", new Record());
		return "record";
	}
	
	
	@RequestMapping(params="btnInsert")
	public String insert(ModelMap model, @ModelAttribute("record") Record record){
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			
			session.save(record);
			transaction.commit();
			model.addAttribute("message", "Insert successfully");
			
		}catch(Exception e){
			model.addAttribute("message", "Insert failed");
			transaction.rollback();
		}
		session.close();
		
		model.addAttribute("record", new Record());
		model.addAttribute("records", getRecords());
		
		return "record";
	}
	
	@RequestMapping(params="btnUpdate")
	public String update(ModelMap model, @ModelAttribute("record") Record record){
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.update(record);
			transaction.commit();
			model.addAttribute("message", "Update successfully");
			
		}catch(Exception e){
			model.addAttribute("message", "Update failed");
			transaction.rollback();
		}
		session.close();
		
		model.addAttribute("record", new Record());
		model.addAttribute("records", getRecords());
		return "record";
	}
	
	@RequestMapping(params ="btnDelete")
	public String delete(ModelMap model, Record record){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try{
			session.delete(record);
			transaction.commit();
			model.addAttribute("message", "Delete successfully");
			
		}catch(Exception e){
			model.addAttribute("message", "Delete failed");
			transaction.rollback();
		}
		session.close();
		
		model.addAttribute("record", new Record());
		model.addAttribute("records", getRecords());
		
		return "record";
	}
	
	@RequestMapping(params="linkEdit")
	public String edit(ModelMap model, @RequestParam("id") String id){
		Session session = factory.getCurrentSession();
		Record record = (Record) session.get(Record.class, id);
		
		model.addAttribute("editMode", true);
		model.addAttribute("record", record);
		return "record";
	}
	
}
