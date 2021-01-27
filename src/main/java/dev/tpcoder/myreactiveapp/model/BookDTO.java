package dev.tpcoder.myreactiveapp.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class BookDTO {
  private String title;
  private String isbn;
  private String author;
  private BigDecimal price;
}