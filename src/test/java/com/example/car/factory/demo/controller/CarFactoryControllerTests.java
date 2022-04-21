package com.example.car.factory.demo.controller;

import com.example.car.factory.demo.dto.CarTypeDto;
import com.example.car.factory.demo.dto.CarTypeResponseDto;
import com.example.car.factory.demo.service.ICarInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CarFactoryControllerTests {

    public static final String API_CAR_FACTORY_PATH = "/api/v1/car-factory";

    @MockBean
    private ICarInfoService carInfoService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new CarFactoryController(carInfoService)).build();
    }

    @Test
    @DisplayName("Car Factory Controller getCarType()")
    void testGetCarInfo() throws Exception {

        CarTypeDto carTypeDto = CarTypeDto.builder().carType("Sedan").build();
        this.mockMvc.perform(post(API_CAR_FACTORY_PATH + "/car-type")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(carTypeDto))
        ).andDo(print()).andExpect(status().isOk());

    }
}
// End of file