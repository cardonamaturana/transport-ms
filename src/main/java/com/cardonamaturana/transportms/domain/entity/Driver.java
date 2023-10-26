package com.cardonamaturana.transportms.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {


  Long id;
  String identification;
  String lastName;
  String name;
  String cellphone;
  String address;

}
