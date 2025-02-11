package com.voting.votingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.voting.Entity")  // Ensure entity package is scanned
@EnableJpaRepositories("com.voting.Repository")  // Ensure repositories are detected
@ComponentScan(basePackages = "com.voting")  
public class VotingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingSystemApplication.class, args);
		
	}

}


