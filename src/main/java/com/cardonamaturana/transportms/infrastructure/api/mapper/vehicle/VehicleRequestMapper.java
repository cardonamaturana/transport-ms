package com.cardonamaturana.transportms.infrastructure.api.mapper.vehicle;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.infrastructure.api.dto.vehicle.VehicleRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface VehicleRequestMapper {

  Vehicle toEntity(VehicleRequest vehicleRequest);


}
