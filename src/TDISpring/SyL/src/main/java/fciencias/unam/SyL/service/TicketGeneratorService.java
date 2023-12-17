package fciencias.unam.SyL.service;


import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TicketGeneratorService{
    String ticketTemplate = """
            ====================================== \n
                Recibo Estacionamiento "Duque" \n
                        {localDate} \n                                   
                Marca: {brand} \n                               
                Modelo: {model} \n                               
                Color: {color} \n              
            ====================================== \n
            \n
            \n
            \n
            \u001dV1
            """;
    public String generateTicket(
            String brand,
            String model,
            String color
    ){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ticketTemplate = ticketTemplate.replace("{localDate}", dtf.format(now).toString());
        ticketTemplate = ticketTemplate.replace("{brand}", brand);
        ticketTemplate = ticketTemplate.replace("{model}", model);
        ticketTemplate = ticketTemplate.replace("{color}", color);
        return ticketTemplate;
    }

    
}
