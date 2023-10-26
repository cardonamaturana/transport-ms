package com.cardonamaturana.transportms.infrastructure.api.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class OrderRequest {

  @Schema(name = "driverId",
      description = "Conductor Id : Campo obligatorio",
      accessMode = Schema.AccessMode.READ_WRITE,
      example = "1",
      type = "Number")
  @NotNull(message = "Conductor Id : Campo obligatorio")
  Long driverId;


  @Size(max = 20)
  @Schema(name = "orderType",
      description = "nombre : Campo obligatorio",
      accessMode = Schema.AccessMode.READ_WRITE,
      example = "Alimentación",
      type = "text")
  String orderType;


  @Size(max = 50)
  @Schema(name = "address",
      description = "Direccion : Campo obligatorio",
      accessMode = Schema.AccessMode.READ_WRITE,
      example = "Cra 53 # 21-15",
      type = "text")
  @NotBlank(message = "Direccion : Campo obligatorio")
  String address;


}