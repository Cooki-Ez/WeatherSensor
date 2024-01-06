package com.example.WeatherSensor.dto;

import com.example.WeatherSensor.models.Sensor;
import com.example.WeatherSensor.util.validation.groups.SensorExistenceValidationGroup;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class MeasurementDTO {
    @Min(value = -100)
    @Max(value = 100)
    private double value;

    @NotNull
    private boolean raining;
    @Valid
    //@NotBlank(groups = SensorExistenceValidationGroup.class)
    private Sensor sensor;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
