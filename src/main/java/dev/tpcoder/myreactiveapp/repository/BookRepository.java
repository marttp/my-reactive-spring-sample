package dev.tpcoder.myreactiveapp.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import dev.tpcoder.myreactiveapp.model.Book;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
  Flux<Book> findBooksByAuthorContainingIgnoreCase(String author);
}
