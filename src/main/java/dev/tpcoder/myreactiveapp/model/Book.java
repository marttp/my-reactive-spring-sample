package dev.tpcoder.myreactiveapp.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("book")
public class Book {
  @Id
  private Long id;
  private String title;
  private String isbn;
  private String author;
  private BigDecimal price;

  public Book(String title, String isbn, String author, BigDecimal price) {
    this.title = title;
    this.isbn = isbn;
    this.author = author;
    this.price = price;
  }
}
