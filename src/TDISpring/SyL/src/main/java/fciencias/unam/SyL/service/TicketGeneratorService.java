package fciencias.unam.SyL.service;


import org.springframework.stereotype.Service;

import fciencias.unam.SyL.entity.Car;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TicketGeneratorService{
    String ticketTemplate = """
                Recibo Estacionamiento "Duque" \n
                        {id}\n
                      {localDate} \n                                   
            Marca: {brand} \n                               
            Modelo: {model} \n                               
            Color: {color} \n              
                No nos hacemos responsable por daño o 
                robo total de los automoviles
            """;
    public String generateTicket(
            String brand,
            String model,
            String color
    ){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String ticketFormatted = ticketTemplate;
        ticketFormatted = ticketFormatted.replace("{localDate}", dtf.format(now).toString());
        ticketFormatted = ticketFormatted.replace("{brand}", brand);
        ticketFormatted = ticketFormatted.replace("{model}", model);
        ticketFormatted = ticketFormatted.replace("{color}", color);
        return ticketFormatted;
    }

    public String generateTicket(Car car){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String ticketFormatted = ticketTemplate;
        ticketFormatted = ticketFormatted.replace("{id}", String.valueOf(car.getId()));
        ticketFormatted = ticketFormatted.replace("{localDate}", dtf.format(car.getDate()).toString());
        ticketFormatted = ticketFormatted.replace("{brand}", car.getBrand());
        ticketFormatted = ticketFormatted.replace("{model}", car.getModel());
        ticketFormatted = ticketFormatted.replace("{color}", car.getColor());
        return ticketFormatted;
    }
    
}
