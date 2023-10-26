package com.cardonamaturana.transportms.infrastructure.adapters.vehicle;

import com.cardonamaturana.transportms.domain.service.vehicle.VehicleIsExistByIdService;
import com.cardonamaturana.transportms.infrastructure.repository.vehicle.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleIsExistByIdAdapter implements VehicleIsExistByIdService {

  private final VehicleRepository vehicleRepository;

  @Override
  public boolean isExist(Long vehicleId) {
    return vehicleRepository.existsById(vehicleId);
  }
}
