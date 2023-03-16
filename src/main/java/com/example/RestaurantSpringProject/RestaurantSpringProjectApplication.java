package com.example.RestaurantSpringProject;

import com.example.RestaurantSpringProject.model.Diner;
import com.example.RestaurantSpringProject.model.DiningReview;
import com.example.RestaurantSpringProject.repositories.DinerRepository;

import com.example.RestaurantSpringProject.repositories.DiningReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;







@SpringBootApplication
public class RestaurantSpringProjectApplication {

	public static void main(String[] args) {
	SpringApplication.run(RestaurantSpringProjectApplication.class, args);

		//Code below used to inspect configuration. Not needed after initial inspection so can be turned off.
		//		ConfigurableApplicationContext context = SpringApplication.run(RestaurantSpringProjectApplication.class, args);
// 		Object datasource = context.getBean("datasource");
//		System.out.println(datasource);







	}

	@Bean
	CommandLineRunner commandLineRunner(DinerRepository dinerRepository) {
		return args ->
				// add some data
		dinerRepository.save(new Diner("Jane Doe", "Las Vegas", "Nevada", "NZ0849340", false, false, true ));

	}


	@Bean
	CommandLineRunner commandLineRunner2(DinerRepository dinerRepository) {
		return args ->
				// add some data
		dinerRepository.save(new Diner("SteveJobs", "Seattle", "Washington", "W9w90358", true, true, true ));

	}


//	@Bean
//	CommandLineRunner commandLineRunner(DiningReviewRepository diningReviewRepository) {
//		return args ->
//				// add some data
//				diningReviewRepository.save(new DiningReview()
//	}

}
