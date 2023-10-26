package com.cardonamaturana.transportms;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.cardonamaturana.transportms.infrastructure.api.dto.vehicle.VehicleRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TransportMsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = {"/db/intial-values-into-independents-tables.sql",
    "/db/insert-one-driver.sql",
    "/db/insert-one-vehicle.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class VehicleControllerTest {

  public MockMvc mockMvc;

  private VehicleRequest vehicleRequest = new VehicleRequest(
      1L,
      "2018",
      "abc123",
      "200TN"
  );

  private String path = "/vehicle";
  private String getAssociatedVehiclesPath = path + "/associated-vehicles/{id}";
  private String getFreeVehiclesPath = path + "/free-vehicles";
  private String patchAttachPath = path + "/attach";
  private String patchDetachPath = path + "/detach";
  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  public WebApplicationContext context;

  @BeforeEach
  public void init() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }


  @Test
  @DisplayName("should create a vehicle")
  void saveVehicle_ShouldCreateVehicle_GivenCorrectData_Return_Ok() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post(path)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(vehicleRequest))
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.model").value("2018"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.plateVehicle").value("abc123"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.capacity").value("200TN"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.driver.id").value("1"));
  }

  @Test
  @DisplayName("Null driverId")
  void saveVehicle_GivenNullDriverId_ShouldReturn_BadRequest() throws Exception {
    vehicleRequest.setDriverId(null);
    mockMvc.perform(MockMvcRequestBuilders.post(path)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(vehicleRequest))
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  @DisplayName("Empty model")
  void saveVehicle_GivenEmptyModel_ShouldReturn_BadRequest() throws Exception {
    vehicleRequest.setModel("");
    mockMvc.perform(MockMvcRequestBuilders.post(path)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(vehicleRequest))
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  @DisplayName("Empty plateVehicle")
  void saveVehicle_GivenEmptyPlateVehicle_ShouldReturn_BadRequest() throws Exception {
    vehicleRequest.setPlateVehicle("");
    mockMvc.perform(MockMvcRequestBuilders.post(path)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(vehicleRequest))
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  @DisplayName("Get vehicles associated")
  void GetVehiclesAssociated_ShouldReturn_Ok() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(getAssociatedVehiclesPath, 1)
            .param("driverId", "1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].model").value("mod1"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].plateVehicle").value("plat1"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].capacity").value("cap1"));
  }


  @Test
  @DisplayName("Get free vehicles ")
  void GetFreeVehicles_ShouldReturn_Ok() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(getFreeVehiclesPath)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isNoContent());
  }

  @Test
  @DisplayName("Patch attach vehicles ")
  void AttachVehicles_ShouldReturn_Ok() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.patch(patchAttachPath)
            .param("driverId", "1")
            .param("vehicleId", "1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  @DisplayName("Patch detach vehicles ")
  void DetachVehicles_ShouldReturn_Ok() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.patch(patchDetachPath)
            .param("vehicleId", "1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk());
  }


}
