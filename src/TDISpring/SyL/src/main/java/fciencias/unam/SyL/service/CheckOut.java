package fciencias.unam.SyL.service;

import java.time.format.DateTimeFormatter;
import  java.lang.IllegalArgumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fciencias.unam.SyL.entity.Car;
import fciencias.unam.SyL.entity.CarDTO;
import fciencias.unam.SyL.service.CarService;;

@Service
public class CheckOut {

    @Autowired
	CarService carService;

    public Object checkOut(long id){
        Car verifiedCar = carService.findById(id);
        Object carDTO;
        if(verifiedCar == null)
            carDTO = "Carro no encontrado";
        else{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            carDTO = new CarDTO(
                verifiedCar.getId(),
                dtf.format(verifiedCar.getDate()),
                verifiedCar.getModel(),
                verifiedCar.getBrand(),
                verifiedCar.getColor()
                );
            }

        
            verifiedCar.setParked(false);
            carService.update(verifiedCar);
        return carDTO;

    }
}
