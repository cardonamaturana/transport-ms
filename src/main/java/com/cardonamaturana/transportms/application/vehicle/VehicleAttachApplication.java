package com.cardonamaturana.transportms.application.vehicle;

import com.cardonamaturana.transportms.application.vehicle.process.VehicleProcess;
import com.cardonamaturana.transportms.domain.entity.Driver;
import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.domain.service.vehicle.VehicleGetByIdService;
import com.cardonamaturana.transportms.domain.service.vehicle.VehicleSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleAttachApplication {

  private final VehicleSaveService vehicleSaveService;
  private final VehicleProcess vehicleProcess;
  private final VehicleGetByIdService vehicleGetByIdService;

  public Vehicle attach(Long vehicleId, Long driverId) {
    Driver driver = new Driver();
    driver.setId(driverId);
    vehicleProcess.validateForAttach(vehicleId, driverId);
    Vehicle vehicle = vehicleGetByIdService.get(vehicleId);
    vehicle.setDriver(driver);
    return vehicleSaveService.save(vehicle);
  }

}
