package com.cardonamaturana.transportms.infrastructure.repository.vehicle;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleDto, Long> {

  List<VehicleDto> findByDriverId(Long driverId);

  List<VehicleDto> findByDriverIdIsNull();


}
