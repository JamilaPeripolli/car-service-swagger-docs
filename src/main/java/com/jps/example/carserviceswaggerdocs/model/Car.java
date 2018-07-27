package com.jps.example.carserviceswaggerdocs.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Car {

    @JsonPropertyDescription("Identifier")
    private Long id;
    @JsonPropertyDescription("Model of the car")
    private String model;
    @JsonPropertyDescription("Brand of the car")
    private String brand;
    @JsonPropertyDescription("Year that the car was made")
    private Integer year;
    @JsonPropertyDescription("Amount of doors in the car")
    private Integer doors;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonPropertyDescription("Date of manufacturing")
    private LocalDate manufactureDate;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}
