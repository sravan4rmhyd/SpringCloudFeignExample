package org.sravan.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sravan.entity.Book;

@Component
@FeignClient(name = "books", path = "/book", url = "http://localhost:8000")
public interface BookRestClient {

	@RequestMapping(consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public Book addBook(Book book);

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public Iterable<Book> getAll();

	@RequestMapping(consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
	public Book updateBook(@RequestBody Book book);

	@RequestMapping(produces = "application/json", method = RequestMethod.DELETE, path = "/{id}")
	public void deleteBook(@PathVariable long id);

	@RequestMapping(produces = "application/json", method = RequestMethod.GET, path = "/{id}")
	public Book getBook(@PathVariable long id);

}
