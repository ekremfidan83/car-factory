package com.example.car.factory.demo.controller;

import com.example.car.factory.demo.dto.CarTypeResponseDto;
import com.example.car.factory.demo.dto.CarTypeDto;
import com.example.car.factory.demo.service.ICarInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.logging.Logger;


@Api(value = "car-factory Api documentation")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/car-factory")
public class CarFactoryController {

    final static Logger logger = Logger.getLogger(CarFactoryController.class.getName());

    private final ICarInfoService carInfoService;

    @ApiOperation(value = "Get car type")
    @PostMapping("/car-type")
    public ResponseEntity<CarTypeResponseDto> getCarType(@Valid @RequestBody CarTypeDto carTypeDto) {
        logger.info("getCarType() method called");
        CarTypeResponseDto carTypeResponseDto = carInfoService.getCarType(carTypeDto.getCarType());
        return new ResponseEntity<>(carTypeResponseDto, new HttpHeaders(), HttpStatus.OK);
    }
}
