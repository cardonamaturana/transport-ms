package com.cardonamaturana.transportms.infrastructure.adapters.vehicle;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.domain.service.vehicle.VehicleGetFreeService;
import com.cardonamaturana.transportms.infrastructure.repository.vehicle.VehicleMapper;
import com.cardonamaturana.transportms.infrastructure.repository.vehicle.VehicleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VehicleGetFreeAdapter implements VehicleGetFreeService {

  private final VehicleRepository vehicleRepository;
  private final VehicleMapper vehicleMapper;

  @Override
  public List<Vehicle> get() {
    return vehicleMapper.toEntityList(vehicleRepository.findByDriverIdIsNull());
  }
}
