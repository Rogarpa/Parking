package fciencias.unam.SyL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import javax.print.PrintService;
import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPosConst;
import com.github.anastaciocintra.escpos.Style;
import com.github.anastaciocintra.escpos.barcode.BarCode;
import com.github.anastaciocintra.escpos.barcode.PDF417;
import com.github.anastaciocintra.output.PrinterOutputStream;


import fciencias.unam.SyL.entity.Car;
import fciencias.unam.SyL.service.PrinterService;
import fciencias.unam.SyL.service.CheckIn;
import java.io.IOException;
@Service
public class CheckIn{
        
    @Autowired
    CarService carService;
    @Autowired
    TicketGeneratorService ticketGeneratorService;
    @Autowired
    PrinterService printerService;

    public String checkIn(Car car){
        Car savedCar = carService.save(car);
        System.out.print(savedCar);
        String ticket = ticketGeneratorService.generateTicket(savedCar);
        // printerService.printString("POS-80", ticket);
        
        PrintService printService = PrinterOutputStream.getPrintServiceByName("POS-80");
        EscPos escpos;
        try {
            escpos = new EscPos(new PrinterOutputStream(printService));

            Style ticketStyle = new Style()
            .setFontSize(Style.FontSize._1, Style.FontSize._1)
            .setJustification(EscPosConst.Justification.Center);
            
            BarCode barcode = new BarCode();

            escpos.write(ticketStyle, "====================================== \n");
            escpos.write(ticketStyle, ticket);
            // escpos.write(ticket);
            escpos.write(barcode, String.format("%19d" , savedCar.getId()));
            escpos.feed(1);
            escpos.write(ticketStyle, "====================================== \n");
            escpos.write(ticketStyle, "\n");
            escpos.write(ticketStyle, "\n");
            escpos.write(ticketStyle, "\n");
            escpos.write(ticketStyle, "\n");

            escpos.cut(EscPos.CutMode.PART);
            
            escpos.close();
            
        } catch (IOException ex) {
            System.out.print("Fallo");
        }
        
        
        return ticket;
    }
}
