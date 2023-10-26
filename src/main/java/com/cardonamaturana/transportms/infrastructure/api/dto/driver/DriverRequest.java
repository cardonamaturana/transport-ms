package com.cardonamaturana.transportms.infrastructure.api.dto.driver;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverRequest {

  @Size(max = 11)
  @Schema(name = "identification",
      description = "numero de identificación : Campo Obligatorio",
      accessMode = Schema.AccessMode.READ_WRITE,
      example = "1067946296",
      type = "text")
  @NotBlank(message = "numero de identificación : Campo Obligatorio")
  String identification;


  @Size(max = 20)
  @Schema(name = "lastName",
      description = "apellido : Campo opcional",
      accessMode = Schema.AccessMode.READ_WRITE,
      example = "Cardona Maturana",
      type = "text")
  String lastName;


  @Size(max = 20)
  @Schema(name = "name",
      description = "nombre : Campo obligatorio",
      accessMode = Schema.AccessMode.READ_WRITE,
      example = "Julio Cesar",
      type = "text")
  @NotBlank(message = "nombre : Campo obligatorio")
  String name;


  @Size(max = 10)
  @Schema(name = "cellphone",
      description = "telefono : Campo obligatorio",
      accessMode = Schema.AccessMode.READ_WRITE,
      example = "3012142213",
      type = "text")
  @NotBlank(message = "telefono : Campo obligatorio")
  String cellphone;


  @Size(max = 50)
  @Schema(name = "address",
      description = "nombre : Campo opcional",
      accessMode = Schema.AccessMode.READ_WRITE,
      example = "Cra 53 # 21-15",
      type = "text")
  String address;

}
