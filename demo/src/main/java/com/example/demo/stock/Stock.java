package com.example.demo.stock;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "stocks")
public class Stock {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String name;

  @Column
  private Double current_price;

  @Column(nullable = false)
  @CreationTimestamp
  private Timestamp createdAt;

  @Column(nullable = false)
  @UpdateTimestamp
  private Timestamp updatedAt;

  public Stock() {
  }

  public Stock(Long id, String name, Double current_price) {
    this.id = id;
    this.name = name;
    this.current_price = current_price;
  }

  public Stock(String name, Double current_price) {
    this.name = name;
    this.current_price = current_price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getCurrent_price() {
    return current_price;
  }

  public void setCurrent_price(Double current_price) {
    this.current_price = current_price;
  }

  public Long getId() {
    return id;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }
}

