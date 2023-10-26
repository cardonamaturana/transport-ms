package com.cardonamaturana.transportms.shared.exceptions.base;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionCode {


  NOT_VALID_PARAMETER("ERR-001", "Exception.NOT_VALID_PARAMETER",
      "Error en los tipos de datos o valores ingresados"),
  NOT_VALID_PARAMETER_STRUCTURE("ERR-002",
      "Exception.NOT_VALID_PARAMETER_STRUCTURE",
      "Error en los campos del JSON o los valores ingresados no tienen el tipo de dato correcto."),
  DRIVER_NOT_FOUND("ERR-003", "Exception.DRIVER_NOT_FOUND",
      "No existe un conductor con el id ingresado");

  private final String code;
  private final String type;
  private final String message;


}
