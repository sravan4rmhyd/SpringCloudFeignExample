package org.sravan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.sravan.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
