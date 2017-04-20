package edu.poly.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bonus")
@Transactional
public class BonusController {
	
	@Autowired
	SessionFactory factory;
	
	//tong hop thanh tich theo nhan vien
		@RequestMapping()
		public String bonus1(ModelMap model){
			Session session = factory.getCurrentSession();
			String hql = "SELECT r.staff.id, "+
			" SUM(case when r.type=1 then 1 else 0 end), "+
			" SUM(case when r.type=0 then 1 else 0 end)"+
			" FROM Record r "+
			" GROUP BY r.staff.id";
			Query query = session.createQuery(hql);
			List<Object[]> list = query.list();
			model.addAttribute("arrays", list);
			return "bonus";
		}
	
		
		 /*//tong hop thanh tich theo nhan vien
				@RequestMapping()
				public String bonus2(ModelMap model){
					Session session = factory.getCurrentSession();
					String hql = "SELECT r.depart.id, "+
					" SUM(case when r.type=1 then 1 else 0 end), "+
					" SUM(case when r.type=0 then 1 else 0 end)"+
					" FROM Record r "+
					" GROUP BY r.staff.id";
					Query query = session.createQuery(hql);
					List<Object[]> list = query.list();
					model.addAttribute("map", list);
					return "bonus";
				}*/

}
