package dev.tpcoder.myreactiveapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
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
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Tag(name = "Book APIs", description = "Book APIs for demo purpose")
public class BookController {

  private final BookService bookService;

  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  @Operation(description = "Get all books")
  public Flux<Book> list(final ServerWebExchange serverWebExchange) {
    return bookService.findAll();
  }

  @GetMapping("/{id}")
  @Operation(description = "Get book by id", parameters = {
      @Parameter(name = "id", in = ParameterIn.PATH, required = true, description = "id parameter")
  })
  public Mono<Book> findById(@PathVariable Long id, final ServerWebExchange serverWebExchange) {
    return bookService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(description = "Create a book demo", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
  public Mono<Book> create(@Valid @RequestBody BookDTO bookDTO,
      final ServerWebExchange serverWebExchange) {
    return bookService.save(bookDTO);
  }

  @GetMapping("/author")
  public Flux<Book> findByAuthor(@RequestParam String name,
      final ServerWebExchange serverWebExchange) {
    return bookService.findByAuthor(name);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id, final ServerWebExchange serverWebExchange) {
    bookService.deleteById(id);
  }
}
