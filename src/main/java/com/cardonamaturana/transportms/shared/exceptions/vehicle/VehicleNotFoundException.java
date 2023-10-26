package com.cardonamaturana.transportms.shared.exceptions.vehicle;


import com.cardonamaturana.transportms.shared.exceptions.base.BaseException;
import com.cardonamaturana.transportms.shared.exceptions.base.ExceptionCode;
import org.springframework.http.HttpStatus;

public class VehicleNotFoundException extends BaseException {

  public VehicleNotFoundException() {
    super(false, HttpStatus.NOT_FOUND, ExceptionCode.VEHICLE_NOT_FOUND.getMessage(),
        ExceptionCode.VEHICLE_NOT_FOUND);
  }
}
