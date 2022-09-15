package com.brushbrosh.servermanagerspring;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

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

}
