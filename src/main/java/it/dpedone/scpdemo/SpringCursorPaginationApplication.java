package it.dpedone.scpdemo;

import com.github.javafaker.Faker;
import com.github.javafaker.HowIMetYourMother;
import it.dpedone.scpdemo.entities.Tweet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoOperations;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Davide Pedone https://github.com/davidepedone
 */
@EnableMongoAuditing
@SpringBootApplication
@Slf4j
public class SpringCursorPaginationApplication {

	@Autowired
	private MongoOperations mongoOperations;

	@PostConstruct
	private void init() {
		Faker faker = new Faker();
		HowIMetYourMother himym = faker.howIMetYourMother();
		List<Tweet> tweetList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Tweet tweet = new Tweet(himym.character(), himym.quote(), faker.date().past(30, TimeUnit.DAYS).getTime());
			tweetList.add(tweet);
		}
		mongoOperations.insert(tweetList, "posts");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCursorPaginationApplication.class, args);
	}

}
