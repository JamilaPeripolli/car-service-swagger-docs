package com.jps.example.carserviceswaggerdocs.controller;

import com.jps.example.carserviceswaggerdocs.exception.BadRequestException;
import com.jps.example.carserviceswaggerdocs.model.Car;
import com.jps.example.carserviceswaggerdocs.service.CarService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@Api(tags = "Cars")
public class CarController {

    private CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @ApiOperation(value= "Return all cars", notes = "Return all cars", nickname = "Return all cars",response = Car.class, responseContainer = "List")
    @ApiResponse(code = 500, message = "Something went wrong, please try again.")
    @GetMapping
    public List<Car> getCars() {
        return service.getCars();
    }

    @ApiOperation(value = "Returns a specific car with the identifier provided")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Something went wrong, please try again."),
            @ApiResponse(code = 400, message = "The identifier was not provided or is invalid.")
    })
    @GetMapping("/{carId}")
    public ResponseEntity getCar(@ApiParam(value="Car identifier", required = true) @PathVariable("carId") Long id) {
        return ResponseEntity.ok(service.getCar(id));
    }

    @ApiOperation(value = "Add the car provided in the request body")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Something went wrong, please try again."),
            @ApiResponse(code = 400, message = "Missing required fields.")
    })
    @PostMapping
    public ResponseEntity addCar(@RequestBody(required = true) Car car) {
        service.addCar(car);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Update the car provided in the request body")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Something went wrong, please try again."),
            @ApiResponse(code = 400, message = "Missing required fields.")
    })
    @PutMapping
    public ResponseEntity updateCar(@RequestBody(required = true) Car car) {
        service.updateCar(car);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Delete the car with the identifier provided.")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Something went wrong, please try again."),
            @ApiResponse(code = 400, message = "Missing required fields.")
    })
    @DeleteMapping
    public ResponseEntity deleteCar(@RequestParam("id") Long id) {
        service.deleteCar(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(BadRequestException.class)
    public void handleExceptions() {

    }
}
