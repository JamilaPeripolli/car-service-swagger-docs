package com.jps.example.carserviceswaggerdocs.dao;

import com.jps.example.carserviceswaggerdocs.model.Car;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CarDAO {

    private Map<Long, Car> cars;

    private Long lastId;

    public CarDAO() {
        this.cars = new HashMap<>();
        lastId = 0L;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars.values());
    }

    public void addCar(Car car) {
        car.setId(lastId++);
        cars.put(car.getId(), car);
    }

    public void updateCar(Car car) {
        cars.put(car.getId(), car);
    }

    public Car getCar(Long id) {
        return cars.get(id);
    }

    public void deleteCar(Long id) {
        cars.remove(id);
    }

}
