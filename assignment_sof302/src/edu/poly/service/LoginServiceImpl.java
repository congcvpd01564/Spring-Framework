package edu.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.poly.dao.*;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;

	
	@Transactional
	public boolean checkLogin(String username, String password){
		return loginDAO.checkLogin(username, password);
	}
	
}
