package com.cardonamaturana.transportms.infrastructure.api.dto.driver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverResponse {


  Long id;
  String identification;
  String lastName;
  String name;
  String cellphone;
  String address;

}
