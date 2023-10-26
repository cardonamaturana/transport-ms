package com.cardonamaturana.transportms.infrastructure.repository.vehicle;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface VehicleMapper {

  Vehicle toEntity(VehicleDto vehicleDto);

  List<Vehicle> toEntityList(List<VehicleDto> vehicleDtoList);

  VehicleDto toDto(Vehicle vehicle);

}
