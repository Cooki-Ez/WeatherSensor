package com.example.WeatherSensor.util.errors;

public class SensorNotCreatedException extends RuntimeException{

    public SensorNotCreatedException(String msg){
        super(msg);
    }
}
