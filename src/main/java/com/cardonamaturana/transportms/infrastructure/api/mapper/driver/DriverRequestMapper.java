package com.cardonamaturana.transportms.infrastructure.api.mapper.driver;

import com.cardonamaturana.transportms.domain.entity.Driver;
import com.cardonamaturana.transportms.infrastructure.api.dto.driver.DriverRequest;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface DriverRequestMapper {

  Driver toEntity(DriverRequest driverRequest);

  List<Driver> toEntityList(List<DriverRequest> driverRequestList);


}
