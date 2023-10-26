package com.cardonamaturana.transportms.infrastructure.adapters;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.domain.service.DriverGetFreeVehiclesService;
import com.cardonamaturana.transportms.infrastructure.repository.vehicle.VehicleMapper;
import com.cardonamaturana.transportms.infrastructure.repository.vehicle.VehicleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DriverGetFreeVehiclesAdapter implements DriverGetFreeVehiclesService {

  private final VehicleRepository vehicleRepository;
  private final VehicleMapper vehicleMapper;

  @Override
  public List<Vehicle> get() {
    return vehicleMapper.toEntityList(vehicleRepository.findByDriverIdIsNull());
  }
}
