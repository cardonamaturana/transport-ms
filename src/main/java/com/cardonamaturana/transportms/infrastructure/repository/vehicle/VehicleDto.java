package com.cardonamaturana.transportms.infrastructure.repository.vehicle;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicles")
public class VehicleDto {

  @Id()
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Size(max = 4)
  @Column(nullable = false)
  String model;


  @Size(max = 7)
  @Column(nullable = false)
  String plateVehicle;

  @Size(max = 7)
  String capacity;

  @ManyToOne
  @JoinColumn(name = "driver_id", referencedColumnName = "id")
  DriverDto driver;

}
