package org.sravan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sravan.entity.Book;
import org.sravan.restClient.BookRestClient;

@Service
public class BookService {

	@Autowired
	private BookRestClient client;

	public Iterable<Book> getAll() {
		return client.getAll();
	}

	public Book addBook(Book book) {
		return client.addBook(book);
	}

	public Book updateBook(Book book) {
		if (client.getBook(book.getId()) != null) {
			return client.addBook(book);
		}
		throw new RuntimeException("book with id " + book.getId() + " not exists");
	}

	public void delete(long id) {
		if (client.getBook(id) != null) {
			client.deleteBook(id);
		} else {
			throw new RuntimeException("book with id " + id + " not exists");
		}
	}

	public Book finidById(long id) {
		if (client.getBook(id) != null) {
			return client.getBook(id);
		}
		throw new RuntimeException("book with id " + id + " not exists");
	}
}
