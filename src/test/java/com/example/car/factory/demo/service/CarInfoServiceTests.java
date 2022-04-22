package com.example.car.factory.demo.service;

import com.example.car.factory.demo.dto.CarTypeResponseDto;
import com.example.car.factory.demo.exception.ApiRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CarInfoServiceTests {

    @Mock
    private CarTypeResponseDto carTypeResponseDto;
    private ICarInfoService carInfoService;

    @BeforeEach
    void setUp() {
        carTypeResponseDto = new CarTypeResponseDto();
        carInfoService = new CarInfoServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("carTypeProvider")
    void parameter_MustGiveCarType_ThatMatchedIt(String carType)  {

        final var exampleCar = carType + " Car has produced.";
        carTypeResponseDto = carInfoService.getCarType(carType);

        assertEquals(exampleCar, carTypeResponseDto.getCarType());
    }

    private static Stream<String> carTypeProvider() {
        return Stream.of("Sedan", "Cabrio", "Hatchback");
    }

    @Test
    void getCarType_WhenCarTypeIsNull_MustGiveNull() {
        assertThrows(ApiRequestException.class, () -> carInfoService.getCarType(null));
    }

    @Test
    void getCarType_WhenCarTypeIsEmpty_MustGiveNull() {
        assertThrows(ApiRequestException.class, () -> carInfoService.getCarType(""));
    }

    @Test
    void getCarType_WhenCarTypeIsNotExist_MustGiveException() {
        assertThrows(ApiRequestException.class, () -> carInfoService.getCarType("NotExist"));
    }
}


