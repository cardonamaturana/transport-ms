package com.cardonamaturana.transportms.application.vehicle.process;

import com.cardonamaturana.transportms.domain.service.driver.DriverIsExistByIdService;
import com.cardonamaturana.transportms.domain.service.vehicle.VehicleIsExistByIdService;
import com.cardonamaturana.transportms.shared.exceptions.driver.DriverNotFoundException;
import com.cardonamaturana.transportms.shared.exceptions.vehicle.VehicleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleProcess {

  private final VehicleIsExistByIdService vehicleIsExistByIdService;
  private final DriverIsExistByIdService driverIsExistByIdService;


  public void validateForDetach(Long vehicleId) {
    vehicleIsExistById(vehicleId);
  }

  public void validateForAttach(Long vehicleId, Long driverId) {
    driverIsExistById(driverId);
    vehicleIsExistById(vehicleId);
  }

  private void driverIsExistById(Long driverId) {
    if (!driverIsExistByIdService.isExist(driverId)) {
      throw new DriverNotFoundException();
    }
  }


  private void vehicleIsExistById(Long vehicleId) {
    if (!vehicleIsExistByIdService.isExist(vehicleId)) {
      throw new VehicleNotFoundException();
    }
  }


}
