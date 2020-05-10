package it.dpedone.scpdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * @author Davide Pedone https://github.com/davidepedone
 */
@EnableMongoAuditing
@SpringBootApplication
public class SpringCursorPaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCursorPaginationApplication.class, args);
	}

}
