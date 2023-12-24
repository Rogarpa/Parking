package fciencias.unam.SyL.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

import fciencias.unam.SyL.entity.Car;


import java.time.LocalDateTime;
import  java.lang.IllegalArgumentException;
@Repository
public class CarRepository{

    private final List<Car> list = new ArrayList<>();

    private final Logger logger = LogManager.getLogger(CarRepository.class);

    public CarRepository() {
        logger.info("*********** CONSTRUCTUR: SemestreRepository");
        initDefaultCars();
    }


    public void initDefaultCars() {
        logger.info("*********** INIT DEFAULT");
    }

    public int count() {
        return list.size();
    }

    public List<Car> getAllCars() {
        return this.list;
    }

    public Car findById(long id){
        for (Car car : list) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public Car save(Car car){
        if(car == null){
            throw new IllegalArgumentException("No se pueden guardar car nulos");
        }
        car.setId(count()+1);
        car.setDate(LocalDateTime.now());
        list.add(car);
        return car;
    }
}
