package com.workshop.back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "people")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Long id;

  @Column(name = "resource_id")
  private String resourceId;

  private String name;
  private BigDecimal weight;
  private BigDecimal height;

  // Default constructor
  public Person() {}

  // Constructor with parameters
  public Person(String resourceId, String name, BigDecimal weight, BigDecimal height) {
    this.resourceId = resourceId;
    this.name = name;
    this.weight = weight;
    this.height = height;
  }

  // Getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getWeight() {
    return weight;
  }

  public void setWeight(BigDecimal weight) {
    this.weight = weight;
  }

  public BigDecimal getHeight() {
    return height;
  }

  public void setHeight(BigDecimal password) {
    this.height = height;
  }
}
