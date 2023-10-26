package com.cardonamaturana.transportms.domain.service.vehicle;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import java.util.List;

public interface VehicleGetAttachedByDriverIdService {

  List<Vehicle> get(Long driverId);
}
