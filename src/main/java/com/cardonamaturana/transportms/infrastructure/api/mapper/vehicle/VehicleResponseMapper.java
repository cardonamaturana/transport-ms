package com.cardonamaturana.transportms.infrastructure.api.mapper.vehicle;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import com.cardonamaturana.transportms.infrastructure.api.dto.vehicle.VehicleResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface VehicleResponseMapper {

  VehicleResponse toDto(Vehicle vehicle);

  List<VehicleResponse> toDtoList(List<Vehicle> vehicleList);

}
