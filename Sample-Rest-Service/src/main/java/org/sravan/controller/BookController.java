package org.sravan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sravan.entity.Book;
import org.sravan.service.BookService;

@RestController
@RequestMapping(path = "/book")
public class BookController {

	@Autowired
	private BookService service;

	@RequestMapping(consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public Book addBook(@RequestBody Book book) {
		return service.addBook(book);
	}

	@RequestMapping(consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
	public Book updateBook(@RequestBody Book book) {
		return service.updateBook(book);
	}

	@RequestMapping(produces = "application/json", method = RequestMethod.DELETE, path = "/{id}")
	public void deleteBook(@PathVariable long id) {
		service.delete(id);
	}

	@RequestMapping(produces = "application/json", method = RequestMethod.GET)
	public Iterable<Book> getBooks() {
		return service.getAll();
	}

	@RequestMapping(produces = "application/json", method = RequestMethod.GET, path = "/{id}")
	public Book getBook(@PathVariable long id) {
		return service.finidById(id);
	}
}
