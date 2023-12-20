package fciencias.unam.SyL.controllers;

import java.awt.print.PageFormat;
import java.awt.print.Paper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fciencias.unam.SyL.entity.Car;
import fciencias.unam.SyL.service.PrinterService;
import fciencias.unam.SyL.service.TicketGeneratorService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
	PrinterService printerService;

    @Autowired
    TicketGeneratorService ticketGeneratorService;

    @GetMapping("/cut")
    @ResponseBody
    public String cut(){
        // byte[] cutP = new byte[] { 0x1d, 'V', 1 };
        printerService.printBytes("POS-80", new byte[] { 0x1d, 'V', 1 });
        return "cortado";
    }
    @GetMapping("/print")
    public String print(){
        return "carForm";
    }

    @PostMapping("/printTicket")
    public String printTicket(Car car){
        String ticket = ticketGeneratorService.generateTicket(car.brand, car.model, car.color);
        printerService.printString("POS-80", ticket);
        // Paper paper = new Paper();
        // paper.setImageableArea(0, 0, 0, 0);
        // PageFormat pf = new PageFormat();
        // pf.setPaper(paper);
        // printerService.print(null, pf, 0)
        return "redirect:print";
    }

}
