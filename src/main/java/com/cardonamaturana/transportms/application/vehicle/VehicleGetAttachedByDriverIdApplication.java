package com.cardonamaturana.transportms.application.vehicle;

import com.cardonamaturana.transportms.application.driver.process.DriverProcess;
import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.domain.service.vehicle.VehicleGetAttachedByDriverIdService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleGetAttachedByDriverIdApplication {

  private final VehicleGetAttachedByDriverIdService getVehiclesByDriverId;
  private final DriverProcess driverProcess;

  public List<Vehicle> get(Long driverId) {
    driverProcess.driverIsExistById(driverId);
    return getVehiclesByDriverId.get(driverId);
  }

}
