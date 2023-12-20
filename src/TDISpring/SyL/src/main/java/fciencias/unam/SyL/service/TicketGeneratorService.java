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
                No nos hacemos responsable por daño o 
                robo total de los automoviles
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
        String ticketFormatted = ticketTemplate;
        ticketFormatted = ticketFormatted.replace("{localDate}", dtf.format(now).toString());
        ticketFormatted = ticketFormatted.replace("{brand}", brand);
        ticketFormatted = ticketFormatted.replace("{model}", model);
        ticketFormatted = ticketFormatted.replace("{color}", color);
        return ticketFormatted;
    }

    
}
