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

import groovyjarjarasm.asm.util.Printer;
import fciencias.unam.SyL.service.PrinterService;
@SpringBootApplication
public class SyLApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyLApplication.class, args);
	}
}
