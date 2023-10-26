package com.cardonamaturana.transportms.infrastructure.adapters.vehicle;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.domain.service.vehicle.VehicleGetByIdService;
import com.cardonamaturana.transportms.infrastructure.repository.vehicle.VehicleDto;
import com.cardonamaturana.transportms.infrastructure.repository.vehicle.VehicleMapper;
import com.cardonamaturana.transportms.infrastructure.repository.vehicle.VehicleRepository;
import com.cardonamaturana.transportms.shared.exceptions.vehicle.VehicleNotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VehicleGetByIdAdapter implements VehicleGetByIdService {

  private final VehicleRepository vehicleRepository;
  private final VehicleMapper vehicleMapper;

  @Override
  public Vehicle get(Long vehicleId) {
    Optional<VehicleDto> result = vehicleRepository.findById(vehicleId);

    if (!result.isPresent()) {
      throw new VehicleNotFoundException();
    }
    return vehicleMapper.toEntity(result.get());
  }
}
