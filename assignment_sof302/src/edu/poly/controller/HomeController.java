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
		public String index() {
		return "index";
		}
		
		@RequestMapping("send")
		public String send(ModelMap model,
				@RequestParam("from") String from,
				@RequestParam("to") String to,
				@RequestParam("subject") String subject,
				@RequestParam("body") String body) {
			try{
		// Gửi mail
		mailer.send(from, to, subject, body);
		model.addAttribute("message", "Send email successfully !");
			}
			catch(Exception ex){
				model.addAttribute("message", "Send email failed !");
			}
			return "index";
		}
		
		/*@RequestMapping("index")
		public String viewStaff(ModelMap model){
			Session session = factory.getCurrentSession();
			String hql="FROM Staff";
			Query query = session.createQuery(hql);
			List<Staff> list = query.list();
			model.addAttribute("view", list);
			return "index";
		}*/
		
		

}
