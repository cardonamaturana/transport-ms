package com.cardonamaturana.transportms.shared.exceptions.driver;


import com.cardonamaturana.transportms.shared.exceptions.base.BaseException;
import com.cardonamaturana.transportms.shared.exceptions.base.ExceptionCode;
import org.springframework.http.HttpStatus;

public class DriverNotFoundException extends BaseException {

  public DriverNotFoundException() {
    super(false, HttpStatus.NOT_FOUND, ExceptionCode.DRIVER_NOT_FOUND.getMessage(),
        ExceptionCode.DRIVER_NOT_FOUND);
  }
}
