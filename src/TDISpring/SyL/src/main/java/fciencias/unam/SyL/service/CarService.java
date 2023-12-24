package fciencias.unam.SyL.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import fciencias.unam.SyL.repository.CarRepository;
import fciencias.unam.SyL.entity.Car;

@Service
public class CarService{
	@Autowired
    private CarRepository carRepository;
    
    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    public Car findById(long id){
        return carRepository.findById(id);
    }

    public Car save(Car car){
        return carRepository.save(car);
    }
}
