package com.cardonamaturana.transportms.domain.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Vehicle {

  Long id;
  String model;
  String plateVehicle;
  String capacity;
  Driver driver;

}
