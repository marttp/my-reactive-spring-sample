package dev.tpcoder.myreactiveapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  @Id
  private Long id;
  private String title;
  private String isbn;
}
