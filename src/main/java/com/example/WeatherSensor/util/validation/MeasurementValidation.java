package com.example.WeatherSensor.util.validation;

import com.example.WeatherSensor.dto.MeasurementDTO;
import com.example.WeatherSensor.services.SensorsService;
import com.example.WeatherSensor.util.validation.groups.SensorExistenceValidationGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

@Component
@Validated(SensorExistenceValidationGroup.class)
public class MeasurementValidation implements Validator {

    private final SensorsService sensorsService;

    @Autowired
    public MeasurementValidation(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MeasurementDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MeasurementDTO measurement = (MeasurementDTO) target;
        if(measurement.getValue() < -100 || measurement.getValue() > 100)
            errors.rejectValue("value", "", "Value should be between -100 and 100");
        if(measurement.getSensor() == null)
            errors.rejectValue("sensor", "", "Sensor can not be empty");
        else if(sensorsService.getByName(measurement.getSensor().getName()).isEmpty())
            errors.rejectValue("sensor","", "Sensor does not exist in database");
    }
}
