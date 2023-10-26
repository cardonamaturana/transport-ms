package com.cardonamaturana.transportms.infrastructure.api.dto.order;

import com.cardonamaturana.transportms.domain.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class OrderResponse {

  Long id;
  String orderType;
  String address;
  Driver driver;

}