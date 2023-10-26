package com.cardonamaturana.transportms.infrastructure.adapters;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.domain.service.DriverGetAssociatedVehiclesByIdService;
import com.cardonamaturana.transportms.infrastructure.repository.vehicle.VehicleMapper;
import com.cardonamaturana.transportms.infrastructure.repository.vehicle.VehicleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverGetAssociatedVehiclesByIdAdapter implements
    DriverGetAssociatedVehiclesByIdService {

  private final VehicleRepository vehicleRepository;
  private final VehicleMapper vehicleMapper;

  @Override
  public List<Vehicle> get(Long driverId) {
    return vehicleMapper.toEntityList(vehicleRepository.findByDriverId(driverId));
  }
}
