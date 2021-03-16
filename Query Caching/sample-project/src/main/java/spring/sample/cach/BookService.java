package spring.sample.cach;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private BookRepository bookRepository;
	
	// https://programmerfriend.com/ultimate-guide-to-redis-cache-with-spring-boot-2-and-spring-data-redis/

	@Cacheable(cacheNames = "cach01")
	public String getHomePage() {
		LOG.info("Get Home Page");
	    return "WelCome to our website";
	}
	
	public Book storeBook(Book book) {
		return bookRepository.save(book);
	}
	
	@Cacheable(cacheNames = "cach02")  // id will be the default key
	public Book getBook(Long id) {
		LOG.info("Fetching Book id : {}", id);
		Book book = bookRepository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundExcepton("Book is not found"));
		return book;
	}
	
	@Cacheable(cacheNames = "cach03")
	public List<Book> getAllBook() {
		LOG.info("Fetching all Book Info {}.", bookRepository.findAll());
	    return bookRepository.findAll();
	}
	
	public Book updateBook(Long id, Book book) {
		
		return bookRepository.save(book);
	}
	
	public String deleteBook(Long id) {
		bookRepository.deleteById(id);
		return "Book deleted successfully";
	}
	

}
