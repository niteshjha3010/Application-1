package com.nagarro.daoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.dao.LoginDao;
import com.nagarro.model.LoginDetails;

@Service
public class LoginDaoService {
	
    @Autowired
	LoginDao loginDao;
    
    public void saveLoginData() {
    	LoginDetails details=new LoginDetails();
    	details.setuserName("SHIV");
    	details.setPassword("SHIV123");
    	loginDao.saveLoginData(details);
    }
    
    public boolean validateLogin(String userName,String password) {
		return loginDao.validateLogin(userName, password);
    }
    
}
