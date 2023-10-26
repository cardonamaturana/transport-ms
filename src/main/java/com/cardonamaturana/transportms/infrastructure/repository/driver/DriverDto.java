package com.cardonamaturana.transportms.infrastructure.repository.driver;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "drivers")
public class DriverDto {

  @Id()
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Size(max = 11)
  @Column(nullable = false)
  String identification;


  @Size(max = 20)
  String lastName;

  @Size(max = 20)
  @Column(nullable = false)
  String name;

  @Size(max = 10)
  @Column(name = "cellphone", nullable = false)
  String cellphone;

  @Size(max = 50)
  String address;

}
