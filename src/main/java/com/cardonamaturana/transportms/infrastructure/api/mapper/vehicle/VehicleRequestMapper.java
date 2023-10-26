package com.cardonamaturana.transportms.infrastructure.api.mapper.vehicle;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.infrastructure.api.dto.vehicle.VehicleRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface VehicleRequestMapper {

  @Mapping(source = "driverId", target = "driver.id")
  Vehicle toEntity(VehicleRequest vehicleRequest);


}
