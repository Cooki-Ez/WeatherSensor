package com.example.WeatherSensor.dto;

import com.example.WeatherSensor.util.validation.groups.SensorNameUniquenessValidationGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SensorDTO {
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    //@NotBlank(groups = SensorNameUniquenessValidationGroup.class)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
