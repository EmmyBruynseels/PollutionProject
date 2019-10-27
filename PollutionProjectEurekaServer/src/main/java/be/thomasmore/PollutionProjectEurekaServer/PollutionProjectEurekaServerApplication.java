package be.thomasmore.PollutionProjectEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PollutionProjectEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollutionProjectEurekaServerApplication.class, args);
	}

}
