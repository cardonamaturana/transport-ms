package com.cardonamaturana.transportms.application.driver;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.domain.service.DriverGetFreeVehiclesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverGetFreeVehiclesApplication {

  private final DriverGetFreeVehiclesService driverGetFreeVehiclesService;

  public List<Vehicle> get() {
    return driverGetFreeVehiclesService.get();
  }

}
