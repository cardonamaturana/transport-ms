package com.cardonamaturana.transportms.infrastructure.repository.order;

import com.cardonamaturana.transportms.infrastructure.repository.driver.DriverDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "orders")
public class OrderDto {

  @Id()
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Size(max = 20)
  String orderType;


  @Size(max = 50)
  @Column(nullable = false)
  String address;

  @ManyToOne()
  @JoinColumn(name = "driver_id", referencedColumnName = "id")
  DriverDto driver;

}