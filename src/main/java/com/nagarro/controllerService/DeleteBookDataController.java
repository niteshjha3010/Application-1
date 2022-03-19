package com.nagarro.controllerService;

import java.util.Calendar;
import java.util.Formatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.daoService.BookService;
import com.nagarro.model.Book;

@Controller
public class DeleteBookDataController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/deleteBook")
     public ModelAndView bookData(HttpServletRequest request) {
    	 ModelAndView mv=new ModelAndView();
    	 
    	 String id = request.getParameter("param");
 		int bookCode = Integer.parseInt(id);
 		
 		System.out.println(bookCode);
 		
 		bookService.deleteBook(bookCode);
 		
         List<Book> list=this.bookService.getBook();
 		 mv.addObject("list", list);
    	 mv.setViewName("booklist.jsp");
		
    	 return mv;
     }
}
