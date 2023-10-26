package com.cardonamaturana.transportms.domain.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Order {

  Long id;
  String orderType;
  String address;
  Driver driver;

}