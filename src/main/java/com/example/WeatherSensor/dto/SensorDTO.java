package com.example.WeatherSensor.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

public class SensorDTO {
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    private String name;
}
