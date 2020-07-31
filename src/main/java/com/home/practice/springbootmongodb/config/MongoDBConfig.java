package com.home.practice.springbootmongodb.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.home.practice.springbootmongodb.document.User;
import com.home.practice.springbootmongodb.repositories.UserRepository;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
//				userRepository.save(new User( "Peter", "Development", 3000L));
//				userRepository.save(new User( "Aks", "BA", 8000L));
//				userRepository.save(new User( "Gau", "Tester", 5000L));
			}
		};
	}

}
