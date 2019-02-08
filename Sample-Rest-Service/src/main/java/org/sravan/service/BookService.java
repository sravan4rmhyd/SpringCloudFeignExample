package org.sravan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sravan.entity.Book;
import org.sravan.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	public Book addBook(Book book) {
		return repository.save(book);
	}

	public Book updateBook(Book book) {
		if (repository.existsById(book.getId())) {
			return repository.save(book);
		}
		throw new RuntimeException("book with id " + book.getId() + " not exists");
	}

	public void delete(long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new RuntimeException("book with id " + id + " not exists");
		}
	}

	public Iterable<Book> getAll() {
		return repository.findAll();
	}

	public Book finidById(long id) {
		if (repository.existsById(id)) {
			return repository.findById(id).get();
		}
		throw new RuntimeException("book with id " + id + " not exists");
	}
}
