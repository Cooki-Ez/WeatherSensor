package com.example.WeatherSensor.services;

import com.example.WeatherSensor.models.Measurement;
import com.example.WeatherSensor.repositories.MeasurementsRepository;
import com.example.WeatherSensor.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {
    private final MeasurementsRepository measurementsRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public MeasurementService(MeasurementsRepository measurementsRepository, SensorRepository sensorRepository) {
        this.measurementsRepository = measurementsRepository;
        this.sensorRepository = sensorRepository;
    }

    public List<Measurement> findAll(){
        return measurementsRepository.findAll();
    }

    @Transactional
    public void save(Measurement measurement){
        measurement.setTimeRecorded(LocalDateTime.now());
        if(sensorRepository.findByName(measurement.getSensor().getName()).isPresent())
            measurement.setSensor(sensorRepository.findByName(measurement.getSensor().getName()).get());
        //measurement.setSensor();
        measurementsRepository.save(measurement);
    }

    public int getRainyDays(){
        return (int) measurementsRepository.findAll().stream().filter(Measurement::isRaining).count();
    }
}
