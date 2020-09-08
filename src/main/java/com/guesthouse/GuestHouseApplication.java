package com.guesthouse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GuestHouseApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GuestHouseApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}


}
