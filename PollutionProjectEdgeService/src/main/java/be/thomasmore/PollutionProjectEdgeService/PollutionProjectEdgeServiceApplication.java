package be.thomasmore.PollutionProjectEdgeService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PollutionProjectEdgeServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {return new RestTemplate();}

	@Bean
	ObjectMapper getObjectMapper() {return new ObjectMapper(); }

	public static void main(String[] args) {
		SpringApplication.run(PollutionProjectEdgeServiceApplication.class, args);
	}



}
