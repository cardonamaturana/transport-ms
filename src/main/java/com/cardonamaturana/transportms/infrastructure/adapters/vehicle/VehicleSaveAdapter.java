package com.cardonamaturana.transportms.infrastructure.adapters.vehicle;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.domain.service.vehicle.VehicleSaveService;
import com.cardonamaturana.transportms.infrastructure.repository.vehicle.VehicleMapper;
import com.cardonamaturana.transportms.infrastructure.repository.vehicle.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleSaveAdapter implements VehicleSaveService {

  private final VehicleRepository vehicleRepository;
  private final VehicleMapper vehicleMapper;

  @Override
  public Vehicle save(Vehicle vehicle) {
    return vehicleMapper.toEntity(vehicleRepository.save(vehicleMapper.toDto(vehicle)));
  }
}
