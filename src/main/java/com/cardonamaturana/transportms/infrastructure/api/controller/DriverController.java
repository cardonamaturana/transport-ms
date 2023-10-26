package com.cardonamaturana.transportms.infrastructure.api.controller;

import com.cardonamaturana.transportms.application.driver.DriverGetAssociatedVehiclesByIdApplication;
import com.cardonamaturana.transportms.application.driver.DriverGetFreeVehiclesApplication;
import com.cardonamaturana.transportms.application.driver.DriverSaveApplication;
import com.cardonamaturana.transportms.infrastructure.api.dto.driver.DriverRequest;
import com.cardonamaturana.transportms.infrastructure.api.dto.driver.DriverResponse;
import com.cardonamaturana.transportms.infrastructure.api.dto.vehicle.VehicleResponse;
import com.cardonamaturana.transportms.infrastructure.api.mapper.driver.DriverRequestMapper;
import com.cardonamaturana.transportms.infrastructure.api.mapper.driver.DriverResponseMapper;
import com.cardonamaturana.transportms.infrastructure.api.mapper.vehicle.VehicleResponseMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
  private final DriverGetAssociatedVehiclesByIdApplication driverGetAssociatedVehiclesByIdApplication;
  private final DriverGetFreeVehiclesApplication driverGetFreeVehiclesApplication;
  private final VehicleResponseMapper vehicleResponseMapper;

  @PostMapping()
  @Operation(summary = "Create Driver", description = "Create a new Driver into database", responses = {
      @ApiResponse(responseCode = "200", description = "create successful"),
      @ApiResponse(responseCode = "400", description = "error in any field of JSON request")})
  public ResponseEntity<DriverResponse> saveDriver(
      @RequestBody DriverRequest driverRequest) {
    return ResponseEntity.ok(driverResponseMapper.toDto(
        driverSaveApplication.save(driverRequestMapper.toEntity(driverRequest))));
  }

  @GetMapping("associated-vehicles/{id}")
  @Operation(summary = "Search associated vehicles", description = "Find the vehicles associated to a driver by id", responses = {
      @ApiResponse(responseCode = "200", description = "get successful"),
      @ApiResponse(responseCode = "204", description = "no such vehicle")})
  public ResponseEntity<List<VehicleResponse>> getAssociatedVehicles(
      @RequestParam("driverId") Long driverId) {

    List<VehicleResponse> result = vehicleResponseMapper.toDtoList(
        driverGetAssociatedVehiclesByIdApplication.get(driverId));

    return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
  }

  @GetMapping("free-vehicles")
  @Operation(summary = "Search free vehicles", description = "Find vehicles without driver associated", responses = {
      @ApiResponse(responseCode = "200", description = "get successful"),
      @ApiResponse(responseCode = "204", description = "no such vehicle")})
  public ResponseEntity<List<VehicleResponse>> getFreeVehicles() {

    List<VehicleResponse> result = vehicleResponseMapper.toDtoList(
        driverGetFreeVehiclesApplication.get());

    return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
  }


}
