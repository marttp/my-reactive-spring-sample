package dev.tpcoder.myreactiveapp.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookDTO {

  @NotEmpty
  private String title;
  @NotEmpty
  private String isbn;
  @NotEmpty
  private String author;
  @NotNull
  private BigDecimal price;
}