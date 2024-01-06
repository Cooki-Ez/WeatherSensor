package com.example.WeatherSensor.models;

import com.example.WeatherSensor.util.validation.groups.SensorExistenceValidationGroup;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Entity
@Table(name = "Measurement")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    @Min(value = -100)
    @Max(value = 100)
    private double value;

    @Column(name = "raining")
    @NotNull
    private boolean raining;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    @Valid
    //@NotBlank(groups = SensorExistenceValidationGroup.class)
    private Sensor sensor;

    @Column(name = "time_recorded")
    private LocalDateTime timeRecorded;

    public Measurement(double value, boolean raining, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }

    public Measurement() {
    }

    public LocalDateTime getTimeRecorded() {
        return timeRecorded;
    }

    public void setTimeRecorded(LocalDateTime timeRecorded) {
        this.timeRecorded = timeRecorded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", value=" + value +
                ", raining=" + raining +
                ", sensor=" + sensor.getName() +
                ", timeRecorded=" + timeRecorded +
                '}';
    }
}
