package com.cardonamaturana.transportms.infrastructure.api.dto.vehicle;

import com.cardonamaturana.transportms.domain.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class VehicleResponse {

  Long id;
  String model;
  String plateVehicle;
  String capacity;
  Driver driver;

}
