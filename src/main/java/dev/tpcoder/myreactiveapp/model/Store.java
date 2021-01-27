package dev.tpcoder.myreactiveapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("store")
@AllArgsConstructor
@NoArgsConstructor
public class Store {
  @Id
  private Long id;
}
