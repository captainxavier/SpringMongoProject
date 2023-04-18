package com.xavier.springmongoproject;

import com.xavier.springmongoproject.domain.category.Category;
import com.xavier.springmongoproject.repository.category.CategoryRepository;
import com.xavier.springmongoproject.repository.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMongoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoProjectApplication.class, args);

	}


	@Bean
	public CommandLineRunner commandLineRunner(
			CategoryRepository repository
	){
		return args -> {
			var product = Category.builder()
					.name("phones")
					.build();
			repository.insert(product);
		};

	}




}
