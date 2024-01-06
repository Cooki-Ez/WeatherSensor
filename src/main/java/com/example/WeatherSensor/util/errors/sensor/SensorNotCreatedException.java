package com.example.WeatherSensor.util.errors.sensor;

public class SensorNotCreatedException extends RuntimeException{

    public SensorNotCreatedException(String msg){
        super(msg);
    }
}
