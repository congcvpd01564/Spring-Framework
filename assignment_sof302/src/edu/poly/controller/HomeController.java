package edu.poly.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.bean.Mailer;
import edu.poly.bean.Staff;

@Controller
@Transactional
public class HomeController {

	@Autowired
	SessionFactory factory;

	@Autowired
	Mailer mailer;

	@RequestMapping("index")
	public String index(ModelMap model) {

		Session session = factory.getCurrentSession();

		String hql = "SELECT s.photo,s.id,s.name,d.name," + "(SUM(case when r.type=1 then 1 else 0 end)"
				+ "-SUM(case when r.type=0 then 1 else 0 end)) as diemthuong"
				+ " FROM Depart d INNER JOIN d.staffs s INNER JOIN s.records r"
				+ " GROUP BY s.id,s.photo,s.name,d.name order by diemthuong DESC";

		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		model.addAttribute("arr", list);

		return "index";
	}

	@RequestMapping("send")
	public String send(ModelMap model, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("subject") String subject, @RequestParam("body") String body) {
		try {
			// Gửi mail
			mailer.send(from, to, subject, body);
			model.addAttribute("message", "Send email successfully !");
		} catch (Exception ex) {
			model.addAttribute("message", "Send email failed !");
		}
		return "index";
	}

	
}
