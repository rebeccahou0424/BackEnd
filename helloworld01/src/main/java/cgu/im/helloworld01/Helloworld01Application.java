package cgu.im.helloworld01;

import java.lang.reflect.Field;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cgu.im.helloworld01.domain.Car;
import cgu.im.helloworld01.domain.CarRepository;
import cgu.im.helloworld01.domain.Owner;
import cgu.im.helloworld01.domain.OwnerRepository;

@SpringBootApplication
public class Helloworld01Application implements CommandLineRunner {
	
	private static final Logger logger = 			
			LoggerFactory.getLogger(Helloworld01Application.class);
	
	private final CarRepository repository;
	private final OwnerRepository orepository;
	
	public Helloworld01Application(CarRepository repository, OwnerRepository orepository) {
	       this.repository = repository;
	       this.orepository = orepository;
	       
	}

	public static void main(String[] args) {
		
		SpringApplication.run(Helloworld01Application.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub	
		
		Owner owner1 = new Owner("John" , "Johnson");
		Owner owner2 = new Owner("Mary" , "Robinson");
		orepository.save(owner1);
		orepository.save(owner2);

		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));		
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner1));
		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owner2));
		repository.save(new Car("Nissan", "Tiida", "White", "SSJ-3003", 2021, 17000, owner2));
		repository.save(new Car("Toyota", "Altis", "Silver", "KKO-0213", 2024, 29000, owner2));
		
		repository.save(new Car("Toyota", "Mustang", "Red","0212-DD", 2023, 59000, owner1));
		
		// 取得所有車主的所有汽車資料     // 先印出車主編號、姓氏   //   然後逐行印出他名下汽車的車號
		for (Owner owner : orepository.findAllWithCars()) {	    	       
		      System.out.printf("owner#: %s last_name: %s\n", 
		      owner.getOwnerid(), owner.getLastname());	            	            
		      List<Car> cars = owner.getCars();
			            
		      if(cars == null) {
		    	  System.out.println(owner.getLastname() + "has no car"); 
		      }
		      else {	            	
		    	  for(Car cc: cars) {
		    		  System.out.println(cc.getRegistrationNumber());
		    	  }		            
		      }
		}
	}
}
