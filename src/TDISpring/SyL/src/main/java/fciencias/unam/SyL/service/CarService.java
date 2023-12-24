package fciencias.unam.SyL.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import fciencias.unam.SyL.repository.CarRepository;
import fciencias.unam.SyL.repository.CarRepositoryy;
import fciencias.unam.SyL.entity.Car;
import fciencias.unam.SyL.entity.Carr;
import java.lang.RuntimeException;

import java.util.Optional;
@Service
public class CarService{
	@Autowired
    private CarRepository carRepository;

    @Autowired
    private CarRepositoryy carRepositoryy;
    
    public List<Car> getAllCars() {
        return carRepositoryy.findAll();
    }

    public Car findById(long id){
        Optional<Car> finded = carRepositoryy.findById(new Long(id));
        if(finded.isEmpty())
            return null;
        return carRepositoryy.findById(new Long(id)).get();
        // return Optional.of(carRepositoryy.findById(new Long(id))).orElseThrow(null);
        // return carRepository.findById(id);
    }

    public Car save(Car car){
        return carRepositoryy.save(new Car(new Long(0),java.time.LocalDateTime.now(),"","","",true));
        // return carRepository.save(car);
    }

    public boolean delete(long id){
        carRepositoryy.deleteById(new Long(id));
        return true;
    }
    public Car update(Car car){
        return carRepositoryy.save(car);
        // return carRepository.update(car);
    }
}
