package com.nagarro.controllerService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.daoService.BookService;
import com.nagarro.daoService.LoginDaoService;
import com.nagarro.model.Book;


@Controller
public class LoginController {
	@Autowired
	 LoginDaoService loginDaoService;
	
	@Autowired
	BookService bookService;

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("userName") String userName, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		loginDaoService.saveLoginData();
		
		if (loginDaoService.validateLogin(userName, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			List<Book> list=this.bookService.getBook();
	 		 mv.addObject("list", list);
			mv.setViewName("booklist.jsp");
		} else {
			mv.setViewName("login.jsp");
		}

		return mv;
	}

}
