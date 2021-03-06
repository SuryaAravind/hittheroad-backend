package com.springboot.hittheroad.hittheroadbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan("com.springboot.hittheroad.resources")
//@RestController
@SpringBootApplication
public class HittheroadBackendApplication {
	
	/*@RequestMapping("/home")
	String home(){
		return "Hello World!!";
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(HittheroadBackendApplication.class, args);
	}
}
