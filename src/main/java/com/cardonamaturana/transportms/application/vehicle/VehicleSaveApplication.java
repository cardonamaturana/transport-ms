package com.cardonamaturana.transportms.application.vehicle;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.domain.service.vehicle.VehicleSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleSaveApplication {

  private final VehicleSaveService vehicleSaveService;

  public Vehicle save(Vehicle vehicle) {
    return vehicleSaveService.save(vehicle);
  }

}
