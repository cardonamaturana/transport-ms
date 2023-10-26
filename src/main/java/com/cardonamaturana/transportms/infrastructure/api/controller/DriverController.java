package com.cardonamaturana.transportms.infrastructure.api.controller;

import com.cardonamaturana.transportms.application.vehicle.VehicleGetAttachedByDriverIdApplication;
import com.cardonamaturana.transportms.application.vehicle.VehicleGetFreeApplication;
import com.cardonamaturana.transportms.application.driver.DriverSaveApplication;
import com.cardonamaturana.transportms.infrastructure.api.dto.driver.DriverRequest;
import com.cardonamaturana.transportms.infrastructure.api.dto.driver.DriverResponse;
import com.cardonamaturana.transportms.infrastructure.api.mapper.driver.DriverRequestMapper;
import com.cardonamaturana.transportms.infrastructure.api.mapper.driver.DriverResponseMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {

  private final DriverSaveApplication driverSaveApplication;
  private final DriverRequestMapper driverRequestMapper;
  private final DriverResponseMapper driverResponseMapper;

  @PostMapping()
  @Operation(summary = "Create Driver", description = "Create a new Driver into database", responses = {
      @ApiResponse(responseCode = "200", description = "create successful"),
      @ApiResponse(responseCode = "400", description = "error in any field of JSON request")})
  public ResponseEntity<DriverResponse> saveDriver(
      @RequestBody DriverRequest driverRequest) {
    return ResponseEntity.ok(driverResponseMapper.toDto(
        driverSaveApplication.save(driverRequestMapper.toEntity(driverRequest))));
  }


}
