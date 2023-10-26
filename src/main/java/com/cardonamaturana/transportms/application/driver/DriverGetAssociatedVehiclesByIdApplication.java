package com.cardonamaturana.transportms.application.driver;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.domain.service.DriverGetAssociatedVehiclesByIdService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverGetAssociatedVehiclesByIdApplication {

  private final DriverGetAssociatedVehiclesByIdService getVehiclesByDriverId;
  private final DriverProcess driverProcess;

  public List<Vehicle> get(Long driverId) {
    driverProcess.driverIsExistById(driverId);
    return getVehiclesByDriverId.get(driverId);
  }

}
