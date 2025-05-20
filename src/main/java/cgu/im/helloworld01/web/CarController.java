package cgu.im.helloworld01.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cgu.im.helloworld01.domain.Car;
import cgu.im.helloworld01.domain.CarRepository;

@RestController
public class CarController {
	
	private final CarRepository repository;	
	
	public CarController(CarRepository repository) {
		
		super();
		this.repository = repository;
	}
	
    @GetMapping("/cars")
    public Iterable<Car> getCars() {
    	
    	//Fetch and return cars
    	return repository.findAll();
    	
    }

}
