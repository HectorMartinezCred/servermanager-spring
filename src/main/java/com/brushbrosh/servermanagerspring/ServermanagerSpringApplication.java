package com.brushbrosh.servermanagerspring;

import java.util.Arrays;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// import com.brushbrosh.servermanagerspring.enumeration.Status;
// import com.brushbrosh.servermanagerspring.model.Server;
// import com.brushbrosh.servermanagerspring.repository.ServerRepository;

@SpringBootApplication
public class ServermanagerSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServermanagerSpringApplication.class, args);
	}

	// @Bean
	// CommandLineRunner run(ServerRepository serverRepository) {
	// return arg -> {
	// serverRepository.save(new Server(null, "10.0.10.67", "Ubuntu Server", "16
	// GB", "GLPI Server", "http:/localhost:8080/server/image/server1.png",
	// Status.SERVER_UP));
	// serverRepository.save(new Server(null, "10.0.10.132", "Windows Server 2019",
	// "16 GB", "License Server", "http:/localhost:8080/server/image/server2.png",
	// Status.SERVER_UP));
	// serverRepository.save(new Server(null, "10.0.12.142", "Ubuntu Server", "16
	// GB", "GLPI Server Test", "http:/localhost:8080/server/image/server3.png",
	// Status.SERVER_UP));
	// };
	// }

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
