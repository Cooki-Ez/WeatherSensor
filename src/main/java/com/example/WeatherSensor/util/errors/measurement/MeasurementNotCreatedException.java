package com.example.WeatherSensor.util.errors.measurement;

public class MeasurementNotCreatedException extends RuntimeException{
    public MeasurementNotCreatedException(String message) {
        super(message);
    }
}
