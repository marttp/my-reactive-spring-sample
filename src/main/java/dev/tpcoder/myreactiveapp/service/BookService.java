package dev.tpcoder.myreactiveapp.service;

import org.springframework.stereotype.Service;

import dev.tpcoder.myreactiveapp.model.Book;
import dev.tpcoder.myreactiveapp.model.BookDTO;
import dev.tpcoder.myreactiveapp.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Flux<Book> findAll() {
        return bookRepository.findAll();
    }

    public Mono<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Mono<Book> save(BookDTO book) {
        Book newBook = new Book(book.getTitle(), book.getIsbn(), book.getAuthor(), book.getPrice());
        return bookRepository.save(newBook).flatMap(Mono::just);
    }

    public Flux<Book> findByAuthor(String author) {
        return bookRepository.findBooksByAuthorContainingIgnoreCase(author);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id).subscribe();
    }
}
