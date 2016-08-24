package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import service.UrlIdService;

/**
 * Main class
 * 
 * @author Dusan Eremic
 *
 */
@EnableAutoConfiguration
@ComponentScan
@EnableMongoRepositories
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public UrlIdService getUrlIdGeneratorService() {
		return new UrlIdService();
	}

}
