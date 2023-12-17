package fciencias.unam.SyL.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import fciencias.unam.SyL.repository.CarRepository;
import fciencias.unam.SyL.entity.Car;

@Service
public class PrintingService{
	@Autowired
    private CarRepository carRepository;
    
    public PrintingService(){
        
    }
    public List<Car> getCars() {
        return carRepository.getAllCars();
    }
}
