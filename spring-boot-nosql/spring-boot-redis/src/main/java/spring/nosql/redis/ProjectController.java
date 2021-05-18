package spring.nosql.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String getHomePage() {
		return bookService.getHomePage();
	}
	
	@PostMapping("/book")
	public Book storeBook(@RequestBody Book book) {
		return bookService.storeBook(book);
	}
	
	@GetMapping("/book/{id}")
	public Book getBook( @PathVariable Long id ) {
		return bookService.getBook(id);
	}
	
	@GetMapping("/books")
	public List<Book> getAllBook() {
	    return bookService.getAllBook();
	}
	
	@PutMapping("/book/{id}")
	public Book updateBook( @PathVariable Long id, @RequestBody Book book ) {
		return bookService.updateBook(id, book);
	}
	
	@DeleteMapping("/book/{id}")
	public String deleteBook( @PathVariable Long id ) {
		bookService.deleteBook(id);
		return "Book deleted successfully";
	}
	
	

}
