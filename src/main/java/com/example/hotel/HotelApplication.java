package com.example.hotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan ("com/example/hotel/mapper")
@EnableTransactionManagement
public class HotelApplication {
	
	public static void main (String[] args) {
		SpringApplication.run (HotelApplication.class , args);
	}
	
}