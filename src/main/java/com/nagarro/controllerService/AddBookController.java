package com.nagarro.controllerService;

import java.util.Calendar;
import java.util.Formatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.daoService.AuthorService;
import com.nagarro.daoService.BookService;
import com.nagarro.model.Author;
import com.nagarro.model.Book;

@Controller
public class AddBookController {
	
	@Autowired
	private BookService bookService;
	
	
	@RequestMapping("/add")
	public ModelAndView authorList(@ModelAttribute Book book) {
		ModelAndView mv = new ModelAndView();
		
		AuthorService authorService=new AuthorService();
		
		List<Author> list=authorService.getAuthor();
		mv.addObject("list", list);
    	 mv.setViewName("addBookDetails.jsp");
		return mv;
	}
	
	
	@RequestMapping("/addBook")
	public ModelAndView addBookData(@RequestParam("bookCode") int bookCode,@RequestParam("bookName") String bookName,
			@RequestParam("author") String author,@RequestParam("date") String date) {
		
		ModelAndView mv = new ModelAndView();
		
		Book book=new Book();
		AuthorService authorService=new AuthorService();
		
		Author authorName=authorService.getAuthorByName(author);
		
		book.setBookCode(bookCode);
		book.setBookName(bookName);
		book.setAuthor(authorName);
		book.setDate(date);
		
		 this.bookService.addBook(book);
		 List<Book> list=this.bookService.getBook();
 		 mv.addObject("list", list);
    	 mv.setViewName("booklist.jsp");
		return mv;
	}

}
