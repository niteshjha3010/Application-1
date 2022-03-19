package com.nagarro.controllerService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.daoService.BookService;
import com.nagarro.daoService.LoginDaoService;
import com.nagarro.model.Book;


@Controller
public class BookListController {
   
	@Autowired
	BookService bookService;
	
	@RequestMapping("/booklist")
	public ModelAndView booklist() {
		ModelAndView mv = new ModelAndView();
		List<Book> list=this.bookService.getBook();
		 mv.addObject("list", list);
		mv.setViewName("booklist.jsp");
		
		return mv;
		
		
	}
	
	
}
