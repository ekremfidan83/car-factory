package com.example.car.factory.demo.service;

import com.example.car.factory.demo.dto.CarTypeResponseDto;
import com.example.car.factory.demo.exception.ApiRequestException;
import com.example.car.factory.demo.resource.car.ICar;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CarInfoServiceImpl implements ICarInfoService {

    public static final String CAR_FACTORY_DEMO_RESOURCE_CAR = "com.example.car.factory.demo.resource.car.";

    final static Logger logger = Logger.getLogger(CarInfoServiceImpl.class.getName());

    public CarTypeResponseDto getCarType(String carType) {
        logger.info("getCarMessage() called");

        try{
            CarTypeResponseDto carTypeResponseDto = new CarTypeResponseDto();
            ICar car = getCarClass(carType);
            carTypeResponseDto.setCarType(car.getType());

            logger.info("getCarMessage() ended");
            return carTypeResponseDto;
        }catch (Exception e){
            logger.info("Exception in getCarMessage()" + e.getMessage());
            throw new ApiRequestException("Invalid Car type");
        }

    }

    private ICar getCarClass(String carType) throws Exception {
        logger.info("getCarClass() called");

        Class<?> cls = Class.forName(CAR_FACTORY_DEMO_RESOURCE_CAR + carType);

        logger.info("getCarClass() ended");
        return(ICar) cls.getDeclaredConstructor().newInstance();
    }

}
