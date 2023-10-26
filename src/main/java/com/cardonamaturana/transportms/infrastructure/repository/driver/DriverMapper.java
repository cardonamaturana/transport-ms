package com.cardonamaturana.transportms.infrastructure.repository.driver;

import com.cardonamaturana.transportms.domain.entity.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface DriverMapper {

  Driver toEntity(DriverDto driverDto);

  DriverDto toDto(Driver driver);

}
