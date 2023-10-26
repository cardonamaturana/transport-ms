package com.cardonamaturana.transportms;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.cardonamaturana.transportms.infrastructure.api.dto.driver.DriverRequest;
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
    "/db/insert-one-driver.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class DriverControllerTest {

  public MockMvc mockMvc;

  private DriverRequest driverRequest = new DriverRequest(
      "987654321",
      "cardona",
      "julio",
      "3012142213",
      "cra 53 # 21-15"
  );

  private String path = "/driver";
  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  public WebApplicationContext context;

  @BeforeEach
  public void init() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }


  @Test
  @DisplayName("should create a driver")
  void saveDriver_ShouldCreateDriver_GivenCorrectData_Return_Ok() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post(path)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(driverRequest))
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.identification").value("987654321"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("cardona"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("julio"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.cellphone").value("3012142213"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("cra 53 # 21-15"));
  }

  @Test
  @DisplayName("Empty identification")
  void saveDriver_GivenEmptyIdentification_ShouldReturn_BadRequest() throws Exception {
    driverRequest.setIdentification("");
    mockMvc.perform(MockMvcRequestBuilders.post(path)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(driverRequest))
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  @DisplayName("Empty name")
  void saveDriver_GivenEmptyName_ShouldReturn_BadRequest() throws Exception {
    driverRequest.setName("");
    mockMvc.perform(MockMvcRequestBuilders.post(path)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(driverRequest))
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  @DisplayName("Empty cellphone")
  void saveDriver_GivenEmptyCellphone_ShouldReturn_BadRequest() throws Exception {
    driverRequest.setCellphone("");
    mockMvc.perform(MockMvcRequestBuilders.post(path)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(driverRequest))
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }
}
