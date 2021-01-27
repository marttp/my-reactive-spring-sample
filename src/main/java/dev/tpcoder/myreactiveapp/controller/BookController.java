package dev.tpcoder.myreactiveapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("books")
public class BookController {
  
  @GetMapping
  public Flux<String> getAllBooks() {
    return Flux.just("Test");
  }
}
