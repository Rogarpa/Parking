package fciencias.unam.SyL.controllers;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fciencias.unam.SyL.entity.Car;
import fciencias.unam.SyL.entity.CarDTO;
import fciencias.unam.SyL.service.CarService;
import fciencias.unam.SyL.service.PrinterService;
import fciencias.unam.SyL.service.CheckIn;
import fciencias.unam.SyL.service.TicketGeneratorService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
	PrinterService printerService;

    @Autowired
    CheckIn checkIn;


    @Autowired
	CarService carService;

    @Autowired
    TicketGeneratorService ticketGeneratorService;

    @GetMapping("/cut")
    @ResponseBody
    public String cut(){
        printerService.printBytes("POS-80", new byte[] { 0x1d, 'V', 1 });
        return "cortado";
    }
    @GetMapping("/agregarCarro")
    public String agregarCarro(){
        return "carForm";
    }
    
    @GetMapping("/inventario")
    public String inventario(Model model){
        model.addAttribute("carros", carService.getAllCars());
        return "carInventory";
    }

    @PostMapping("/checkIn")
// 
    @ResponseBody
    public String checkIn(Car car){
        return checkIn.checkIn(car);
        // return "redirect:/agregarCarro"
    }

    @PostMapping("/verificar")
    public String verificar(Car car, Model model){
        Car verifiedCar = carService.findById(car.getId());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        CarDTO carDTO = new CarDTO(
                                verifiedCar.getId(),
                                dtf.format(verifiedCar.getDate()),
                                verifiedCar.getModel(),
                                verifiedCar.getBrand(),
                                verifiedCar.getColor()
                            );
        model.addAttribute("verifiedCar", carDTO);
        return "carForm";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        
        long l = (long)Math.pow(2,63)-1;
        System.out.println(String.valueOf(l));
        while(l > 0){
            l++;
            System.out.println(String.valueOf(l));
        }
        return "";
    }
        
}
