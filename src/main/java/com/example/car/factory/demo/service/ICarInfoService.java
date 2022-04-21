package com.example.car.factory.demo.service;

import com.example.car.factory.demo.dto.CarTypeResponseDto;

public interface ICarInfoService {

    CarTypeResponseDto getCarType(String carType);
}
