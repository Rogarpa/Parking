package fciencias.unam.SyL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;






import java.util.Arrays;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;




import fciencias.unam.SyL.utils.PrinterService;
import groovyjarjarasm.asm.util.Printer;
import fciencias.unam.SyL.service.PrintingService;
@SpringBootApplication
public class SyLApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyLApplication.class, args);
	}
	@Autowired
	PrintingService p;

	@Autowired
	PrinterService ps;
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			// System.out.println("Let's inspect the beans provided by Spring Boot:");

			// Scanner s = new Scanner(System.in);

			// while(true){
			// 	System.out.println(s.next());
			// }

			// String[] beanNames = ctx.getBeanDefinitionNames();
			// Arrays.sort(beanNames);
			// for (String beanName : beanNames) {
			// 	System.out.println(beanName);
			// }

			// PrinterService printerService = new PrinterService();
			// System.out.println(printerService.getPrinters());
			String margin = "0123456789012345678901234567890123456789";
			ps.printString("POS-80", margin);
			// PrintingService p = new PrintingService();
			// p.getCars();
		};
	}

}
