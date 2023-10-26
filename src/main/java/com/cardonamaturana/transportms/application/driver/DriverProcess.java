package com.cardonamaturana.transportms.application.driver;

import com.cardonamaturana.transportms.domain.service.DriverIsExistByIdService;
import com.cardonamaturana.transportms.shared.exceptions.driver.DriverNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverProcess {

  private final DriverIsExistByIdService driverIsExistByIdService;


  public void driverIsExistById(Long driverId) {
    if (!driverIsExistByIdService.isExist(driverId)) {
      throw new DriverNotFoundException();
    }
  }


}
