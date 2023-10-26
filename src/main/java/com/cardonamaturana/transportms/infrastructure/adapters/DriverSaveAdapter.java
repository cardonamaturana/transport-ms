package com.cardonamaturana.transportms.infrastructure.adapters;

import com.cardonamaturana.transportms.domain.entity.Driver;
import com.cardonamaturana.transportms.domain.service.DriverSaveService;
import com.cardonamaturana.transportms.infrastructure.repository.driver.DriverMapper;
import com.cardonamaturana.transportms.infrastructure.repository.driver.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverSaveAdapter implements DriverSaveService {

  private final DriverRepository driverRepository;
  private final DriverMapper driverMapper;

  @Override
  public Driver save(Driver driver) {
    return driverMapper.toEntity(driverRepository.save(driverMapper.toDto(driver)));
  }
}
