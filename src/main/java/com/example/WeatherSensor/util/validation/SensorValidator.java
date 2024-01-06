package com.example.WeatherSensor.util.validation;

import com.example.WeatherSensor.models.Sensor;
import com.example.WeatherSensor.services.SensorsService;
import com.example.WeatherSensor.util.validation.groups.SensorExistenceValidationGroup;
import com.example.WeatherSensor.util.validation.groups.SensorNameUniquenessValidationGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

@Component
@Validated(SensorNameUniquenessValidationGroup.class)
public class SensorValidator implements Validator {

    private final SensorsService sensorsService;

    @Autowired
    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Sensor.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        if(sensorsService.getByName(sensor.getName()).isPresent())
            errors.rejectValue("name", "", "Name should be unique");
    }
}
