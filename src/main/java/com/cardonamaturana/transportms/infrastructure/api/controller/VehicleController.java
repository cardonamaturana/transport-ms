package com.cardonamaturana.transportms.infrastructure.api.controller;

import com.cardonamaturana.transportms.application.vehicle.VehicleAttachApplication;
import com.cardonamaturana.transportms.application.vehicle.VehicleDetachApplication;
import com.cardonamaturana.transportms.application.vehicle.VehicleGetAttachedByDriverIdApplication;
import com.cardonamaturana.transportms.application.vehicle.VehicleGetFreeApplication;
import com.cardonamaturana.transportms.application.vehicle.VehicleSaveApplication;
import com.cardonamaturana.transportms.infrastructure.api.dto.vehicle.VehicleRequest;
import com.cardonamaturana.transportms.infrastructure.api.dto.vehicle.VehicleResponse;
import com.cardonamaturana.transportms.infrastructure.api.mapper.vehicle.VehicleRequestMapper;
import com.cardonamaturana.transportms.infrastructure.api.mapper.vehicle.VehicleResponseMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {

  private final VehicleRequestMapper vehicleRequestMapper;
  private final VehicleResponseMapper vehicleResponseMapper;
  private final VehicleSaveApplication vehicleSaveApplication;
  private final VehicleGetAttachedByDriverIdApplication vehicleGetAttachedByDriverIdApplication;
  private final VehicleGetFreeApplication vehicleGetFreeApplication;
  private final VehicleAttachApplication vehicleAttachApplication;
  private final VehicleDetachApplication vehicleDetachApplication;

  @PostMapping()
  @Operation(summary = "Create Vehicle", description = "Create a new vehicle into database", responses = {
      @ApiResponse(responseCode = "200", description = "create successful"),
      @ApiResponse(responseCode = "400", description = "error in any field of JSON request")})
  public ResponseEntity<VehicleResponse> saveVehicle(
      @RequestBody VehicleRequest vehicleRequest) {
    return ResponseEntity.ok(vehicleResponseMapper.toDto(
        vehicleSaveApplication.save(vehicleRequestMapper.toEntity(vehicleRequest))));
  }

  @GetMapping("associated-vehicles/{id}")
  @Operation(summary = "Search associated vehicles", description = "Find the vehicles associated to a driver by id", responses = {
      @ApiResponse(responseCode = "200", description = "get successful"),
      @ApiResponse(responseCode = "204", description = "no such vehicle")})
  public ResponseEntity<List<VehicleResponse>> getAssociatedVehicles(
      @RequestParam("driverId") Long driverId) {

    List<VehicleResponse> result = vehicleResponseMapper.toDtoList(
        vehicleGetAttachedByDriverIdApplication.get(driverId));

    return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
  }

  @GetMapping("free-vehicles")
  @Operation(summary = "Search free vehicles", description = "Find vehicles without driver associated", responses = {
      @ApiResponse(responseCode = "200", description = "get successful"),
      @ApiResponse(responseCode = "204", description = "no such vehicle")})
  public ResponseEntity<List<VehicleResponse>> getFreeVehicles() {

    List<VehicleResponse> result = vehicleResponseMapper.toDtoList(
        vehicleGetFreeApplication.get());

    return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
  }

  @PatchMapping("attach")
  @Operation(summary = "Attach driver to vehicle", description = "Attach driver to vehicle", responses = {
      @ApiResponse(responseCode = "200", description = "Attach successful"),
      @ApiResponse(responseCode = "204", description = "no such vehicle")})
  public ResponseEntity<VehicleResponse> attachVehicle(@RequestParam("driverId") Long driverId,
      @RequestParam("vehicleId") Long vehicleId) {

    return ResponseEntity.ok(
        vehicleResponseMapper.toDto(vehicleAttachApplication.attach(vehicleId, driverId)));
  }

  @PatchMapping("detach")
  @Operation(summary = "detach driver to vehicle", description = "detach driver to vehicle", responses = {
      @ApiResponse(responseCode = "200", description = "detach successful"),
      @ApiResponse(responseCode = "204", description = "no such vehicle")})
  public ResponseEntity<VehicleResponse> detachVehicle(@RequestParam("vehicleId") Long vehicleId) {

    return ResponseEntity.ok(
        vehicleResponseMapper.toDto(vehicleDetachApplication.detach(vehicleId)));
  }

}
