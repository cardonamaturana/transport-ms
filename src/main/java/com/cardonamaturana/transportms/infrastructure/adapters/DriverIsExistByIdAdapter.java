package com.cardonamaturana.transportms.infrastructure.adapters;

import com.cardonamaturana.transportms.domain.service.DriverIsExistByIdService;
import com.cardonamaturana.transportms.infrastructure.repository.driver.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverIsExistByIdAdapter implements DriverIsExistByIdService {

  private final DriverRepository driverRepository;

  @Override
  public boolean isExist(Long driverId) {
    return driverRepository.existsById(driverId);
  }
}
