package com.example.car.factory.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "CarType Api model documentation", description = "Model")
public class CarTypeDto {

    @ApiModelProperty(value = "the field where the car type is sent", required = true)
    @NotNull(message = "Car type is required")
    private String carType;

}
