package com.example.WeatherSensor.repositories;

import com.example.WeatherSensor.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {
}
