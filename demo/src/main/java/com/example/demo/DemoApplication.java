package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CarRepository repository) {
		return args -> {

			Car car1 = repository.findByBrandAndModel(Brand.MERCEDES, "W202");
			System.out.printf("I Found %s %s%n",car1.getBrand(), car1.getModel());
			Car car2 = repository.findByCarNumber("РВ1234MK");
			System.out.printf("I Found %s",car2.getCarNumber());
			Car car3 = repository.findByEngineNumber("22WWEP");
			System.out.printf("I Found %s %s with engine number %s%n",car3.getBrand(), car3.getModel(), car3.getEngine().getNumber());
			Car car4 = repository.findByOwnerFirstName("Ivan");
			System.out.printf("I Found %s %s with engine number %s%n",car4.getBrand(), car4.getModel(), car4.getOwner().getFirstName());

		};
	}

}
