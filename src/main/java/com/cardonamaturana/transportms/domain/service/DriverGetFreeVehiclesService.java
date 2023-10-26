package com.cardonamaturana.transportms.domain.service;

import com.cardonamaturana.transportms.domain.entity.Vehicle;
import java.util.List;

public interface DriverGetFreeVehiclesService {

  List<Vehicle> get();
}
