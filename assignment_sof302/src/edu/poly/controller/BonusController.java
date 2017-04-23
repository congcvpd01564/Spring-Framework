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
			
			String hql1 = "SELECT r.staff.id, "
			+" SUM(case when r.type=1 then 1 else 0 end), "
			+" SUM(case when r.type=0 then 1 else 0 end)"
			+" FROM Record r "
			+" GROUP BY r.staff.id";
			
			String hql2 = "select d.name,"
					+ "SUM(case when r.type=1 then 1 else 0 end),"
					+ "SUM(case when r.type=0 then 1 else 0 end)"
					+ "from Depart d inner join d.staffs s inner join s.records r"
					+ " group by d.name ";
			
			Query query1 = session.createQuery(hql1);
			List<Object[]> list1 = query1.list();
			model.addAttribute("arrays", list1);
			
			Query query2 = session.createQuery(hql2);
			List<Object[]> list2 = query2.list();
			model.addAttribute("map", list2);
		
			return "bonus";
		}
}
