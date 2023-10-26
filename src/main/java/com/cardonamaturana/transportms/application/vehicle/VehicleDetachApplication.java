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
public class VehicleDetachApplication {

  private final VehicleSaveService vehicleSaveService;
  private final VehicleProcess vehicleProcess;
  private final VehicleGetByIdService vehicleGetByIdService;

  public Vehicle detach(Long vehicleId) {
    vehicleProcess.validateForDetach(vehicleId);
    Vehicle vehicle = vehicleGetByIdService.get(vehicleId);
    vehicle.setDriver(null);
    return vehicleSaveService.save(vehicle);
  }

}
