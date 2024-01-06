package com.example.WeatherSensor.models;

import com.example.WeatherSensor.util.validation.groups.SensorNameUniquenessValidationGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Sensor")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    //@NotBlank(groups = SensorNameUniquenessValidationGroup.class)
    private String name;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.PERSIST)
    private List<Measurement> measurements = new ArrayList<>();

    public Sensor(String name) {
        this.name = name;
    }

    public Sensor() {
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
