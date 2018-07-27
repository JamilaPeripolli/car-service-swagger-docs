package com.jps.example.carserviceswaggerdocs.service;

import com.jps.example.carserviceswaggerdocs.dao.CarDAO;
import com.jps.example.carserviceswaggerdocs.exception.BadRequestException;
import com.jps.example.carserviceswaggerdocs.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CarService {

    private CarDAO dao;

    @Autowired
    public CarService(CarDAO dao) {
        this.dao = dao;
    }

    public List<Car> getCars() {
        return dao.getCars();
    }

    public Car getCar(Long id) {
        if(id == null || id == 0L) {
            throw new BadRequestException("Invalid identifier.");
        }
        return dao.getCar(id);
    }

    public void addCar(Car car) {
        if(StringUtils.isEmpty(car.getModel())
                || StringUtils.isEmpty(car.getBrand())
                || car.getYear() == null
                || car.getManufactureDate() == null) {
            throw new BadRequestException("Missing required fields.");
        }
        dao.addCar(car);
    }

    public void updateCar(Car car) {
        if(car.getId() == null || car.getId() == 0L
                || StringUtils.isEmpty(car.getModel())
                || StringUtils.isEmpty(car.getBrand())
                || car.getYear() == null
                || car.getManufactureDate() == null) {
            throw new BadRequestException("Missing required fields.");
        }
        dao.updateCar(car);
    }

    public void deleteCar(Long id) {
        if(id == null || id == 0L) {
            throw new BadRequestException("Invalid identifier.");
        }
        dao.deleteCar(id);
    }

}
