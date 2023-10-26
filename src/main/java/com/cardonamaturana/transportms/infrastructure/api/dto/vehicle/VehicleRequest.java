package com.cardonamaturana.transportms.infrastructure.api.dto.vehicle;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class VehicleRequest {

  @Schema(name = "driverId",
      description = "Conductor Id : Campo obligatorio",
      accessMode = Schema.AccessMode.READ_WRITE,
      example = "1",
      type = "Number")
  @NotNull(message = "Conductor Id : Campo obligatorio")
  Long driverId;


  @Size(max = 4)
  @Schema(name = "model",
      description = "Modelo : Campo obligatorio",
      accessMode = Schema.AccessMode.READ_WRITE,
      example = "NPR 2018",
      type = "text")
  @NotBlank(message = "Modelo : Campo obligatorio")
  String model;


  @Size(max = 7)
  @Schema(name = "plateVehicle",
      description = "Placa Vehículo : Campo obligatorio",
      accessMode = Schema.AccessMode.READ_WRITE,
      example = "UMA09F",
      type = "text")
  @NotBlank(message = "Placa Vehículo : Campo obligatorio")
  String plateVehicle;

  @Size(max = 7)
  @Schema(name = "capacity",
      description = "Capacidad : Campo obligatorio",
      accessMode = Schema.AccessMode.READ_WRITE,
      example = "15 TN",
      type = "text")
  String capacity;

}
