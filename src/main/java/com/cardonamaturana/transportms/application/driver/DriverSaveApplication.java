package com.cardonamaturana.transportms.application.driver;

import com.cardonamaturana.transportms.domain.entity.Driver;
import com.cardonamaturana.transportms.domain.service.driver.DriverSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverSaveApplication {

  private final DriverSaveService driverSaveService;

  public Driver save(Driver driver) {
    return driverSaveService.save(driver);
  }

}
