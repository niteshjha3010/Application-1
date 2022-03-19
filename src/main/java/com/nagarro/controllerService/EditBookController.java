package com.nagarro.controllerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.daoService.AuthorService;
import com.nagarro.daoService.BookService;
import com.nagarro.model.Author;
import com.nagarro.model.Book;

@Controller
public class EditBookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	AuthorService authorService;

	@RequestMapping("/editBook")
	public String bookData(HttpServletRequest request,Model model) {
		//ModelAndView mv = new ModelAndView();

		String id = request.getParameter("parameter");
		int bookCode = Integer.parseInt(id);

		List<Book> list = bookService.getBookById(bookCode);

		List<Author> authorList = authorService.getAuthor();
		        
		 model.addAttribute("list", list);
		 model.addAttribute("authorList", authorList);

        System.out.println(authorList.size());
        

		return("editBookDetails.jsp");
		
	}

	@RequestMapping("/edit")
	public ModelAndView bookData(@RequestParam("bookCode") int bookCode,@RequestParam("bookName") String bookName,
			@RequestParam("author") String bookAuthor,@RequestParam("date") String date) {
		ModelAndView mv = new ModelAndView();
		
		Book book=new Book();
		Author authorDetails=this.authorService.getAuthorByName(bookAuthor);

		book.setBookCode(bookCode);
		book.setBookName(bookName);
		book.setAuthor(authorDetails);
		book.setDate(date);

		this.bookService.addBook(book);

		bookService.editBook(book, bookCode);
		List<Book> list = this.bookService.getBook();
		mv.addObject("list", list);
		mv.setViewName("booklist.jsp");

		return mv;
	}

}
