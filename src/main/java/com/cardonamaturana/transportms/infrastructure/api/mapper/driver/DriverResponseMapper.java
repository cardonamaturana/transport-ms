package com.cardonamaturana.transportms.infrastructure.api.mapper.driver;

import com.cardonamaturana.transportms.domain.entity.Driver;
import com.cardonamaturana.transportms.infrastructure.api.dto.driver.DriverResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface DriverResponseMapper {

  DriverResponse toDto(Driver driver);

  List<DriverResponse> toDtoList(List<Driver> driverList);


}
