package cgu.im.helloworld01.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends CrudRepository<Car, Long> {
	
	 // Fetch cars by brand
     List<Car> findByBrand(String brand);
     
	 // Fetch cars by brand
     List<Car> findByColor(String color);
     
     // 
     List<Car> findAllByColor(String color);
     
     // Fetch cars by year
     List<Car> findByModelYear(int year);
     
     // Fetch cars by year
     List<Car> findByModelYearGreaterThanEqual(int year);
     
     // Fetch cars by brand and model
     List<Car> findByBrandAndModel(String brand, String model);
     
     // Fetch cars by brand or color
     List<Car> findByBrandOrColor(String brand, String color);
     
     // Fetch all cars and sort them by model_year
     List<Car> findByModelYearOrderByModelYear(int year); 
     
     // Fetch all cars and sort them by model_year
     List<Car> findOrderByModelYear(int year); 
     
     // Fetch all cars and sort them by model_year
//     List<Car> findByOrderByModelYear(int year); 
     
     // Fetch cars by year and print fetched cars by brand
     List<Car> findByModelYearOrderByBrand(int year);
     
     // Fetch cars based on brand and sort them by model_year descending
     List<Car> findByBrandOrderByModelYearDesc(String brand);
     
     // Delete a car c
//     void delete(Car c);
     
     // 請取得2022年以外年份出廠的所有汽車資料
     List<Car> findByModelYearNotOrderByModelYear(int year);
     
     //
     @Query("SELECT c FROM Car c WHERE c.registrationNumber LIKE '____-__'")
     List<Car> findCarByRegistrationNumberFifthLetter();
     
     //JPQL查詢車廠為Toyota者
     @Query("SELECT c FROM Car c WHERE c.brand LIKE 'Toyota'")
     List<Car> findToyota();
     
     // JPQL印出所有汽車資料及其車主姓氏，即使尚未售出也要列出來
     @Query("SELECT c FROM Car c LEFT JOIN FETCH c.owner")
     List<Car> findAllCarsWithOwnerLastNames(); 
     
     @Query("SELECT c FROM Car c LEFT JOIN c.owner o WHERE c.color <> 'Silver'")
     List<Car> findNonSilverCarsWithOwner(); 
     
     @Query("SELECT c FROM Car c LEFT JOIN c.owner o WHERE c.color <> 'Silver' AND o.firstname = :kkk")
     List<Car> findJohnNonSilverCars(@Param("kkk") String owner);







     



}
