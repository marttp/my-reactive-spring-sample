package dev.tpcoder.myreactiveapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("store")
public class Store {
  @Id
  private Long id;
  private String name;
}
