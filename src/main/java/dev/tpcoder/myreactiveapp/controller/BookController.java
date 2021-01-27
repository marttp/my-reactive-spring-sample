package dev.tpcoder.myreactiveapp.controller;

import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.tpcoder.myreactiveapp.model.Book;
import dev.tpcoder.myreactiveapp.model.BookDTO;
import dev.tpcoder.myreactiveapp.service.BookService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
  private final BookService bookService;

  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Book> list() {
    return bookService.findAll();
  }

  @GetMapping("/{id}")
  public Mono<Book> findById(@PathVariable Long id) {
    return bookService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Book> create(@RequestBody BookDTO bookDTO) {
    return bookService.save(bookDTO);
  }

  @GetMapping("/author")
  public Flux<Book> findByAuthor(@RequestParam String name) {
    return bookService.findByAuthor(name);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    bookService.deleteById(id);
  }
}
