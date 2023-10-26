package com.cardonamaturana.transportms.application.vehicle;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.domain.service.vehicle.VehicleGetFreeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleGetFreeApplication {

  private final VehicleGetFreeService vehicleGetFreeService;

  public List<Vehicle> get() {
    return vehicleGetFreeService.get();
  }

}
